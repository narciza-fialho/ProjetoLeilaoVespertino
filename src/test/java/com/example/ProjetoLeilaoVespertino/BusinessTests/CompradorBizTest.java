package com.example.ProjetoLeilaoVespertino.BusinessTests;

import com.example.ProjetoLeilaoVespertino.business.CompradorBiz;
import com.example.ProjetoLeilaoVespertino.entities.Comprador;
import com.example.ProjetoLeilaoVespertino.repositories.CompradorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CompradorBizTest {

    @Autowired
    private CompradorRepository compradorRepository;
    public CompradorBizTest() {}

    @Test
    public void EmailNaoExisteTest () {
        Boolean expected = true;
        Boolean result = false;

        try {
            Comprador compradorNovo = new Comprador();
            compradorNovo.setEmail("nulo@mail.com");
            compradorNovo.setTelefone("46934795755");
            compradorNovo.setAtivo(true);
            compradorNovo.setNome("Nulo");
            compradorNovo.setId(0);
            CompradorBiz compradorBiz = new CompradorBiz(compradorNovo.getId(), compradorNovo, compradorRepository);
            Boolean retorno = compradorBiz.emailNaoExiste(compradorNovo.getEmail());
            if (retorno) {
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
    public void TelefoneNaoExisteTest() {
        Boolean expected = true;
        Boolean result = false;

        try {
            Comprador compradorNovo = new Comprador();
            compradorNovo.setEmail("nulo@mail.com");
            compradorNovo.setTelefone("46934795755");
            compradorNovo.setAtivo(true);
            compradorNovo.setNome("Nulo");
            compradorNovo.setId(0);
            CompradorBiz compradorBiz = new CompradorBiz(compradorNovo.getId(), compradorNovo, compradorRepository);
            Boolean retorno = compradorBiz.telefoneNaoExiste(compradorNovo.getTelefone());
            if (retorno) {
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
    public void NomePeloMenos2LetrasTest() {
        Boolean expected = true;
        Boolean result = false;

        try {
            Comprador compradorNovo = new Comprador();
            compradorNovo.setEmail("nulo@mail.com");
            compradorNovo.setTelefone("46934795755");
            compradorNovo.setAtivo(true);
            compradorNovo.setNome("Nu");
            compradorNovo.setId(0);
            CompradorBiz compradorBiz = new CompradorBiz(compradorNovo.getId(), compradorNovo, compradorRepository);
            Boolean retorno = compradorBiz.nomePeloMenos2Letras(compradorNovo.getNome());
            if (retorno) {
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
    public void IsValidTest() {
        Boolean expected = true;
        Boolean result = false;

        try {
            Comprador compradorNovo = new Comprador();
            compradorNovo.setEmail("nulo@mail.com");
            compradorNovo.setTelefone("46934795755");
            compradorNovo.setAtivo(true);
            compradorNovo.setNome("Nu");
            compradorNovo.setId(0);
            CompradorBiz compradorBiz = new CompradorBiz(compradorNovo.getId(), compradorNovo, compradorRepository);
            Boolean retorno = compradorBiz.isValid();
            if (retorno) {
                result = true;
            } else {
                result = false;
            }
        } catch (Exception ex) {
            result = false;
        }
    }
}
