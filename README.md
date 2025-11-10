# Home-Chef

👨‍🍳 Home Chef – Aplicativo Inteligente de Receitas
👤 Autor

Nome: Gabriel Alves
Função: Desenvolvedor Full Stack
Projeto Individual

🎯 1. Objetivo Geral

O projeto Home Chef tem como objetivo desenvolver um aplicativo mobile inteligente que auxilia o usuário a encontrar receitas com base nos ingredientes disponíveis em casa.
A aplicação busca reduzir o desperdício de alimentos e promover praticidade no dia a dia, oferecendo sugestões rápidas e personalizadas.

🎯 2. Objetivos Específicos

Criar uma interface fluida e intuitiva utilizando Flutter.

Implementar um backend em Java (Spring Boot) para lidar com lógica e integração externa.

Integrar o sistema ao Firebase Firestore e Firebase Authentication para armazenamento e controle de usuários.

Permitir buscas por receitas baseadas nos ingredientes informados.

Salvar receitas favoritas e histórico de buscas.

Permitir uso offline por meio de cache local.

Automatizar build, testes e deploy usando Jenkins (CI/CD).

📋 3. Escopo do Projeto
🔹 Funcionalidades Principais

Autenticação de Usuário

Login e registro com Firebase Authentication.

Sessões persistentes e logout seguro.

Busca Inteligente de Receitas

O backend (Spring Boot) recebe os ingredientes e consulta a API TheMealDB.

As receitas filtradas são retornadas ao app.

Visualização Detalhada

Mostra imagem, ingredientes, preparo e tempo estimado.

Favoritos e Histórico

Dados armazenados no Firebase Firestore.

Modo Offline

Cache local usando Hive.

Filtros Avançados

Tempo, tipo de refeição e dificuldade.

⚙️ 4. Tecnologias Utilizadas
Camada	Tecnologia	Função
Frontend	Flutter	Interface mobile
Backend	Java + Spring Boot	API REST
Banco de Dados	Firebase Firestore	Armazenamento de dados
Autenticação	Firebase Auth (JWT)	Controle de acesso
API Externa	TheMealDB	Fonte de receitas
Cache Local	Hive	Acesso offline
CI/CD	Jenkins	Build, teste e deploy
Testes	JUnit + Mockito / Flutter Test	Validação automatizada
🧠 5. Arquitetura e Engenharia de Software

Backend: arquitetura MVC (Controller / Service / Repository).

Frontend: arquitetura MVVM (com Riverpod).

Comunicação: REST API (JSON).

Banco: Firebase Firestore com coleções (“users”, “favorites”, “history”).

Versionamento: Git + GitHub com Pull Requests e branches.

Gerenciamento de dependências: Maven (Java) e pubspec.yaml (Flutter).

🧪 6. Testes Automatizados

Backend

Testes unitários (serviços e integração com TheMealDB).

Teste de autenticação via Firebase SDK.

Testes de endpoint /recipes/search.

Frontend

Testes unitários de lógica (cache e filtros).

Testes de widget (navegação e renderização).

CI/CD

Jenkins roda testes antes do build.

Apenas builds bem-sucedidos são implantados.

🔄 7. Pipeline CI/CD (Jenkins)

Build Backend: compila via Maven e executa testes JUnit.

Build Frontend: executa flutter test e gera APK.

Deploy: backend (Render/Heroku) e app (Firebase App Distribution).

Relatórios: Jenkins notifica status de builds e testes.

🧩 8. Requisitos
Requisitos Funcionais

RF01: O usuário deve se autenticar via Firebase.

RF02: O sistema deve buscar receitas conforme ingredientes.

RF03: O usuário pode favoritar receitas.

RF04: O sistema deve salvar histórico de buscas.

RF05: O app deve funcionar offline.

Requisitos Não Funcionais

RNF01: Interface responsiva e intuitiva.

RNF02: Backend deve responder em até 2 segundos.

RNF03: Banco e autenticação devem usar Firebase.

RNF04: Deve ter pipeline CI/CD no Jenkins.

RNF05: Seguir boas práticas de Engenharia de Software.

🧾 9. Conclusão

O Home Chef combina tecnologias modernas — Flutter, Spring Boot e Firebase — em uma aplicação prática, escalável e automatizada com Jenkins.
O projeto demonstra domínio em desenvolvimento mobile e backend, versionamento, testes e automação, cumprindo integralmente as exigências de Engenharia de Software.
