#!/bin/bash
echo "--- Iniciando Avaliação do Capítulo 5 ---"

# 0. Ativa o ambiente virtual se existir
if [ -d "venv" ]; then
    source venv/bin/activate
fi

# 1. Instala o pacote localmente
pip install -e .

# 2. Roda Cobertura (Slide 7)
echo "📊 Gerando Relatório de Cobertura..."
pytest --cov=src tests/

# 3. Roda Mutação (Slide 8)
echo "👾 Gerando Teste de Mutação..."
mutmut run
mutmut results

echo "✅ Avaliação concluída!"