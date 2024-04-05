/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trabalho.trabalhoandre.Dados;

import com.trabalho.trabalhoandre.Entidades.Pessoa;
import com.trabalho.trabalhoandre.Entidades.Tarefa;
import org.eclipse.persistence.exceptions.DatabaseException;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author gabriel.guimaraes
 */
public class OperacoesDB {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.unigran.br_Diario_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction etx = em.getTransaction();

    public void salvar(Object o) {
        etx.begin();
        em.persist(o);
        etx.commit();
    }

    public void atualiza(Object o, Object old)  {
        if (!em.contains(old)) {
            old = em.merge(old);
        }
        etx.begin();
        em.remove(old);
        em.persist(o);
        etx.commit();
    }

    public void remove(Object o) {
        if (!em.contains(o)) {
            o = em.merge(o);
        }
        etx.begin();
        em.remove(o);
        etx.commit();
    }

    public List listarPessoas() {
        return em.createNativeQuery("select * from pessoa p", Pessoa.class).getResultList();
    }
    public List listarTarefas()
    {
        return em.createNativeQuery("select * from tarefa t", Tarefa.class).getResultList();
    }
}
