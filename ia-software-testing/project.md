1. Descrição do Projeto (E2E)
Você deve criar um código simples em Java e comparar duas formas de testá-lo: uma usando uma ferramenta automática de "força bruta" (EvoSuite) e outra usando inteligência artificial (LLM). O objetivo final é provar que você sabe medir a qualidade de testes usando métricas de cobertura e mutação.

Linguagem: Java (versão 11 ou superior).
Ferramentas: Maven, JUnit, PITest, EvoSuite.

2. O que precisa ser feito (Passo a Passo)
Passo 1: O Código Base
Crie uma classe Java com alguma lógica (ex: CalculadoraAmbiental.java). Ela deve ter condicionais (if/else) para que os testes tenham o que validar.

Onde colocar: src/main/java/com/ecosense/

Passo 2: Configurar o Maven (pom.xml)
Você precisa de um arquivo pom.xml que gerencie o JUnit e, principalmente, o PITest. O PITest é o que gera o "Relatório de Mutação" que a professora exigiu.

Passo 3: Gerar os Testes (Os dois mundos)
Mundo LLM: Peça para o Gemini ou ChatGPT: "Gere testes unitários em JUnit para esta classe [cole seu código]". Salve na pasta /llm.

Mundo EvoSuite: Baixe o jar do EvoSuite e rode o comando para gerar testes automáticos. Salve na pasta /evosuite.

Passo 4: Executar e Coletar Prints
Rode o comando do PITest no terminal. Ele vai gerar um site (HTML) dentro da pasta target/pit-reports.

Abra esse site, tire print das tabelas de Line Coverage e Mutation Score.

Faça isso para os testes da IA e depois para os do EvoSuite.

3. Organização Obrigatória das Pastas
Seu repositório no GitHub deve estar assim para ser aceito:

```
PROJETO/
├── src/main/java/      <-- Seu código original
├── evosuite/           <-- Testes gerados pelo EvoSuite
├── llm/                <-- Testes gerados pela IA
├── pom.xml             <-- Configuração do projeto
└── README.md           <-- Onde você vai colocar os links e prints
```

4. Requisitos Obrigatórios (Entregáveis)
A. O Repositório Git
Link público do GitHub com as pastas organizadas conforme acima.

B. O Relatório Técnico (PDF)
Este é o arquivo que você sobe no portal da UFJF. Ele deve conter:

Introdução: O que é o projeto.

Análise Comparativa: Um texto seu explicando: "Os testes da IA foram melhores em X, enquanto o EvoSuite foi melhor em Y".

Prints do PITest: Mostre os resultados de cobertura de ambos.

Link do Git: O endereço para a professora conferir o código.
