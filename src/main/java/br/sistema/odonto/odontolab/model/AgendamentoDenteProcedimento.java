package br.sistema.odonto.odontolab.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.PrimaryKeyJoinColumns;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AgendamentoDenteProcedimento")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "agendamentoDenteProcedimentoId")
public class AgendamentoDenteProcedimento {
    
    @EmbeddedId
    private AgendamentoDenteProcedimentoId agendamentoDenteProcedimentoId;

    @MapsId("denteProcedimentoId")
    @ManyToOne(fetch = FetchType.LAZY)
    private DenteProcedimento denteProcedimento;

    @MapsId("agendamentoId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Agendamento agendamento;
}
