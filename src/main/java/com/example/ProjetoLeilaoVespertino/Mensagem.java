package com.example.ProjetoLeilaoVespertino;

import java.util.ArrayList;
import java.util.List;

public class Mensagem {
    private String mensagem;
    private List<String> erros;


    public List<String> getErro() {
        return erros;
    }

    public void setErro(List<String> erros) {
        this.erros = erros;
    }
    public Mensagem(){
        erros = new ArrayList<>();
    }

    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
