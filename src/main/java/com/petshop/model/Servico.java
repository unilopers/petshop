package com.petshop.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "servico")
public class Servico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal precoBase;
    private String descricao;
    public Servico(){}
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getNome(){return nome;}
    public void setNome(String nome){this.nome=nome;}
    public BigDecimal getPrecoBase(){return precoBase;}
    public void setPrecoBase(BigDecimal precoBase){this.precoBase=precoBase;}
}
