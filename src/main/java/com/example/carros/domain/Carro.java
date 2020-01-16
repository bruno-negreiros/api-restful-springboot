package com.example.carros.domain;

import javax.persistence.*;

// @Entity(name = "carro") - Caso objeto com o nome diferente da tabela.
@Entity
public class Carro {

    @Id // Chave Primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremento
    private Long id;

//    @Column(name = "nome") - Caso propriedade com o nome diferente da coluna da tabela.
    private String nome;
    private String tipo;


    public Carro() {}

    public Carro(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
