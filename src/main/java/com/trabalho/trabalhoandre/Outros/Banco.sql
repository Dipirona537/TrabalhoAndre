create schema public

create table Tarefa(
	id serial primary key,
	titulo varchar(50),
	descricao varchar(200),
	entrega date,
	prioridade int,
	concluida bool
)

create table Pessoa(
	id serial primary key,
	nome varchar(50),
	email varchar(50),
	senha varchar(50),
	permissao int,
	fk_tarefa int,
	foreign key (fk_tarefa) references Tarefa(id)
)

CREATE OR REPLACE FUNCTION fn_filtrar_tarefas(
    responsavelp VARCHAR DEFAULT NULL,
    dataentp DATE DEFAULT NULL,
    prioridadep INT DEFAULT null

)
RETURNS TABLE (
    nome VARCHAR,
    titulo VARCHAR,
    descricao VARCHAR,
    entrega DATE,
    prioridade INT
)
AS $$
BEGIN
    RETURN QUERY
    SELECT p.nome, t.titulo, t.descricao, t.entrega, t.prioridade
    FROM pessoa p
    JOIN tarefa t ON p.fk_tarefa = t.id
    WHERE (responsavelp like p.nome)
      AND (dataentp IS NULL OR t.entrega = dataentp)
      AND (prioridadep IS NULL OR t.prioridade = prioridadep);
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION fn_filtrar_tarefas_sem_pessoa(
    dataentp DATE DEFAULT NULL,
    prioridadep INT DEFAULT NULL
)
RETURNS TABLE (
    tarefa_titulo VARCHAR,
    tarefa_descricao VARCHAR,
    tarefa_entrega DATE,
    tarefa_prioridade INT
)
AS $$
BEGIN
    RETURN QUERY
    SELECT titulo as tarefa_titulo, descricao as tarefa_descricao, entrega as tarefa_entrega, prioridade as tarefa_prioridade
    FROM tarefa
    WHERE (dataentp IS NULL OR entrega = dataentp)
      AND (prioridadep IS NULL OR prioridade = prioridadep);
END;
$$ LANGUAGE plpgsql;
