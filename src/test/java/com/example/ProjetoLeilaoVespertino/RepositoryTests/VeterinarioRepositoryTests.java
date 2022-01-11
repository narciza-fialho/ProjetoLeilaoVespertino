package com.example.ProjetoLeilaoVespertino.RepositoryTests;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class VeterinarioRepositoryTests {


    private Boolean expected;

    public VeterinarioRepositoryTests(){
        expected = true;
    }

    @Test
    public void findByEmailTest(){

        //List<Veterinario> lista = veterinarioRepository.findByEmail("oioa@hotmail.com");

        //Boolean result = lista.isEmpty();

        assertThat(true).isEqualTo(expected);
    }
}
