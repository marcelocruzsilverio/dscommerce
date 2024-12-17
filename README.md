# Sistema DSCommerce

## Escola de Programação  
**Prof. Dr. Nelio Alves**  
[DevSuperior](https://devsuperior.com.br)

---

## DOCUMENTO DE REQUISITOS

### Sumário  
1. [Premissas](#1-premissas)  
2. [Visão geral do sistema](#2-visao-geral-do-sistema)  
3. [Protótipos de tela](#3-prototipos-de-tela)  
4. [Modelo conceitual](#4-modelo-conceitual)  
5. [Casos de uso (visão geral)](#5-casos-de-uso-visao-geral)  
6. [Casos de uso (detalhamento)](#6-casos-de-uso-detalhamento)

---

## 1. Premissas  

O sistema DSCommerce foi desenvolvido para uso didático nos cursos da DevSuperior com base nas seguintes premissas:  
- Modelo de domínio simples, porém abrangente, explorando relacionamentos entre entidades.  
- Aplicação de conhecimentos fundamentais da programação.  
- Contém funcionalidades essenciais para construção de sistemas, como telas de cadastro e casos de uso práticos.

---

## 2. Visão geral do sistema  

O sistema DSCommerce possui as seguintes funcionalidades:  
- **Cadastro de usuários**: Nome, email, telefone, data de nascimento e senha.  
- **Produtos e categorias**: Nome, descrição, preço e imagem.  
- **Catálogo de produtos**: Com filtro por nome, apresentação paginada e detalhamento de produto.  
- **Carrinho de compras**: Inclusão, remoção e alteração de quantidades de produtos.  
- **Pedidos**: Registro do pedido com status ("aguardando pagamento", "pago", "enviado", "entregue" e "cancelado").  
- **Perfis de usuário**:  
  - **Cliente**: Acesso ao catálogo, gerenciamento de carrinho, registro de pedidos e histórico pessoal.  
  - **Administrador**: CRUD de produtos, categorias e usuários, além de relatórios de pedidos.  

---

## 3. Protótipos de tela  

Os protótipos de tela podem ser acessados no link:  
[Protótipos Figma - DSCommerce](https://www.figma.com/file/ZrGNVNG0kZL6txDv4G8P6s/DSCommerce)

---

## 4. Modelo conceitual  

### Considerações:  
- Cada **OrderItem** corresponde a um produto no pedido, incluindo quantidade e preço armazenado para histórico.  
- Um **Usuário** pode ter um ou mais **Roles** (Client, Admin).
![Captura de tela de 2024-12-17 00-21-32](https://github.com/user-attachments/assets/5acb84ea-0176-4ed5-ad89-f43c76c768dc)

---

## 5. Casos de uso (visão geral)  

| **Caso de Uso**          | **Visão Geral**                                                                         | **Acesso**         |
|--------------------------|----------------------------------------------------------------------------------------|--------------------|
| **Manter produtos**      | CRUD de produtos, com filtro por nome.                                                 | Somente Admin      |
| **Manter categorias**    | CRUD de categorias, com filtro por nome.                                               | Somente Admin      |
| **Manter usuários**      | CRUD de usuários, com filtro por nome.                                                 | Somente Admin      |
| **Gerenciar carrinho**   | Incluir, remover e alterar quantidade de itens no carrinho.                            | Público            |
| **Consultar catálogo**   | Listar produtos com filtro por nome.                                                   | Público            |
| **Sign up**              | Cadastro de novos usuários.                                                            | Público            |
| **Login**                | Login no sistema.                                                                      | Público            |
| **Registrar pedido**     | Salvar o pedido a partir do carrinho de compras.                                       | Usuário logado     |
| **Atualizar perfil**     | Atualizar dados pessoais.                                                              | Usuário logado     |
| **Visualizar pedidos**   | Listar histórico de pedidos do usuário.                                                | Usuário logado     |
| **Registrar pagamento**  | Salvar os dados do pagamento de um pedido.                                             | Somente Admin      |
| **Reportar pedidos**     | Relatório de pedidos com filtro por data.                                              | Somente Admin      |

---

## 6. Casos de uso (detalhamento)  

### Consultar catálogo  
**Atores**: Usuário anônimo, Cliente, Admin  
**Visão geral**: Listar produtos disponíveis com filtro por nome.  
- **Cenário principal**:  
  1. O sistema apresenta uma listagem paginada de produtos (nome, imagem, preço).  
  2. O usuário pode informar parte do nome do produto para filtrar a listagem.  
- **Informações complementares**:  
  - Página padrão com 12 registros.  

![Captura de tela de 2024-12-17 00-20-03](https://github.com/user-attachments/assets/0d20c03a-d110-4d01-be2f-e9e5f526ce8e)

---

### Manter produtos  
**Atores**: Admin  
**Visão geral**: CRUD de produtos.  
- **Cenário principal**:  
  1. O admin consulta o catálogo de produtos.  
  2. Realiza as operações de inserir, atualizar ou deletar produtos.  

**Cenários alternativos**:  
- **Inserção**: Validação de dados (nome, preço, descrição, categorias).  
- **Atualização/Deleção**: Tratamento de ID não encontrado e integridade referencial.  

---

### Login  
**Atores**: Usuário anônimo  
**Visão geral**: Efetuar login no sistema.  
- **Cenário principal**:  
  1. O usuário informa credenciais.  
  2. O sistema retorna um token válido.  
- **Exceção**: Credenciais inválidas.

---

### Gerenciar carrinho  
**Atores**: Usuário anônimo  
**Visão geral**: Manipular itens do carrinho de compras.  
- **Cenário principal**:  
  1. O usuário seleciona um produto no catálogo.  
  2. Adiciona/remover produtos e ajusta as quantidades.  

---

### Registrar pedido  
**Atores**: Cliente  
**Precondições**: Carrinho de compras não vazio e usuário logado.  
**Visão geral**: Registrar o pedido a partir do carrinho.  
- **Cenário principal**:  
  1. O cliente confirma os itens do carrinho.  
  2. O sistema salva o pedido com um ID.  

---

## Atores  

- **Usuário anônimo**: Pode acessar o catálogo, carrinho, login e sign up.  
- **Cliente**: Pode atualizar seu perfil, gerenciar pedidos e histórico.  
- **Admin**: Possui acesso à área administrativa para CRUD de dados e relatórios.  

---

## Observações Finais  

O sistema DSCommerce foi desenvolvido para fins de aprendizado, com funcionalidades práticas e essenciais para aplicações de e-commerce modernas.
