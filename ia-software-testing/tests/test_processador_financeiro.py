import pytest
from calculadora_financeira import calcular_juros_compostos, classificar_risco

@pytest.mark.unit_tests
def test_calcula_juros_compostos_sucesso():
    assert calcular_juros_compostos(1000, 0.05, 5) == 1276.28

@pytest.mark.unit_tests
def test_calcula_juros_compostos_valor_negativo_principal():
    with pytest.raises(ValueError):
        calcular_juros_compostos(-1000, 0.05, 5)

@pytest.mark.unit_tests
def test_calcula_juros_compostos_valor_negativo_taxa():
    with pytest.raises(ValueError):
        calcular_juros_compostos(1000, -0.05, 5)

@pytest.mark.unit_tests
def test_calcula_juros_compostos_valor_negativo_tempo():
    with pytest.raises(ValueError):
        calcular_juros_compostos(1000, 0.05, -5)

@pytest.mark.unit_tests
def test_classifica_risco_sucesso_alto():
    assert classificar_risco(200) == "ALTO"

@pytest.mark.unit_tests
def test_classifica_risco_sucesso_medio():
    assert classificar_risco(550) == "MEDIO"

@pytest.mark.unit_tests
def test_classifica_risco_sucesso_baixo():
    assert classificar_risco(800) == "BAIXO"
