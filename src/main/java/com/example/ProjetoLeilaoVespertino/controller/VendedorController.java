package com.example.ProjetoLeilaoVespertino.controller;

import com.example.ProjetoLeilaoVespertino.Mensagem;
import com.example.ProjetoLeilaoVespertino.business.VendedorBiz;
import com.example.ProjetoLeilaoVespertino.entities.Animal;
import com.example.ProjetoLeilaoVespertino.entities.Vendedor;
import com.example.ProjetoLeilaoVespertino.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vendedor")
@CrossOrigin
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
        VendedorBiz vendedorBiz = new VendedorBiz(vendedor, vendedorRepository);
        Mensagem msg = new Mensagem();

        if(vendedorBiz.isValid()){
            vendedor.setId(0);
            vendedorRepository.saveAndFlush(vendedor);
            msg.setMensagem("Tudo certo, vendedor cadastrado!");
            return msg;
        }
        else{
            msg.setMensagem("Erro");
            msg.setErro(vendedorBiz.getErros());
        }
        return msg;
    }

    @PutMapping
    public Mensagem alterar (@RequestBody Vendedor vendedor) {
        VendedorBiz vendedorBiz = new VendedorBiz(vendedor, vendedorRepository);
        Mensagem msg = new Mensagem();

        if(vendedorBiz.isValid()){
            vendedorRepository.saveAndFlush(vendedor);
            msg.setMensagem("Tudo certo, cadastro do vendedor alterado!");
            return msg;
        }
        else{
            msg.setMensagem("Erro");
            msg.setErro(vendedorBiz.getErros());
            System.out.println(vendedorBiz.getErros());
        }
        return msg;
    }

    @DeleteMapping("/{id}")
    public Mensagem Deletar(@PathVariable int id){
        Vendedor vendedor = vendedorRepository.findById(id).get();
        vendedor.setAtivo(false);
        vendedorRepository.saveAndFlush(vendedor);
        Mensagem msg = new Mensagem();
        msg.setMensagem("Vendedor deletado com sucesso!");
        return msg;
    }
}
