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
  ('Long John Silver', 'Av. Duque de Caxias, 137-1 - Centro, Duque de Caxias - RJ', -22.786874, -43.311194),
  ('Margarida Gautier', 'Av. Pastor Martin Luther King Júnior, 126 - Del Castilho, Rio de Janeiro - RJ', -22.877612, -43.271699),
  ('Daisy Buchanan', 'R. Soares Meireles, 394 - Pilares, Rio de Janeiro - RJ, 20760-692', -22.877612, -43.291819),
  ('Van Helsing', 'Shopping Nova América - Del Castilho, Rio de janeiro - RJ', -22.902944, -43.183255),
  ('Ichabod Crane', 'Av. Presidente Vargas, 137 - Rio de janeiro - RJ', -22.931522, -43.179178),
  ('Hamlet', 'Rua Conde de Bonfim 7 - Tijuca, Rio de Janeiro - RJ', -22.922076, -43.221750),
  ('Romeu', 'R. do Bpo - Rio Comprido, Rio de Janeiro - RJ', -22.924803, -43.211622),
  ('Sherlock Holmes', 'Rua Visc. de Itaúna - Jardim Botânico, Rio de Janeiro - RJ', -22.961351, -43.225045),
  ('Ebenezer Scrooge', 'Avenida Menezes Cortes - Engenho Novo, Rio de janeiro - RJ', -22.922839, -43.295695),
  ('Dom Quixote', 'Estr. do Rio Grande, 4577 - Taquara, Rio de Janeiro - RJ', -22.918642, -43.405667),
  ('Drácula ', 'Av. Etiópia 83 - Bangu, Rio de Janeiro- RJ', -22.855886, -43.490361),
  ('James Bond', 'Estr. do Guandú do Sena, 2247 - Bangu, Rio de Janeiro - RJ', -22.842242, -43.492931),
  ('Norman Bates', 'Bairro Industrial, Mesquita - RJ', -22.772271, -43.407657),
  ('Robin Hood', 'R. Sarmento, 335-221 - Centro, Mesquita - RJ', -22.785522, -43.429322),
  ('Dorothy Gale', 'R. Sarmento, 335-221 - Centro, Mesquita - RJ', -22.758518, -43.432139),
  ('Peter Pan', 'R. Athaide Pimenta de Morais, 783-665 - Centro, Nova Iguaçu - RJ', -22.754499, -43.452981),
  ('Rei Arthur', 'R. Athaide Pimenta de Morais, 783-665 - Centro, Nova Iguaçu - RJ', -22.757387, -43.457419),
  ('Dr. Frankenstein', 'R. Afrânio Peixoto, 280 - Centro, Nova Iguaçu - RJ', -22.762024, -43.458063),
  ('Siegfried', 'R. Luiz de Camões, 356-460 - Alvarez, Nova Iguaçu - RJ', -22.759092, -43.464465),
  ('Dr. Jekyll', 'R. Humberto de Campos, 469-259 - Luz, Nova Iguaçu - RJ', -22.757670, -43.465295);

INSERT INTO ESPECIALIDADE (nome) VALUES
  ('CARDIOLOGIA'),
  ('OLFTAMOLOGIA'),
  ('PEDIATRIA'),
  ('RADIOLOGIA'),
  ('ONCOLOGIA'),
  ('DERMATOLOGIA'),
  ('GASTROENTEROLOGIA'),
  ('ENDOCRINOLOGIA'),
  ('GINECOLOGIA'),
  ('MASTOLOGIA'),
  ('NEUROLOGIA'),
  ('UROLOGIA');
  
  
INSERT INTO PRESTADOR_ESPECIALIDADE(ID_PRESTADOR, ID_ESPECIALIDADE) VALUES
   (1,1),
   (2,2),
   (3,3),
   (4,4),
   (5,5),
   (6,6),
   (7,7),
   (8,8),
   (9,9),
   (10,10),
   (11,11),
   (12,12),
   (13,6),
   (14,7),
   (15,3),
   (16,12),
   (17,4),
   (18,3),
   (19,8),
   (20,7),
   (1,2),
   (1,3),
   (2,4),
   (3,8),
   (4,5),
   (5,2),
   (12,7),
   (15,4),
   (18,2),
   (20,7),
   (6,11),
   (9,10);
 
 