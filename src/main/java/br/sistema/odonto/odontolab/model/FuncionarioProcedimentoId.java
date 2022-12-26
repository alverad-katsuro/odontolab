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
public class FuncionarioProcedimentoId {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funcionarioProcedimentoId", unique = true, nullable = false, precision = 10)
    private long funcionarioProcedimentoId;
    
    @Column(name = "procedimentoId", unique = true, nullable = false, precision = 10)
    private long procedimentoId;

    @Column(name = "pessoaId", unique = true, nullable = false, precision = 10)
    private long pessoaId;
}
