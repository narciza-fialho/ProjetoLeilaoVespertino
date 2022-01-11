package com.example.ProjetoLeilaoVespertino.BusinessTests;

import com.example.ProjetoLeilaoVespertino.business.VeterinarioBiz;
import com.example.ProjetoLeilaoVespertino.entities.Veterinario;
import com.example.ProjetoLeilaoVespertino.repositories.VeterinarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class VeterinarioBizTests {

    private VeterinarioBiz veterinarioBiz;
    private Veterinario veterinario;

    private Boolean expected;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public VeterinarioBizTests(){
        expected = true;
    }

    @Test
    public void nomeMin2LetraTest(){


        veterinario = new Veterinario();

        veterinario.setNome("Maria");

        veterinarioBiz = new VeterinarioBiz(0, veterinario, veterinarioRepository);

        Boolean result = veterinarioBiz.nomeMin2Letra(veterinario.getNome());

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void telefoneExisteTest(){

        veterinario = new Veterinario();

        veterinario.setTelefone("00000000000");

        veterinarioBiz = new VeterinarioBiz(0, veterinario, veterinarioRepository);

        Boolean result = veterinarioBiz.telefoneExiste(veterinario.getTelefone());

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void emailExisteTest(){

        veterinario = new Veterinario();

        veterinario.setEmail("mariadb@hotmail.com");

        veterinarioBiz = new VeterinarioBiz(0, veterinario, veterinarioRepository);

        Boolean result = veterinarioBiz.emailExiste(veterinario.getEmail());

        assertThat(result).isEqualTo(expected);
    }



}
