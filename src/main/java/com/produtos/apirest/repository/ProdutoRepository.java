package com.produtos.apirest.repository;

import com.produtos.apirest.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("select p from TB_PRODUTO p where p.nome = ?1")
    public List<Produto> findByProductName(String nome);

    @Query("select p from TB_PRODUTO p where p.nome like ?1%")
    public List<Produto> findByProductNameStartsWith(String nome);



}
