package com.example.ProjetoLeilaoVespertino.BusinessTests;

import com.example.ProjetoLeilaoVespertino.business.AnimalBiz;
import com.example.ProjetoLeilaoVespertino.entities.Animal;
import com.example.ProjetoLeilaoVespertino.repositories.AnimalRepository;
import com.example.ProjetoLeilaoVespertino.repositories.VendedorRepository;
import com.example.ProjetoLeilaoVespertino.repositories.VeterinarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AnimalBizTest {
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private VendedorRepository vendedorRepository;
    @Autowired
    private VeterinarioRepository veterinarioRepository;

    private AnimalBiz animalBiz;

    @Test
    public void RegistroNaoExisteTest() {
        Boolean expected = true;
        Boolean result = false;
        try{
            Animal animal = new Animal();
            animal.setId(0);
            animal.setAtivo(true);
            animal.setRegistro("12233");
            animal.setPreco(1200.0);
            animal.setRaca("Nelore");
            animal.setIdVendedor(42);
            animal.setIdVeterinario(10);
            animalBiz = new AnimalBiz(animal.getId(), animal, animalRepository, vendedorRepository, veterinarioRepository);
            if (animalBiz.registroNaoExiste(animal.getRegistro())) {
                result = true;
            } else {
                result = false;
            }
        } catch (Exception ex) {
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void RegistroSomenteNumerosTest() {
        Boolean expected = true;
        Boolean result = false;
        try {
            Animal animal = new Animal();
            animal.setId(0);
            animal.setAtivo(true);
            animal.setRegistro("12233");
            animal.setPreco(1200.0);
            animal.setRaca("Nelore");
            animal.setIdVendedor(42);
            animal.setIdVeterinario(10);
            animalBiz = new AnimalBiz(animal.getId(), animal, animalRepository, vendedorRepository, veterinarioRepository);
            if(animalBiz.registroSomenteNumeros(animal.getRegistro())){
                result=true;
            }else{
                result=false;
            }


        } catch (Exception ex) {
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void precoValorPositivoTest() {
        Boolean expected = true;
        Boolean result = false;
        try {
            Animal animal = new Animal();
            animal.setId(0);
            animal.setAtivo(true);
            animal.setRegistro("12233");
            animal.setPreco(1200.0);
            animal.setRaca("Nelore");
            animal.setIdVendedor(42);
            animal.setIdVeterinario(10);
            animalBiz = new AnimalBiz(animal.getId(), animal, animalRepository, vendedorRepository, veterinarioRepository);
            if(animalBiz.precoValorPositivo(animal.getPreco())){
                result=true;
            }else{
                result=false;
            }


        } catch (Exception ex) {
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void racaComecaComMaiusculaTest() {
        Boolean expected = true;
        Boolean result = false;
        try {
            Animal animal = new Animal();
            animal.setId(0);
            animal.setAtivo(true);
            animal.setRegistro("12233");
            animal.setPreco(1200.0);
            animal.setRaca("Nelore");
            animal.setIdVendedor(42);
            animal.setIdVeterinario(10);
            animalBiz = new AnimalBiz(animal.getId(), animal, animalRepository, vendedorRepository, veterinarioRepository);
            if(animalBiz.racaComecaComMaiusculo(animal.getRaca())){
                result=true;
            }else{
                result=false;
            }


        } catch (Exception ex) {
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void nomeDiferenteDeNuloTest() {
        Boolean expected = true;
        Boolean result = false;
        try {
            Animal animal = new Animal();
            animal.setId(0);
            animal.setNome("Aauuuuuu");
            animal.setAtivo(true);
            animal.setRegistro("12233");
            animal.setPreco(1200.0);
            animal.setRaca("Nelore");
            animal.setIdVendedor(42);
            animal.setIdVeterinario(10);
            animalBiz = new AnimalBiz(animal.getId(), animal, animalRepository, vendedorRepository, veterinarioRepository);
            if(animalBiz.nomeDiferenteDeNulo(animal.getNome())){
                result=true;
            }else{
                result=false;
            }


        } catch (Exception ex) {
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void verificadorDoVendedorTest() {
        Boolean expected = true;
        Boolean result = false;
        try {
            Animal animal = new Animal();
            animal.setId(0);
            animal.setAtivo(true);
            animal.setRegistro("12233");
            animal.setPreco(1200.0);
            animal.setRaca("Nelore");
            animal.setIdVendedor(42);
            animal.setIdVeterinario(10);
            animalBiz = new AnimalBiz(animal.getId(), animal, animalRepository, vendedorRepository, veterinarioRepository);
            if(animalBiz.verificadorDoVendedor(animal.getIdVendedor())){
                result=true;
            }else{
                result=false;
            }


        } catch (Exception ex) {
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void verificadorDoVeterinarioTest() {
        Boolean expected = true;
        Boolean result = false;
        try {
            Animal animal = new Animal();
            animal.setId(0);
            animal.setAtivo(true);
            animal.setRegistro("12233");
            animal.setPreco(1200.0);
            animal.setRaca("Nelore");
            animal.setIdVendedor(42);
            animal.setIdVeterinario(10);
            animalBiz = new AnimalBiz(animal.getId(), animal, animalRepository, vendedorRepository, veterinarioRepository);
            if(animalBiz.verificadorDoVeterinario(animal.getIdVeterinario())){
                result=true;
            }else{
                result=false;
            }


        } catch (Exception ex) {
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }
}
