package br.sistema.odonto.odontolab.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.sistema.odonto.odontolab.model.estatico.AtivoInativo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
@Table(name = "Funcionario")
@PrimaryKeyJoinColumn(name="pessoaId")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "pessoaId")
public final class Funcionario extends Pessoa {

    @Column(name = "odontologistaCRO", nullable = false, unique = true, length = 11)
    private String odontologistaCRO;

    @Column(name = "funcionarioAtivo", nullable = false, unique = true, length = 1)
    @Enumerated(EnumType.STRING)
    private AtivoInativo funcionarioAtivo;

    @OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY)
    private Set<FuncionarioFuncao> funcoes;

	@OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY)
    private Set<FuncionarioEspecializacao> funcionarios;
}
