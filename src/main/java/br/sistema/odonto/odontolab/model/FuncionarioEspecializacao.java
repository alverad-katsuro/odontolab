package br.sistema.odonto.odontolab.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
@Table(name = "FuncionarioEspecializacao")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "funcionarioEspecializacaoId")
public class FuncionarioEspecializacao {
    
    @EmbeddedId
    private FuncionarioEspecializacaoId funcionarioEspecializacaoId;

    @MapsId("pessoaId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoaId")
    private Funcionario funcionario;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("especializacaoId")
    @JoinColumn(name = "especializacaoId")
    private Especializacao especializacao;
}
