-- Criando as tabelas
CREATE TABLE VEM_SER.PAIS (
    id_pais NUMBER(38, 0) NOT NULL,
    nome VARCHAR2(50) NOT NULL,
    PRIMARY KEY (id_pais)
);

CREATE TABLE VEM_SER.ESTADO (
    id_estado NUMBER(38, 0) NOT NULL,
    id_pais NUMBER(38, 0) NOT NULL,
    nome VARCHAR2(50) UNIQUE NOT NULL,
    PRIMARY KEY (id_estado),
    CONSTRAINT FK_ESTADO_PAIS FOREIGN KEY (id_pais) REFERENCES VEM_SER.PAIS(id_pais)
);

CREATE TABLE VEM_SER.CIDADE (
    id_cidade NUMBER(38, 0) NOT NULL,
    id_estado NUMBER(38, 0) NOT NULL,
    id_pais NUMBER(38, 0) NOT NULL,
    nome VARCHAR2(50) UNIQUE NOT NULL,
    PRIMARY KEY (id_cidade, id_estado),
    CONSTRAINT FK_CIDADE_ESTADO FOREIGN KEY (id_estado) REFERENCES ESTADO(id_estado),
    CONSTRAINT FK_CIDADE_PAIS FOREIGN KEY (id_pais) REFERENCES PAIS(id_pais)
);

CREATE TABLE VEM_SER.BAIRRO (
    id_bairro NUMBER(38, 0) NOT NULL,
    id_cidade NUMBER(38, 0) NOT NULL,
    id_estado NUMBER(38, 0) NOT NULL,
    nome VARCHAR2(50) UNIQUE NOT NULL,
    PRIMARY KEY (id_bairro, id_cidade),
    CONSTRAINT FK_BAIRRO_CIDADE FOREIGN KEY (id_cidade, id_estado) REFERENCES CIDADE(id_cidade, id_estado)
);

CREATE TABLE VEM_SER.ENDERECO (
    id_endereco NUMBER(38, 0) NOT NULL,
    id_bairro NUMBER(38, 0) NOT NULL,
    id_cidade NUMBER(38, 0) NOT NULL,
    logradouro VARCHAR2(255) NOT NULL,
    numero NUMBER(38, 0) NOT NULL,
    complemento VARCHAR2(100),
    cep CHAR(9),
    PRIMARY KEY (id_endereco),
    CONSTRAINT FK_ENDERECO_BAIRRO FOREIGN KEY (id_bairro, id_cidade) REFERENCES BAIRRO(id_bairro, id_cidade) -- Chave estrangeira composta
);

-- Criando sequences
CREATE SEQUENCE SEQ_PAIS
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

CREATE SEQUENCE SEQ_ESTADO
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

CREATE SEQUENCE SEQ_CIDADE
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

CREATE SEQUENCE SEQ_BAIRRO
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

CREATE SEQUENCE SEQ_ENDERECO
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

-- Inserindo 2 países
INSERT INTO VEM_SER.PAIS (id_pais, nome) VALUES(SEQ_PAIS.nextval, 'Brasil');

INSERT INTO VEM_SER.PAIS (id_pais, nome) VALUES(SEQ_PAIS.nextval, 'Estados Unidos')

-- Inserindo 2 estados
INSERT INTO VEM_SER.ESTADO (id_estado, id_pais, nome) VALUES(SEQ_ESTADO.nextval, 1, 'Paraíba');

INSERT INTO VEM_SER.ESTADO (id_estado, id_pais, nome) VALUES(SEQ_ESTADO.nextval, 2, 'Florida');

-- Inserindo 2 cidades
INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, id_pais, nome) VALUES(SEQ_CIDADE.nextval, 1, 1, 'Campina Grande');

INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, id_pais, nome) VALUES(SEQ_CIDADE.nextval, 2, 2, 'Orlando');

-- Inserindo 2 bairros
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES(SEQ_BAIRRO.nextval, 1, 1, 'Alto Branco');

INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES(SEQ_BAIRRO.nextval, 2, 2, 'Windermere');

-- Inserindo 2 endereços
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES(SEQ_ENDERECO.nextval, 1, 1, 'Rua Presidente Roosevelt', 130, 'Casa de Esquina', '58401-696');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES(SEQ_ENDERECO.nextval, 2, 2, 'Forest Avenue', 234, 'White house', '98765-432');


