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
public class DenteProcedimentoId {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "denteProcedimentoId", unique = true, nullable = false, precision = 10)
    private long denteProcedimentoId;

    @Column(name = "denteId", unique = true, nullable = false, precision = 10)
    private long denteId;
    
    @Column(name = "odontogramaId", unique = true, nullable = false, precision = 10)
    private long odontogramaId;
    
    @Column(name = "procedimentoId", unique = true, nullable = false, precision = 10)
    private long procedimentoId;
}
