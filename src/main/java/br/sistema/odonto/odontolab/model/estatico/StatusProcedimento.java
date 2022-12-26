package br.sistema.odonto.odontolab.model.estatico;


public enum StatusProcedimento {
    PENDENTE("P"),
    REALIZADO("R"),
    CANCELADO("C"),
    TRATAMENTO("T");

    private final String status;

    StatusProcedimento(String status){
        this.status = status;
    }

    public String status() {
        return status;
    }

    public static StatusProcedimento fromStatus(final String status) {
        for (final StatusProcedimento statusProcedimento : StatusProcedimento.values()) {
            if (statusProcedimento.status.equalsIgnoreCase(status)) {
                return statusProcedimento;
            }
        }

        throw new IllegalArgumentException(status);
    }

    @Override
    public String toString() {
        return this.status;
    }
}
