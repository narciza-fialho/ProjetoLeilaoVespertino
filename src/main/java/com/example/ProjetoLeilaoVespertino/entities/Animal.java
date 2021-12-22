package com.example.ProjetoLeilaoVespertino.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10, nullable = false)
    //@Pattern(regexp="[A-z0-9\s]{1,10}")
    private Integer id;

    @Column(name="nome", nullable = false, length = 255)
    //@Pattern(regexp="[A-z\s]{1,255}")
    private String nome;

    @Column(name = "registro", nullable = false, length = 255, unique = true)
    //@Pattern(regexp = "[0-9]{1,1000}")
    private String registro;

    @Column(name = "preco", length = 10, nullable = false)
    //@Pattern(regexp = "[1-9]\\d*(\\.\\d+)?")
    private Double preco;

    @Column(name = "raca", nullable = false, length = 255)
    //@Pattern(regexp="[A-z\s]{1,255}")
    private String raca;

    @Column(name = "ativo", nullable = false)
    //@Pattern(regexp = "^true$|^false$")
    private Boolean ativo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
