# language: pt

@regressivo
Funcionalidade: Validar o contrato ao realizar um cadastro bem-sucedido de usuário
  Como usuário da API
  Quero cadastrar um novo usuário bem-sucedido
  Para que eu consiga validar se o contrato esta conforme o esperado

  Cenário: Validar contrato do cadastro bem-sucedido de usuário
    Dado que eu tenha os seguintes dados de usuário:
      | campo | valor             |
      | nome  | Contrato Json     |
      | email | contrato@json.com |
      | senha | 123456            |
      | role  | USER              |
    Quando eu enviar a requisição para o endpoint "/auth/register" de cadastro de usuário
    Então o status code da resposta deve ser 201
    E que o arquivo de contrato esperado é o "Cadastro bem-sucedido de usuário"
    Então a resposta da requisição deve estar em conformidade com o contrato selecionado