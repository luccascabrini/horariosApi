package com.escola.horarios_api.dto;

import java.time.LocalTime;

public class SalaOcupadaDTO {
    private String nomeSala;
    private String diaDaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private String codigoTurma;
    private String nomeMateria;
    private String nomeProfessor;

    public SalaOcupadaDTO() {}

    public SalaOcupadaDTO(String nomeSala, String diaDaSemana, LocalTime horaInicio, LocalTime horaFim, String codigoTurma, String nomeMateria, String nomeProfessor) {
        this.nomeSala = nomeSala;
        this.diaDaSemana = diaDaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.codigoTurma = codigoTurma;
        this.nomeMateria = nomeMateria;
        this.nomeProfessor = nomeProfessor;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
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

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public String getNomeMateria() {
        return nomeMateria;
    }

    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }
}