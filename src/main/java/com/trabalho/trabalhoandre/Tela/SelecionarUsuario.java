package com.trabalho.trabalhoandre.Tela;

import com.trabalho.trabalhoandre.Dados.OperacoesDB;
import com.trabalho.trabalhoandre.Entidades.Pessoa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SelecionarUsuario extends JFrame {
    private JScrollPane scroll;
    private JTable usuarios;
    private JButton selecionar;
    private JButton atualizar;
    private List<Pessoa> pessoas;
    private JPanel principal;
    private boolean concluir;

    public SelecionarUsuario() {
        this.concluir = false;
        alocar();
        configurar();
        acoes();
        if (pessoas.size()==0)
        {
            semRegistros();
        }
    }

    public SelecionarUsuario(boolean concluir) {
        this.concluir = true;
        alocar();
        configurar();
        acoes();
        if (pessoas.size()==0)
        {
            semRegistros();
        }
    }

    private void configurar() {
        setTitle("Selecionar Usuário");
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void alocar() {
        principal = new JPanel(new FlowLayout());
        usuarios = new JTable();
        scroll = new JScrollPane(usuarios);
        atualizarLista();
        selecionar = new JButton("Selecionar");
        atualizar = new JButton("Atualizar");
        add(scroll, BorderLayout.NORTH);
        add(principal, BorderLayout.SOUTH);
        principal.add(selecionar);
        principal.add(atualizar);
        add(principal);
    }

    public void semRegistros()
    {
        JLabel semreg = new JLabel("Sem registros, por favor cadastre antes de acessar o menu.");
        remove(scroll);
        add(semreg, BorderLayout.NORTH);
        pack();
    }

    public void atualizarLista()
    {
        pessoas = new OperacoesDB().listarPessoas();
        String[] colunas = new String[]{"Nome"};
        Object[][] data = new Object[pessoas.size()][colunas.length];
        for (int i = 0; i < pessoas.size(); i++) {
            data[i][0] = pessoas.get(i).getNome();
        }
        usuarios.setModel(new DefaultTableModel(data,colunas));
        pack();
    }

    public void acoes()
    {
        if (concluir)
        {
            selecionar.addActionListener(e -> {
                int id = usuarios.getSelectedRow();
                if (id < 0)
                {
                    JOptionPane.showMessageDialog(null,"Nenhum usuário selecionado!");
                }else{
                    dispose();
                    new ConcluirTarefa(pessoas.get(id));
                }
            });
        }else{
            selecionar.addActionListener(e -> {
                int id = usuarios.getSelectedRow();
                if (id < 0)
                {
                    JOptionPane.showMessageDialog(null,"Nenhum usuário selecionado!");
                }else{
                    dispose();
                    new SelecionarTarefa(pessoas.get(id)).setVisible(true);
                }
            });
        }

        atualizar.addActionListener(e -> atualizarLista());
    }
}
