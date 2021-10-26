package com.sistema.financeiro.sisfin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.financeiro.sisfin.model.Receita;
import  com.sistema.financeiro.sisfin.service.ReceitaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Validated
public class ReceitaController {
    
    @Autowired
    private ReceitaService receitaService;

    //Retorna todas as receitas cadastradas
    @GetMapping(path = "/receitas")
    public ResponseEntity<List<Receita>> listar(){
        return new ResponseEntity<>(receitaService.findAll(), HttpStatus.OK);
    }

    //Cria novas receitas
    @PostMapping(path="/receitas")
    public ResponseEntity<Receita> adicionar(@Validated @RequestBody Receita receita) {
        return new ResponseEntity<>(receitaService.salvar(receita), HttpStatus.CREATED);
    }
}
