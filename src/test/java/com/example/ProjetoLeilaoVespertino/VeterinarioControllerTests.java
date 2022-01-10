package com.example.ProjetoLeilaoVespertino;

import com.example.ProjetoLeilaoVespertino.controller.VeterinarioController;
import com.example.ProjetoLeilaoVespertino.entities.Animal;
import com.example.ProjetoLeilaoVespertino.entities.Veterinario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class VeterinarioControllerTests {

    @Autowired
    private VeterinarioController veterinarioController;

    private int idVeterinario;

    public VeterinarioControllerTests(){
        idVeterinario = 999999;
    }

    @Test
    public void BuscarTest(){
        Boolean expected = true;
        Boolean result = false;
        try {
            Veterinario vetTest = veterinarioController.buscar(this.idVeterinario);

            if (vetTest.getId() == this.idVeterinario){
                result = true;
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

        if (veterinarioController.listar().stream().count() > 0){
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
            registros_antes = veterinarioController.listar().stream().count();

            Veterinario veterinario = new Veterinario();

            veterinario.setId(0);
            veterinario.setNome("Haniel");
            veterinario.setEmail("dala@hotmail.com");
            veterinario.setTelefone("4521451452");
            veterinario.setAtivo(true);

            veterinarioController.incluir(veterinario);

            registros_depois = veterinarioController.listar().stream().count();

            if (registros_depois > registros_antes){
                result = true;
            }

        } catch (Exception ex){
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }
/*
    @Test
    public void ExcluirTest(){
        Boolean expected = true;
        Boolean result = false;
        long registros_antes;
        long registros_depois;

        try {


            Veterinario veterinario = new Veterinario();

            veterinario.setId(0);
            veterinario.setNome("Haniel");
            veterinario.setEmail("dala@hotmail.com");
            veterinario.setTelefone("4521451452");
            veterinario.setAtivo(true);

            registros_antes = veterinarioController.deletar(1);

            registros_depois = veterinarioController.listar().stream().count();

            if (registros_depois > registros_antes){
                result = true;
            }

        } catch (Exception ex){
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }*/

}
