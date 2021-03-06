package com.example.ProjetoLeilaoVespertino.ControllerTests;

import com.example.ProjetoLeilaoVespertino.Mensagem;
import com.example.ProjetoLeilaoVespertino.controller.AnimalController;
import com.example.ProjetoLeilaoVespertino.entities.Animal;
import com.example.ProjetoLeilaoVespertino.repositories.AnimalRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AnimalControllerTests {


    @Autowired
    private AnimalController animalController;
    @Autowired
    private AnimalRepository animalRepository;

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
            animal.setNome("Boi de teste" + (registros_antes +1000000));
            animal.setIdVeterinario(5);
            animal.setId(0);
            animal.setPreco(1200.0);
            animal.setRegistro("35646" + (registros_antes +1000000) );
            animal.setRaca("Nelore");
            Mensagem msg = animalController.incluir(animal);

            registros_depois = animalController.listar().stream().count();
            System.out.println("Teste de animal controller:");
            if (registros_depois == registros_antes + 1){
                result = true;
            } else {
                result = false;
                for(String s: msg.getErro()){
                    System.out.println(s);
                }

            }

        } catch (Exception ex){
            result = false;
        }
        assertThat(result).isEqualTo(expected);

    }

    @Test
    public void AlterarTest() {
        Boolean expected = true;
        Boolean result = false;

        try {
            Animal animalTeste = new Animal();
            animalTeste = animalController.buscar(44);

            animalTeste.setNome("Boi teste alterar");
            animalTeste.setPreco(1500.00);
            animalTeste.setRaca("Nelore");
            animalTeste.setRegistro("8510");
            animalTeste.setIdVendedor(5);
            animalTeste.setIdVendedor(39);
            animalTeste.setAtivo(true);
            Mensagem msg = animalController.alterar(animalTeste);

            if (!msg.getErro().isEmpty()) {
                result = false;
            } else {
                result = true;
            }
        } catch (Exception ex){
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void DeletarTest() {
        Boolean expected = true;
        Boolean result = false;

        Animal animaldelet = animalController.buscar(4);

        try {
            animaldelet.setAtivo(false);
            animalController.Deletar(animaldelet.getId());
            List<Animal> lista = animalRepository.findByAtivo(true);
            if (lista.contains(animaldelet)) {
                result = false;
            } else {
                result = true;
            }
        } catch (Exception ex) {
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }


}
