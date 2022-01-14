package com.example.ProjetoLeilaoVespertino.ControllerTests;

import com.example.ProjetoLeilaoVespertino.Mensagem;
import com.example.ProjetoLeilaoVespertino.controller.LeilaoController;
import com.example.ProjetoLeilaoVespertino.entities.Animal;
import com.example.ProjetoLeilaoVespertino.entities.Leilao;
import com.example.ProjetoLeilaoVespertino.repositories.LeilaoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@SpringBootTest
public class LeilaoControllerTests {
    @Autowired
    private LeilaoController leilaoController;
    @Autowired
    private LeilaoRepository leilaoRepository;

    private int idLeilaoTeste;

    public LeilaoControllerTests(){
        this.idLeilaoTeste = 7;

    }


    @Test
    public void BuscarTest( ){
        Boolean expected = true;
        Boolean result = false;
        try {
            Leilao leilaoTest = leilaoController.buscar(this.idLeilaoTeste);
            if (leilaoTest.getId() == this.idLeilaoTeste){
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

        if (leilaoController.lista().stream().count() > 0){
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
            registros_antes = leilaoController.lista().stream().count();
            Leilao leilao = new Leilao();
            leilao.setAtivo(true);
            leilao.setId(0);
            leilao.setNome("Leilao teste");
            leilao.setData(Date.valueOf("2022-01-11"));
            leilaoController.incluir(leilao);

            registros_depois = leilaoController.lista().stream().count();
            if (registros_depois>registros_antes){
                result = true;
            }else {
                result = false;
            }
        }catch (Exception ex){
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void AlterarTest(){
        Boolean expected = true;
        Boolean result = false;

        Leilao leilaoNovo = leilaoController.buscar(7);
        try {
            leilaoNovo.setId(7);
            leilaoNovo.setData(Date.valueOf("2022-01-11"));
            leilaoNovo.setNome("Clube do boi teste");
            leilaoNovo.setAtivo(true);
            Mensagem msg = leilaoController.alterar(leilaoNovo);
            if (!msg.getErro().isEmpty()){
                result = false;
            }else {
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

        Leilao leilaodelet = leilaoController.buscar(4);

        try {
            leilaodelet.setAtivo(false);
            leilaoController.deletar(leilaodelet.getId());
            List<Leilao> lista = leilaoRepository.findByAtivo(true);
            if (lista.contains(leilaodelet)) {
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
