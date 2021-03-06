package com.sistema.financeiro.sisfin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sistema.financeiro.sisfin.model.NotaFiscal;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long> {

    //Query para buscar despesas vencidas
	@Query(value = "SELECT * FROM nota_fiscal nf WHERE nf.vencimento < curdate()", nativeQuery = true)
	public List<NotaFiscal> getDespesasVencidas();

	//Retorna a soma de todas as receitas
	@Query(value = "SELECT SUM(nf.valor) FROM nota_fiscal nf WHERE eh_despesa = 0", nativeQuery = true)
	public Double getSomaReceitas();

	//Retorna a soma de todas as despesas
	@Query(value = "SELECT SUM(nf.valor) FROM nota_fiscal nf WHERE eh_despesa = 1", nativeQuery = true)
	public Double getSomaDespesas();

	//Retorna lista de receitas
	@Query(value = "SELECT nf.nome, nf.descricao, nf.data, nf.valor FROM nota_fiscal nf WHERE eh_despesa = 0", nativeQuery = true)
	public List<?> getListaReceitas();
	
	//Retorna lista de receitas
	@Query(value = "SELECT nf.nome, nf.descricao, nf.data, nf.valor, nf.vencimento FROM nota_fiscal nf WHERE eh_despesa = 1", nativeQuery = true)
	public List<?> getListaDespesas();

}
