package com.example.ProjetoLeilaoVespertino.controller;


import com.example.ProjetoLeilaoVespertino.Mensagem;
import com.example.ProjetoLeilaoVespertino.business.LanceBiz;
import com.example.ProjetoLeilaoVespertino.entities.Lance;
import com.example.ProjetoLeilaoVespertino.repositories.AnimalRepository;
import com.example.ProjetoLeilaoVespertino.repositories.CompradorRepository;
import com.example.ProjetoLeilaoVespertino.repositories.LanceRepository;
import com.example.ProjetoLeilaoVespertino.repositories.LeilaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lance")
public class LanceController {
    @Autowired
    private LanceRepository lanceRepository;
    @Autowired
    private LeilaoRepository leilaoRepository;
    @Autowired
    private CompradorRepository compradorRepository;
    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping
    public List<Lance> listar(){
        List<Lance> lista = lanceRepository.findByAtivo(true);
        return lista;
    }

    @GetMapping("/{id}")
    public Lance buscar(@PathVariable int id){
        Lance lance = lanceRepository.findById(id).get();
        return lance;
    }

    @PostMapping
    public Mensagem incluir(@RequestBody Lance lance){
        LanceBiz lanceBiz = new LanceBiz(lance, lanceRepository,leilaoRepository,compradorRepository,animalRepository);
        Mensagem msg = new Mensagem();
        if(lanceBiz.isValid()){
            lance.setId(0);
            lanceRepository.saveAndFlush(lance);
            msg.setMensagem("Inserido!!");
        }
        else {
            msg.setErro(lanceBiz.getErros());
            msg.setMensagem("Erro");
        }
        return msg;

    }
    @PutMapping
    public Mensagem alterar (@RequestBody Lance lance){
        LanceBiz lanceBiz = new LanceBiz(lance, lanceRepository,leilaoRepository,compradorRepository,animalRepository);
        Mensagem msg = new Mensagem();
        if(lanceBiz.isValid()){
            lanceRepository.saveAndFlush(lance);
            msg.setMensagem("Alterado!!");
        }
        else {
            msg.setErro(lanceBiz.getErros());
            msg.setMensagem("Erro");
        }
        return msg;
    }
    @DeleteMapping
    public Mensagem deletar (@RequestBody Lance lance){
        lance.setAtivo(false);
        lanceRepository.save(lance);
        lanceRepository.flush();

        Mensagem msg = new Mensagem();
        msg.setMensagem("Deletado");
        return msg;
    }
}
