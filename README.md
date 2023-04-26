# API Pede Ai

### Sobre o projeto

Consiste em uma API RESTFul para cadastro de pedidos de pizzas.

Restrições:

- Usuário precisa estar cadastrado para realizar os pedidos!

 #### Instruções para realizar o cadastro:

+ Acesse a url: 
localhost:8080/usuarios

{
  "login": "insira seu login",
  "senha": "insira sua senha",
  "admin": "insira true = admin ou false = user"
}

+ Após realizar o cadastro, acesse a url abaixo para realizar a autenticação:
localhost:8080/usuarios/auth

{
  "login": "insira seu login",
  "senha": "insira sua senha"
}

Será gerado um token válido por 60 minutos.

+ Status dos Pedidos são atualizados automaticamente a cada 10 segundos.

### Tecnologias utilizadas:

<table>

<tr>
<td>Java</td>
<td>Spring Boot (Web, Validation, Security, Data Jpa)</td>
<td>Jwt</td>
<td>MySQL</td>
</tr>

<tr>
<td align="center">11</td>
<td align="center">2.7.10</td>
<td align="center">0.9.1</td>
<td align="center">8.0</td>
</tr>

</table>

### Autor

> Thalys Henrique

https://www.linkedin.com/in/thalyshenrique7/
