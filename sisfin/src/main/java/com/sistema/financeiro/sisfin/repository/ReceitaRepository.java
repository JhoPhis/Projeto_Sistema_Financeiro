package com.sistema.financeiro.sisfin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.sistema.financeiro.sisfin.model.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    //Query para buscar entre as datas
	@Query(value ="SELECT (FLOOR(year(r.criado) / 10) * 10) AS Decada, COUNT(id) AS Quantidade FROM Receita r GROUP BY FLOOR(year(r.criado)/ 10)", nativeQuery = true)
	public List<String> findDecada();

    //Query para buscar receitas adicionadas recentemente
	@Query(value = "SELECT * FROM Receita r WHERE r.criado >= curdate() - INTERVAL DAYOFWEEK(curdate())+6 DAY", nativeQuery = true)
	public List<Receita> ultimaSemana();
}
