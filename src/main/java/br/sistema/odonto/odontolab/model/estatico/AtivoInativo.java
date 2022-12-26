package br.sistema.odonto.odontolab.model.estatico;


public enum AtivoInativo {
    ATIVO("A"),
    INATIVO("I");

    private final String status;

    AtivoInativo(String status){
        this.status = status;
    }

    public String status() {
        return status;
    }

    @Override
    public String toString() {
        return this.status;
    }
}
