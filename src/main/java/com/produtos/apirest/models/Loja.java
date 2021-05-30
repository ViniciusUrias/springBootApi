package com.produtos.apirest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity(name = "TB_LOJA")
@Table(name = "TB_LOJA")
public class Loja implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;

    private String cidade;


    @OneToMany(cascade = CascadeType.ALL, targetEntity = Produto.class)
    @JoinColumn(name = "produtos")
    @JsonIgnore
    private List<Produto> produtos ;




}
