package com.example.ProjetoLeilaoVespertino.RepositoryTests;

import com.example.ProjetoLeilaoVespertino.entities.Animal;
import com.example.ProjetoLeilaoVespertino.entities.Lance;
import com.example.ProjetoLeilaoVespertino.repositories.AnimalRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AnimalRepositoryTest {
    @Autowired
    private AnimalRepository animalRepository;

    private boolean expected;

    public AnimalRepositoryTest(){
        expected = true;
    }

    @Test
    public void findByAtivoTest(){

        List<Animal> listaDeAnimal = animalRepository.findByAtivo(true);

        assertThat(!listaDeAnimal.isEmpty()).isEqualTo(expected);
    }

    @Test
    public void findByRegistrTest(){

        List<Animal> listaDeIdRegistro = animalRepository.findByRegistro("22222");

        assertThat(!listaDeIdRegistro.isEmpty()).isEqualTo(expected);
    }

    @Test
    public void findByIdVendedorTest(){
        List<Animal> listaDeIdVendedor = animalRepository.findByIdVendedor(42);

        assertThat(!listaDeIdVendedor.isEmpty()).isEqualTo(expected);
    }

    @Test
    public void findByIdVeterinarioTest(){
        List<Animal> listaDeIdVeterinario = animalRepository.findByIdVeterinario(10);

        assertThat(!listaDeIdVeterinario.isEmpty()).isEqualTo(expected);
    }

}
