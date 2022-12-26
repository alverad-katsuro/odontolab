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
@Table(name = "Odontograma")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "odontogramaId")
public class Odontograma {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "odontogramaId", unique = true, nullable = false, precision = 10)
    private long odontogramaId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoaId")
    private Pessoa pessoa;

    @OneToMany(mappedBy = "odontograma", fetch = FetchType.LAZY)
    private Set<Dente> dentes;
}
