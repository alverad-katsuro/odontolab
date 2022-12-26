package br.sistema.odonto.odontolab.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.sistema.odonto.odontolab.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
    List<Pessoa> findAll();

}
