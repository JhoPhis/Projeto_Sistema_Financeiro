package com.sistema.financeiro.sisfin.controller;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sistema.financeiro.sisfin.model.Despesa;
import com.sistema.financeiro.sisfin.service.DespesaService;

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
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    // --- GET ---
    @GetMapping(path = "/despesa")
    public @ResponseBody String listar() {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        List<Despesa> notaList = null;
        @SuppressWarnings("unused")
        String exception = null;
        String arrayToJson = null;
        try {
            notaList = despesaService.findAll();
            arrayToJson = objectMapper.writeValueAsString(notaList);
        } catch (Exception ex) {
            ex.printStackTrace();
            exception = ex.getMessage();
        }

        return arrayToJson;
    }

    @GetMapping("/despesa/{id}")
    public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
        return new ResponseEntity<>(despesaService.findById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/somadespesas")
    public ResponseEntity<Double> getSomaDespesas() {
        return new ResponseEntity<>(despesaService.getSomaDespesas(), HttpStatus.OK);
    }

    // --- POST ---
    @PostMapping(path = "/despesa")
    public ResponseEntity<Despesa> adicionar(@Validated @RequestBody Despesa nf) {
        return new ResponseEntity<>(despesaService.salvar(nf), HttpStatus.CREATED);
    }
    // ----------

    // --- DELETE ---
    @DeleteMapping("/despesa/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
        despesaService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
