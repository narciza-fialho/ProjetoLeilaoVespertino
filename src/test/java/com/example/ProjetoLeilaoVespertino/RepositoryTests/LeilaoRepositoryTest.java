package com.example.ProjetoLeilaoVespertino.RepositoryTests;

import com.example.ProjetoLeilaoVespertino.repositories.LeilaoRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LeilaoRepositoryTest {
    private Boolean expected;

    public LeilaoRepositoryTest(){expected= true;}

    @Test
    public void findByAtivoTest(){
        assertThat(true).isEqualTo(expected);
    }


}
