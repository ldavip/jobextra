package br.com.kesley.jobextra.model;

public enum CourseStatusEnum {
    INTERRUPTED("Interrompido"), IN_PROGRESS("Cursando"), FINISHED("Concluído");

    private final String description;

    private CourseStatusEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}