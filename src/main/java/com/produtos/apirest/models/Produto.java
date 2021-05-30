package com.produtos.apirest.models;

import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity(name = "TB_PRODUTO")
@Table(name = "TB_PRODUTO")

public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;

    private BigDecimal quantidade;

    private BigDecimal valor;

    @ManyToOne()
    private Loja loja;
}
