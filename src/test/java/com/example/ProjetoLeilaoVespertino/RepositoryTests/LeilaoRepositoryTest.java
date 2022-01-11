package com.example.ProjetoLeilaoVespertino.RepositoryTests;

import com.example.ProjetoLeilaoVespertino.entities.Leilao;
import com.example.ProjetoLeilaoVespertino.repositories.LeilaoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LeilaoRepositoryTest {
    @Autowired
    private LeilaoRepository leilaoRepository;

    @Test
    public void findByAtivoTest(){
        List<Leilao> lista = leilaoRepository.findByAtivo(true);
        Boolean result = !lista.isEmpty();
        assertThat(true).isEqualTo(result);
    }


}
