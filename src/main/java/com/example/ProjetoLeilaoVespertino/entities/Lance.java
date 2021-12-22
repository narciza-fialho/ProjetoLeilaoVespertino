package com.example.ProjetoLeilaoVespertino.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Entity
@Table(name = "lance")
public class Lance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10, nullable = false)
    //@Pattern(regexp="^[0-9]{1,10}$")
    private Integer id;

    @Column(name = "data", nullable = false, unique = true, length = 50)
    //@Pattern(regexp="^[0-9:-/]{1,50}$")
    private Date data;

    @Column(name = "valor", nullable = false, length = 18)
    //@Pattern(regexp="^[0-9]{1,15}[.][0-9]{1,2}$")
    private Double valor;

    @Column(name = "ativo", nullable = false)
    //@Pattern(regexp = "^[0-1]$")
    private Boolean ativo;

    @Column(name = "id_comprador", length = 10, nullable = false)
    //@Pattern(regexp="^[0-9]{1,10}$")
    private Integer idComprador;

    @Column(name = "id_leilao", length = 10, nullable = false)
    //@Pattern(regexp="^[0-9]{1,10}$")
    private Integer idLeilao;

    @Column(name = "id_animal", length = 10, nullable = false)
    //@Pattern(regexp="^[0-9]{1,10}$")
    private Integer idAnimal;

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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(Integer idComprador) {
        this.idComprador = idComprador;
    }

    public Integer getIdLeilao() {
        return idLeilao;
    }

    public void setIdLeilao(Integer idLeilao) {
        this.idLeilao = idLeilao;
    }

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }
}
