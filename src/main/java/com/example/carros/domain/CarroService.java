package com.example.carros.domain;

import com.example.carros.domain.dto.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {

    @Autowired
    private CarroRepository rep;

    public List<CarroDTO> getCarros() {
        List<Carro> carros = rep.findAll();

        List<CarroDTO> list = new ArrayList<>();

        for (Carro c : carros) {
            list.add(new CarroDTO(c));
        }
        return list;

//        List<CarroDTO> list = carros.stream().map(c -> new CarroDTO(c)).collect(Collectors.toList());
//        return list;
//        ou
//        return rep.findAll().stream().map(c -> new CarroDTO(c)).collect(Collectors.toList());
    }

    public Optional<Carro> getCarroById(Long id) {
        return rep.findById(id);
    }

    public List<CarroDTO> getCarrosByTipo(String tipo) {
        List<Carro> carros = rep.findByTipo(tipo);

        List<CarroDTO> list = new ArrayList<>();

        for (Carro c : carros) {
            list.add(new CarroDTO(c));
        }
        return list;
    }

    public Carro insert(Carro carro) {
        Assert.isNull(carro.getId(), "Não foi possível inserir o registro");
        return rep.save(carro);
    }

    public Carro update(Carro carro, Long id) {
        Assert.isNull(carro.getId(), "Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Carro> optional = getCarroById(id);

        if (optional.isPresent()) {
            Carro db = optional.get();

            // Copiar as propriedades
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());

            // Atualiza o carro
            rep.save(db);

            return db;
        } else {
            throw new RuntimeException("Não foi possível atualizar o registro");
        }

        /* Lambda
        getCarroById(id).map(db -> {
            // Copiar as propriedades
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());

            // Atualiza o carro
            rep.save(db);

            return db;
        }).orElseThrow(() -> new RuntimeException("Não foi possível atualizar o registro"));
         */

    }

    public void delete(Long id) {
        Optional<Carro> carro = getCarroById(id);

        if(carro.isPresent()){
            rep.deleteById(id);
        }
    }
}
