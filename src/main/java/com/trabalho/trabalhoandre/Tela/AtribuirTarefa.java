package com.trabalho.trabalhoandre.Tela;

import javax.swing.*;

public class AtribuirTarefa extends JFrame {

    public AtribuirTarefa()
    {
        alocar();
        configurar();
        acoes();
    }

    private void acoes() {
    }

    private void alocar() {

    }

    private void configurar()
    {
        setTitle("Gestor de Tarefas");
        setSize(390, 140);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
