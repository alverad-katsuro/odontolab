package br.sistema.odonto.odontolab.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "Procedimento")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "procedimentoId")
public class Procedimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "procedimentoId", nullable = false, unique = true, precision = 10)
    private long procedimentoId;

    @Column(name = "procedimentoNome", length = 30)
    private String procedimentoNome;

    @Column(name = "procedimentoDescricao", length = 50)
    private String procedimentoDescricao;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "especialidadeId", nullable = false, unique = false)
    private Especialidade especialidade;

    @OneToMany(mappedBy = "procedimento", fetch = FetchType.LAZY)
    private Set<DenteProcedimento> denteProcedimentos;

    @OneToMany(mappedBy = "procedimento", fetch = FetchType.LAZY)
    private Set<ProcedimentoFuncao> funcoes;
}
