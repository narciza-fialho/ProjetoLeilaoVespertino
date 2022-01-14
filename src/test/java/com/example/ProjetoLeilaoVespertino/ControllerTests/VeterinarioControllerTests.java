package com.example.ProjetoLeilaoVespertino.ControllerTests;

import com.example.ProjetoLeilaoVespertino.Mensagem;
import com.example.ProjetoLeilaoVespertino.controller.VeterinarioController;
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
        idVeterinario = 19;
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

    @Test
    public void AlterarTest(){
        Boolean expected = true;
        Boolean result = false;

        try {
            Veterinario vetAtual = veterinarioController.buscar(this.idVeterinario);

            vetAtual.setNome("xxzzzzxxxxxxx");
            vetAtual.setEmail("lilxzzxxxzheuhex@hotmail.com");
            vetAtual.setTelefone("4523451445");
            vetAtual.setAtivo(true);
            Mensagem msg = veterinarioController.alterar(vetAtual);
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
    public void ExcluirTest(){
        Boolean expected = true;
        Boolean result = false;

        try {

            veterinarioController.deletar(this.idVeterinario);

            Veterinario vetTest = veterinarioController.buscar(this.idVeterinario);

            if (!vetTest.getAtivo()){
                result = true;
            }

        } catch (Exception ex){
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }

}
