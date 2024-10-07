## Projeto Sistema de gerenciamento de bibliotéca  

Projeto criado com o intuito de praticar o que eu aprendi na trilha de conhecimentos SP_SpringBoot_AWS_SET_2024


## Instalação
1. Clone o Répositorio
   ```bash
   git clone https://github.com/Luciano089/SP_SpringBoot_AWS_Desafio_01.git
   
2. Dentro da conexão root Crie um Banco de dados com as seguintes configurações:
   Senha: password;
   Nome: sistemabiblioteca

#### Tecnologias Utilizadas

- Java
- Jakarta EE (JPA)
- Banco de dados MySql
- Scanner (para entrada de dados via console)
- Jakarta Persistence Query Language(JPQL)

## Funcionalidades

### Cadastro de Autores

A funcionalidade **Cadastro de Autores** permite adicionar novos autores ao sistema, Ele verifica se o autor já existe antes de cadastrar ele, garantindo que não haja duplicidade de registros. O sistema coleta informações como nome, nacionalidade, biografia e data de nascimento do autor.

1. **Entrada de Dados**: O sistema solicita ao usuário que insira informações sobre o autor, incluindo nome, nacionalidade, biografia e data de nascimento

2. **Verificação de Existência**: Antes de cadastrar, o sistema verifica se o autor já está registrado no banco de dados usando uma consulta `TypedQuery`. Se o autor já existir, uma mensagem é exibida e o cadastro não prossegue.

3. **Formatação da Data**: A data de nascimento é recebida como uma string e convertida em um objeto `Date` usando `SimpleDateFormat`.

4. **Persistência**: Após a validação, as informações do autor são armazenadas no banco de dados.

5. **Confirmação**: Após a transação, o sistema confirma ao usuário que o autor foi cadastrado com sucesso.

### Cadastro de Livros

A funcionalidade **Cadastro de Livros** permite registrar novos livros no sistema. Ele coleta informações como título, autor, gênero, ISBN, quantidade e data de publicação do livro

1. **Entrada de Dados**: O sistema solicita ao usuário que insira informações sobre o livro, incluindo título, autor, gênero, ISBN e data de publicação.

2. **Verificação de Duplicidade**: O sistema verifica se já existe um livro cadastrado com o mesmo ISBN.

3. **Persistência**: Após a coleta e verificação dos dados, as informações do livro são armazenadas no banco de dados.

4. **Confirmação**: Após a transação, o sistema confirma ao usuário que o livro foi cadastrado com sucesso.

### Cadastro de Membros

A funcionalidade **Cadastro de Membros** permite registrar novos membros no sistema, Ele coleta informações como nome, endereço, telefone, e-mail e data de associação do membro

1. **Entrada de Dados**: O sistema solicita ao usuário que insira informações sobre o membro, incluindo nome, endereço, telefone, e-mail e data de associação

2. **Formatação da Data**: A data de associação é recebida como uma string e convertida em um objeto `Date` usando `SimpleDateFormat`.

3. **Persistência**: Após a coleta e formatação dos dados, as informações do membro são armazenadas no banco de dados

4. **Confirmação**: Após a transação, o sistema confirma ao usuário que o membro foi cadastrado com sucesso

## Devolução de Livros

A funcionalidade **Devolução de Livros** permite que um membro devolva um livro emprestado, atualizando o estado do empréstimo e a quantidade disponível do livro no sistema, Ele também calcula uma multa se a devolução ocorrer após o prazo estipulado.

1. **Entrada de Dados**: O sistema solicita ao usuário que insira o nome do membro e o ISBN do livro que está sendo devolvido

2. **Verificação de Empréstimo**: O sistema busca um empréstimo ativo correspondente ao membro e ao livro especificado

3. **Cálculo de Multa**: O sistema verifica se a devolução está atrasada, calculando a quantidade de dias de atraso e aplicando uma multa, se necessário

4. **Atualização do Estado**: Após a devolução, o sistema atualiza o estado do empréstimo para "devolvido" e incrementa a quantidade do livro

5. **Confirmação**: O sistema confirma a devolução do livro


    