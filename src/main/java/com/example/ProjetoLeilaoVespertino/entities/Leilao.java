package com.example.ProjetoLeilaoVespertino.entities;


import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;

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
    private Date data;
    @Column(name="nome", length = 50, nullable = false)
    // @Pattern(regexp = "^[A-Z]{1}[A-Za-z\s]{2,47}$")
    private String nome;
    @Column(name="ativo", nullable = false)
  //  @Pattern(regexp = "(?i)(true|false)")
    private Boolean ativo;





    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

}
