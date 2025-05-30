package com.escola.horarios_api.dto;

import java.util.List;

public class ResultadoSalaDTO {
    private String nomeSala;
    private List<SalaOcupadaDTO> horariosOcupados;
    private List<HorarioLivreDTO> horariosLivres;

    public ResultadoSalaDTO() {}

    public ResultadoSalaDTO(String nomeSala, List<SalaOcupadaDTO> horariosOcupados, List<HorarioLivreDTO> horariosLivres) {
        this.nomeSala = nomeSala;
        this.horariosOcupados = horariosOcupados;
        this.horariosLivres = horariosLivres;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public List<SalaOcupadaDTO> getHorariosOcupados() {
        return horariosOcupados;
    }

    public void setHorariosOcupados(List<SalaOcupadaDTO> horariosOcupados) {
        this.horariosOcupados = horariosOcupados;
    }

    public List<HorarioLivreDTO> getHorariosLivres() {
        return horariosLivres;
    }

    public void setHorariosLivres(List<HorarioLivreDTO> horariosLivres) {
        this.horariosLivres = horariosLivres;
    }
}
