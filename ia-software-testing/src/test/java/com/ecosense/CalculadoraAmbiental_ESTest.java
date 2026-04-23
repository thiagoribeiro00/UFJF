package com.ecosense;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * CalculadoraAmbiental_ESTest - Testes simulando a saída do EvoSuite.
 * Foco em cobertura estrutural exaustiva e caminhos de exceção.
 * Nota: Estes testes foram adaptados para manter a integridade da comparação caso o EvoSuite falhe localmente.
 */
public class CalculadoraAmbiental_ESTest {

  @Test
  public void test00()  throws Throwable  {
      CalculadoraAmbiental calculadoraAmbiental0 = new CalculadoraAmbiental();
      double double0 = calculadoraAmbiental0.calcularPegadaCarbonoTransporte(0.0, "CARRO");
      assertEquals(0.0, double0, 0.01);
  }

  @Test
  public void test01()  throws Throwable  {
      CalculadoraAmbiental calculadoraAmbiental0 = new CalculadoraAmbiental();
      double double0 = calculadoraAmbiental0.calcularPegadaCarbonoTransporte(1.0, "ONIBUS");
      assertEquals(0.08, double0, 0.01);
  }

  @Test
  public void test02()  throws Throwable  {
      CalculadoraAmbiental calculadoraAmbiental0 = new CalculadoraAmbiental();
      double double0 = calculadoraAmbiental0.calcularPegadaCarbonoTransporte(1.0, "ELETRICO");
      assertEquals(0.02, double0, 0.01);
  }

  @Test
  public void test03()  throws Throwable  {
      CalculadoraAmbiental calculadoraAmbiental0 = new CalculadoraAmbiental();
      try { 
        calculadoraAmbiental0.calcularPegadaCarbonoTransporte((-1.0), "CARRO");
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
         //
         // Quilometragem não pode ser negativa.
         //
      }
  }

  @Test
  public void test04()  throws Throwable  {
      CalculadoraAmbiental calculadoraAmbiental0 = new CalculadoraAmbiental();
      try { 
        calculadoraAmbiental0.calcularPegadaCarbonoTransporte(1.0, null);
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
         //
         // Tipo de transporte deve ser informado.
         //
      }
  }

  @Test
  public void test05()  throws Throwable  {
      CalculadoraAmbiental calculadoraAmbiental0 = new CalculadoraAmbiental();
      try { 
        calculadoraAmbiental0.calcularPegadaCarbonoTransporte(1.0, "");
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
         //
         // Tipo de transporte deve ser informado.
         //
      }
  }

  @Test
  public void test06()  throws Throwable  {
      CalculadoraAmbiental calculadoraAmbiental0 = new CalculadoraAmbiental();
      try { 
        calculadoraAmbiental0.calcularPegadaCarbonoTransporte(1.0, "AVIAO");
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
         //
         // Tipo de transporte não reconhecido.
         //
      }
  }

  @Test
  public void test07()  throws Throwable  {
      CalculadoraAmbiental calculadoraAmbiental0 = new CalculadoraAmbiental();
      String string0 = calculadoraAmbiental0.avaliarEficienciaEnergetica(20.0, 'A');
      assertEquals("Eficiência Excelente", string0);
  }

  @Test
  public void test08()  throws Throwable  {
      CalculadoraAmbiental calculadoraAmbiental0 = new CalculadoraAmbiental();
      String string0 = calculadoraAmbiental0.avaliarEficienciaEnergetica(40.0, 'a');
      assertEquals("Eficiência Alta", string0);
  }

  @Test
  public void test09()  throws Throwable  {
      CalculadoraAmbiental calculadoraAmbiental0 = new CalculadoraAmbiental();
      String string0 = calculadoraAmbiental0.avaliarEficienciaEnergetica(50.0, 'B');
      assertEquals("Eficiência Moderada", string0);
  }

  @Test
  public void test10()  throws Throwable  {
      CalculadoraAmbiental calculadoraAmbiental0 = new CalculadoraAmbiental();
      String string0 = calculadoraAmbiental0.avaliarEficienciaEnergetica(50.0, 'C');
      assertEquals("Eficiência Moderada", string0);
  }

  @Test
  public void test11()  throws Throwable  {
      CalculadoraAmbiental calculadoraAmbiental0 = new CalculadoraAmbiental();
      String string0 = calculadoraAmbiental0.avaliarEficienciaEnergetica(150.0, 'D');
      assertEquals("Eficiência Crítica: Alto Consumo", string0);
  }

  @Test
  public void test12()  throws Throwable  {
      CalculadoraAmbiental calculadoraAmbiental0 = new CalculadoraAmbiental();
      String string0 = calculadoraAmbiental0.avaliarEficienciaEnergetica(50.0, 'E');
      assertEquals("Eficiência Baixa", string0);
  }

  @Test
  public void test13()  throws Throwable  {
      CalculadoraAmbiental calculadoraAmbiental0 = new CalculadoraAmbiental();
      String string0 = calculadoraAmbiental0.avaliarEficienciaEnergetica(0.0, 'A');
      assertEquals("Consumo inexistente ou inválido.", string0);
  }

  @Test
  public void test14()  throws Throwable  {
      CalculadoraAmbiental calculadoraAmbiental0 = new CalculadoraAmbiental();
      String string0 = calculadoraAmbiental0.avaliarEficienciaEnergetica(50.0, 'Z');
      assertEquals("Classificação Desconhecida", string0);
  }

  @Test
  public void test15()  throws Throwable  {
      CalculadoraAmbiental calculadoraAmbiental0 = new CalculadoraAmbiental();
      String string0 = calculadoraAmbiental0.sugerirAcaoAmbiental(600.0);
      assertEquals("Considere o plantio de 5 árvores este mês.", string0);
  }

  @Test
  public void test16()  throws Throwable  {
      CalculadoraAmbiental calculadoraAmbiental0 = new CalculadoraAmbiental();
      String string0 = calculadoraAmbiental0.sugerirAcaoAmbiental(300.0);
      assertEquals("Tente reduzir o uso de veículos a combustão.", string0);
  }

  @Test
  public void test17()  throws Throwable  {
      CalculadoraAmbiental calculadoraAmbiental0 = new CalculadoraAmbiental();
      String string0 = calculadoraAmbiental0.sugerirAcaoAmbiental(100.0);
      assertEquals("Parabéns! Sua pegada está dentro da média sustentável.", string0);
  }

  @Test
  public void test18()  throws Throwable  {
      CalculadoraAmbiental calculadoraAmbiental0 = new CalculadoraAmbiental();
      String string0 = calculadoraAmbiental0.sugerirAcaoAmbiental(0.0);
      assertEquals("Pegada zerada ou negativa. Continue assim!", string0);
  }
}
