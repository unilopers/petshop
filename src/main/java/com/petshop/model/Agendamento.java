package com.petshop.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "agendamento")
public class Agendamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne @JoinColumn(name = "id_pet")
    private Pet pet;
    @ManyToOne @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @ManyToOne @JoinColumn(name = "id_servico")
    private Servico servico;
    private LocalDateTime dataHora;
    public Agendamento(){}
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
}
