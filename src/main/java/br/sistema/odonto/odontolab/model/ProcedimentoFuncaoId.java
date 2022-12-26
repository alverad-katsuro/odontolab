package br.sistema.odonto.odontolab.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ProcedimentoFuncaoId {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "procedimentoFuncaoId", unique = true, nullable = false, precision = 10)
    private long procedimentoFuncaoId;
    
    @Column(name = "funcaoId", unique = true, nullable = false, precision = 10)
    private long funcaoId;

    @Column(name = "procedimentoId", unique = true, nullable = false, precision = 10)
    private long procedimentoId;
}
