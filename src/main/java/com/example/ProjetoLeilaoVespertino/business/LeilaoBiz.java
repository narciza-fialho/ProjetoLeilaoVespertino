package com.example.ProjetoLeilaoVespertino.business;

import com.example.ProjetoLeilaoVespertino.entities.Leilao;
import com.example.ProjetoLeilaoVespertino.repositories.LeilaoRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LeilaoBiz {
    private Leilao leilao;
    private LeilaoRepository leilaoRepository;
    private List<String> erros;
    public List<String> getErros() {
        return erros;
    }

    public LeilaoBiz(Leilao leilao, LeilaoRepository leilaoRepository){
        this.leilao =leilao;
        this.leilaoRepository = leilaoRepository;
        this.erros = new ArrayList<>();

    }
    public Boolean isValid(){
        return true;
    }
    public Boolean nomeNulo(String nome){
        Boolean resultado = nome == null;
        if(resultado)
        {
         erros.add("O nome não pode ser nulo");
        }
        return resultado;

    }
    public Boolean verificadorDeData(String data){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataVerificada = LocalDate.parse(data, dtf);
        LocalDate hoje = LocalDate.now();
        Boolean resultado = dataVerificada.compareTo(hoje) <= 0;
        if(!resultado)
        {
         erros.add("Esse dia ja é passado");
        }
        return resultado;

    }
}
