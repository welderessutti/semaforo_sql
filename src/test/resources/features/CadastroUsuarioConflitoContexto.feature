# language: pt

@regressivo
Funcionalidade: Impedimento de cadastro de usuário com e-mail duplicado
  Como usuário da API
  Devo ser impedido de cadastrar um usuário com e-mail duplicado, já existente

  Contexto: Cadastro bem-sucedido de usuário
    Dado que eu tenha os seguintes dados de usuário:
      | campo | valor               |
      | nome  | Usuário Duplicado   |
      | email | email@duplicado.com |
      | senha | 123456              |
      | role  | USER                |
    Quando eu enviar a requisição para o endpoint "/auth/register" de cadastro de usuário
    Então o status code da resposta deve ser 201

  Cenário: Devo ser impedido de cadastrar um usuário com e-mail duplicado já existente
    Dado que eu possua os dados de usuário iguais ao criado no contexto
    Quando eu enviar a requisição para o endpoint "/auth/register" de cadastro de usuário
    Então o status code da resposta deve ser 409
    E o corpo de resposta de erro de conflito da api deve retornar a mensagem "Usuário já cadastrado!"