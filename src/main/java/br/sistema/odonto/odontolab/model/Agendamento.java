package br.sistema.odonto.odontolab.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.sistema.odonto.odontolab.model.estatico.StatusAgendamento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agendamentoId", nullable = false, unique = true, precision = 10)
    private long agendamentoId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date agendamentoData;

    @JoinColumn(name = "pessoaId", nullable = false, unique = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Pessoa pessoa;

    @Column(name = "statusAgendamento", nullable = false, unique = false, length = 2)
    @Enumerated(EnumType.STRING)
    private StatusAgendamento statusAgendamento;
}
