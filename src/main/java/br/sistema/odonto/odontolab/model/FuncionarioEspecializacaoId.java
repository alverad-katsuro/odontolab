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
public class FuncionarioEspecializacaoId {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funcionarioEspecializacaoId", unique = true, nullable = false, precision = 10)
    private long funcionarioEspecializacaoId;
    
    @Column(name = "especializacaoId", unique = true, nullable = false, precision = 10)
    private long especializacaoId;

    @Column(name = "pessoaId", unique = true, nullable = false, precision = 10)
    private long pessoaId;
}
