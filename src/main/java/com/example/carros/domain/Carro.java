package com.example.carros.domain;

import lombok.*;

import javax.persistence.*;


@Entity // @Entity(name = "carro") - Caso objeto com o nome diferente da tabela.
@Data // equivale ao @Getter, @Setter, @ToString e @EqualsAndHashCode.
@NoArgsConstructor
@AllArgsConstructor
public class Carro {

    @Id // Chave Primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremento.
    private Long id;

    private String nome; //    @Column(name = "nome") - Caso propriedade com o nome diferente da coluna da tabela.
    private String tipo;

}
