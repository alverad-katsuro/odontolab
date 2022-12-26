package br.sistema.odonto.odontolab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sistema.odonto.odontolab.model.Pessoa;
import br.sistema.odonto.odontolab.repository.PessoaRepository;

@Service
public class PessoaService {
    
    @Autowired
    PessoaRepository pessoaRepository;

    public List<Pessoa> getPessoas(){
        return pessoaRepository.findAll();
    }
}
