package com.produtoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.produtoapi.model.Produto;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	// Busca por Nome
	List<Produto> findByNome(String nome);
	
	List<Produto> findByNomeContaining(String nome);
	
	List<Produto> findByNomeAndStatus(String nome, String status);
	
	List<Produto> findByNomeStartingWith(String prefix);
	
	List<Produto> findByNomeEndingWith(String suffix);
	
	// Busca por Preço
	List<Produto> findByPreco(Double preco);
	
	List<Produto> findByPrecoGreaterThan(Double preco);

	List<Produto> findByPrecoLessThan(Double preco);
	
	// Usando anottation @Query para obter total de preços
	@Query("SELECT SUM(p.preco) FROM Produto p")
	Double findTotalPreco();
	
	// Busca por Quantidade
	List<Produto> findByQuantidade(Integer quantidade);
	
	List<Produto> findByQuantidadeLessThan(Integer quantidade);
	
	List<Produto> findByQuantidadeGreaterThan(Integer quantidade);
} 
