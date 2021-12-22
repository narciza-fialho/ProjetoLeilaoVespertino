package com.example.ProjetoLeilaoVespertino.repositories;

import com.example.ProjetoLeilaoVespertino.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findByAtivo(Boolean ativo);
}
