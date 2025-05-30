package com.escola.horarios_api.controller;

import com.escola.horarios_api.dto.ProfessorHorasDTO;
import com.escola.horarios_api.dto.ResultadoSalaDTO;
import com.escola.horarios_api.service.HorariosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/escola") // Um prefixo mais genérico para a API da escola
@Tag(name = "Gestão de Horários da Escola")
public class HorariosController {

    @Autowired
    private HorariosService horariosService;

    @GetMapping("/professores/horas-comprometidas")
    @Operation(summary = "Retorna a quantidade de horas comprometidas de cada professor em aulas")
    public List<ProfessorHorasDTO> getHorasComprometidasProfessores() {
        return horariosService.getHorasProfessores();
    }

    @GetMapping("/salas/horarios")
    @Operation(summary = "Lista salas com horários ocupados e livres")
    public List<ResultadoSalaDTO> getHorariosSalas() {
        return horariosService.listarHorariosSalas();
    }
}