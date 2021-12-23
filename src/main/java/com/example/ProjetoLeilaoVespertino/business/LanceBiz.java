package com.example.ProjetoLeilaoVespertino.business;

import com.example.ProjetoLeilaoVespertino.entities.Animal;
import com.example.ProjetoLeilaoVespertino.entities.Lance;
import com.example.ProjetoLeilaoVespertino.entities.Leilao;
import com.example.ProjetoLeilaoVespertino.repositories.AnimalRepository;
import com.example.ProjetoLeilaoVespertino.repositories.CompradorRepository;
import com.example.ProjetoLeilaoVespertino.repositories.LanceRepository;
import com.example.ProjetoLeilaoVespertino.repositories.LeilaoRepository;

import java.util.ArrayList;
import java.util.List;

public class LanceBiz {
    private Lance lance;
    private LanceRepository lanceRepository;
    private List<String> erros;
    private LeilaoRepository leilaoRepository;
    private CompradorRepository compradorRepository;
    private AnimalRepository animalRepository;

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public LanceBiz(Lance lance, LanceRepository lanceRepository, LeilaoRepository leilaoRepository,
                    CompradorRepository compradorRepository, AnimalRepository animalRepository ){
        this.lance = lance;
        this.lanceRepository = lanceRepository;
        this.erros = new ArrayList<>();
        this.leilaoRepository = leilaoRepository;
        this.compradorRepository = compradorRepository;
        this.animalRepository = animalRepository;
    }

    public Boolean isValid(){
        Boolean resultado = leilaoEAtivo(this.lance.getIdLeilao());
        resultado = compradorEAtivo(this.lance.getIdComprador()) && resultado;
        resultado = animalEAtivo(this.lance.getIdAnimal()) && resultado;
        resultado = valorMinimo(this.lance.getValor(), this.lance.getIdAnimal()) && resultado;
        resultado = leilaoExiste(this.lance.getIdLeilao()) && resultado;
        return resultado;
    }
    //Um lance não pode ser dado para um leilão desativado
    public Boolean leilaoEAtivo(Integer id){
        Boolean ativo = leilaoRepository.findById(id).get().getAtivo();
        if (!ativo){
            erros.add("Leilão Destaivado");
        }
         return ativo;
    }
    //Lance não pode ser dado para um comprador desativado
    public Boolean compradorEAtivo(Integer id){
        Boolean ativo = compradorRepository.findById(id).get().getAtivo();
        if (!ativo){
            erros.add("Comprador não é ativo");
        }
        return ativo;
    }
    //Lance não pode ser dado para um animal desativado
    public Boolean animalEAtivo(Integer id){
        Boolean ativo = animalRepository.findById(id).get().getAtivo();
        if (!ativo){
            erros.add("Animal não é ativo");
        }
        return ativo;
    }
    //Lance precisa ter valor maior ou igual que do animal
    public Boolean valorMinimo (Double preco, Integer id) {
        Animal animal = animalRepository.findById(id).get();
        Boolean resultado = preco >= animal.getPreco();
        if (!resultado) {
            erros.add("Valor invalido");
        }
        return resultado;
    }

    //O leilão precisa existir para dar o lance
    public Boolean leilaoExiste (Integer id) {
        List<Lance> lista = lanceRepository.findByIdLeilao(id);
        if(lista.isEmpty()) {
            erros.add("O leilao não está na lista");
            return false;
        }
        if (!leilaoEAtivo(id)){
            return false;
        } else {
            return true;
        }
    }
}
