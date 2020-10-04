package com.mleitejunior.lanchesrestapispring.service;

import com.mleitejunior.lanchesrestapispring.model.OrderItem;
import com.mleitejunior.lanchesrestapispring.model.Sandwich;
import com.mleitejunior.lanchesrestapispring.repository.SandwichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SandwichService {

    @Autowired
    private SandwichRepository repository;

    public Sandwich saveSandwich(Sandwich sandwich) {
        return repository.save(sandwich);
    }

    public List<Sandwich> saveSandwich(List<Sandwich> sandwiches) {
        return repository.saveAll(sandwiches);
    }

    public List<Sandwich> getSandwiches() {
        return repository.findAll();
    }

    public Sandwich getSandwichById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Sandwich getSandwichByName(String name) {
        return repository.findByName(name);
    }

    public Sandwich updateSandwich(Sandwich sandwich) {
        if (repository.findById(sandwich.getId()) != null) {
            return repository.save(sandwich);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sandwich not found");
    }

    public String deleteSandwich(int id) {
        repository.deleteById(id);

        return "Sandwich removed : " + id;
    }

}
