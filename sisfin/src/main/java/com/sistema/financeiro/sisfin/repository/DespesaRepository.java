package com.sistema.financeiro.sisfin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sistema.financeiro.sisfin.model.Despesa;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

	// Query para buscar despesas vencidas
	@Query(value = "SELECT * FROM despesa d WHERE d.vencimento < curdate()", nativeQuery = true)
	public List<Despesa> getDespesasVencidas();

	// Retorna a soma de todas as despesas

	@Query(value = "SELECT coalesce(SUM(d.valor),0) FROM despesa d", nativeQuery = true)
	public Double getSomaDespesas();
}
