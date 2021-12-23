package com.example.ProjetoLeilaoVespertino.controller;

import com.example.ProjetoLeilaoVespertino.Mensagem;
import com.example.ProjetoLeilaoVespertino.business.VeterinarioBiz;
import com.example.ProjetoLeilaoVespertino.entities.Veterinario;
import com.example.ProjetoLeilaoVespertino.repositories.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("veterinario")
public class VeterinarioController {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @GetMapping
    public List<Veterinario> listar(){
        List<Veterinario> lista =veterinarioRepository.findByAtivo(true);
        return lista;
    }

    @GetMapping("/{id}")
    public Veterinario buscar(@PathVariable int id){
        Veterinario veterinario = veterinarioRepository.findById(id).get();
        return veterinario;
    }

    @PostMapping
    public Mensagem incluir(@RequestBody Veterinario veterinario){

        VeterinarioBiz veterinarioBiz = new VeterinarioBiz(veterinario, veterinarioRepository);
        Mensagem msg = new Mensagem();

        if(veterinarioBiz.isValid()) {
            veterinario.setId(0);
            veterinarioRepository.saveAndFlush(veterinario);
            msg.setMensagem("Incluido com Sucesso.");
        } else {
            msg.setErro( veterinarioBiz.getErros() );
            msg.setMensagem("Erro");
        }
        return msg;
    }

    @PutMapping
    public Mensagem alterar(@RequestBody Veterinario veterinario){
        veterinarioRepository.saveAndFlush(veterinario);
        Mensagem msg = new Mensagem();
        msg.setMensagem("Alterado com Sucesso.");
        return msg;
    }

    @DeleteMapping
    public Mensagem deletar (@RequestBody Veterinario veterinario){
        veterinario.setAtivo(false);
        veterinarioRepository.saveAndFlush(veterinario);
        Mensagem msg = new Mensagem();
        msg.setMensagem("Deletado com Sucesso.");
        return msg;
    }

}
