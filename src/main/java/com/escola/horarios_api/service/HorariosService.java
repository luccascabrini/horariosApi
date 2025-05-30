package com.escola.horarios_api.service;


import com.escola.horarios_api.dto.HorarioLivreDTO;
import com.escola.horarios_api.dto.ProfessorHorasDTO;
import com.escola.horarios_api.dto.ResultadoSalaDTO;
import com.escola.horarios_api.dto.SalaOcupadaDTO;
import com.escola.horarios_api.repository.HorariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class HorariosService {

    @Autowired
    private HorariosRepository horariosRepository;

    private static final LocalTime INICIO_EXPEDIENTE = LocalTime.of(8, 0);
    private static final LocalTime FIM_EXPEDIENTE = LocalTime.of(22, 0);
    private static final String[] DIAS_DA_SEMANA_ORDENADOS = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo"};


    public List<ProfessorHorasDTO> getHorasProfessores() {
        return horariosRepository.findHorasComprometidasPorProfessor();
    }

    public List<ResultadoSalaDTO> listarHorariosSalas() {
        List<SalaOcupadaDTO> todosHorariosOcupados = horariosRepository.findAllHorariosOcupados();
        List<String> todasAsSalas = horariosRepository.findAllRoomNames();

        Map<String, List<SalaOcupadaDTO>> horariosPorSala = todosHorariosOcupados.stream()
                .collect(Collectors.groupingBy(SalaOcupadaDTO::getNomeSala));

        List<ResultadoSalaDTO> resultadosFinais = new ArrayList<>();

        for (String nomeSala : todasAsSalas) {
            List<SalaOcupadaDTO> ocupadosDaSala = horariosPorSala.getOrDefault(nomeSala, new ArrayList<>());
            List<HorarioLivreDTO> livresDaSala = calcularHorariosLivres(ocupadosDaSala);
            resultadosFinais.add(new ResultadoSalaDTO(nomeSala, ocupadosDaSala, livresDaSala));
        }

        return resultadosFinais;
    }

    private List<HorarioLivreDTO> calcularHorariosLivres(List<SalaOcupadaDTO> horariosOcupados) {
        Map<String, List<SalaOcupadaDTO>> horariosPorDia = horariosOcupados.stream()
                .collect(Collectors.groupingBy(SalaOcupadaDTO::getDiaDaSemana));

        List<HorarioLivreDTO> horariosLivres = new ArrayList<>();

        for (String dia : DIAS_DA_SEMANA_ORDENADOS) {
            List<SalaOcupadaDTO> ocupadosNoDia = horariosPorDia.getOrDefault(dia, new ArrayList<>());
            ocupadosNoDia.sort(Comparator.comparing(SalaOcupadaDTO::getHoraInicio));

            LocalTime tempoLivreAtual = INICIO_EXPEDIENTE;

            for (SalaOcupadaDTO ocupado : ocupadosNoDia) {
                if (tempoLivreAtual.isBefore(ocupado.getHoraInicio())) {
                    horariosLivres.add(new HorarioLivreDTO(dia, tempoLivreAtual, ocupado.getHoraInicio()));
                }
                tempoLivreAtual = ocupado.getHoraFim();
            }

            if (tempoLivreAtual.isBefore(FIM_EXPEDIENTE)) {
                horariosLivres.add(new HorarioLivreDTO(dia, tempoLivreAtual, FIM_EXPEDIENTE));
            }
        }
        return horariosLivres;
    }
}