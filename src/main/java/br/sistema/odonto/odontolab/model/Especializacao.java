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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Especializacao")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "especializacaoId")
public class Especializacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "especializacaoId", nullable = false, unique = true, precision = 10)
    private long especializacaoId;
    
    @Column(name = "especializacaoNome", nullable = false, unique = true, length = 20)
    private String especializacaoNome;

    @Column(name = "especializacaoDescricao", nullable = false, unique = true, length = 40)
    private String especializacaoDescricao;

	@OneToMany(mappedBy = "especializacao", fetch = FetchType.LAZY)
    private Set<FuncionarioEspecializacao> especializacoes;
}
