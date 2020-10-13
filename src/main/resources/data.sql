DROP TABLE IF EXISTS PRESTADOR_ESPECIALIDADE;
DROP TABLE IF EXISTS PRESTADOR_SAUDE;
DROP TABLE IF EXISTS ESPECIALIDADE;
 
CREATE TABLE PRESTADOR_SAUDE (
  ID INT AUTO_INCREMENT  PRIMARY KEY,
  nome VARCHAR(250) NOT NULL,
  endereco VARCHAR(250) NOT NULL,
  latitude NUMBER DEFAULT NULL,
  longitude NUMBER DEFAULT NULL
);

CREATE TABLE ESPECIALIDADE(
  ID INT AUTO_INCREMENT  PRIMARY KEY,
  nome VARCHAR(250) NOT NULL
);

CREATE TABLE PRESTADOR_ESPECIALIDADE(
ID INT AUTO_INCREMENT  PRIMARY KEY,
ID_PRESTADOR INT,
ID_ESPECIALIDADE INT,
FOREIGN KEY (ID_PRESTADOR) REFERENCES PRESTADOR_SAUDE(ID),
FOREIGN KEY (ID_ESPECIALIDADE) REFERENCES ESPECIALIDADE(ID)
);


   
INSERT INTO PRESTADOR_SAUDE (nome, endereco, latitude, longitude) VALUES
  ('Joao Luis', 'Av. Duque de Caxias, 137-1 - Centro, Duque de Caxias - RJ', -22.786874, -43.311194);

INSERT INTO ESPECIALIDADE (nome) VALUES
  ('cardiologia'),
  ('olftamologia');
  
INSERT INTO PRESTADOR_ESPECIALIDADE(ID_PRESTADOR, ID_ESPECIALIDADE) VALUES
   (1,2);
 