package com.example.ProjetoLeilaoVespertino.controller;

import com.example.ProjetoLeilaoVespertino.Mensagem;
import com.example.ProjetoLeilaoVespertino.entities.Vendedor;
import com.example.ProjetoLeilaoVespertino.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vendedor")
public class VendedorController {
    @Autowired
    private VendedorRepository vendedorRepository;

    @GetMapping
    public List<Vendedor> listar () {
        List<Vendedor> lista = vendedorRepository.findByAtivo(true);
        return lista;
    }

    @GetMapping("/{id}")
    public Vendedor buscar (@PathVariable int id) {
        Vendedor vendedor = vendedorRepository.findById(id).get();
        return vendedor;
    }

    @PostMapping
    public Mensagem incluir (@RequestBody Vendedor vendedor) {
        vendedor.setId(0);
        vendedorRepository.saveAndFlush(vendedor);
        Mensagem msg = new Mensagem();
        msg.setMensagem("Incluido com sucesso");
        return msg;
    }

    @PutMapping
    public Mensagem alterar (@RequestBody Vendedor vendedor) {
        vendedorRepository.saveAndFlush(vendedor);
        Mensagem msg = new Mensagem();
        msg.setMensagem("Alterado com sucesso");
        return msg;
    }

    @DeleteMapping
    public Mensagem deletar (@RequestBody Vendedor vendedor) {
        vendedor.setAtivo(false);
        vendedorRepository.saveAndFlush(vendedor);
        Mensagem msg = new Mensagem();
        msg.setMensagem("Deletado com sucesso");
        return msg;
    }
}
