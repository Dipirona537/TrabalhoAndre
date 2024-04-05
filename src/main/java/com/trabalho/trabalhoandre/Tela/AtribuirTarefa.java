package com.trabalho.trabalhoandre.Tela;

import com.trabalho.trabalhoandre.Dados.OperacoesDB;
import com.trabalho.trabalhoandre.Entidades.Pessoa;
import com.trabalho.trabalhoandre.Entidades.Tarefa;

import javax.swing.*;

public class AtribuirTarefa {
    private Pessoa p;
    private Tarefa t;

    public AtribuirTarefa(Pessoa p, Tarefa t) {
        this.p = p;
        this.t = t;
    }

    public void Atribuir() {
        Pessoa temp = p;
        int resp = JOptionPane.showConfirmDialog(null, "Deseja atribuir a tarefa\n" + t.getTitulo() + "\nAo usuário " + p.getNome() + "?");
        if (resp == JOptionPane.YES_OPTION) {
            p.setTarefa(t);
            p.getTarefa().setConcluida(false);
            JOptionPane.showMessageDialog(null, "Tarefa atribuida!");
            OperacoesDB op = new OperacoesDB();
            op.atualiza(p, temp);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma alteração realizada!");
        }
    }
}
