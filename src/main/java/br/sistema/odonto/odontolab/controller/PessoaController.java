package br.sistema.odonto.odontolab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sistema.odonto.odontolab.model.Pessoa;
import br.sistema.odonto.odontolab.service.PessoaService;


@RestController
public class PessoaController {

    @Autowired
    PessoaService pessoaService;
    
    @GetMapping(value="/pessoas")
    public List<Pessoa> getMethodName() {
        return pessoaService.getPessoas();
    }
    
}
