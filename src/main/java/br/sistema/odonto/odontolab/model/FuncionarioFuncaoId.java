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
public class FuncionarioFuncaoId {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funcionarioFuncaoId", unique = true, nullable = false, precision = 10)
    private long funcionarioFuncaoId;
    
    @Column(name = "funcaoId", unique = true, nullable = false, precision = 10)
    private long funcaoId;

    @Column(name = "pessoaId", unique = true, nullable = false, precision = 10)
    private long pessoaId;
}
