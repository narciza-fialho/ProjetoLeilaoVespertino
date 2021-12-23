package com.example.ProjetoLeilaoVespertino.business;

import com.example.ProjetoLeilaoVespertino.entities.Leilao;
import com.example.ProjetoLeilaoVespertino.repositories.LeilaoRepository;
import net.bytebuddy.build.Plugin;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;

public class LeilaoBiz {
    private Leilao leilao;
    private LeilaoRepository leilaoRepository;
    private List<String> erros;

    public List<String> getErros() {
        return erros;
    }

    public LeilaoBiz(Leilao leilao, LeilaoRepository leilaoRepository) {
        this.leilao = leilao;
        this.leilaoRepository = leilaoRepository;
        this.erros = new ArrayList<>();

    }

    public Boolean isValid() {
        Boolean resultado = nomeNulo(this.leilao.getNome());
        resultado = verificadorDeData(this.leilao.getData()) && resultado;

        return resultado;
    }

    public Boolean nomeNulo(String nome) {
        Boolean resultado = nome == null;
        if (resultado) {
            erros.add("O nome não pode ser nulo");
        }
        return !resultado;

    }

    public Boolean verificadorDeData(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date hoje = Date.valueOf(LocalDate.now());

        if ( data.before(hoje)) {
            erros.add("Esse dia ja é passado");
            return false;
        } else {
            return true;
        }

    }
}
