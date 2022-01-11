package com.example.ProjetoLeilaoVespertino.BusinessTests;

import com.example.ProjetoLeilaoVespertino.business.VendedorBiz;
import com.example.ProjetoLeilaoVespertino.controller.VendedorController;
import com.example.ProjetoLeilaoVespertino.entities.Vendedor;
import com.example.ProjetoLeilaoVespertino.repositories.VendedorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class VendedorBizTest {
    private VendedorBiz vendedorBiz;
    @Autowired
    private VendedorRepository vendedorRepository;

    @Test
    public void nomeNaoPodeSerNuloTest() {
        Boolean expected = true;
        Boolean result = false;
        try {
            Vendedor vendedor = new Vendedor();
            vendedor.setNome("Alvarez");
            String[] contador = vendedor.getNome().split("");
            if (contador.length > 3) {
                result = true;
            } else {
                result = false;
            }
        } catch (Exception e) {
            result = false;
        }

        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void telefoneNaoPodeExistirNoBancoTest() {
        Boolean expected = true;
        Vendedor vendedor = new Vendedor();
        vendedor.setTelefone("92831248590");
        vendedorBiz = new VendedorBiz(1, vendedor, vendedorRepository);
        Boolean resultado = vendedorBiz.telefoneNaoPodeExistirNoBanco(vendedor.getTelefone());
        assertThat(resultado).isEqualTo(expected);
    }
    @Test
    public void emailNaoPodeSerIgualTest(){
        Boolean expected = true;
        Vendedor vendedor = new Vendedor();
        vendedor.setEmail("xxoxoxoxo@gmail.com");
        vendedorBiz = new VendedorBiz(1, vendedor, vendedorRepository);
        Boolean resultado = vendedorBiz.emailNaoPodeSerIgual(vendedor.getEmail());
        assertThat(resultado).isEqualTo(expected);
    }
    @Test
    public void isValidIncluindoTest(){
        Boolean expected = true;
        Vendedor vendedor = new Vendedor();
        vendedor.setEmail("xixixixias@gmail.com");
        vendedor.setAtivo(true);
        vendedor.setNome("Rofafasasf");
        vendedor.setId(0);
        vendedor.setTelefone("07809022802");
        vendedorBiz = new VendedorBiz(0, vendedor, vendedorRepository);
        Boolean resultado = vendedorBiz.isValid();
        assertThat(resultado).isEqualTo(expected);
    }
    @Test
    public void isValidAlterandoTest(){
        Boolean expected = true;
        Vendedor vendedor = new Vendedor();
        vendedor.setEmail("xixixixias@gmail.com");
        vendedor.setAtivo(true);
        vendedor.setNome("Joao da Silva");
        vendedor.setId(0);
        vendedor.setTelefone("07809022802");
        vendedorBiz = new VendedorBiz(1, vendedor, vendedorRepository);
        Boolean resultado = vendedorBiz.isValid();
        assertThat(resultado).isEqualTo(expected);
    }
}
