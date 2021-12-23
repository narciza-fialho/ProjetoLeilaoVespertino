package com.example.ProjetoLeilaoVespertino.repositories;

import com.example.ProjetoLeilaoVespertino.entities.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompradorRepository extends JpaRepository<Comprador,Integer> {
    List<Comprador> findByAtivo(Boolean ativo);
    List<Comprador> findByTelefone(String telefone);
    List<Comprador> findByEmail(String email);
}
