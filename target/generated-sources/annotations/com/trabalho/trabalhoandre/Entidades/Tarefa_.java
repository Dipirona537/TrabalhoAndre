package com.trabalho.trabalhoandre.Entidades;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-05T13:38:55", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Tarefa.class)
public class Tarefa_ { 

    public static volatile SingularAttribute<Tarefa, Boolean> concluida;
    public static volatile SingularAttribute<Tarefa, Integer> prioridade;
    public static volatile SingularAttribute<Tarefa, String> titulo;
    public static volatile SingularAttribute<Tarefa, Date> entrega;
    public static volatile SingularAttribute<Tarefa, Integer> id;
    public static volatile SingularAttribute<Tarefa, String> desc;

}