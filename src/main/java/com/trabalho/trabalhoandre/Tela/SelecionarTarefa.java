package com.trabalho.trabalhoandre.Tela;

import com.trabalho.trabalhoandre.Dados.OperacoesDB;
import com.trabalho.trabalhoandre.Entidades.Pessoa;
import com.trabalho.trabalhoandre.Entidades.Tarefa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SelecionarTarefa extends JFrame {
    private Pessoa pessoa;
    private List<Tarefa> tarefas;
    private JTable tarefast;
    private JScrollPane scroll;
    private JButton selecionar;
    private JButton atualizar;

    public SelecionarTarefa()
    {
        this.tarefas = new ArrayList<>();//new OperacoesDB().listarTarefas();
        alocar();
        configurar();
        acoes();
        if (tarefas.size()==0)
        {
            semRegistros();
        }
    }
    public SelecionarTarefa(Pessoa pessoa)
    {
        this.pessoa = pessoa;
        alocar();
        configurar();
        acoes();
        if (tarefas.size()==0)
        {
            semRegistros();
        }
    }

    public void alocar()
    {
        tarefast = new JTable();
        scroll = new JScrollPane(tarefast);
        atualizarLista();
        selecionar = new JButton("Selecionar");
        atualizar = new JButton("Atualizar");
        JPanel principal = new JPanel(new FlowLayout());
        principal.add(selecionar);
        principal.add(atualizar);
        add(scroll, BorderLayout.NORTH);
        add(principal, BorderLayout.SOUTH);
        add(principal);
    }

    public void semRegistros()
    {
        JLabel semreg = new JLabel("Sem registros, por favor cadastre antes de acessar o menu.");
        remove(scroll);
        add(semreg, BorderLayout.NORTH);
        pack();
    }

    public Tarefa retornaTarefa(int i)
    {
        return tarefas.get(i);
    }

    public void configurar()
    {
        setTitle("Selecionar Tarefa");
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void acoes()
    {
        if (pessoa!=null)
        {
            selecionar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int id = tarefast.getSelectedRow();
                    if (id < 0)
                    {
                        JOptionPane.showMessageDialog(null,"Nenhuma tarefa selecionada!");
                    }else{
                        dispose();
                        new AtribuirTarefa(pessoa, retornaSelecionado(id)).Atribuir();
                    }
                }
            });
        }else{
            selecionar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int id = tarefast.getSelectedRow();
                    if (id < 0)
                    {
                        JOptionPane.showMessageDialog(null,"Nenhuma tarefa selecionada!");
                    }else{
                        dispose();
                        new VisualizarTarefa(retornaTarefa(id)).setVisible(true);

                    }
                }
            });
        }

        atualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarLista();
            }
        });
    }

    private Tarefa retornaSelecionado(int i)
    {
        return tarefas.get(i);
    }

    public void atualizarLista()
    {
        this.tarefas = new OperacoesDB().listarTarefas();
        String[] colunas = new String[]{"Tarefa"};
        Object[][] data = new Object[tarefas.size()][colunas.length];
        for (int i = 0; i < tarefas.size(); i++) {
            data[i][0] = tarefas.get(i).getTitulo();
        }
        tarefast.setModel(new DefaultTableModel(data,colunas));
        pack();
    }
}
