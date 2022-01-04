package com.example.ProjetoLeilaoVespertino.business;

import com.example.ProjetoLeilaoVespertino.entities.Comprador;
import com.example.ProjetoLeilaoVespertino.repositories.CompradorRepository;

import java.util.ArrayList;
import java.util.List;

public class CompradorBiz {

    private Comprador comprador;
    private CompradorRepository compradorRepository;
    private List<String> erros;
    private Boolean incluindo;
    private Boolean alterando;


    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public CompradorBiz (int modo, Comprador comprador, CompradorRepository compradorRepository) {

        this.incluindo = modo==0;
        this.alterando = modo!=0;
        this.comprador = comprador;
        this.compradorRepository = compradorRepository;
        this.erros = new ArrayList<>();
    }

    public Boolean isValid() {
        Boolean resultado = true;
        if (this.incluindo) {
            resultado = telefoneNaoExiste(this.comprador.getTelefone()) && resultado;
            resultado = emailNaoExiste(this.comprador.getEmail()) && resultado;
        }
        resultado = nomePeloMenos2Letras(this.comprador.getNome());

        return resultado;
    }

    //Um nome não pode ter menos que 2 letras
    public Boolean nomePeloMenos2Letras (String nome) {
        Boolean resultado = nome.matches("^[A-z]{3}[A-z\s]{0,58}$");
        if (!resultado) {
            erros.add("Nome deve ter pelo menos 3 letras");
        }
        return resultado;
    }
    //Telefone não pode existir no banco
    public Boolean telefoneNaoExiste (String telefone) {
        List<Comprador> lista = compradorRepository.findByTelefone(telefone);
        Boolean resultado = lista.isEmpty();
        if (!resultado) {
            erros.add("Este telefone ja existe");
        }
        return resultado;
    }
    //Email não pode existir no banco
    public Boolean emailNaoExiste (String email) {
        List<Comprador> lista = compradorRepository.findByEmail(email);
        Boolean resultado = lista.isEmpty();
        if (!resultado) {
            erros.add("Este email ja existe");
        }
        return resultado;
    }
}
