package com.produtos.apirest.controllers;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class ProdutoController  {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    public List<Produto> listaProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/produtos/{id}")
    public Optional listaProdutoUnico(@PathVariable(value = "id") long id){
        return produtoRepository.findById(id);
    }

    @GetMapping("/produtos/{nome}")
    public List<Produto> listProdutoPorNome(@PathVariable(value = "nome") String nome){
        return produtoRepository.findByProductName(nome);
    }

    @GetMapping("/produtosPorNome/{nome}")
    public List<Produto> listProdutoPorNomeComecaCom(@PathVariable(value = "nome") String nome){
        return produtoRepository.findByProductNameStartsWith(nome);
    }

    @PostMapping("/produtos")
    public Produto salvaProduto(@RequestBody Produto produto){
        return  produtoRepository.save(produto);
    }

    @DeleteMapping("/produtos/s{id}")
    public void deletaProduto(@PathVariable(value = "id") long id){
         produtoRepository.deleteById(id);
    }

    @PutMapping("/produtos/{id}")
    public Produto atualizaProduto(@PathVariable(value = "id")@RequestBody Produto produto ){
        return  produtoRepository.save(produto);

    }

}
