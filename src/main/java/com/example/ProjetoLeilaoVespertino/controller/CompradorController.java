package com.example.ProjetoLeilaoVespertino.controller;


import com.example.ProjetoLeilaoVespertino.Mensagem;
import com.example.ProjetoLeilaoVespertino.business.CompradorBiz;
import com.example.ProjetoLeilaoVespertino.entities.Comprador;
import com.example.ProjetoLeilaoVespertino.repositories.CompradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comprador")
public class CompradorController {

    @Autowired
    private CompradorRepository compradorRepository;

    @GetMapping
    public List<Comprador> listar(){
        List<Comprador> lista = compradorRepository.findByAtivo(true);
        return lista;
    }
    @GetMapping("/{id}")
    public Comprador buscar(@PathVariable int id){
        Comprador comprador = compradorRepository.findById(id).get();
        return comprador;
    }
    @PostMapping
    public Mensagem incluir(@RequestBody Comprador comprador){

        CompradorBiz compradorBiz = new CompradorBiz(comprador, compradorRepository);
        Mensagem msg = new Mensagem();

        if (compradorBiz.isValid()) {
            comprador.setId(0);
            compradorRepository.save(comprador);
            compradorRepository.flush();
            msg.setMensagem("Incluido com sucesso!");
        } else {
            msg.setErro( compradorBiz.getErros() );
            msg.setMensagem("Erro");
        }
        return msg;

    }
    @PutMapping
    public Mensagem alterar (@RequestBody Comprador comprador){
        CompradorBiz compradorBiz = new CompradorBiz(comprador, compradorRepository);
        Mensagem msg = new Mensagem();
        if (compradorBiz.isValid()) {
            compradorRepository.save(comprador);
            compradorRepository.flush();
            msg.setMensagem("Alterado com sucesso!");
        } else {
            msg.setErro( compradorBiz.getErros() );
            msg.setMensagem("Erro");
        }
        return msg;
    }

    @DeleteMapping
    public Mensagem Deletar(@RequestBody Comprador comprador){
        comprador.setAtivo(false);
        compradorRepository.save(comprador);
        compradorRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("Deleta com sucesso!");
        return msg;

    }

}
