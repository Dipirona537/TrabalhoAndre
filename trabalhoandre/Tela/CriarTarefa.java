package com.trabalho.trabalhoandre.Tela;

import com.toedter.calendar.JCalendar;
import com.trabalho.trabalhoandre.Dados.OperacoesDB;
import com.trabalho.trabalhoandre.Entidades.Tarefa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

public class CriarTarefa extends JFrame {
    private JTextField titulo;
    private JTextArea descricao;
    private JCalendar dataentrega;
    private JComboBox<Integer> prioridade;
    private JButton salvar;
    private JButton fechar;

    public CriarTarefa() {
        alocar();
        configurar();
        acoes();
    }

    private void acoes() {
        salvar.addActionListener(e -> {
            String titulo = CriarTarefa.this.titulo.getText();
            String descricao = CriarTarefa.this.descricao.getText();
            Date dataEntrega = dataentrega.getDate();
            int prioridade = (int) CriarTarefa.this.prioridade.getSelectedItem();
            if (dataEntrega == null)
            {
                JOptionPane.showMessageDialog(null, "Data inválida!");
            }else{
                OperacoesDB op = new OperacoesDB();
                Tarefa t = new Tarefa();
                t.setTitulo(titulo);
                t.setDesc(descricao);
                t.setPrioridade(prioridade);
                t.setEntrega(dataEntrega);
                op.salvar(t);
            }



            dispose();
        });

        fechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void alocar() {
        setLayout(new BorderLayout());

        JPanel camposPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        camposPanel.add(new JLabel("Título:"), gbc);
        gbc.gridy++;
        titulo = new JTextField(20);
        camposPanel.add(titulo, gbc);

        gbc.gridy++;
        camposPanel.add(new JLabel("Descrição:"), gbc);
        gbc.gridy++;
        descricao = new JTextArea(4, 20);
        descricao.setLineWrap(true);
        camposPanel.add(new JScrollPane(descricao), gbc);

        gbc.gridy++;
        camposPanel.add(new JLabel("Data de Entrega:"), gbc);
        gbc.gridy++;
        dataentrega = new JCalendar();
        camposPanel.add(dataentrega, gbc);

        gbc.gridy++;
        camposPanel.add(new JLabel("Prioridade:"), gbc);
        gbc.gridy++;
        prioridade = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        camposPanel.add(prioridade, gbc);

        JPanel botoesPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcBotoes = new GridBagConstraints();
        gbcBotoes.gridx = 0;
        gbcBotoes.gridy = 0;
        gbcBotoes.anchor = GridBagConstraints.WEST;
        gbcBotoes.insets = new Insets(5, 5, 5, 5);

        salvar = new JButton("Salvar");
        botoesPanel.add(salvar, gbcBotoes);

        gbcBotoes.gridx++;
        fechar = new JButton("Fechar");
        botoesPanel.add(fechar, gbcBotoes);

        add(camposPanel, BorderLayout.CENTER);
        add(botoesPanel, BorderLayout.SOUTH);
    }

    private void configurar() {
        setTitle("Criar Tarefa");
        setSize(380, 510);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
