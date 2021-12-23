package com.example.ProjetoLeilaoVespertino.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="vendedor")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", length = 10, nullable = false)
    //@Pattern(regexp = "^[0-9]{1,10}$")
    private Integer id;

    @Column(name="nome", length = 60, nullable = false)
    //@Pattern(regexp = "^[A-Z]{1}[A-Za-z\s]{2,57}$")
    private String nome;

    @Column(name="email", length = 60, nullable = false)
    //@Pattern(regexp = "[A-z0-9]{5,55}$")
    private String email;

    @Column(name="telefone", length = 11, nullable = false)
    //@Pattern(regexp = "^[0-9]{11}$")
    private String telefone;

    @Column(name="ativo", nullable = false)
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
