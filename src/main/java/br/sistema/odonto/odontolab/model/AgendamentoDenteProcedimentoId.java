package br.sistema.odonto.odontolab.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AgendamentoDenteProcedimentoId {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agendamentoDenteProcedimentoId", unique = true, nullable = false, precision = 10)
    private long agendamentoDenteProcedimentoId;

    private AgendamentoId agendamentoId;

    private DenteProcedimentoId denteProcedimentoId;
}
