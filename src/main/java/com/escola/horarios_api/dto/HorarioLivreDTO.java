package com.escola.horarios_api.dto;

import java.time.LocalTime;

public class HorarioLivreDTO {
    private String diaDaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFim;

    public HorarioLivreDTO() {}

    public HorarioLivreDTO(String diaDaSemana, LocalTime horaInicio, LocalTime horaFim) {
        this.diaDaSemana = diaDaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }
}
