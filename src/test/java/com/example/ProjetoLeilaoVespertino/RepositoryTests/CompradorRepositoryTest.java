package com.example.ProjetoLeilaoVespertino.RepositoryTests;

import com.example.ProjetoLeilaoVespertino.entities.Comprador;
import com.example.ProjetoLeilaoVespertino.repositories.CompradorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CompradorRepositoryTest {
    @Autowired
    private CompradorRepository compradorRepository;

    @Test
    public void findByAtivoTest() {
        List<Comprador> lista = compradorRepository.findByAtivo(true);
        Boolean result = !lista.isEmpty();
        assertThat(true).isEqualTo(result);
    }

    @Test
    public void findByTelefoneTest() {
        List<Comprador> lista = compradorRepository.findByTelefone("9433867512");
        Boolean result = !lista.isEmpty();
        assertThat(true).isEqualTo(result);
    }

    @Test
    public void findByEmailTest() {
        List<Comprador> lista = compradorRepository.findByEmail("carmeqq@gmail.com");
        Boolean result = !lista.isEmpty();
        assertThat(true).isEqualTo(result);
    }
}
