package com.escola.horarios_api.dto;

public class ProfessorHorasDTO {
    private String professorNome;
    private Double horasComprometidas;

    public ProfessorHorasDTO() {}

    public ProfessorHorasDTO(String professorNome, Double horasComprometidas) {
        this.professorNome = professorNome;
        this.horasComprometidas = horasComprometidas;
    }

    public String getProfessorNome() {
        return professorNome;
    }

    public void setProfessorNome(String professorNome) {
        this.professorNome = professorNome;
    }

    public Double getHorasComprometidas() {
        return horasComprometidas;
    }

    public void setHorasComprometidas(Double horasComprometidas) {
        this.horasComprometidas = horasComprometidas;
    }
}