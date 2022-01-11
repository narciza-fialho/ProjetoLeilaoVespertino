package com.example.ProjetoLeilaoVespertino.BusinessTests;

import com.example.ProjetoLeilaoVespertino.business.LeilaoBiz;
import com.example.ProjetoLeilaoVespertino.entities.Leilao;
import com.example.ProjetoLeilaoVespertino.repositories.LeilaoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LeilaoBizTest {
    @Autowired
    private LeilaoRepository leilaoRepository;

    @Test
    public void NomeNuloTest() {
        Boolean expected = true;
        Boolean result = false;

        try {
            Leilao leilaoNovo = new Leilao();
            leilaoNovo.setNome("Nao nulo");
            leilaoNovo.setData(Date.valueOf("2023-01-01"));
            leilaoNovo.setAtivo(true);
            leilaoNovo.setId(0);
            LeilaoBiz leilaoBiz = new LeilaoBiz(leilaoNovo, leilaoRepository);
            if (leilaoBiz.nomeNulo(leilaoNovo.getNome())) {
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
    public void VerificadorDeDataTest() {
        Boolean expected = true;
        Boolean result = false;

        try {
            Leilao leilaoNovo = new Leilao();
            leilaoNovo.setNome("Nao nulo");
            leilaoNovo.setData(Date.valueOf("2023-01-01"));
            leilaoNovo.setAtivo(true);
            leilaoNovo.setId(0);
            LeilaoBiz leilaoBiz = new LeilaoBiz(leilaoNovo, leilaoRepository);
            if (leilaoBiz.verificadorDeData(leilaoNovo.getData())) {
                result = true;
            } else {
                result = false;
            }
        } catch (Exception ex) {
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }
}
