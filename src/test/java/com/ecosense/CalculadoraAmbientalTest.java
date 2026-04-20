package com.ecosense;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Teste base manual - Serve como ponto de partida
 * Os testes do EvoSuite e LLM serao comparados com este
 */
class CalculadoraAmbientalTest {
    
    private final CalculadoraAmbiental calc = new CalculadoraAmbiental();
    
    @Test
    @DisplayName("Deve calcular media corretamente")
    void deveCalcularMedia() {
        double[] valores = {10.0, 20.0, 30.0};
        assertEquals(20.0, calc.calcularMedia(valores), 0.001);
    }
    
    @Test
    @DisplayName("Deve converter Celsius para Fahrenheit")
    void deveConverterCelsiusParaFahrenheit() {
        assertEquals(32.0, calc.celsiusParaFahrenheit(0.0), 0.001);
        assertEquals(212.0, calc.celsiusParaFahrenheit(100.0), 0.001);
    }
}
