package com.example.ProjetoLeilaoVespertino.business;

import com.example.ProjetoLeilaoVespertino.entities.Animal;
import com.example.ProjetoLeilaoVespertino.entities.Vendedor;
import com.example.ProjetoLeilaoVespertino.entities.Veterinario;
import com.example.ProjetoLeilaoVespertino.repositories.AnimalRepository;
import com.example.ProjetoLeilaoVespertino.repositories.VendedorRepository;
import com.example.ProjetoLeilaoVespertino.repositories.VeterinarioRepository;

import java.util.ArrayList;
import java.util.List;

public class AnimalBiz {
    private Animal animal;
    private VendedorRepository vendedorRepository;
    private VeterinarioRepository veterinarioRepository;
    private Vendedor vendedor;
    private AnimalRepository animalRepository;
    private List<String> erros;

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public AnimalBiz(Animal animal, AnimalRepository ar/*, VendedorRepository vr, VeterinarioRepository veterinarioRepository*/ ){
        this.animal = animal;
        this.animalRepository = ar;
     //   this.vendedorRepository = vr;
      //  this.veterinarioRepository = veterinarioRepository;
        this.erros = new ArrayList<>();
    }

    public Boolean isValid(){
        Boolean resultado = registroNaoExiste(this.animal.getRegistro());
        resultado = registroSomenteNumeros(this.animal.getRegistro()) && resultado;
        resultado = precoValorPositivo(this.animal.getPreco()) && resultado;
        resultado = racaComecaComMaiusculo(this.animal.getRaca()) && resultado;
        resultado = nomeDiferenteDeNulo(this.animal.getNome()) && resultado;
       // resultado = vendedorAtivo(this.animal.getIdVendedor()) && resultado;


        return resultado;
    }
    public Boolean registroNaoExiste (String registro){
        List<Animal> lista = animalRepository.findByRegistro(registro);
        Boolean resultado = lista.isEmpty();
        if(!resultado){
            erros.add("O registro ja existe no banco de dados");
        }
        return resultado;
    }
    public Boolean registroSomenteNumeros( String registro){
        Boolean resultado = registro.matches("^[0-9]{1,50}");
        if (!resultado) {
            erros.add("O registro deve conter apenas numeros");
        }
        return resultado;
    }
    public Boolean precoValorPositivo(Double preco){
        Boolean resultado = preco.doubleValue() > 0;
        if(!resultado){
            erros.add("O preco deve ser acima de 0");
        }
        return resultado;

    }
    public Boolean racaComecaComMaiusculo(String raca){
        Boolean resultado = raca.matches("^[A-Z\s]{1}[A-z]{1,40}");
        if(!resultado){
            erros.add("A primeira letra da raca deve ser maiuscula");
        }
        return resultado;
    }
    public Boolean nomeDiferenteDeNulo(String nome){
        Boolean resultado = !nome.isEmpty();
        if(!resultado){
            erros.add("O nome nao pode estar vazio");
        }
        return resultado;
    }
  /*  public Boolean vendedorAtivo(Integer id){
        Boolean vazio = vendedorRepository.findById(id).isEmpty();
        if (vazio){
            erros.add("O vendedor nao existe!");
            return false;
        } else {
            Vendedor ativo = vendedorRepository.findById(id).get();
            ativo = ativo.getAtivo().
            if(!ativo) {
                erros.add("Vendedor nao esta ativo");
                return false;
            }
            return  true;

        } */

    }


