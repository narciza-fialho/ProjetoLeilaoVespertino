package com.example.ProjetoLeilaoVespertino.RepositoryTests;

import com.example.ProjetoLeilaoVespertino.entities.Lance;
import com.example.ProjetoLeilaoVespertino.entities.Vendedor;
import com.example.ProjetoLeilaoVespertino.repositories.VendedorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class VendedorRepositoryTest {
    @Autowired
    private VendedorRepository vendedorRepository;

    private boolean expected;

    public VendedorRepositoryTest(){
        expected = true;
    }

    @Test
    public void findByAtivoTest(){

        List<Vendedor> listaDeVendedor = vendedorRepository.findByAtivo(true);

        assertThat(!listaDeVendedor.isEmpty()).isEqualTo(expected);
    }
}
