package com.produtos.apirest.controllers;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProdutoController  {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> listaProdutoUnico(@PathVariable(value = "id") long id){
        Produto produto = produtoService.listaProdutoUnico(id);
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping("/produtos")
    public List<Produto> listaProdutos(){
        return produtoService.listaProdutos();
    }

    @GetMapping("/produtos/{nome}")
    public List<Produto> listProdutoPorNome(@PathVariable(value = "nome") String nome){
        return produtoService.listProdutoPorNome(nome);
    }

    @GetMapping("/produtosPorNome/{nome}")
    public List<Produto> listProdutoPorNomeComecaCom(@PathVariable(value = "nome") String nome){
        return produtoService.listProdutoPorNomeComecaCom(nome);
    }

    @PostMapping("/produtos")
    public Produto salvaProduto(@RequestBody Produto produto){
        return  produtoService.salvaProduto(produto);
    }

    @DeleteMapping("/produtos/s{id}")
    public void deletaProduto(@PathVariable(value = "id") long id){
        produtoService.deletaProduto(id);
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<Produto> atualizaProduto(@PathVariable(value = "id") long id, @RequestBody Produto produto){
        return  produtoService.atualizaProduto(produto, id);

    }

}
