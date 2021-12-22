package com.example.ProjetoLeilaoVespertino.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="veterinario")
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true, length = 10)
    //@Pattern(regexp = "^[0-9]{1,10}")
    private Integer id;
    @Column(name="nome", nullable = false, length = 255)
    //@Pattern(regexp = "[A-z\s]{1,255}")
    private String nome;
    @Column(name="email", nullable = false, unique = true, length = 255)
    //@Pattern(regexp ="[A-z]{1,64}@[A-Za-z0-9]{1,255}.[A-z]{1,3}" )
    private String email;
    @Column(name="telefone", nullable = false, unique = true, length = 255)
    //@Pattern(regexp = "[0-9]{2}[\\s][0-9]{5}-[0-9]{4}")
    private String telefone;
    @Column(name="ativo")
    private Boolean ativo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }


}
