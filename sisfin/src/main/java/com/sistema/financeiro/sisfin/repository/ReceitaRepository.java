package com.sistema.financeiro.sisfin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sistema.financeiro.sisfin.model.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

	// Retorna a soma de todas as receitas
	@Query(value = "SELECT coalesce(SUM(r.valor),0) FROM receita r", nativeQuery = true)
	public Double getSomaReceitas();
}
