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
@Table(name = "ProcedimentoFuncao")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "procedimentoFuncaoId")
public class ProcedimentoFuncao {
    
    @EmbeddedId
    private ProcedimentoFuncaoId procedimentoFuncaoId;

    @MapsId("procedimentoId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "procedimentoId")
    private Procedimento procedimento;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("funcaoId")
    @JoinColumn(name = "funcaoId")
    private Funcao funcao;
}
