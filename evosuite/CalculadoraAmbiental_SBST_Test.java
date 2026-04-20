package com.ecosense;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes gerados com estrategia SBST (Search-Based Software Testing)
 * Simula a abordagem do EvoSuite: busca por cobertura maxima de ramos
 * 
 * ESTRATEGIA:
 * - Cobertura de ramos (branch coverage): cada if/else testado
 * - Valores de borda: limites exatos das condicoes
 * - Particionamento de equivalencia: valores tipicos e extremos
 */
class CalculadoraAmbiental_SBST_Test {
    
    private final CalculadoraAmbiental calc = new CalculadoraAmbiental();
    
    // ============================================
    // TESTES PARA calcularMedia (cobertura de ramos)
    // ============================================
    
    @Test
    @DisplayName("SBST: Media com valores tipicos")
    void testMedia_ValoresTipicos() {
        double[] valores = {10.0, 20.0, 30.0};
        assertEquals(20.0, calc.calcularMedia(valores), 0.001);
    }
    
    @Test
    @DisplayName("SBST: Media com valores negativos")
    void testMedia_ValoresNegativos() {
        double[] valores = {-10.0, -20.0, -30.0};
        assertEquals(-20.0, calc.calcularMedia(valores), 0.001);
    }
    
    @Test
    @DisplayName("SBST: Media com um elemento (borda)")
    void testMedia_UmElemento() {
        double[] valores = {42.0};
        assertEquals(42.0, calc.calcularMedia(valores), 0.001);
    }
    
    @Test
    @DisplayName("SBST: Media com array nulo (excecao)")
    void testMedia_ArrayNulo() {
        assertThrows(IllegalArgumentException.class, () -> calc.calcularMedia(null));
    }
    
    @Test
    @DisplayName("SBST: Media com array vazio (excecao)")
    void testMedia_ArrayVazio() {
        assertThrows(IllegalArgumentException.class, () -> calc.calcularMedia(new double[]{}));
    }
    
    // ============================================
    // TESTES PARA classificarQualidadeAr (todos os ramos)
    // ============================================
    
    @Test
    @DisplayName("SBST: Qualidade do ar - INVALIDO (borda negativa)")
    void testQualidadeAr_Invalido() {
        assertEquals("INDICE INVALIDO", calc.classificarQualidadeAr(-1.0));
    }
    
    @Test
    @DisplayName("SBST: Qualidade do ar - BOA (limite superior)")
    void testQualidadeAr_Boa_Limite() {
        assertEquals("BOA", calc.classificarQualidadeAr(50.0));
    }
    
    @Test
    @DisplayName("SBST: Qualidade do ar - MODERADA (limite inferior)")
    void testQualidadeAr_Moderada_LimiteInf() {
        assertEquals("MODERADA", calc.classificarQualidadeAr(51.0));
    }
    
    @Test
    @DisplayName("SBST: Qualidade do ar - MODERADA (limite superior)")
    void testQualidadeAr_Moderada_LimiteSup() {
        assertEquals("MODERADA", calc.classificarQualidadeAr(100.0));
    }
    
    @Test
    @DisplayName("SBST: Qualidade do ar - NAO SAUDAVEL GRUPOS SENSIVEIS")
    void testQualidadeAr_NaoSaudavelGrupos() {
        assertEquals("NAO SAUDAVEL PARA GRUPOS SENSIVEIS", calc.classificarQualidadeAr(125.0));
    }
    
    @Test
    @DisplayName("SBST: Qualidade do ar - NAO SAUDAVEL")
    void testQualidadeAr_NaoSaudavel() {
        assertEquals("NAO SAUDAVEL", calc.classificarQualidadeAr(175.0));
    }
    
    @Test
    @DisplayName("SBST: Qualidade do ar - MUITO NAO SAUDAVEL")
    void testQualidadeAr_MuitoNaoSaudavel() {
        assertEquals("MUITO NAO SAUDAVEL", calc.classificarQualidadeAr(250.0));
    }
    
    @Test
    @DisplayName("SBST: Qualidade do ar - PERIGOSA (borda alta)")
    void testQualidadeAr_Perigosa() {
        assertEquals("PERIGOSA", calc.classificarQualidadeAr(301.0));
    }
    
    // ============================================
    // TESTES PARA calcularIndiceSustentabilidade (multiplos caminhos)
    // ============================================
    
    @Test
    @DisplayName("SBST: Indice sustentabilidade - valores tipicos")
    void testIndice_Tipico() {
        double resultado = calc.calcularIndiceSustentabilidade(50.0, 50.0, 100.0);
        // (50*0.4) + (50*0.3) - (100*0.01) = 20 + 15 - 1 = 34
        assertEquals(34.0, resultado, 0.001);
    }
    
    @Test
    @DisplayName("SBST: Indice sustentabilidade - valor negativo (excecao)")
    void testIndice_Negativo() {
        assertThrows(IllegalArgumentException.class, 
            () -> calc.calcularIndiceSustentabilidade(-1.0, 50.0, 100.0));
    }
    
    @Test
    @DisplayName("SBST: Indice sustentabilidade - porcentagem > 100 (excecao)")
    void testIndice_PorcentagemAlta() {
        assertThrows(IllegalArgumentException.class, 
            () -> calc.calcularIndiceSustentabilidade(101.0, 50.0, 100.0));
    }
    
    @Test
    @DisplayName("SBST: Indice sustentabilidade - resultado limitado a 0")
    void testIndice_LimiteZero() {
        double resultado = calc.calcularIndiceSustentabilidade(0.0, 0.0, 10000.0);
        assertEquals(0.0, resultado, 0.001);
    }
    
    @Test
    @DisplayName("SBST: Indice sustentabilidade - resultado limitado a 100")
    void testIndice_LimiteCem() {
        double resultado = calc.calcularIndiceSustentabilidade(100.0, 100.0, 0.0);
        assertEquals(100.0, resultado, 0.001);
    }
    
    // ============================================
    // TESTES PARA calcularConsumoAgua (switch + excecoes)
    // ============================================
    
    @Test
    @DisplayName("SBST: Consumo agua - ULTRASSONICO")
    void testConsumo_Ultrassonico() {
        double resultado = calc.calcularConsumoAgua("ULTRASSONICO", 100.0, 10);
        assertEquals(1.0, resultado, 0.001); // (100*1.0*10)/1000
    }
    
    @Test
    @DisplayName("SBST: Consumo agua - ELETROMAGNETICO")
    void testConsumo_Eletromagnetico() {
        double resultado = calc.calcularConsumoAgua("ELETROMAGNETICO", 100.0, 10);
        assertEquals(0.95, resultado, 0.001); // (100*0.95*10)/1000
    }
    
    @Test
    @DisplayName("SBST: Consumo agua - MECANICO")
    void testConsumo_Mecanico() {
        double resultado = calc.calcularConsumoAgua("MECANICO", 100.0, 10);
        assertEquals(1.05, resultado, 0.001); // (100*1.05*10)/1000
    }
    
    @Test
    @DisplayName("SBST: Consumo agua - DIGITAL")
    void testConsumo_Digital() {
        double resultado = calc.calcularConsumoAgua("DIGITAL", 100.0, 10);
        assertEquals(0.98, resultado, 0.001); // (100*0.98*10)/1000
    }
    
    @Test
    @DisplayName("SBST: Consumo agua - sensor desconhecido (default)")
    void testConsumo_Desconhecido() {
        double resultado = calc.calcularConsumoAgua("XYZ", 100.0, 10);
        assertEquals(1.1, resultado, 0.001); // (100*1.1*10)/1000
    }
    
    @Test
    @DisplayName("SBST: Consumo agua - sensor nulo (excecao)")
    void testConsumo_SensorNulo() {
        assertThrows(IllegalArgumentException.class, 
            () -> calc.calcularConsumoAgua(null, 100.0, 10));
    }
    
    @Test
    @DisplayName("SBST: Consumo agua - leitura negativa (excecao)")
    void testConsumo_LeituraNegativa() {
        assertThrows(IllegalArgumentException.class, 
            () -> calc.calcularConsumoAgua("ULTRASSONICO", -1.0, 10));
    }
    
    @Test
    @DisplayName("SBST: Consumo agua - dias <= 0 (excecao)")
    void testConsumo_DiasInvalido() {
        assertThrows(IllegalArgumentException.class, 
            () -> calc.calcularConsumoAgua("ULTRASSONICO", 100.0, 0));
    }
    
    // ============================================
    // TESTES PARA detectarAnomaliaTemperatura
    // ============================================
    
    @Test
    @DisplayName("SBST: Anomalia - array nulo")
    void testAnomalia_ArrayNulo() {
        assertFalse(calc.detectarAnomaliaTemperatura(null));
    }
    
    @Test
    @DisplayName("SBST: Anomalia - array com 1 elemento")
    void testAnomalia_UmElemento() {
        assertFalse(calc.detectarAnomaliaTemperatura(new double[]{25.0}));
    }
    
    @Test
    @DisplayName("SBST: Anomalia - sem anomalia")
    void testAnomalia_SemAnomalia() {
        assertFalse(calc.detectarAnomaliaTemperatura(new double[]{20.0, 21.0, 22.0}));
    }
    
    @Test
    @DisplayName("SBST: Anomalia - com anomalia (>10 graus)")
    void testAnomalia_ComAnomalia() {
        assertTrue(calc.detectarAnomaliaTemperatura(new double[]{20.0, 35.0}));
    }
    
    @Test
    @DisplayName("SBST: Anomalia - anomalia negativa")
    void testAnomalia_AnomaliaNegativa() {
        assertTrue(calc.detectarAnomaliaTemperatura(new double[]{30.0, 15.0}));
    }
    
    // ============================================
    // TESTES PARA conversoes de temperatura
    // ============================================
    
    @Test
    @DisplayName("SBST: Celsius para Fahrenheit - zero")
    void testCelsiusParaFahrenheit_Zero() {
        assertEquals(32.0, calc.celsiusParaFahrenheit(0.0), 0.001);
    }
    
    @Test
    @DisplayName("SBST: Celsius para Fahrenheit - valor tipico")
    void testCelsiusParaFahrenheit_Tipico() {
        assertEquals(212.0, calc.celsiusParaFahrenheit(100.0), 0.001);
    }
    
    @Test
    @DisplayName("SBST: Fahrenheit para Celsius - zero")
    void testFahrenheitParaCelsius_Zero() {
        assertEquals(-17.778, calc.fahrenheitParaCelsius(0.0), 0.001);
    }
}
