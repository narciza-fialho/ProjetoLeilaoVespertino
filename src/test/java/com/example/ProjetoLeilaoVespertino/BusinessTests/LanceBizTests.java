package com.example.ProjetoLeilaoVespertino.BusinessTests;

import com.example.ProjetoLeilaoVespertino.business.LanceBiz;
import com.example.ProjetoLeilaoVespertino.business.VeterinarioBiz;
import com.example.ProjetoLeilaoVespertino.entities.Lance;
import com.example.ProjetoLeilaoVespertino.entities.Veterinario;
import com.example.ProjetoLeilaoVespertino.repositories.AnimalRepository;
import com.example.ProjetoLeilaoVespertino.repositories.CompradorRepository;
import com.example.ProjetoLeilaoVespertino.repositories.LanceRepository;
import com.example.ProjetoLeilaoVespertino.repositories.LeilaoRepository;
import org.hibernate.validator.constraints.Range;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LanceBizTests {

    private LanceBiz lanceBiz;
    private Lance lance;

    private Boolean expected;

    @Autowired
    private LanceRepository lanceRepository;
    @Autowired
    private LeilaoRepository leilaoRepository;
    @Autowired
    private CompradorRepository compradorRepository;
    @Autowired
    private AnimalRepository animalRepository;

    public LanceBizTests(){
        expected = true;
    }
    @Test
    public void isValidTest(){
        lance = new Lance();

        lance.setIdComprador(4);
        lance.setIdAnimal(5);
        lance.setValor(1500.00);
        lance.setIdLeilao(7);

        lanceBiz = new LanceBiz(0, lance, lanceRepository, leilaoRepository, compradorRepository, animalRepository);

        Boolean result = lanceBiz.isValid();

        assertThat(result).isEqualTo(expected);
    }


    @Test
    public void compradorEAtivoTest(){

        lance = new Lance();

        lance.setIdComprador(4);

        lanceBiz = new LanceBiz(0, lance, lanceRepository, leilaoRepository, compradorRepository, animalRepository);

        Boolean result = lanceBiz.compradorEAtivo(lance.getIdComprador());

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void animalEAtivoTest(){

        lance = new Lance();

        lance.setIdAnimal(5);

        lanceBiz = new LanceBiz(0, lance, lanceRepository, leilaoRepository, compradorRepository, animalRepository);

        Boolean result = lanceBiz.animalEAtivo(lance.getIdAnimal());

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void valorMinimoTest(){

        lance = new Lance();


        lance.setValor(1500.00);

        lanceBiz = new LanceBiz(0, lance, lanceRepository, leilaoRepository, compradorRepository, animalRepository);

        Boolean result = lanceBiz.valorMinimo(lance.getValor(), 5);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void leilaoExisteTest(){

        lance = new Lance();

        lance.setIdLeilao(7);

        lanceBiz = new LanceBiz(0, lance, lanceRepository, leilaoRepository, compradorRepository, animalRepository);

        Boolean result = lanceBiz.leilaoExiste(lance.getIdLeilao());

        assertThat(result).isEqualTo(expected);
    }



}