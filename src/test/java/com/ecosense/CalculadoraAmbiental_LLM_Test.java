package com.ecosense;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes gerados por IA Generativa (LLM)
 * Abordagem: cenarios realistas, criativos e stress
 */
class CalculadoraAmbiental_LLM_Test {

    private CalculadoraAmbiental calc;

    @BeforeEach
    void setUp() {
        calc = new CalculadoraAmbiental();
    }

    @Test
    @DisplayName("LLM: Media de temperaturas diarias de uma semana")
    void testMedia_TemperaturasSemana() {
        double[] temps = {22.5, 23.1, 21.8, 24.0, 22.9, 23.5, 21.2};
        assertEquals(22.714, calc.calcularMedia(temps), 0.001);
    }

    @Test
    @DisplayName("LLM: Media com valores identicos sensor travado")
    void testMedia_SensorTravado() {
        double[] valores = {25.0, 25.0, 25.0, 25.0};
        assertEquals(25.0, calc.calcularMedia(valores), 0.001);
    }

    @Test
    @DisplayName("LLM: Media com valores muito grandes")
    void testMedia_ValoresGrandes() {
        double[] valores = {1000000.0, 2000000.0, 3000000.0};
        assertEquals(2000000.0, calc.calcularMedia(valores), 0.001);
    }

    @Test
    @DisplayName("LLM: Media com decimais precisos")
    void testMedia_DecimaisPrecisos() {
        double[] valores = {0.1, 0.2, 0.3};
        assertEquals(0.2, calc.calcularMedia(valores), 0.001);
    }

    @Test
    @DisplayName("LLM: Media com negativos e positivos misturados")
    void testMedia_Misturados() {
        double[] valores = {-10.0, 10.0, -5.0, 5.0};
        assertEquals(0.0, calc.calcularMedia(valores), 0.001);
    }

    @Test
    @DisplayName("LLM: Zero absoluto em Celsius")
    void testCelsiusParaFahrenheit_ZeroAbsoluto() {
        assertEquals(-459.67, calc.celsiusParaFahrenheit(-273.15), 0.01);
    }

    @Test
    @DisplayName("LLM: Temperatura corporal humana")
    void testCelsiusParaFahrenheit_TemperaturaCorporal() {
        assertEquals(98.6, calc.celsiusParaFahrenheit(37.0), 0.001);
    }

    @Test
    @DisplayName("LLM: Ebulicao da agua")
    void testCelsiusParaFahrenheit_EbulicaoAgua() {
        assertEquals(212.0, calc.celsiusParaFahrenheit(100.0), 0.001);
    }

    @Test
    @DisplayName("LLM: Fahrenheit para Celsius ponto congelamento")
    void testFahrenheitParaCelsius_PontoCongelamento() {
        assertEquals(0.0, calc.fahrenheitParaCelsius(32.0), 0.001);
    }

    @Test
    @DisplayName("LLM: Fahrenheit para Celsius negativo")
    void testFahrenheitParaCelsius_Negativo() {
        assertEquals(-40.0, calc.fahrenheitParaCelsius(-40.0), 0.001);
    }

    @Test
    @DisplayName("LLM: Temperatura ambiente tipica")
    void testCelsiusParaFahrenheit_Ambiente() {
        assertEquals(68.0, calc.celsiusParaFahrenheit(20.0), 0.001);
    }

    @Test
    @DisplayName("LLM: Qualidade do ar em dia limpo")
    void testQualidadeAr_DiaLimpo() {
        assertEquals("BOA", calc.classificarQualidadeAr(25.0));
    }

    @Test
    @DisplayName("LLM: Qualidade do ar em dia poluido")
    void testQualidadeAr_DiaPoluido() {
        assertEquals("NAO SAUDAVEL", calc.classificarQualidadeAr(180.0));
    }

    @Test
    @DisplayName("LLM: Qualidade do ar critica incendio")
    void testQualidadeAr_Incendio() {
        assertEquals("PERIGOSA", calc.classificarQualidadeAr(450.0));
    }

    @Test
    @DisplayName("LLM: Limite exato entre BOA e MODERADA")
    void testQualidadeAr_LimiteBoaModerada() {
        assertEquals("BOA", calc.classificarQualidadeAr(50.0));
    }

    @Test
    @DisplayName("LLM: Limite MODERADA e NAO SAUDAVEL GRUPOS")
    void testQualidadeAr_LimiteModeradaNaoSaudavel() {
        assertEquals("MODERADA", calc.classificarQualidadeAr(100.0));
    }

    @Test
    @DisplayName("LLM: Limite NAO SAUDAVEL e MUITO NAO SAUDAVEL")
    void testQualidadeAr_LimiteNaoSaudavelMuito() {
        assertEquals("NAO SAUDAVEL", calc.classificarQualidadeAr(200.0));
    }

    @Test
    @DisplayName("LLM: Limite MUITO NAO SAUDAVEL e PERIGOSA")
    void testQualidadeAr_LimiteMuitoPerigosa() {
        assertEquals("MUITO NAO SAUDAVEL", calc.classificarQualidadeAr(300.0));
    }

    @Test
    @DisplayName("LLM: AQI zero")
    void testQualidadeAr_Zero() {
        assertEquals("BOA", calc.classificarQualidadeAr(0.0));
    }

    @Test
    @DisplayName("LLM: AQI negativo pequeno")
    void testQualidadeAr_NegativoPequeno() {
        assertEquals("INDICE INVALIDO", calc.classificarQualidadeAr(-0.1));
    }

    @Test
    @DisplayName("LLM: Empresa com excelente sustentabilidade")
    void testIndice_EmpresaExcelente() {
        assertEquals(70.0, calc.calcularIndiceSustentabilidade(100.0, 100.0, 0.0), 0.001);
    }

    @Test
    @DisplayName("LLM: Empresa sem sustentabilidade")
    void testIndice_EmpresaZero() {
        assertEquals(0.0, calc.calcularIndiceSustentabilidade(0.0, 0.0, 0.0), 0.001);
    }

    @Test
    @DisplayName("LLM: Empresa com alta emissao limita a zero")
    void testIndice_EmpresaPoluidora() {
        double resultado = calc.calcularIndiceSustentabilidade(10.0, 10.0, 5000.0);
        assertEquals(0.0, resultado, 0.001);
    }

    @Test
    @DisplayName("LLM: Empresa media")
    void testIndice_EmpresaMedia() {
        double resultado = calc.calcularIndiceSustentabilidade(50.0, 50.0, 500.0);
        assertEquals(30.0, resultado, 0.001);
    }

    @Test
    @DisplayName("LLM: Valores decimais precisos no indice")
    void testIndice_Decimais() {
        double resultado = calc.calcularIndiceSustentabilidade(33.33, 66.67, 250.0);
        assertEquals(30.833, resultado, 0.001);
    }

    @Test
    @DisplayName("LLM: Excecao energia negativa")
    void testIndice_EnergiaNegativa() {
        assertThrows(IllegalArgumentException.class,
            () -> calc.calcularIndiceSustentabilidade(-0.01, 50.0, 100.0));
    }

    @Test
    @DisplayName("LLM: Excecao reciclagem negativa")
    void testIndice_ReciclagemNegativa() {
        assertThrows(IllegalArgumentException.class,
            () -> calc.calcularIndiceSustentabilidade(50.0, -1.0, 100.0));
    }

    @Test
    @DisplayName("LLM: Excecao carbono negativo")
    void testIndice_CarbonoNegativo() {
        assertThrows(IllegalArgumentException.class,
            () -> calc.calcularIndiceSustentabilidade(50.0, 50.0, -0.1));
    }

    @Test
    @DisplayName("LLM: Excecao energia exatamente 100.01")
    void testIndice_EnergiaLimiteSuperior() {
        assertThrows(IllegalArgumentException.class,
            () -> calc.calcularIndiceSustentabilidade(100.01, 50.0, 100.0));
    }

    @Test
    @DisplayName("LLM: Sensor ultrassonico industrial")
    void testConsumo_UltrassonicoIndustrial() {
        double resultado = calc.calcularConsumoAgua("ULTRASSONICO", 5000.0, 30);
        assertEquals(150.0, resultado, 0.001);
    }

    @Test
    @DisplayName("LLM: Sensor eletromagnetico residencial")
    void testConsumo_EletromagneticoResidencial() {
        double resultado = calc.calcularConsumoAgua("ELETROMAGNETICO", 1200.0, 30);
        assertEquals(34.2, resultado, 0.001);
    }

    @Test
    @DisplayName("LLM: Sensor mecanico rural")
    void testConsumo_MecanicoRural() {
        double resultado = calc.calcularConsumoAgua("MECANICO", 8000.0, 30);
        assertEquals(252.0, resultado, 0.001);
    }

    @Test
    @DisplayName("LLM: Sensor digital precisao")
    void testConsumo_DigitalPrecisao() {
        double resultado = calc.calcularConsumoAgua("DIGITAL", 999.99, 1);
        assertEquals(0.9799902, resultado, 0.0001);
    }

    @Test
    @DisplayName("LLM: Sensor desconhecido fallback")
    void testConsumo_SensorDesconhecidoFallback() {
        double resultado = calc.calcularConsumoAgua("LASER", 1000.0, 10);
        assertEquals(11.0, resultado, 0.001);
    }

    @Test
    @DisplayName("LLM: Sensor case insensitive")
    void testConsumo_CaseInsensitive() {
        double resultado = calc.calcularConsumoAgua("ultrassonico", 1000.0, 10);
        assertEquals(10.0, resultado, 0.001);
    }

    @Test
    @DisplayName("LLM: Sensor com espacos")
    void testConsumo_ComEspacos() {
        double resultado = calc.calcularConsumoAgua("  ULTRASSONICO  ", 1000.0, 10);
        assertEquals(10.0, resultado, 0.001);
    }

    @Test
    @DisplayName("LLM: Leitura zero sem fluxo")
    void testConsumo_SemFluxo() {
        double resultado = calc.calcularConsumoAgua("ULTRASSONICO", 0.0, 10);
        assertEquals(0.0, resultado, 0.001);
    }

    @Test
    @DisplayName("LLM: Excecao string vazia com espacos")
    void testConsumo_StringVaziaComEspacos() {
        assertThrows(IllegalArgumentException.class,
            () -> calc.calcularConsumoAgua("   ", 100.0, 10));
    }

    @Test
    @DisplayName("LLM: Excecao dias negativos")
    void testConsumo_DiasNegativos() {
        assertThrows(IllegalArgumentException.class,
            () -> calc.calcularConsumoAgua("ULTRASSONICO", 100.0, -5));
    }

    @Test
    @DisplayName("LLM: Excecao ambos invalidos")
    void testConsumo_AmbosInvalidos() {
        assertThrows(IllegalArgumentException.class,
            () -> calc.calcularConsumoAgua("ULTRASSONICO", -1.0, 0));
    }

    @Test
    @DisplayName("LLM: Anomalia variacao exatamente 10 graus")
    void testAnomalia_LimiteExato() {
        assertFalse(calc.detectarAnomaliaTemperatura(new double[]{20.0, 30.0}));
    }

    @Test
    @DisplayName("LLM: Anomalia variacao 10.1 graus")
    void testAnomalia_AcimaLimite() {
        assertTrue(calc.detectarAnomaliaTemperatura(new double[]{20.0, 30.1}));
    }

    @Test
    @DisplayName("LLM: Anomalia variacao 9.9 graus")
    void testAnomalia_AbaixoLimite() {
        assertFalse(calc.detectarAnomaliaTemperatura(new double[]{20.0, 29.9}));
    }

    @Test
    @DisplayName("LLM: Anomalia multiplas leituras com anomalia no meio")
    void testAnomalia_NoMeio() {
        assertTrue(calc.detectarAnomaliaTemperatura(
            new double[]{20.0, 21.0, 35.0, 22.0}));
    }

    @Test
    @DisplayName("LLM: Anomalia resfriamento abrupto")
    void testAnomalia_ResfriamentoAbrupto() {
        assertTrue(calc.detectarAnomaliaTemperatura(
            new double[]{30.0, 15.0, 16.0}));
    }

    @Test
    @DisplayName("LLM: Anomalia dois elementos iguais")
    void testAnomalia_DoisIguais() {
        assertFalse(calc.detectarAnomaliaTemperatura(new double[]{25.0, 25.0}));
    }

    @Test
    @DisplayName("LLM: Anomalia array vazio")
    void testAnomalia_ArrayVazio() {
        assertFalse(calc.detectarAnomaliaTemperatura(new double[]{}));
    }

    @Test
    @DisplayName("LLM: Anomalia variacoes pequenas sequenciais")
    void testAnomalia_VariacoesPequenas() {
        assertFalse(calc.detectarAnomaliaTemperatura(
            new double[]{20.0, 21.0, 22.0, 23.0, 24.0}));
    }

    @Test
    @DisplayName("LLM: Stress valores muito grandes no consumo")
    void testStress_ConsumoGrande() {
        double resultado = calc.calcularConsumoAgua("ULTRASSONICO", 999999.0, 365);
        assertEquals(364999.635, resultado, 0.001);
    }

    @Test
    @DisplayName("LLM: Stress media com mil elementos")
    void testStress_MediaMilElementos() {
        double[] valores = new double[1000];
        for (int i = 0; i < 1000; i++) {
            valores[i] = i;
        }
        assertEquals(499.5, calc.calcularMedia(valores), 0.001);
    }

    @Test
    @DisplayName("LLM: Stress AQI maximo teorico")
    void testStress_AQIExtremo() {
        assertEquals("PERIGOSA", calc.classificarQualidadeAr(999999.0));
    }
}
