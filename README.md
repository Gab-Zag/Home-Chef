# Home-Chef

# 👨‍🍳 Home Chef – Aplicativo Inteligente de Receitas
### 👤 Autor

Nome: Gabriel Alves

Função: Desenvolvedor Full Stack
Projeto Individual

## 🎯 1. Objetivo Geral

O projeto Home Chef tem como objetivo desenvolver um aplicativo mobile inteligente que auxilia o usuário a encontrar receitas com base nos ingredientes disponíveis em casa.
A aplicação busca reduzir o desperdício de alimentos e promover praticidade no dia a dia, oferecendo sugestões rápidas e personalizadas.

# 🎯 2. Objetivos Específicos

Criar uma interface fluida e intuitiva utilizando Flutter.

Implementar um backend em Java (Spring Boot) para lidar com lógica e integração externa.

Integrar o sistema ao Firebase Firestore e Firebase Authentication para armazenamento e controle de usuários.

Permitir buscas por receitas baseadas nos ingredientes informados.

Salvar receitas favoritas e histórico de buscas.

Permitir uso offline por meio de cache local.

Automatizar build, testes e deploy usando Jenkins (CI/CD).

# 📋 3. Escopo do Projeto
## 🔹 Funcionalidades Principais

Busca Inteligente de Receitas

O backend (Spring Boot) recebe os ingredientes e consulta a API TheMealDB.

As receitas filtradas são retornadas ao app.

Visualização Detalhada

Mostra imagem, preparo.

# ⚙️ 4. Tecnologias Utilizadas
Camada:	Tecnologia	Função
Frontend: Flutter	Interface mobile
Backend:	Java + Spring Boot API REST
API Externa	TheMealDB	Fonte de receitas
CI/CD	Jenkins	Build, teste e deploy
Testes	JUnit + Mockito / Flutter Test	Validação automatizada

# 🧠 5. Arquitetura e Engenharia de Software

Backend: arquitetura MVC (Controller / Service / Repository).

Frontend: arquitetura MVVM (com Riverpod).

Comunicação: REST API (JSON).

Versionamento: Git + GitHub com Pull Requests e branches.

Gerenciamento de dependências: Maven (Java) e pubspec.yaml (Flutter).

# 🧪 6. Testes Automatizados

## Backend

Testes unitários (serviços e integração com TheMealDB).

Testes de endpoint /recipes/search.

## Frontend

Testes unitários de lógica (cache e filtros).

Testes de widget (navegação e renderização).

## CI/CD

Jenkins roda testes antes do build.

Apenas builds bem-sucedidos são implantados.

# 🔄 7. Pipeline CI/CD (Jenkins)

 Build Backend: compila via Maven e executa testes JUnit.

 Build Frontend: executa flutter test e gera APK.

 Relatórios: Jenkins notifica status de builds e testes.

# 🧩 8. Requisitos
### Requisitos Funcionais

RF02: O sistema deve buscar receitas conforme ingrediente.

### Requisitos Não Funcionais

RNF01: Interface responsiva e intuitiva.

RNF02: Backend deve responder em até 2 segundos.

RNF03: Banco e autenticação devem usar Firebase.

RNF04: Deve ter pipeline CI/CD no Jenkins.

RNF05: Seguir boas práticas de Engenharia de Software.

# 🧱 Estrutura inicial

## 📱 Frontend (Flutter)

``` home_chef/
 ├─ lib/
 │   ├─ main.dart
 │   ├─ core/          # Configurações globais, tema, constantes
 │   ├─ models/        # Modelos de dados (Recipe, User, etc.)
 │   ├─ services/      # Comunicação com a API e Firebas
 │   ├─ viewmodels/    # Lógica de estado (usando Riverpod)
 │   └─ views/         # Telas (Login, Home, Detalhe, Favoritos)
 ├─ pubspec.yaml
 └─ test/
     └─ unit_tests/
```
##  ☕ Backend (Spring Boot)
```
homechef-api/
 ├─ src/
 │   ├─ main/
 │   │   ├─ java/com/homechef/homechef_api/
 │   │   │   ├─ config/              # Segurança, CORS, etc.
 │   │   │   ├─ controller/          # Endpoints REST
 │   │   │   ├─ model/               # Modelos (Recipe)
 │   │   │   ├─ services/            # Lógica de negócio e integrações
 │   │   │   └─ HomeChefApiApplication.java
 │   │   └─ resources/
 │   │       └─ application.properties
 │   └─ test/java/com/homechef/homechef_api/
 │       ├─ controller/              # Testes dos controllers
 │       └─ services/                # Testes dos services
 ├─ pom.xml
 └─ Jenkinsfile

```
# 🌐 Endpoints da API

## 🍽️ 1. Listar Todas as Receitas

### GET /recipes/all

Retorna todas as receitas disponíveis na API externa.

📌 Exemplo de requisição:
```
GET http://localhost:9090/recipes/all
```

## 🔎 2. Buscar Receitas por Ingrediente

### GET /recipes/search?ingredients={ingrediente}

Retorna apenas receitas que utilizam o ingrediente informado.

📌 Exemplo de requisição: GET http://localhost:9090/recipes/search?ingredients=chicken

# 📌 Exemplo de resposta:
```
{
    "id": "52940",
    "name": "Brown Stew Chicken",
    "category": "Unknown",
    "area": null,
    "instructions": "Clique para ver detalhes",
    "image": "https://www.themealdb.com/images/media/meals/sypxpx1515365095.jpg"
  }
```

## 📘 3. Detalhes de Uma Receita

### GET /recipes/details?id={id}

Retorna todas as informações da receita, incluindo preparo completo e ingredientes.

📌 Exemplo de requisição: GET http://localhost:9090/recipes/details?id=52940

📌 Exemplo de resposta:

```
{
  "id": "52940",
  "name": "Brown Stew Chicken",
  "category": "Chicken",
  "area": "Jamaican",
  "instructions": "Squeeze lime over chicken and rub well. Drain off excess lime juice.\r\nCombine tomato, scallion, onion, garlic, pepper, thyme, pimento and soy sauce in a large bowl with the chicken pieces. Cover and marinate at least one hour.\r\nHeat oil in a dutch pot or large saucepan. Shake off the seasonings as you remove each piece of chicken from the marinade. Reserve the marinade for sauce.\r\nLightly brown the chicken a few pieces at a time in very hot oil. Place browned chicken pieces on a plate to rest while you brown the remaining pieces.\r\nDrain off excess oil and return the chicken to the pan. Pour the marinade over the chicken and add the carrots. Stir and cook over medium heat for 10 minutes.\r\nMix flour and coconut milk and add to stew, stirring constantly. Turn heat down to minimum and cook another 20 minutes or until tender.",
  "image": "https://www.themealdb.com/images/media/meals/sypxpx1515365095.jpg"
}
```
