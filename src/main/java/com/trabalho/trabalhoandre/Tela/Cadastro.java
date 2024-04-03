package com.trabalho.trabalhoandre.Tela;

import javax.swing.*;
import java.awt.*;

public class Cadastro extends JFrame {
    private JTextField nome;
    private JButton salvar;
    private JButton fechar;
    private JTextField email;
    private JMenuBar permissao;
    private JMenuItem p1;
    private JMenuItem p2;
    private JPasswordField senha;
    private JPanel botoes;
    private JPanel campos;
    public Cadastro()
    {
        alocar();
        configurar();
        acoes();
    }

    private void acoes() {

    }

    private void alocar() {
        botoes = new JPanel();
        campos = new JPanel();
        permissao = new JMenuBar();
        p1 = new JMenuItem("Usuario");
        p2 = new JMenuItem("Admin");
        permissao.add(p1);
        permissao.add(p2);

        nome = new JTextField();
        salvar = new JButton("Salvar");
        fechar = new JButton("Fechar");
        email = new JTextField(30);
        senha = new JPasswordField(16);

        botoes.setLayout(new FlowLayout());
        campos.setLayout(new FlowLayout());

        botoes.add(salvar);
        botoes.add(fechar);
        campos.add(nome);
        campos.add(email);
        campos.add(senha);

        add(campos, BorderLayout.NORTH);
        add(botoes, BorderLayout.CENTER);
    }
    private void configurar()
    {
        setTitle("Gestor de Tarefas");
        setSize(640, 480);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(rootPane);
    }
}
