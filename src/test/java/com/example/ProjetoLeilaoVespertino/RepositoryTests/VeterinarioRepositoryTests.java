package com.example.ProjetoLeilaoVespertino.RepositoryTests;

import com.example.ProjetoLeilaoVespertino.entities.Veterinario;
import com.example.ProjetoLeilaoVespertino.repositories.VeterinarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class VeterinarioRepositoryTests {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    private Boolean expected;

    public VeterinarioRepositoryTests(){
        expected = true;
    }

    @Test
    public void findByEmailTest(){

        List<Veterinario> lista = veterinarioRepository.findByEmail("emailveterinario4@gmail.com");

        assertThat(!lista.isEmpty()).isEqualTo(expected);
    }

    @Test
    public void findByTelefoneTest(){
        List<Veterinario> lista = veterinarioRepository.findByTelefone("67992409215");

        assertThat(!lista.isEmpty()).isEqualTo(expected);
    }

    @Test
    public void findByAtivoTest(){
        List<Veterinario> lista = veterinarioRepository.findByAtivo(true);

        assertThat(!lista.isEmpty()).isEqualTo(expected);
    }
}
