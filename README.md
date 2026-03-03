# Enterprise Management Challenge - SCTEC

Desafio técnico SCTEC para o processo seletivo no curso de API para DEVs (API Rest - JAVA back-end).

## 🎥 Demonstração (Vídeo)
[LINK DO VÍDEO PÚBLICO NO GOOGLE DRIVE](https://drive.google.com/file/d/1-3Kw33EWdKQPuYKsg85BJdut-2VknA_M/view?usp=drive_link)

## 🛠️ Tecnologias Utilizadas
* **Java 17** & **Spring Boot 4.0.3**
* **Spring Data JPA - Hibernate** (Persistência de dados)
* **H2 Database** (Banco em memória para testes rápidos)
* **Maven** (Gerenciador de dependências)

## 🚀 Como Executar o Projeto
1. Clone o repositório: `git clone https://github.com/AlissonPeter/sctec-enterprise-management-challenge.git`

2. Este projeto utiliza o **Maven Wrapper**, o que permite rodar a aplicação sem a necessidade de ter o Maven instalado globalmente na máquina.
No terminal (dentro da pasta raiz do projeto), utilize o comando correspondente ao seu sistema:

- **Windows (Prompt de Comando ou PowerShell):**
  `mvnw clean spring-boot:run`
  
- **Linux, macOS ou Git Bash:**
  `./mvnw clean spring-boot:run`
  
3. A API estará disponível em: `http://localhost:8080`

## 📑 Principais Endpoints
* `POST /enterprises` - Cadastro de novo empreendimento.
* `GET /enterprises/{id}` - Listagem do empreendimento pelo ID informado.
* `GET /enterprises/all` - Listagem de todos os empreendimentos cadastrados.
* `PUT /enterprises` - Atualização completa dos dados do empreedimento.
* `DELETE /enterprises/{id}` - Exclusão do empreedimento pelo ID (retorna 204 No Content).

## 💡 Diferenciais Implementados
* **Mapeamento de Enum:** Descrição dos segmentos no JSON para português, mas mantando a constante Enum no banco de dados.
* **Tratamento de Exceções:** Retornos HTTP semânticos (404, 400, 201).

## 🌿 Organização de Branches
Para este desafio, utilizei o fluxo de trabalho baseado em branches para garantir a organização do código:

* **`main`**: Versão estável e final do projeto (com a Tag `v1.0`).
* **`develop`**: Branch de integração onde as funcionalidades foram reunidas.
* **`feature/api-create`**: Desenvolvimento principal da API (Entidades, Controllers e Services).
* **`docs`**: Branch dedicada exclusivamente à documentação e refinamento do README.