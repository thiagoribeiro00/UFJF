package com.ecosense;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * CalculadoraAmbientalTest - Testes unitários gerados por IA (Antigravity).
 * Foco em cobertura de caminhos críticos e validação de requisitos de negócio.
 */
public class CalculadoraAmbientalTest {

    private CalculadoraAmbiental calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new CalculadoraAmbiental();
    }

    @Test
    void testCalcularPegadaCarbonoCarro() {
        double resultado = calculadora.calcularPegadaCarbonoTransporte(100, "CARRO");
        assertEquals(18.0, resultado, 0.001, "Pegada de carro deve ser 0.18 * km");
    }

    @Test
    void testCalcularPegadaCarbonoOnibus() {
        double resultado = calculadora.calcularPegadaCarbonoTransporte(100, "ONIBUS");
        assertEquals(8.0, resultado, 0.001, "Pegada de ônibus deve ser 0.08 * km");
    }

    @Test
    void testCalcularPegadaCarbonoEletrico() {
        double resultado = calculadora.calcularPegadaCarbonoTransporte(100, "ELETRICO");
        assertEquals(2.0, resultado, 0.001, "Pegada de elétrico deve ser 0.02 * km");
    }

    @Test
    void testCalcularPegadaCarbonoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularPegadaCarbonoTransporte(100, "AVIAO");
        }, "Deve lançar exceção para transporte desconhecido");
    }

    @Test
    void testCalcularPegadaCarbonoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularPegadaCarbonoTransporte(-10, "CARRO");
        }, "Deve lançar exceção para quilometragem negativa");
    }

    @ParameterizedTest
    @CsvSource({
        "25, A, Eficiência Excelente",
        "35, A, Eficiência Alta",
        "50, B, Eficiência Moderada",
        "50, C, Eficiência Moderada",
        "120, D, 'Eficiência Crítica: Alto Consumo'",
        "80, E, Eficiência Baixa",
        "50, X, Classificação Desconhecida"
    })
    void testAvaliarEficienciaEnergetica(double consumo, char classificacao, String esperado) {
        assertEquals(esperado, calculadora.avaliarEficienciaEnergetica(consumo, classificacao));
    }

    @Test
    void testAvaliarEficienciaConsumoInvalido() {
        assertEquals("Consumo inexistente ou inválido.", calculadora.avaliarEficienciaEnergetica(0, 'A'));
        assertEquals("Consumo inexistente ou inválido.", calculadora.avaliarEficienciaEnergetica(-5, 'A'));
    }

    @Test
    void testSugerirAcaoAmbiental() {
        assertEquals("Considere o plantio de 5 árvores este mês.", calculadora.sugerirAcaoAmbiental(501));
        assertEquals("Tente reduzir o uso de veículos a combustão.", calculadora.sugerirAcaoAmbiental(250));
        assertEquals("Parabéns! Sua pegada está dentro da média sustentável.", calculadora.sugerirAcaoAmbiental(100));
        assertEquals("Pegada zerada ou negativa. Continue assim!", calculadora.sugerirAcaoAmbiental(0));
    }
}
