package com.example.ProjetoLeilaoVespertino.RepositoryTests;

import com.example.ProjetoLeilaoVespertino.entities.Lance;
import com.example.ProjetoLeilaoVespertino.repositories.LanceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LanceRepositoryTests {

    @Autowired
    private LanceRepository lanceRepository;

    private boolean expected;

    public LanceRepositoryTests(){
        expected = true;
    }

    @Test
    public void findByAtivoTest(){

        List<Lance> listaDeLance = lanceRepository.findByAtivo(true);

        assertThat(!listaDeLance.isEmpty()).isEqualTo(expected);
    }
    @Test
    public void findByIdLeilaoTest(){
        List<Lance> listaDeIdLeilao = lanceRepository.findByIdLeilao(7);

        assertThat(!listaDeIdLeilao.isEmpty()).isEqualTo(expected);
    }
}
