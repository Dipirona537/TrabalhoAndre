/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trabalho.trabalhoandre.Dados;

import org.eclipse.persistence.exceptions.DatabaseException;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author gabriel.guimaraes
 */
public class OperacoesDB {
    
    //Gerencia toda a parte do banco de dados

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
        em.merge(o);
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

    public List listar() {
        return null;//em.createNativeQuery("select * from diario d", Diario.class).getResultList();
    }
    
    public Object get(int esc)
    {
        List objetos = listar();
        return objetos.get(esc);
    }
}
