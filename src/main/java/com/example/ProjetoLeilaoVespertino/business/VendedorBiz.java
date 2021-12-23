package com.example.ProjetoLeilaoVespertino.business;

import com.example.ProjetoLeilaoVespertino.entities.Vendedor;
import com.example.ProjetoLeilaoVespertino.repositories.VendedorRepository;

import java.util.ArrayList;
import java.util.List;

public class VendedorBiz {

    private Vendedor vendedor;
    private VendedorRepository vendedorRepository;

    private List<String> erros;

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public VendedorBiz(Vendedor vendedor, VendedorRepository vendedorRepository) {
        this.vendedor = vendedor;
        this.vendedorRepository = vendedorRepository;
        this.erros = new ArrayList<>();
    }

    public Boolean isValid(){
        Boolean resultado = nomeNaoPodeSerNulo(this.vendedor);
        resultado = telefoneNaoPodeExistirNoBanco(this.vendedor) && resultado;
        resultado = emailNaoPodeSerIgual(this.vendedor) && resultado;
        return resultado;
    }

    public Boolean nomeNaoPodeSerNulo(Vendedor vendedor){
        String[] contador = vendedor.getNome().split("");

        if (contador.length < 3){
            erros.add("O nome nao pode ser vazio!");
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean telefoneNaoPodeExistirNoBanco(Vendedor vendedor){
        List<Vendedor> lista = vendedorRepository.findAll();

        for(Vendedor s: lista){
            if(s.getTelefone().equals(vendedor.getTelefone())){
                erros.add("Telefone nao pode existir");
                return false;
            }
        }
        return true;
    }
    public Boolean emailNaoPodeSerIgual(Vendedor vendedor){
        List<Vendedor> lista = vendedorRepository.findAll();

        for(Vendedor s: lista){
            if(s.getEmail().equals(vendedor.getEmail())){
                erros.add("Ja existe este email cadastrado");
                return false;
            }
        }
        return true;
    }
}
