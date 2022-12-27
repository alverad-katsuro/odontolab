package br.sistema.odonto.odontolab.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.sistema.odonto.odontolab.model.estatico.StatusProcedimento;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
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
@Table(name = "DenteProcedimento")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "denteProcedimentoId")
public class DenteProcedimento {

    @EmbeddedId
    private DenteProcedimentoId denteProcedimentoId;
    
    @MapsId("procedimentoId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "procedimentoId")
    private Procedimento procedimento;

    @MapsId("denteId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Dente dente;

    @Column(name = "denteProcedimentoStatus", nullable = false, unique = false, length = 1)
    @Enumerated(EnumType.STRING)
    private StatusProcedimento denteProcedimentoStatus;

    @Column(name = "denteProcedimentoValor", nullable = false, unique = false, precision = 10)
    private double denteProcedimentoValor;

    @OneToMany(mappedBy = "denteProcedimento")
    private Set<AgendamentoDenteProcedimento> agendamento;
}
