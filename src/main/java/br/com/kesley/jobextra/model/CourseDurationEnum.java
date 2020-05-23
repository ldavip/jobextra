package br.com.kesley.jobextra.model;

public enum CourseDurationEnum {

    SHORT("Curta (até 40 horas)"), 
    AVERAGE("Média (acima de 40 horas, até 360 horas)"),
    LONG("Longa (acima de 360 horas)");

    private final String description;

    private CourseDurationEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}