package com.example.carros.domain.dto;

import com.example.carros.domain.Carro;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class CarroDTO {
    private Long id;
    private String nome;
    private String tipo;

//    Substituído pelo Model Mapper
//    public CarroDTO(Carro c) {
//        this.id = c.getId();
//        this.nome = c.getNome();
//        this.tipo = c.getTipo();
//    }

    public static CarroDTO create(Carro c) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(c, CarroDTO.class); // ATRIBUTOS DO DTO E OBJETO A SER CONVERTIDO TEM QUE SER IGUAIS!!!
    }
}
