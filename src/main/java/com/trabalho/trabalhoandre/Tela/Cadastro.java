package com.trabalho.trabalhoandre.Tela;

import com.trabalho.trabalhoandre.Dados.OperacoesDB;
import com.trabalho.trabalhoandre.Entidades.Pessoa;
import org.eclipse.persistence.exceptions.DatabaseException;
import org.postgresql.util.PSQLException;

import javax.persistence.PersistenceException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cadastro extends JFrame {
    private JTextField nome;
    private JButton salvar;
    private JButton fechar;
    private JTextField email;
    private JComboBox permissao;
    private JMenuItem p1;
    private JMenuItem p2;
    private JPasswordField senha;
    private JPanel botoes;
    private JPanel campos;
    private JLabel nomel;
    private JLabel emaill;
    private JLabel senhal;
    private JLabel perml;

    public Cadastro() {
        alocar();
        configurar();
        acoes();
    }

    private void acoes() {
        salvar.addActionListener(e -> {
            String nomeu = nome.getText();
            String emailu = email.getText();
            String senhau = new String(senha.getPassword());
            String permissaou = (String) permissao.getSelectedItem();
            if (nomeu.equals("") || emailu.equals("") || senhau.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Por favor, preencha todos os dados");
            }else{
                OperacoesDB op = new OperacoesDB();
                if (permissaou.equals("Usuário")) {
                    Pessoa p = new Pessoa();
                    p.setNome(nomeu);
                    p.setEmail(emailu);
                    p.setPermissao(1);
                    p.setSenha(senhau);
                    op.salvar(p);
                    JOptionPane.showMessageDialog(null,"Gravado com sucesso!");
                    dispose();
                } else {
                    Pessoa p = new Pessoa();
                    p.setNome(nomeu);
                    p.setEmail(emailu);
                    p.setPermissao(999);
                    p.setSenha(senhau);
                    op.salvar(p);
                    JOptionPane.showMessageDialog(null,"Gravado com sucesso!");
                    dispose();
                }
            }
        });

        fechar.addActionListener(e -> dispose());
    }

    private void alocar() {
        setLayout(new BorderLayout());
        nomel = new JLabel("Nome:");
        emaill = new JLabel("Email:");
        senhal = new JLabel("Senha:");
        perml = new JLabel("Permissão:");
        botoes = new JPanel();
        campos = new JPanel();
        permissao = new JComboBox<>(new String[]{"Administrador", "Usuário"});
        permissao.setSelectedIndex(1);

        nome = new JTextField(30);
        salvar = new JButton("Salvar");
        fechar = new JButton("Fechar");
        email = new JTextField(30);
        senha = new JPasswordField(16);

        campos.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        campos.add(new JLabel("Nome:"), gbc);
        gbc.gridy++;
        campos.add(nome, gbc);
        gbc.gridy++;
        campos.add(new JLabel("Email:"), gbc);
        gbc.gridy++;
        campos.add(email, gbc);
        gbc.gridy++;
        campos.add(new JLabel("Senha:"), gbc);
        gbc.gridy++;
        campos.add(senha, gbc);
        gbc.gridy++;
        campos.add(new JLabel("Permissão:"), gbc);
        gbc.gridy++;
        campos.add(permissao, gbc);

        botoes.setLayout(new GridBagLayout());
        GridBagConstraints gbcBotoes = new GridBagConstraints();
        gbcBotoes.gridx = 0;
        gbcBotoes.gridy = 0;
        gbcBotoes.anchor = GridBagConstraints.WEST;
        gbcBotoes.insets = new Insets(5, 5, 5, 5);

        botoes.add(salvar, gbcBotoes);
        gbcBotoes.gridx++;
        botoes.add(fechar, gbcBotoes);

        add(campos, BorderLayout.NORTH);
        add(botoes, BorderLayout.CENTER);
    }

    private void configurar() {
        setTitle("Cadastro");
        setSize(640, 480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
