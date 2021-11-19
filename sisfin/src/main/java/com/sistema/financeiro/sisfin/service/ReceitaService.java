package com.sistema.financeiro.sisfin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.financeiro.sisfin.model.Receita;
import com.sistema.financeiro.sisfin.repository.ReceitaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    // Retorna tudo
    public List<Receita> findAll() {
        return receitaRepository.findAll();
    }

    // Salva uma receita ou despesa
    public Receita salvar(Receita r) {
        return receitaRepository.save(r);
    }

    // Busca por ID
    public Object findById(Long id) {
        return receitaRepository.findById(id).get();
    }

    // Retorna a soma de todas as receitas
    public Double getSomaReceitas() {
        return receitaRepository.getSomaReceitas();
    }

    // Deleta alguma receita pelo ID
    public void deletar(Long id) {
        receitaRepository.deleteById(id);
    }

    

}
