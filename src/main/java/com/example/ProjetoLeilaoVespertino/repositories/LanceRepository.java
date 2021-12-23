package com.example.ProjetoLeilaoVespertino.repositories;

import com.example.ProjetoLeilaoVespertino.entities.Lance;
import com.example.ProjetoLeilaoVespertino.entities.Leilao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanceRepository extends JpaRepository<Lance, Integer> {
    List<Lance> findByAtivo(Boolean ativo);
    List<Lance> findByIdLeilao(Integer id);
}
