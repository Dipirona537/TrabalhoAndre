package com.trabalho.trabalhoandre.Tela;

import com.toedter.calendar.JCalendar;
import com.trabalho.trabalhoandre.Entidades.Tarefa;
import com.trabalho.trabalhoandre.Entidades.TarefaGenerica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Filtrar extends JFrame {
    private JButton filtrarButton;
    private JCalendar dataEntregaCalendar;
    private JComboBox<Integer> prioridadeComboBox;
    private JTextField responsavelTextField;

    private JLabel dataEntregaLabel;
    private JLabel prioridadeLabel;
    private JLabel responsavelLabel;

    public Filtrar() {
        alocar();
        configurar();
        acoes();
    }

    private void alocar() {
        setLayout(new BorderLayout());

        JPanel camposPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        dataEntregaLabel = new JLabel("Data de Entrega:");
        camposPanel.add(dataEntregaLabel, gbc);
        gbc.gridy++;
        dataEntregaCalendar = new JCalendar();
        camposPanel.add(dataEntregaCalendar, gbc);

        gbc.gridy++;
        prioridadeLabel = new JLabel("Prioridade:");
        camposPanel.add(prioridadeLabel, gbc);
        gbc.gridy++;
        prioridadeComboBox = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        camposPanel.add(prioridadeComboBox, gbc);

        gbc.gridy++;
        responsavelLabel = new JLabel("Responsável:");
        camposPanel.add(responsavelLabel, gbc);
        gbc.gridy++;
        responsavelTextField = new JTextField(20);
        camposPanel.add(responsavelTextField, gbc);

        filtrarButton = new JButton("Filtrar");
        add(camposPanel, BorderLayout.CENTER);
        add(filtrarButton, BorderLayout.SOUTH);
    }

    private void configurar() {
        setTitle("Filtrar Tarefas");
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void acoes() {
        filtrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pesquisa;
                int pesq;
                if (responsavelTextField.getText().isEmpty()) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String dataEntregaStr = dateFormat.format(dataEntregaCalendar.getDate());
                    String dataent = "to_date('" + dataEntregaStr + "', 'DD/MM/YYYY')";
                    int prioridade = (int) prioridadeComboBox.getSelectedItem();
                    pesquisa = "select * from fn_filtrar_tarefas_sem_pessoa(" + dataent + ", " + prioridade + ") order by tarefa_titulo";
                    pesq = 1;
                } else {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String dataEntregaStr = dateFormat.format(dataEntregaCalendar.getDate());
                    String responsavel = responsavelTextField.getText(); // Correção aqui
                    String dataent = "to_date('" + dataEntregaStr + "', 'DD/MM/YYYY')";
                    int prioridade = (Integer) prioridadeComboBox.getSelectedItem();
                    if (responsavel.equals("")) responsavel = "NULL";
                    pesquisa = "select * from fn_filtrar_tarefas('" + responsavel + "', " + dataent + ", " + prioridade + ") order by titulo";
                    pesq = 2;
                }
                try {
                    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "senhaboa1");
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(pesquisa);
                    ArrayList tarefas = new ArrayList<TarefaGenerica>();
                    if (pesq == 1)
                    {
                        while(rs.next())
                        {
                            TarefaGenerica temp = new TarefaGenerica();
                            temp.setDesc(rs.getString("tarefa_descricao"));
                            temp.setEntrega(rs.getDate("tarefa_entrega"));
                            temp.setPrioridade(rs.getInt("tarefa_prioridade"));
                            temp.setTitulo(rs.getString("tarefa_titulo"));
                            tarefas.add(temp);
                        }
                    }else{
                        while(rs.next())
                        {
                            TarefaGenerica temp = new TarefaGenerica();
                            temp.setDesc(rs.getString("descricao"));
                            temp.setEntrega(rs.getDate("entrega"));
                            temp.setPrioridade(rs.getInt("prioridade"));
                            temp.setTitulo(rs.getString("titulo"));
                            temp.setResponsavel(rs.getString("nome"));
                            tarefas.add(temp);
                        }
                    }
                    new Consulta(tarefas, pesq).setVisible(true);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco\n"+ex.getMessage());
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
