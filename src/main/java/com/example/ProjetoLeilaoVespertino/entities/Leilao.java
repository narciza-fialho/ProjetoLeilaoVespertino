package com.example.ProjetoLeilaoVespertino.entities;


import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="leilao")
public class Leilao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name= "id", nullable = false, unique = true, length = 10)
  //  @Pattern(regexp="[A-z0-9\s]{1,10} ")
    private Integer id;
    @Column(name="data", nullable = false)
  //  @Pattern(regexp="^([1-2]?[0-9]|3[0-1]|0[1-9])/(1?[0-2]|0[1-9])/[0-9]{4}$")
    private String data;
    @Column(name="ativo", nullable = false)
  //  @Pattern(regexp = "(?i)(true|false)")
    private Boolean ativo;
    @Column(name ="id_funcionario",nullable = false, length = 10)
  //  @Pattern(regexp="^[0-9]{1,10}$")
    private Integer idFuncionario;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
}
