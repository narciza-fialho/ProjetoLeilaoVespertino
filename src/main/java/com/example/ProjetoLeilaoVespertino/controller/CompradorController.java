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
@CrossOrigin
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
        comprador.setId(0);
        CompradorBiz compradorBiz = new CompradorBiz(comprador.getId(), comprador, compradorRepository);
        Mensagem msg = new Mensagem();

        if (compradorBiz.isValid()) {
            compradorRepository.save(comprador);
            compradorRepository.flush();
            msg.setMensagem("Tudo certo, comprador cadastrado!");
        } else {
            msg.setErro( compradorBiz.getErros() );
            msg.setMensagem("Erro");
        }
        return msg;

    }
    @PutMapping
    public Mensagem alterar (@RequestBody Comprador comprador){
        CompradorBiz compradorBiz = new CompradorBiz(comprador.getId(), comprador, compradorRepository );
        Mensagem msg = new Mensagem();
        if (compradorBiz.isValid()) {
            compradorRepository.save(comprador);
            compradorRepository.flush();
        msg.setMensagem("Tudo certo, cadastro do comprador alterado!");
        } else {
            msg.setErro( compradorBiz.getErros() );
            msg.setMensagem("Erro");
        }
        return msg;
    }

    @DeleteMapping("/{id}")
    public Mensagem deletar(@PathVariable int id){

        Comprador comprador = compradorRepository.findById(id).get();

        comprador.setAtivo(false);
        compradorRepository.save(comprador);
        compradorRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("Cadastro deletado com sucesso!");
        return msg;

    }

}
