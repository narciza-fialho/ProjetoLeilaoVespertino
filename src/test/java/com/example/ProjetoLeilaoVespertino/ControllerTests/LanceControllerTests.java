package com.example.ProjetoLeilaoVespertino.ControllerTests;

import com.example.ProjetoLeilaoVespertino.Mensagem;
import com.example.ProjetoLeilaoVespertino.controller.LanceController;
import com.example.ProjetoLeilaoVespertino.entities.Animal;
import com.example.ProjetoLeilaoVespertino.entities.Lance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LanceControllerTests {

    @Autowired
    private LanceController lanceController;

    private int idLanceTeste;

    public LanceControllerTests(){
        this.idLanceTeste = 10;
    }

    @Test
    public void BuscarTest(){

        Boolean expected = true;
        Boolean result = false;

        try {
            Lance lanceTest = lanceController.buscar(this.idLanceTeste);

            if (lanceTest.getId() == this.idLanceTeste) {
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

        if (lanceController.listar().stream().count() > 0){
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
            registros_antes = lanceController.listar().stream().count();

            Lance lance = new Lance();
            lance.setId(0);
            lance.setData(Date.valueOf("2021-01-12"));
            lance.setValor(2510.6);
            lance.setAtivo(true);
            lance.setIdComprador(4);
            lance.setIdLeilao(10);
            lance.setIdAnimal(5);

            lanceController.incluir(lance);

            registros_depois = lanceController.listar().stream().count();

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

    @Test
    public void alterarTest(){

        Boolean expected = true;
        Boolean result = true;
        try {
            Lance lance = lanceController.buscar(this.idLanceTeste);

            lance.setData(Date.valueOf("2021-01-10"));
            lance.setValor(3109.1);
            lance.setAtivo(true);
            lance.setIdComprador(8);
            lance.setIdLeilao(6);
            lance.setIdAnimal(6);

            Mensagem msg = lanceController.alterar(lance);

            if(!msg.getErro().isEmpty()){
                result= false;
            }else {
                result = true;
            }
        }catch (Exception ex) {
            result = false;
        }
        assertThat(result).isEqualTo(expected);

    }

    @Test
    public void deletarTest(){

        Boolean expected = true;
        Boolean result = false;



        try {
            lanceController.deletar(this.idLanceTeste);
            Lance lance = lanceController.buscar(this.idLanceTeste);


            if (lance.getAtivo() == false){
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
