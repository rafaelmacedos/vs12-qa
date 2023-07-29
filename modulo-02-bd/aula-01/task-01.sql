-- Criando tabela
CREATE TABLE VEM_SER.ESTUDANTE (
    id_estudante NUMBER,
    nome VARCHAR2(200) NOT NULL,
    data_nascimento DATE NOT NULL,
    nr_matricula NUMBER(10) UNIQUE,
 	ativo CHAR(1) CHECK (ativo IN ('S', 'N')),
 	PRIMARY KEY(id_estudante)
);

-- Criando sequence
CREATE SEQUENCE SEQ_ESTUDANTE
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

DROP SEQUENCE VEM_SER.SEQ_ESTUDANTE

-- Inserindo linhas na tabela
INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Jeffinho', TO_DATE('01-01-2000', 'dd-mm-yyyy'), 2203009001, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Marcos', TO_DATE('11-03-1992', 'dd-mm-yyyy'), 2203009002, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Cleiton', TO_DATE('24-10-2003', 'dd-mm-yyyy'), 2203009003, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Cristiano', TO_DATE('02-02-1998', 'dd-mm-yyyy'), 2203009004, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Ronaldo', TO_DATE('8-03-2004', 'dd-mm-yyyy'), 2203009005, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Marcelo', TO_DATE('19-12-2003', 'dd-mm-yyyy'), 2203009006, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Roberto', TO_DATE('15-06-1987', 'dd-mm-yyyy'), 2203009007, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Osvaldo', TO_DATE('30-01-2002', 'dd-mm-yyyy'), 2203009008, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Pedro', TO_DATE('20-09-2005', 'dd-mm-yyyy'), 2203009009, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Lucas', TO_DATE('07-10-1998', 'dd-mm-yyyy'), 2203009010, 'S');

-- Selecionando registros
SELECT * FROM VEM_SER.ESTUDANTE

