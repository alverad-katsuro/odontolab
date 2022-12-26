package br.sistema.odonto.odontolab.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
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
@Table(name = "FuncionarioProcedimento")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "odontologistaEspecializacaoId")
public class FuncionarioProcedimento {
    
    @EmbeddedId
    private FuncionarioProcedimentoId funcionarioProcedimentoId;

    @MapsId("pessoaId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoaId")
    private Funcionario odontologista;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("procedimentoId")
    @JoinColumn(name = "procedimentoId")
    private Procedimento procedimento;

    @Column(name = "funcionarioProcedimentoComissao")
    private float funcionarioProcedimentoComissao;
}
