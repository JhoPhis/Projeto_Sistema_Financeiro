package com.sistema.financeiro.sisfin.controller;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sistema.financeiro.sisfin.model.Receita;
import com.sistema.financeiro.sisfin.service.ReceitaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Validated
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    // --- GET ---
    @GetMapping(path = "/receita")
    public @ResponseBody String listar() {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        List<Receita> notaList = null;
        @SuppressWarnings("unused")
        String exception = null;
        String arrayToJson = null;
        try {
            notaList = receitaService.findAll();
            arrayToJson = objectMapper.writeValueAsString(notaList);
        } catch (Exception ex) {
            ex.printStackTrace();
            exception = ex.getMessage();
        }

        return arrayToJson;
    }

    @GetMapping("/receita/{id}")
    public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
        return new ResponseEntity<>(receitaService.findById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/somareceitas")
    public ResponseEntity<Double> getSomaReceitas() {
        return new ResponseEntity<>(receitaService.getSomaReceitas(), HttpStatus.OK);
    }

    // --- POST ---
    @PostMapping(path = "/receita")
    public ResponseEntity<Receita> adicionar(@Validated @RequestBody Receita r) {
        return new ResponseEntity<>(receitaService.salvar(r), HttpStatus.CREATED);
    }
    // ----------

    // --- DELETE ---
    @DeleteMapping("/receita/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
        receitaService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
