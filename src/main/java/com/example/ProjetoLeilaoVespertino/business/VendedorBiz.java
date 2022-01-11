package com.example.ProjetoLeilaoVespertino.business;

import com.example.ProjetoLeilaoVespertino.entities.Vendedor;
import com.example.ProjetoLeilaoVespertino.repositories.VendedorRepository;

import java.util.ArrayList;
import java.util.List;

public class VendedorBiz {

    private Vendedor vendedor;
    private VendedorRepository vendedorRepository;
    private Boolean incluindo;
    private Boolean alterando;

    private List<String> erros;

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public VendedorBiz(int modo, Vendedor vendedor, VendedorRepository vendedorRepository) {
        this.incluindo = modo==0;
        this.alterando = modo!=0;
        this.vendedor = vendedor;
        this.vendedorRepository = vendedorRepository;
        this.erros = new ArrayList<>();
    }

    public Boolean isValid(){
        Boolean resultado = true;
        if (this.incluindo) {
            resultado = telefoneNaoPodeExistirNoBanco(this.vendedor.getTelefone()) && resultado;
            resultado = emailNaoPodeSerIgual(this.vendedor.getEmail()) && resultado;
        }
        resultado = nomeNaoPodeSerNulo(this.vendedor.getNome()) && resultado;
        return resultado;
    }

    public Boolean nomeNaoPodeSerNulo(String nome){
        String[] contador = nome.split("");

        if (contador.length < 3){
            erros.add("O nome nao pode ser menor que 3 letras!");
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean telefoneNaoPodeExistirNoBanco(String telefone){
        List<Vendedor> lista = vendedorRepository.findAll();

        for(Vendedor s: lista){
            if(s.getTelefone().equals(telefone)){
                erros.add("Telefone ja esta cadastrado!");
                return false;
            }
        }
        return true;
    }
    public Boolean emailNaoPodeSerIgual(String email){
        List<Vendedor> lista = vendedorRepository.findAll();

        for(Vendedor s: lista){
            if(s.getEmail().equals(email)){
                erros.add("Ja existe este email cadastrado");
                return false;
            }
        }
        return true;
    }
}
