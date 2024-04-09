package com.trabalho.trabalhoandre.Tela;

import com.trabalho.trabalhoandre.Entidades.TarefaGenerica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class Consulta extends JFrame {
    private JTable tabela;
    private List<TarefaGenerica> tarefas;
    private JScrollPane scroll;
    private int pesq;

    public Consulta(List<TarefaGenerica> tarefas, int pesq) {
        this.tarefas = tarefas;
        this.pesq = pesq;
        alocar();
        configurar();
        if (tarefas.size()==0) semRegistros();
        else atualizarLista();
    }

    public void semRegistros() {
        JLabel semreg = new JLabel("Sem registros, por favor cadastre antes de acessar o menu.");
        remove(scroll);
        add(semreg, BorderLayout.NORTH);
        pack();
    }

    public void atualizarLista() {
        if (pesq == 1) {
            String[] colunas = new String[]{"Tarefa", "Descrição", "Entrega", "Prioridade"};
            Object[][] data = new Object[tarefas.size()][colunas.length];
            for (int i = 0; i < tarefas.size(); i++) {
                data[i][0] = tarefas.get(i).getTitulo();
                data[i][1] = tarefas.get(i).getDesc();
                data[i][2] = tarefas.get(i).getEntrega();
                data[i][3] = tarefas.get(i).getPrioridade();
            }
            tabela.setModel(new DefaultTableModel(data, colunas));
        } else {
            String[] colunas = new String[]{"Responsável", "Tarefa", "Descrição", "Entrega", "Prioridade"};
            Object[][] data = new Object[tarefas.size()][colunas.length];
            for (int i = 0; i < tarefas.size(); i++) {
                data[i][0] = tarefas.get(i).getResponsavel();
                data[i][1] = tarefas.get(i).getTitulo();
                data[i][2] = tarefas.get(i).getDesc();
                data[i][3] = tarefas.get(i).getEntrega();
                data[i][4] = tarefas.get(i).getPrioridade();
            }
            tabela.setModel(new DefaultTableModel(data, colunas));
        }
    }

    private void alocar() {
        setLayout(new BorderLayout());
        tabela = new JTable();
        scroll = new JScrollPane(tabela);
        add(scroll, BorderLayout.NORTH);
        pack();
    }

    private void configurar() {
        setTitle("Consulta de Tarefas");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
