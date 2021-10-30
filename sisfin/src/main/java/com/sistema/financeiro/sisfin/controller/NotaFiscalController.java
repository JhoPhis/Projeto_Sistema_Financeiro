package com.sistema.financeiro.sisfin.controller;

import java.util.List;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sistema.financeiro.sisfin.model.NotaFiscal;
import  com.sistema.financeiro.sisfin.service.NotaFiscalService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Validated
public class NotaFiscalController {
    
    @Autowired
    private NotaFiscalService notaFiscalService;

    // --- GET ---
    @GetMapping(path = "/notafiscal")
    public @ResponseBody String listar(){

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        List<NotaFiscal> notaList = null;
        @SuppressWarnings("unused")
        String exception = null;
        String arrayToJson = null;
        try{
            notaList = notaFiscalService.findAll();
            arrayToJson = objectMapper.writeValueAsString(notaList);
        } catch (Exception ex){
            ex.printStackTrace();
            exception = ex.getMessage();
        }

        return arrayToJson;
    }

    @GetMapping("/notafiscal/{id}")
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
	    return new ResponseEntity<>(notaFiscalService.findById(id), HttpStatus.OK);
	}

    @GetMapping(path="/receitas")
    public ResponseEntity<Double> getReceitas(){
        return new ResponseEntity<>(notaFiscalService.getReceitas(), HttpStatus.OK);
    }

    @GetMapping(path="/despesas")
    public ResponseEntity<Double> getDespesas(){
        return new ResponseEntity<>(notaFiscalService.getDespesas(), HttpStatus.OK);
    }
    // ----------
    
    // --- POST ---
    @PostMapping(path="/notafiscal")
    public ResponseEntity<NotaFiscal> adicionar(@Validated @RequestBody NotaFiscal nf) {
        return new ResponseEntity<>(notaFiscalService.salvar(nf), HttpStatus.CREATED);
    }
    // ----------

    // --- DELETE ---
    @DeleteMapping("/notafiscal/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
        notaFiscalService.deletar(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
}
