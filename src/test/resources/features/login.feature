# language: pt

@login
Funcionalidade: Login
  Eu como usuário do sistema
  Quero fazer login
  Para fazer uma compra no site

  Contexto: Acessar tela de login
  Dado que estou na tela de login

  @login-sucesso
  Cenário: Login com sucesso
    Quando preencho login "robsonaguiar6883@gmail.com" e senha "123456"
    E clico em Login
    Então vejo mensagem de login com sucesso

  @login-invalido
  Esquema do Cenário: Validar: <Name>
    Quando preencho login "<User>" e senha "<Password>"
    E clico em Login
    Então vejo mensagem "<Message>" de campo nao preenchido

    Exemplos:
      | User              | Password | Message          | Name           |
      | robson.           | 123456   | E-mail inválido. | email invalido |
      |                   | 123456   | E-mail inválido. | email vazio    |
      | robson@aguiar.com | 00       | Senha inválida.  | senha invalida |
      | robson@aguiar.com |          | Senha inválida.  | senha vazia    |