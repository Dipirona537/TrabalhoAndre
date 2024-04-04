package com.trabalho.trabalhoandre.Tela;

import com.trabalho.trabalhoandre.Entidades.Pessoa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SelecionarUsuario extends JFrame {
    private JScrollPane scroll;
    private JTable tabelaUsuarios;
    private JButton selecionarButton;
    private List<Pessoa> listaPessoas;
    private JPanel painelPrincipal;
    private Pessoa pessoaSelecionada;

    public SelecionarUsuario(List<Pessoa> listaPessoas) {
        this.listaPessoas = listaPessoas;
        alocar();
        configurar();
        acoes();
    }

    private void configurar() {
        setTitle("Selecionar Usuário");
        setSize(380, 510);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void alocar() {
        painelPrincipal = new JPanel(new BorderLayout());

        String[] colunas = new String[]{"Nome"};
        Object[][] data = new Object[listaPessoas.size()][colunas.length];
        for (int i = 0; i < listaPessoas.size(); i++) {
            data[i][0] = listaPessoas.get(i).getNome();
        }
        tabelaUsuarios.setModel(new DefaultTableModel(data,colunas));
        scroll = new JScrollPane(tabelaUsuarios);
        selecionarButton = new JButton("Selecionar");
        add(tabelaUsuarios, BorderLayout.NORTH);
        painelPrincipal.add(selecionarButton, BorderLayout.SOUTH);
        add(painelPrincipal);
    }

    public void acoes()
    {
        selecionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = tabelaUsuarios.getSelectedRow();
                if (id < 0)
                {
                    JOptionPane.showMessageDialog(null,"Nenhum usuário selecionado!");
                }else{
                    Pessoa p = retornaSelecionado(id);
                    dispose();
                    new SelecionarTarefa(p).setVisible(true);
                }
            }
        });
    }

    private Pessoa retornaSelecionado(int i)
    {
        return listaPessoas.get(i);
    }
}
