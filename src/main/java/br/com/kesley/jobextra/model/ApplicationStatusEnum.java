package br.com.kesley.jobextra.model;

public enum ApplicationStatusEnum {
    ANALYZING("Analisando"), SELECTED("Selecionado"), NOT_SELECTED("Não selecionado");

    private final String description;

    private ApplicationStatusEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
