# language: pt

@regressivo
Funcionalidade: Cadastro de novo usuário
  Como usuário da API
  Quero cadastrar um novo usuário
  Para que o registro seja salvo corretamente no sistema

  Cenário: Cadastro bem-sucedido de usuário
    Dado que eu tenha os seguintes dados de usuário:
      | campo | valor               |
      | nome  | Welder Ressutti     |
      | email | welder@ressutti.com |
      | senha | 123456              |
      | role  | ADMIN               |
    Quando eu enviar a requisição para o endpoint "/auth/register" de cadastro de usuário
    Então o status code da resposta deve ser 201

  Cenário: Cadastro de usuário sem sucesso ao passar o campo nome vazio
    Dado que eu tenha os seguintes dados de usuário:
      | campo | valor               |
      | nome  |                     |
      | email | welder@ressutti.com |
      | senha | 123456              |
      | role  | ADMIN               |
    Quando eu enviar a requisição para o endpoint "/auth/register" de cadastro de usuário
    Então o status code da resposta deve ser 400
    E o corpo de resposta de erro de nome da api deve retornar a mensagem "O nome é obrigatório!"

  Cenário: Cadastro de usuário sem sucesso ao passar o campo e-mail sem e-mail válido
    Dado que eu tenha os seguintes dados de usuário:
      | campo | valor              |
      | nome  | Welder Ressutti    |
      | email | welderressutti.com |
      | senha | 123456             |
      | role  | ADMIN              |
    Quando eu enviar a requisição para o endpoint "/auth/register" de cadastro de usuário
    Então o status code da resposta deve ser 400
    E o corpo de resposta de erro de e-mail da api deve retornar a mensagem "O e-mail do usuário não é válido!"

  Cenário: Cadastro de usuário sem sucesso ao passar o campo senha com mais de 16 caracteres
    Dado que eu tenha os seguintes dados de usuário:
      | campo | valor               |
      | nome  | Welder Ressutti     |
      | email | welder@ressutti.com |
      | senha | 12345678901234567   |
      | role  | ADMIN               |
    Quando eu enviar a requisição para o endpoint "/auth/register" de cadastro de usuário
    Então o status code da resposta deve ser 400
    E o corpo de resposta de erro de senha da api deve retornar a mensagem "A senha deve conter entre 6 e 16 caracteres!"

  Cenário: Cadastro de usuário sem sucesso ao passar o campo role vazio
    Dado que eu tenha os seguintes dados de usuário:
      | campo | valor               |
      | nome  | Welder Ressutti     |
      | email | welder@ressutti.com |
      | senha | 12345678901234567   |
      | role  |                     |
    Quando eu enviar a requisição para o endpoint "/auth/register" de cadastro de usuário
    Então o status code da resposta deve ser 400
    E o corpo de resposta de erro de role da api deve retornar a mensagem "A role é obrigatória!"