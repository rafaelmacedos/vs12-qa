-- Criando tabela
CREATE TABLE VEM_SER.PESSOA (
    id_pessoa NUMBER NOT NULL,
    nome VARCHAR2(255) NOT NULL,
    data_nascimento DATE NOT NULL,
    telefone VARCHAR(14), -- +5551995249346
    idade NUMBER(3) NOT NULL,
    altura DECIMAL(2,1) NOT NULL,
    cpf CHAR(11) UNIQUE NOT NULL,
    PRIMARY KEY(id_pessoa)
);

-- Inserindo linhas na tabela
INSERT INTO PESSOA (id_pessoa, nome, data_nascimento, telefone, idade, altura, cpf) 
VALUES (1, 'Rafael', TO_DATE('07-07-2002', 'dd-mm-yyyy'),'83999999999', 21, 1.68, '12345678999');

INSERT INTO VEM_SER.PESSOA (id_pessoa, nome, data_nascimento, telefone, idade, altura, cpf) 
VALUES (2,'Jonny', TO_DATE('10-10-1999', 'dd-mm-yyyy'), '85999999999', 30, 1.91, '08945678999');

INSERT INTO VEM_SER.PESSOA (id_pessoa, nome, data_nascimento, telefone, idade, altura, cpf) 
VALUES (3,'Moises', TO_DATE('01-10-2001', 'dd-mm-yyyy'), '11999999999', 22, 1.75, '08945231499');

INSERT INTO VEM_SER.PESSOA (id_pessoa, nome, data_nascimento, telefone, idade, altura, cpf) 
VALUES (4,'Klopp', TO_DATE('10-10-1980', 'dd-mm-yyyy'), '21999999999', 43, 1.85, '08945678423');

-- Selecionando registros
SELECT * FROM VEM_SER.PESSOA;

-- Atualizando registros para aumentar um ano na idade de todos
UPDATE VEM_SER.PESSOA
SET idade = idade + 1;

-- Selecionando registros
SELECT * FROM VEM_SER.PESSOA;

-- Deletando registro com id = 1
DELETE FROM VEM_SER.PESSOA WHERE id_pessoa = 1;

-- Selecionando registros
SELECT * FROM VEM_SER.PESSOA;