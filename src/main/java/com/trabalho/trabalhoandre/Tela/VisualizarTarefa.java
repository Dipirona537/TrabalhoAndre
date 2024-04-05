package com.trabalho.trabalhoandre.Tela;

import com.trabalho.trabalhoandre.Entidades.Tarefa;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class VisualizarTarefa extends JFrame {
    private Tarefa tarefa;
    private JPanel detalhes;
    private GridBagConstraints gbc;
    private JTextField titulo;
    private JTextArea descricao;
    private JTextField entrega;
    private JTextField prioridade;

    public VisualizarTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
        alocar();
        configurar();
    }

    private void alocar() {
        setLayout(new BorderLayout());

        detalhes = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        detalhes.add(new JLabel("Título:"), gbc);
        gbc.gridy++;
        titulo = new JTextField(20);
        titulo.setEditable(false);
        titulo.setText(tarefa.getTitulo());
        detalhes.add(titulo, gbc);

        gbc.gridy++;
        detalhes.add(new JLabel("Descrição:"), gbc);
        gbc.gridy++;
        descricao = new JTextArea(4, 20);
        descricao.setEditable(false);
        descricao.setLineWrap(true);
        descricao.setText(tarefa.getDesc());
        detalhes.add(new JScrollPane(descricao), gbc);

        gbc.gridy++;
        detalhes.add(new JLabel("Data de Entrega:"), gbc);
        gbc.gridy++;
        entrega = new JTextField(20);
        entrega.setEditable(false);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataEntregaFormatada = sdf.format(tarefa.getEntrega());
        entrega.setText(dataEntregaFormatada);
        detalhes.add(entrega, gbc);

        gbc.gridy++;
        detalhes.add(new JLabel("Prioridade:"), gbc);
        gbc.gridy++;
        prioridade = new JTextField(20);
        prioridade.setEditable(false);
        prioridade.setText(String.valueOf(tarefa.getPrioridade()));
        detalhes.add(prioridade, gbc);

        add(detalhes, BorderLayout.CENTER);
    }

    private void configurar() {
        setTitle("Visualizar Tarefa");
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
