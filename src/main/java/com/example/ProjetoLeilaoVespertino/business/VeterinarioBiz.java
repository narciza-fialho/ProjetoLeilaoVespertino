package com.example.ProjetoLeilaoVespertino.business;

import com.example.ProjetoLeilaoVespertino.entities.Veterinario;
import com.example.ProjetoLeilaoVespertino.repositories.VeterinarioRepository;

import java.util.ArrayList;
import java.util.List;

public class VeterinarioBiz {

    private Veterinario veterinario;
    private VeterinarioRepository veterinarioRepository;
    private List<String> erros;
    private Boolean incluindo;
    private Boolean alterando;

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public VeterinarioBiz (int modo, Veterinario veterinario, VeterinarioRepository veterinarioRepository){
        this.incluindo = modo==0;
        this.alterando = modo!=0;
        this.veterinario = veterinario;
        this.veterinarioRepository = veterinarioRepository;
        this.erros = new ArrayList<>();
    }

    public Boolean isValid(){
        Boolean resultado = true;
        if (this.incluindo) {
            resultado = telefoneExiste(this.veterinario.getTelefone()) && resultado;
            resultado = emailExiste(this.veterinario.getEmail()) && resultado;
        }
        resultado = nomeMin2Letra(this.veterinario.getNome());

        return resultado;
    }

    public Boolean nomeMin2Letra (String nome){
        Boolean resultado  = nome.matches("^[A-z]{3}[A-z\s]{0,58}$");
        if (!resultado){
            erros.add("O Nome deve pelo menos possuir 3 letras!");
        }
        return resultado;
    }

    public Boolean telefoneExiste (String telefone){
        List<Veterinario> lista = veterinarioRepository.findByTelefone(telefone);
        Boolean resultado = lista.isEmpty();
        if (!resultado) {
            erros.add("Este telefone ja esta cadastrado!");
        }
        return resultado;
    }

    public Boolean emailExiste (String email){
        List<Veterinario> lista = veterinarioRepository.findByEmail(email);
        Boolean resultado = lista.isEmpty();
        if (!resultado) {
            erros.add("Este email ja existe, no sistema!");
        }
        return resultado;
    }


}
