package br.sistema.odonto.odontolab.model.estatico;


public enum StatusAgendamento {
    PENDENTE("P"),
    REALIZADO("R"),
    REAGENDADO("RA"),
    CANCELADO("C");

    private final String status;

    StatusAgendamento(String status){
        this.status = status;
    }

    public String status() {
        return status;
    }

    public static StatusAgendamento fromStatus(final String status) {
        for (final StatusAgendamento statusAgendamento : StatusAgendamento.values()) {
            if (statusAgendamento.status.equalsIgnoreCase(status)) {
                return statusAgendamento;
            }
        }

        throw new IllegalArgumentException(status);
    }

    @Override
    public String toString() {
        return this.status;
    }
}
