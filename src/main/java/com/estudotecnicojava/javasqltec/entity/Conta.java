package com.estudotecnicojava.javasqltec.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String agencia;
    private String numero;
    private String nomeTitular;
    private String tipo;

    @OneToMany(mappedBy = "conta_id", cascade = CascadeType.ALL)
    private List<Lancamento> lancamentos = new ArrayList<>();

}

