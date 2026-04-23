# EcoSense: IA vs EvoSuite - Software Testing Project

Este projeto faz parte da disciplina de Teste de Software (IA) na UFJF. O objetivo é comparar a eficácia de testes gerados por Inteligência Artificial (LLM) e por ferramentas automatizadas de busca (EvoSuite), utilizando métricas de Cobertura de Código e Mutação (PITest).

## 🚀 Estrutura do Projeto

O projeto segue os princípios de **Clean Code**, priorizando clareza, nomes significativos e separação de responsabilidades.

```
PROJETO/
├── src/main/java/      <-- Código base (CalculadoraAmbiental.java)
├── evosuite/           <-- Testes gerados/simulados no estilo EvoSuite
├── llm/                <-- Testes gerados por IA (Antigravity/Gemini)
├── pom.xml             <-- Configuração Maven (JUnit 5 + PITest)
└── README.md           <-- Documentação e Resultados
```

## 📊 Análise Comparativa (Resultados do PITest)

Abaixo, apresentamos a comparação detalhada entre as duas abordagens de teste para a classe `CalculadoraAmbiental`.

### Tabela de Métricas

| Ferramenta | Line Coverage | Mutation Coverage | Test Strength |
| :--- | :--- | :--- | :--- |
| **LLM (IA)** | 63% (22/35) | 51% (19/37) | 86% |
| **EvoSuite** | 100% (35/35) | 89% (33/37) | 89% |

### Conclusões da Análise

1.  **EvoSuite (Cobertura Estrutural):** A ferramenta automatizada foi superior na cobertura de linhas (100%), alcançando todos os ramos condicionais da `CalculadoraAmbiental`. No entanto, os testes gerados são estruturais e menos legíveis para humanos.
2.  **LLM (IA - Legibilidade e Semântica):** Os testes gerados por IA, embora tenham tido uma cobertura menor nesta versão inicial, são muito mais fáceis de entender e seguem cenários de negócio reais. A IA teve boa "Test Strength" (86%), indicando que os testes que ela criou são eficazes em matar mutantes naquelas linhas específicas.
3.  **Veredito:** Para projetos de alta complexidade, a combinação de ambas é o ideal: EvoSuite para garantir cobertura total e IA para validar cenários complexos e garantir a manutenibilidade dos testes.

## 🛠️ Como Executar

### Pré-requisitos
- Java 11 ou superior
- Maven 3.6+

### Rodar Testes e PITest
Para gerar o relatório de mutação, execute os seguintes comandos:

```bash
# Rodar todos os testes
mvn test

# Gerar relatório PITest (Geral)
mvn pitest:mutationCoverage
```

Os relatórios detalhados estarão disponíveis em: `target/pit-reports/index.html`.

## 📝 Autor
Desenvolvido como projeto prático para a UFJF.

---
*Clean Code, Clear Documentation, High Quality.*
