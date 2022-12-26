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
@Table(name = "Funcao")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "funcaoId")
public class Funcao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funcaoId", nullable = false, unique = true, precision = 10)
    private long funcaoId;

    @Column(name = "funcaoNome", nullable = false, unique = true, length = 25)
    private String funcaoNome;
    
    @Column(name = "funcaoDescricao", nullable = false, unique = true, length = 40)
    private String funcaoDescricao;

    @OneToMany(mappedBy = "funcao", fetch = FetchType.LAZY)
    private Set<FuncionarioFuncao> funcionarios;

    @OneToMany(mappedBy = "funcao", fetch = FetchType.LAZY)
    private Set<ProcedimentoFuncao> procedimentos;
}
