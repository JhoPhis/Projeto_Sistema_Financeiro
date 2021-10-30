package com.sistema.financeiro.sisfin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.financeiro.sisfin.model.NotaFiscal;

import  com.sistema.financeiro.sisfin.repository.NotaFiscalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotaFiscalService {
    
    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    //Retorna tudo
    public List<NotaFiscal> findAll(){
        return notaFiscalRepository.findAll();
    }

    //Salva uma receita ou despesa
    public NotaFiscal salvar(NotaFiscal nf) {
        return notaFiscalRepository.save(nf);
    }

    //Busca por ID
    public Object findById(Long id) {
        return notaFiscalRepository.findById(id).get();
      }

    //Retorna todas as receitas
    public Double getReceitas(){
        return notaFiscalRepository.getReceitas();
    }

    //Retorna todas as despesas
    public Double getDespesas(){
        return notaFiscalRepository.getDespesas();
    }

    //Retorna despesas vencidas
    public List<NotaFiscal> getDespesasVencidas(){
        return notaFiscalRepository.getDespesasVencidas();
    }

    //Deleta alguma receita ou despesa pelo ID
    public void deletar(Long id) {
        notaFiscalRepository.deleteById(id);
    }
    
}
