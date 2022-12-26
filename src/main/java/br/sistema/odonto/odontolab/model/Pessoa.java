package br.sistema.odonto.odontolab.model;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "Pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "pessoaId")
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pessoaId", unique = true, nullable = false, precision = 10)
    private long pessoaId;

    @Column(name = "pessoaNome", nullable = false, length = 15)
    private String pessoaNome;

    @Column(name = "pessoaSobrenome", nullable = false, length = 40)
    private String pessoaSobrenome;
    
    @Column(name = "pessoaTelefone", nullable = true, length = 15)
    private String pessoaTelefone;

    @Temporal(TemporalType.DATE)
    @Column(name = "pessoaNascimento", nullable = true)
    private Date pessoaNascimento;

    @Temporal(TemporalType.DATE)
    @Column(name = "pessoaRegistro", nullable = true, updatable = false)
    private Date pessoaRegistro;

    @OneToOne(mappedBy = "pessoa")
    private Usuario usuario;

    @OneToOne(mappedBy = "pessoa", fetch = FetchType.LAZY)
    private Odontograma odontograma;

    @OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
    private Set<Agendamento> agendamentos;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "enderecoId", nullable = true)
    private Endereco endereco;
}
