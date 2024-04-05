package com.trabalho.trabalhoandre.Entidades;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nome", length = 50)
    private String nome;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "senha", length = 50)
    private String senha;
    @Column(name = "permissao")
    private int permissao;
    @JoinColumn(name = "fk_tarefa")
    @ManyToOne
    private Tarefa tarefa;

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getPermissao() {
        return permissao;
    }

    public void setPermissao(int permissao) {
        this.permissao = permissao;
    }
}
