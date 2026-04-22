# Projeto de Geração Automática de Testes - IA na Engenharia de Software

Este projeto demonstra a aplicação de Inteligência Artificial para a geração de oráculos de teste e avaliação de eficiência (cobertura e mutação), conforme os conceitos do Capítulo 5.

## Descrição da Técnica
Utilizamos **LLMs (Large Language Models)** via **Ollama (Llama 3)** para a geração automatizada de testes unitários. A IA analisou o código-fonte em `src/` e gerou casos de teste em `tests/` buscando cobrir diferentes caminhos de execução.

## Estrutura do Projeto
- `src/calculadora_financeira.py`: Código-fonte sob teste.
- `tests/test_processador_financeiro.py`: Testes unitários gerados pela LLM.
- `generator.py`: Script para chamada do modelo Llama 3.
- `pyproject.toml`: Configuração do pacote e dependências.
- `evaluator.sh`: Script de execução automatizada da avaliação.

## Resultados de Eficiência
Baseado nas métricas dos Slides 7 e 8:

- **Cobertura de Código**: Atingiu **100% de Statement Coverage**.
- **Teste de Mutação**: Mutation Score de **19/32** (19 mutantes mortos).

## Análise Crítica
A LLM foi altamente eficaz em cobrir todos os caminhos de execução (100% de cobertura). No entanto, a análise de mutação revelou que os testes gerados ainda podem ser aprimorados para capturar falhas mais sutis em operadores lógicos, uma vez que 13 mutantes sobreviveram.

## Como Executar
Dê permissão ao script de avaliação e execute-o:
```bash
chmod +x evaluator.sh
./evaluator.sh
```