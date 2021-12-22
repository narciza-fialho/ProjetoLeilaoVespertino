package com.example.ProjetoLeilaoVespertino.repositories;
import com.example.ProjetoLeilaoVespertino.entities.Comprador;
import com.example.ProjetoLeilaoVespertino.entities.Leilao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LeilaoRepository extends JpaRepository<Leilao,Integer> {
    List<Leilao> findByAtivo(Boolean ativo);
}
