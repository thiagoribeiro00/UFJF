import os
from langchain_community.llms import Ollama

# Configuração do Modelo (Llama 3 é excelente para código)
llm = Ollama(model="llama3")

def generate_tests(source_code_path):
    with open(source_code_path, 'r') as f:
        code = f.read()

    prompt = f"""
    Como um especialista em QA e Python, gere testes unitários usando Pytest para o código abaixo.
    Certifique-se de:
    1. Cobrir casos de sucesso e falha.
    2. Usar mocks se necessário.
    3. Retornar APENAS o código Python do teste, sem explicações.

    Código:
    {code}
    """

    print(f"🤖 Gerando testes para {source_code_path}...")
    response = llm.invoke(prompt)
    
    # Salva o teste gerado
    test_file_path = f"tests/test_{os.path.basename(source_code_path)}"
    os.makedirs("tests", exist_ok=True)
    
    with open(test_file_path, 'w') as f:
        f.write(response)
    
    print(f"✅ Testes salvos em: {test_file_path}")

# Exemplo de uso
if __name__ == "__main__":
    # Vamos criar um arquivo de exemplo para testar o gerador
    generate_tests("src/processador_financeiro.py")