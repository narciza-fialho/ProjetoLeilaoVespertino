package com.example.ProjetoLeilaoVespertino.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="comprador")
public class Comprador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", length = 10, nullable = false)
    //@Pattern(regexp = "^[0-9]{1,10}$")
    private Integer id;
    @Column(name="nome",length = 60, nullable = false, unique = true)
    //@Pattern(regexp ="^[A-Z]{1}[A-z\s]{1,59}")
    private String nome;
    @Column(name = "email",length = 60,nullable = false,unique = true)
    //@Pattern(regexp = "^[a-z0-9_]{1,64}@[a-z.0-9_]{1,255}$")
    private String email;
    @Column(name="telefone", length = 11, nullable = false,unique = true)
    //@Pattern(regexp = "^[0-9]{11}$")
    private String telefone;
    @Column(name = "ativo",nullable = false)
    //@Pattern(regexp = "^true|false$")
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
