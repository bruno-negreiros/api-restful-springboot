package com.example.carros.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository rep;

    public Iterable<Carro> getCarros() {
        return rep.findAll();
    }

    public List<Carro> getCarrosFake() {
        List<Carro> carros = new ArrayList<Carro>();

        carros.add(new Carro(1L, "Fusca"));
        carros.add(new Carro(2L, "Brasília"));
        carros.add(new Carro(3L, "Chevette"));

        return carros;
    }

    public Optional<Carro> getCarroById(Long id) {
        return rep.findById(id);
    }

    public Iterable<Carro> getCarrosByTipo(String tipo) {
        return rep.findByTipo(tipo);
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
