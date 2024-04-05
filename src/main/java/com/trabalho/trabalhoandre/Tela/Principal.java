/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trabalho.trabalhoandre.Tela;

import com.trabalho.trabalhoandre.Entidades.Tarefa;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author laboratorio
 */
public class Principal extends JFrame{
    private JButton cadastro;
    private JButton criarTarefa;
    private JButton atribuirTarefa;
    private JButton visualizarTarefa;
    private JButton concluirTarefa;
    
    public Principal()
    {
        alocar();
        configurar();
        acoes();
    }
    
    private void alocar() {
        setLayout(new FlowLayout());
        cadastro = new JButton("Cadastrar Usuario");
        criarTarefa = new JButton("Criar Tarefa");
        atribuirTarefa = new JButton("Atribuir Tarefa");
        visualizarTarefa = new JButton("Visualizar Tarefa");
        concluirTarefa = new JButton("Concluir Tarefa");

        add(cadastro);
        add(criarTarefa);
        add(atribuirTarefa);
        add(visualizarTarefa);
        add(concluirTarefa);
    }
    
    private void configurar()
    {
        setTitle("Gestor de Tarefas");
        setSize(390, 140);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    private void acoes()
    {
        cadastro.addActionListener(e -> new Cadastro().setVisible(true));
        criarTarefa.addActionListener(e -> new CriarTarefa().setVisible(true));
        atribuirTarefa.addActionListener(e -> new SelecionarUsuario().setVisible(true));
        visualizarTarefa.addActionListener(e -> new SelecionarTarefa().setVisible(true));
        concluirTarefa.addActionListener(e -> new SelecionarUsuario(true).setVisible(true));
    }
}
