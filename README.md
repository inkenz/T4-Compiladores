# T3-Compiladores - Analisador Sintático da Linguagem LA

Trabalho 3 da Disciplina de Construção de Compiladores 2023/01 UFSCar

## Grupo:

  + Guilherme Calça - 790759
  + Kenzo Inanami de Faria - 790778
  + Julio Cesar dos Santos Oliveira Filho - 779800


## Compilação do Projeto

O projeto foi compilado usando a versão Java 20.0.1 e a ferramenta Maven. Para compilar em sua máquina, em alguns casos, será necessário mudar o arquivo pom.xml para aceitar outras versões. Para fazer isso, abra o arquivo pom.xml e nas linhas 58 e 59 alterar o número da versão.
```
<maven.compiler.source>20</maven.compiler.source>
<maven.compiler.target>20</maven.compiler.target>
```

Na pasta do projeto basta realizar a compilação do projeto com o comandos:

```
mvn package
```

## Execução

Para execução digite o comando:
```
java -jar  target\linguagem-la-1.0-SNAPSHOT-jar-with-dependencies.jar [arquivo de entrada] [arquivo de saída]
```
