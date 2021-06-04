package com.produtos.apirest.services;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import com.produtos.apirest.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listaProdutos(){
        return produtoRepository.findAll();
    }

    public Produto listaProdutoUnico(Long id){
        return produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(new StringBuilder("Resource not found:  ").append(id).toString()));
    }

    public List<Produto> listProdutoPorNome(@PathVariable(value = "nome") String nome){
        if(!nome.isEmpty())throw new EntityNotFoundException("product not found");
        return produtoRepository.findByProductName(nome);
    }

    public Produto salvaProduto(@RequestBody Produto produto){
        return  produtoRepository.save(produto);
    }

    public List<Produto> listProdutoPorNomeComecaCom(@PathVariable(value = "nome") String nome){
            return produtoRepository.findByProductNameStartsWith(nome);
    }

    public void deletaProduto(@PathVariable(value = "id") long id){
        produtoRepository.deleteById(id);
    }

    public ResponseEntity<Produto> atualizaProduto(@RequestBody Produto produto, @PathVariable(value = "id") long id){
      Produto novoProduto =  produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(new StringBuilder("Resource not found: ").append(id).toString()));
        novoProduto.setLoja(produto.getLoja());
        novoProduto.setValor(produto.getValor());
        novoProduto.setQuantidade(produto.getQuantidade());
        novoProduto.setNome(produto.getNome());
        Produto updated = produtoRepository.save(novoProduto);
        return ResponseEntity.ok().body(updated);

    }

}
