package com.example.ProjetoLeilaoVespertino.ControllerTests;

import com.example.ProjetoLeilaoVespertino.Mensagem;
import com.example.ProjetoLeilaoVespertino.controller.CompradorController;
import com.example.ProjetoLeilaoVespertino.entities.Comprador;
import com.example.ProjetoLeilaoVespertino.repositories.CompradorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CompradorControllerTest {
    @Autowired
    private CompradorController compradorController;
    @Autowired
    private CompradorRepository compradorRepository;

    private int idCompradorTeste;

    public CompradorControllerTest() { this.idCompradorTeste = 14; }

    @Test
    public void BuscarTest() {
        Boolean expected = true;
        Boolean result = false;

        try {
            Comprador compradorTest = compradorController.buscar(this.idCompradorTeste);
            if (compradorTest.getId() == this.idCompradorTeste) {
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
    public void ListarTest() {
        Boolean expected = true;
        Boolean result = false;

        if (compradorController.listar().stream().count() > 0) {
            result = true;
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void IncluirTest() {
        Boolean expected = true;
        Boolean result = false;
        long registros_antes;
        long registros_depois;

        try {
            registros_antes = compradorController.listar().stream().count();
            Comprador comprador = new Comprador();
            comprador.setNome("Cleude");
            comprador.setEmail("cleudinha@gmail.com");
            comprador.setTelefone("95921895285");
            comprador.setAtivo(true);
            compradorController.incluir(comprador);

            registros_depois = compradorController.listar().stream().count();
            if (registros_depois > registros_antes) {
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
    public void AlterarTest() {
        Boolean expected = true;
        Boolean result = false;

        try {
            Comprador compradornovo = compradorController.buscar(this.idCompradorTeste);
            compradornovo.setNome("Marcelo");
            compradornovo.setEmail("mnfialho@hotmail.com");
            compradornovo.setTelefone("67992968584");
            Mensagem msg =compradorController.alterar(compradornovo);

            if (!msg.getErro().isEmpty()) {
                result = false;
            } else {
                result = true;
            }
        } catch (Exception ex) {
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void DeletarTest() {
        Boolean expected = true;
        Boolean result = false;

        try {
            Comprador compradordelet = compradorController.buscar(this.idCompradorTeste);
            compradordelet.setAtivo(false);
            compradorController.deletar(compradordelet.getId());
            List<Comprador> lista = compradorRepository.findByAtivo(true);
            if (lista.contains(compradordelet)) {
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
