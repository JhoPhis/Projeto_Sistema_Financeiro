package com.sistema.financeiro.sisfin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.financeiro.sisfin.model.Receita;

import  com.sistema.financeiro.sisfin.repository.ReceitaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReceitaService {
    
    @Autowired
    private ReceitaRepository receitaRepository;

    public List<Receita> findAll(){
        return receitaRepository.findAll();
    }

    public Receita salvar(Receita receita) {
        return receitaRepository.save(receita);
      }
}
