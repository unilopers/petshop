package com.petshop.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "funcionario")
public class Funcionario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String funcao;
    private String telefone;
    private LocalDate dataAdmissao;
    public Funcionario(){}
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getNome(){return nome;}
    public void setNome(String nome){this.nome=nome;}
}
