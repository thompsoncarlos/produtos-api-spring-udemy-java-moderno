package com.produtoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.produtoapi.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
