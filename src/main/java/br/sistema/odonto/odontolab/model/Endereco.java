package br.sistema.odonto.odontolab.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.sistema.odonto.odontolab.model.estatico.UnidadeFederacao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
@Table(name = "Endereco")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "enderecoId")
public class Endereco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enderecoId", unique = true, nullable = false, precision = 10)
    private long enderecoId;
    
    @Column(name = "enderecoRua", nullable = false, unique = false, length = 40)
    private String enderecoRua;
    
    @Column(name = "enderecoNumero", nullable = false, unique = false, length = 10)
    private String enderecoNumero;
    
    @Column(name = "enderecoComplemento", nullable = false, unique = false, length = 40)
    private String enderecoComplemento;
    
    @Column(name = "enderecoBairro", nullable = false, unique = false, length = 30)
    private String enderecoBairro;
    
    @Column(name = "enderecoCidade", nullable = false, unique = false, length = 30)
    private String enderecoCidade;
    
    @Column(name = "enderecoEstado", nullable = false, unique = false, length = 2)
    private UnidadeFederacao enderecoEstado;
    
    @Column(name = "enderecoPais", nullable = false, unique = false, length = 10)
    private String enderecoPais;
    
    @Column(name = "enderecoCEP", nullable = false, unique = false, length = 9)
    private String enderecoCEP;

    @OneToOne(mappedBy = "endereco", fetch = FetchType.LAZY)
    private Pessoa pessoa;
    
    @OneToOne(mappedBy = "endereco", fetch = FetchType.LAZY)
    private Clinica clinica;
}
