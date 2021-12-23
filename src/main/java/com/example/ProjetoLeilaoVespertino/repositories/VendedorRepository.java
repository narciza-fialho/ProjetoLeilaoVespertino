package com.example.ProjetoLeilaoVespertino.repositories;

import com.example.ProjetoLeilaoVespertino.entities.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
    List<Vendedor> findByAtivo(Boolean ativo);
    //List<Vendedor> findByIdAtivo(Integer id, Boolean ativo);
}
