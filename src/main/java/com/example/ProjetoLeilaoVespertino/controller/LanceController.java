package com.example.ProjetoLeilaoVespertino.controller;


import com.example.ProjetoLeilaoVespertino.Mensagem;
import com.example.ProjetoLeilaoVespertino.entities.Lance;
import com.example.ProjetoLeilaoVespertino.repositories.LanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lance")
public class LanceController {
    @Autowired
    private LanceRepository lanceRepositoryRepository;

    @GetMapping
    public List<Lance> lista(){
        List<Lance> lista = lanceRepositoryRepository.findByAtivo(true);
        return lista;
    }

    @GetMapping("/{id}")
    public Lance buscar(@PathVariable int id){
        Lance lance = lanceRepositoryRepository.findById(id).get();
        return lance;
    }

    @PostMapping
    public Mensagem incluir(@RequestBody Lance lance){

        lance.setId(0);
        lanceRepositoryRepository.saveAndFlush(lance);
        Mensagem msg = new Mensagem();
        msg.setMensagem("Inserido!!");
        return msg;
    }
    @PutMapping
    public Mensagem alterar (@RequestBody Lance lance){
        lanceRepositoryRepository.save(lance);
        lanceRepositoryRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("Alterado!!");
        return msg;
    }
    @DeleteMapping
    public Mensagem deletar (@RequestBody Lance lance){
        lance.setAtivo(false);
        lanceRepositoryRepository.save(lance);
        lanceRepositoryRepository.flush();

        Mensagem msg = new Mensagem();
        msg.setMensagem("Deletado");
        return msg;
    }
}
