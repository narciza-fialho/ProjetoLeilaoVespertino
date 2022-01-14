package com.example.ProjetoLeilaoVespertino.ControllerTests;

import com.example.ProjetoLeilaoVespertino.Mensagem;
import com.example.ProjetoLeilaoVespertino.controller.VendedorController;

import com.example.ProjetoLeilaoVespertino.entities.Vendedor;
import com.example.ProjetoLeilaoVespertino.repositories.AnimalRepository;
import com.example.ProjetoLeilaoVespertino.repositories.VendedorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class VendedorControllerTests {
    @Autowired
    private VendedorRepository vendedorRepository;
    @Autowired
    private VendedorController vendedorController;
    private int idVendedorTeste;
    public VendedorControllerTests() {this.idVendedorTeste =34;}
    @Test
    public void buscarTest(){
        Boolean expected = true;
        Boolean result = false;
        try{
            Vendedor vendedorTest = vendedorController.buscar(this.idVendedorTeste);
            if(vendedorTest.getId()==this.idVendedorTeste){
                result = true;
            } else {
                result = false;
            }
        } catch (Exception ex){
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void ListarTest(){
        Boolean expected = true;
        Boolean result = false;

        if (vendedorController.listar().stream().count() > 0){
            result = true;
        }
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void IncluirTest(){
        Boolean expected = true;
        Boolean result = false;
        long registros_antes;
        long registros_depois;
        try {
            registros_antes=vendedorController.listar().stream().count();
            Vendedor vendedor = new Vendedor();
            vendedor.setAtivo(true);
            vendedor.setId(0);
            vendedor.setEmail("abc1234@gmail.com");
            vendedor.setNome("Junior Neto");
            vendedor.setTelefone("98989898989");
            vendedorController.incluir(vendedor);
            registros_depois = vendedorController.listar().stream().count();
            if (registros_depois > registros_antes){
                result = true;
            } else {
                result = false;
            }

        }
        catch (Exception ex){
            result = false;
        }
        assertThat(result).isEqualTo(expected);

    }
    @Test
    public void alterarTest()
    {
        Boolean expected = true;
        Boolean result = false;
        Vendedor vendedorNovo = vendedorController.buscar(9);
        try{
            vendedorNovo.setAtivo(true);
            vendedorNovo.setEmail("abc1234@gmail.com");
            vendedorNovo.setNome("");
            vendedorNovo.setTelefone("98989898989");
            Mensagem msg = vendedorController.alterar(vendedorNovo);
            if(!msg.getErro().isEmpty()){
                result=false;
            } else{
                result=true;
            }
        }
        catch (Exception ex){
            result=false;
        }
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void DeletarTest() {
        Boolean expected = true;
        Boolean result = false;

        Vendedor vendedordelet = vendedorController.buscar(9);

        try {
            vendedordelet.setAtivo(false);
            vendedorController.deletar(vendedordelet.getId());
            List<Vendedor> lista =vendedorRepository.findByAtivo(true);
            if (lista.contains(vendedordelet)) {
                result = false;
            } else {
                result = true;
            }
        } catch (Exception ex) {
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }
}






