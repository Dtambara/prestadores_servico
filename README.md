# Prestadores_servico

Aplicação que retorna prestadores de saúde por especialidade ordenados por distância.

### Iniciando a aplicação
Na pasta raiz do projeto execute os seguintes comandos:
```sh
mvn clean install
```
```sh
java -jar target\saude-0.0.1-SNAPSHOT.jar
```

A aplicaçao irá inicar na porta 8080.
Os parâmetros esperados são:
- Latitude : double
- Longitude : double
- Epecialidade : String

### Exemplo de request
```
http://localhost:8080/prestador?latitude=-22.807286&longitude=-43.354022&especialidade=olftamologia
```
### Banco de dados
A aplicação usa o H2, um banco de dados em memória. Ao iniciar a aplicação o banco de dados é sempre populado. O script se encontra em src/main/resources/data.sql

### <span style="color: red;">Importante</span>
A aplicação faz consulta a api de distancias do Google, é importante que na propriedade distance.matrix.key em src/main/application.properties seja colocada uma key para consulta a api ou a aplicação não irá funcionar.
