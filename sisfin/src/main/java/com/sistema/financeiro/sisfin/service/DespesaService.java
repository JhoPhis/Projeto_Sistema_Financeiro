package com.sistema.financeiro.sisfin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.financeiro.sisfin.model.Despesa;
import com.sistema.financeiro.sisfin.repository.DespesaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    // Retorna tudo
    public List<Despesa> findAll() {
        return despesaRepository.findAll();
    }

    // Salva uma receita ou despesa
    public Despesa salvar(Despesa nf) {
        return despesaRepository.save(nf);
    }

    // Busca por ID
    public Object findById(Long id) {
        return despesaRepository.findById(id).get();
    }

    // Retorna a soma de todas as despesas
    public Double getSomaDespesas() {
        return despesaRepository.getSomaDespesas();
    }

    // Retorna despesas vencidas
    public List<Despesa> getDespesasVencidas() {
        return despesaRepository.getDespesasVencidas();
    }

    // Deleta alguma receita ou despesa pelo ID
    public void deletar(Long id) {
        despesaRepository.deleteById(id);
    }

}
