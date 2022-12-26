package br.sistema.odonto.odontolab.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Dente")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "denteId")
public class Dente {

    @EmbeddedId
    private DenteId denteId;

    @Column(name = "denteNumero", unique = true, nullable = false, length = 4)
    private String denteNumero;
    
    @Column(name = "denteExiste", unique = true, nullable = false, length = 1)
    private boolean denteExiste;

    @MapsId("odontogramaId")
    @JoinColumn(name = "odontogramaId", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Odontograma odontograma;

    @OneToMany(mappedBy = "dente", fetch = FetchType.LAZY)
    private Set<DenteProcedimento> denteProcedimentos;
}
