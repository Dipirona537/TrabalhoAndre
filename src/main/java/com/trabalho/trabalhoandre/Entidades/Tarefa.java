package com.trabalho.trabalhoandre.Entidades;

import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Tarefa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "titulo", length = 50)
    private String titulo;
    @Column(name = "descricao", length = 200)
    private String desc;
    @Column(name = "entrega")
    @Temporal(TemporalType.DATE)
    private Date entrega;
    @Column(name = "prioridade")
    private int prioridade;
    @Column(name = "concluida")
    private boolean concluida;

    public Tarefa()
    {
        this.concluida = false;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getEntrega() {
        return entrega;
    }

    public void setEntrega(Date entrega) {
        this.entrega = entrega;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
}
