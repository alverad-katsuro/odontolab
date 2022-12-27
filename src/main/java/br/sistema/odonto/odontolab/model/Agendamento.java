package br.sistema.odonto.odontolab.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.sistema.odonto.odontolab.model.estatico.StatusAgendamento;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Agendamento")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "agendamentoId")
public class Agendamento {
    
    @EmbeddedId
    private AgendamentoId agendamentoId;

    @JoinColumn(name = "pessoaId", nullable = false, unique = false, referencedColumnName = "pessoaId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pessoa pessoa;

    @JoinColumn(name = "funcionarioId", nullable = false, unique = false, referencedColumnName = "pessoaId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Funcionario funcionario;

    @Column(name = "statusAgendamento", nullable = false, unique = false, length = 2)
    @Enumerated(EnumType.STRING)
    private StatusAgendamento statusAgendamento;

    @Column(name = "agendamentoPago", nullable = false, unique = false)
    private boolean agendamentoPago;

    @OneToMany(mappedBy = "agendamento")
    private Set<AgendamentoDenteProcedimento> denteProcedimentos;
}
