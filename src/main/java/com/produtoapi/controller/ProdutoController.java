package com.produtoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.produtoapi.model.Produto;
import com.produtoapi.service.ProdutoService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public List<Produto> listarTodos() {
		return produtoService.listarTodos();
	}
	
	@PostMapping
	public Produto salvar(@RequestBody Produto produto) {
		return produtoService.salvar(produto);
	}
	
	@PutMapping("/{id}")
	public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
		return produtoService.atualizar(id, produto);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		produtoService.deletar(id);
	}
	
	@GetMapping("/{id}")
	public Optional<Produto> findById(@PathVariable Long id) {
		return produtoService.findById(id);
	}
	
	@PostMapping("/salvarLista")
	public List<Produto> salvarLista(@RequestBody List<Produto> produtos) {
		return produtoService.salvarLista(produtos);
	}
	
	// ======================================
	// ==== BUSCAS DETALHADAS POR NOME   ====
	// ======================================
	
	@GetMapping("/buscarPorNome")
	public List<Produto> buscarPorNome(@RequestParam String nome) {
		return produtoService.findByNome(nome);
	}
	
	@GetMapping("/buscarPorNomeContendo")
	public List<Produto> buscarPorNomeContendo(@RequestParam String nome) {
		return produtoService.findByNomeContaining(nome);
	}
	
	@GetMapping("/buscarPorNomeEStatus")
	public List<Produto> buscarPorNomeEStatus(@RequestParam String nome, @RequestParam String status) {
		return produtoService.findByNomeAndStatus(nome, status);
	}
	
	@GetMapping("/buscarPorNomeComecandoCom")
	public List<Produto> buscarPorNomeComecandoCom(@RequestParam String valor) {
		return produtoService.findByNomeStartingWith(valor);
	}
	
	@GetMapping("/buscarPorNomeTerminandoCom")
	public List<Produto> buscarPorNomeTerminandoCom(@RequestParam String valor) {
		return produtoService.findByNomeEndingWith(valor);
	}
	
	// ======================================
	// ==== BUSCAS DETALHADAS POR PREÇO  ====
	// ======================================
	
	@GetMapping("/buscarPorPreco")
	public List<Produto> buscarPorPreco(@RequestParam Double preco) {
		return produtoService.findByPreco(preco);
	}
	
	@GetMapping("/buscarPorPrecoMaiorQue")
	public List<Produto> buscarPorPrecoMaiorQue(@RequestParam Double preco) {
		return produtoService.findByPrecoGreaterThan(preco);
	}
	
	@GetMapping("/buscarPorPrecoMenorQue")
	public List<Produto> buscarPorPrecoMenorQue(@RequestParam Double preco) {
		return produtoService.findByPrecoLessThan(preco);
	}
	
	@GetMapping("/buscarTotalPreco")
	public Double buscarTotalPreco() {
		return produtoService.buscarTotalPreco();
	}
	
	// ===========================================
	// ==== BUSCAS DETALHADAS POR QUANTIDADE  ====
	// ===========================================
	
	@GetMapping("/buscarPorQuantidade")
	public List<Produto> buscarPorQuantidade(@RequestParam Integer quantidade) {
		return produtoService.findByQuantidade(quantidade);
	}
	
	@GetMapping("/buscarPorQuantidadeMenorQue")
	public List<Produto> buscarPorQuantidadeMenorQue(@RequestParam Integer quantidade) {
		return produtoService.findByQuantidadeLessThan(quantidade);
	}
	
	@GetMapping("/buscarPorQuantidadeMaiorQue")
	public List<Produto> buscarPorQuantidadeMaiorQue(@RequestParam Integer quantidade) {
		return produtoService.findByQuantidadeGreaterThan(quantidade);
	}
}