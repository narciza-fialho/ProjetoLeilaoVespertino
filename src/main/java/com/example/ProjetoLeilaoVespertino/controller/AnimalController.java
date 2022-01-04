package com.example.ProjetoLeilaoVespertino.controller;

import com.example.ProjetoLeilaoVespertino.Mensagem;
import com.example.ProjetoLeilaoVespertino.business.AnimalBiz;
import com.example.ProjetoLeilaoVespertino.entities.Animal;
import com.example.ProjetoLeilaoVespertino.repositories.AnimalRepository;
import com.example.ProjetoLeilaoVespertino.repositories.VendedorRepository;
import com.example.ProjetoLeilaoVespertino.repositories.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("animal")
@CrossOrigin
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private VeterinarioRepository veterinarioRepository;
    @Autowired
    private VendedorRepository vendedorRepository;

    @GetMapping
    public List<Animal> listar(){
        List<Animal> lista = animalRepository.findByAtivo(true);
        return lista;
    }
    @GetMapping("/{id}")
    public Animal buscar(@PathVariable int id){
        Animal animal = animalRepository.findById(id).get();
        return animal;
    }
    @PostMapping
    public Mensagem incluir(@RequestBody Animal animal){
        AnimalBiz animalBiz = new AnimalBiz(animal.getId(), animal, animalRepository, vendedorRepository, veterinarioRepository);
        Mensagem msg = new Mensagem();

        if (animalBiz.isValid()) {
            animal.setId(0);
            animalRepository.save(animal);
            animalRepository.flush();
            msg.setMensagem("Tudo certo, animal cadastrado!");
        } else {
            msg.setErro( animalBiz.getErros() );
            msg.setMensagem("Erro");
        }
        return msg;
    }
    @PutMapping
    public Mensagem alterar(@RequestBody Animal animal){
        AnimalBiz animalBiz = new AnimalBiz(animal.getId(), animal, animalRepository, vendedorRepository, veterinarioRepository);
        Mensagem msg = new Mensagem();
        if (animalBiz.isValid()) {
            animalRepository.save(animal);
            animalRepository.flush();
            msg.setMensagem("Tudo certo, cadastro do animal alterado!");
        } else {
            msg.setMensagem("Erro");
            msg.setErro(animalBiz.getErros());
        }
        return msg;
    }
    @DeleteMapping("/{id}")
    public Mensagem Deletar(@PathVariable int id){

        Animal animal = animalRepository.findById(id).get();

        animal.setAtivo(false);
        animalRepository.save(animal);
        animalRepository.flush();

        Mensagem msg = new Mensagem();
        msg.setMensagem("Animal deletado com sucesso!");
        return msg;

    }

}
