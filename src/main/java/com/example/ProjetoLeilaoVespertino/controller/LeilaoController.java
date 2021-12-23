package com.example.ProjetoLeilaoVespertino.controller;


import com.example.ProjetoLeilaoVespertino.Mensagem;
import com.example.ProjetoLeilaoVespertino.business.LeilaoBiz;
import com.example.ProjetoLeilaoVespertino.entities.Leilao;
import com.example.ProjetoLeilaoVespertino.repositories.LeilaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("leilao")
public class LeilaoController {

    @Autowired
    private LeilaoRepository leilaoRepository;

    @GetMapping
    public List<Leilao> lista() {
        List<Leilao> lista = leilaoRepository.findByAtivo(true);
        return lista;
    }

    @GetMapping("/{id}")
    public Leilao buscar(@PathVariable int id) {
        Leilao leilao = leilaoRepository.findById(id).get();
        return leilao;
    }

    @PostMapping
    public Mensagem incluir(@RequestBody Leilao leilao) {
        LeilaoBiz leilaoBiz = new LeilaoBiz(leilao, leilaoRepository);
        Mensagem msg = new Mensagem();

        if (leilaoBiz.isValid()) {
            leilao.setId(0);
            leilaoRepository.saveAndFlush(leilao);
            msg.setMensagem("Inserido!!");
        } else {
            msg.setErro((leilaoBiz.getErros()));
            msg.setMensagem(("erro"));
        }

        return msg;
    }

    @PutMapping
    public Mensagem alterar(@RequestBody Leilao leilao) {
        leilaoRepository.save(leilao);
        leilaoRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("Alterado!!");
        return msg;
    }

    @DeleteMapping
    public Mensagem deletar(@RequestBody Leilao leilao) {
        leilao.setAtivo(false);
        leilaoRepository.save(leilao);
        leilaoRepository.flush();

        Mensagem msg = new Mensagem();
        msg.setMensagem("Deletado");
        return msg;
    }
}
