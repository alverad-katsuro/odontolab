package br.sistema.odonto.odontolab.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "Especialidade")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "especialidadeId")
public class Especialidade {
    
    @Id
    @Column(name = "especialidadeId", nullable = false, unique = true, precision = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long especialidadeId;

    @Column(name = "especilidadeNome", nullable = false, unique = true, length = 25)
    private String especilidadeNome;

    @OneToMany(mappedBy = "especialidade")
    private Set<Procedimento> procedimentos;
}
