package com.example.ProjetoLeilaoVespertino.repositories;


import com.example.ProjetoLeilaoVespertino.entities.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer> {
    List<Veterinario> findByAtivo(Boolean ativo);
    List<Veterinario> findByTelefone(String telefone);
    List<Veterinario> findByEmail(String email);
}

