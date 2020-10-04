package com.mleitejunior.lanchesrestapispring.service;

import com.mleitejunior.lanchesrestapispring.model.Sandwich;
import com.mleitejunior.lanchesrestapispring.repository.SandwichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public String deleteSandwich(int id) {
        repository.deleteById(id);

        return "Sandwich removed : " + id;
    }

}
