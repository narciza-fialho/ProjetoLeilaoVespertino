package com.example.ProjetoLeilaoVespertino;

import com.example.ProjetoLeilaoVespertino.controller.AnimalController;
import com.example.ProjetoLeilaoVespertino.entities.Animal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AnimalControllerTests {


    @Autowired
    private AnimalController animalController;

    private int idAnimalTeste;

    public AnimalControllerTests(){
        this.idAnimalTeste = 2;
    }

    @Test
    public void BuscarTest( ){
        Boolean expected = true;
        Boolean result = false;
        try {
            //area de execução
            Animal animalTest = animalController.buscar(this.idAnimalTeste);
            if (animalTest.getId() == this.idAnimalTeste){
                result = true;
            } else {
                result = false;
            }
        } catch (Exception ex){
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void ListarTest(){
        Boolean expected = true;
        Boolean result = false;

        if (animalController.listar().stream().count() > 0){
            result = true;
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void IncluirTest(){
        Boolean expected = true;
        Boolean result = false;
        long registros_antes;
        long registros_depois;

        try {
            registros_antes = animalController.listar().stream().count();
            Animal animal = new Animal();
            animal.setAtivo(true);
            animal.setIdVendedor(11);
            animal.setNome("Boi de teste");
            animal.setIdVeterinario(5);
            animal.setId(0);
            animal.setPreco(1200.0);
            animal.setRegistro("35646");
            animal.setRaca("Nelore");
            animalController.incluir(animal);

            registros_depois = animalController.listar().stream().count();
            if (registros_depois > registros_antes){
                result = true;
            } else {
                result = false;
            }

        } catch (Exception ex){
            result = false;
        }
        assertThat(result).isEqualTo(expected);

    }
}
