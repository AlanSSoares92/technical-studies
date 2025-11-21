package com.estudotecnicojava.javasqltec.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Lancamento")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private Double valor;
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;

}
