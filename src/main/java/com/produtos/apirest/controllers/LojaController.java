package com.produtos.apirest.controllers;

import com.produtos.apirest.models.Loja;
import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class LojaController {

    @Autowired
    LojaRepository lojaRepository;

    @GetMapping("/lojas")
    public List<Loja> listaLojas(){
        return lojaRepository.findAll();
    }

    @GetMapping("lojas/{id}")
    public Optional listLojaUnica(@PathVariable(value = "id") long id){
        return lojaRepository.findById(id);
    }

    @PostMapping("/lojas")
    public Loja salvaProduto(@RequestBody Loja loja){
        return  lojaRepository.save(loja);
    }

    @DeleteMapping("/lojas/{id}")
    public void deletaLoja(@PathVariable(value = "id") long id){
        lojaRepository.deleteById(id);
    }

    @PutMapping("/lojas/{id}")
    public Loja atualizaProduto(@PathVariable(value = "id")@RequestBody Loja loja ){
        return  lojaRepository.save(loja);

    }
}
