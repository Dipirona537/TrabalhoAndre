package com.trabalho.trabalhoandre.Tela;

import com.trabalho.trabalhoandre.Dados.OperacoesDB;
import com.trabalho.trabalhoandre.Entidades.Pessoa;
import com.trabalho.trabalhoandre.Entidades.Tarefa;

import javax.swing.*;

public class ConcluirTarefa {
    private final Pessoa p;

    public ConcluirTarefa(Pessoa p)
    {
        this.p = p;
        concluir();
    }

    private void concluir()
    {
        Tarefa temp2 = p.getTarefa();
        Pessoa temp = p;
        if(temp2==null)
        {
            JOptionPane.showMessageDialog(null, "Usuário não possui tarefa!");
        }else{
            OperacoesDB op = new OperacoesDB();
            p.getTarefa().setConcluida(true);
            op.atualiza(p.getTarefa(), temp2);
            p.setTarefa(null);
            op.atualiza(p, temp);
            JOptionPane.showMessageDialog(null, "Tarefa finalizada!");
        }
    }
}
