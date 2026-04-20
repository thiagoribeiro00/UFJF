package com.ecosense;

/**
 * CalculadoraAmbiental - Classe exemplo para testes
 * Simula calculos de monitoramento ambiental
 */
public class CalculadoraAmbiental {
    
    // ============================================
    // METODOS BASICOS (Faceis de testar)
    // ============================================
    
    /**
     * Calcula a media de um array de valores
     * @param valores array de numeros
     * @return media aritmetica
     * @throws IllegalArgumentException se array for nulo ou vazio
     */
    public double calcularMedia(double[] valores) {
        if (valores == null || valores.length == 0) {
            throw new IllegalArgumentException("Array nao pode ser nulo ou vazio");
        }
        double soma = 0;
        for (double v : valores) {
            soma += v;
        }
        return soma / valores.length;
    }
    
    /**
     * Converte temperatura Celsius para Fahrenheit
     */
    public double celsiusParaFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32.0;
    }
    
    /**
     * Converte temperatura Fahrenheit para Celsius
     */
    public double fahrenheitParaCelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }
    
    // ============================================
    // METODOS INTERMEDIARIOS (Caminhos logicos)
    // ============================================
    
    /**
     * Classifica a qualidade do ar baseado no indice
     * @param indiceQualidade valor do indice (0-500)
     * @return classificacao em texto
     */
    public String classificarQualidadeAr(double indiceQualidade) {
        if (indiceQualidade < 0) {
            return "INDICE INVALIDO";
        }
        if (indiceQualidade <= 50) {
            return "BOA";
        } else if (indiceQualidade <= 100) {
            return "MODERADA";
        } else if (indiceQualidade <= 150) {
            return "NAO SAUDAVEL PARA GRUPOS SENSIVEIS";
        } else if (indiceQualidade <= 200) {
            return "NAO SAUDAVEL";
        } else if (indiceQualidade <= 300) {
            return "MUITO NAO SAUDAVEL";
        } else {
            return "PERIGOSA";
        }
    }
    
    /**
     * Calcula o indice de sustentabilidade baseado em multiplos fatores
     */
    public double calcularIndiceSustentabilidade(double energiaRenovavel, 
                                                  double reciclagem, 
                                                  double emissaoCarbono) {
        if (energiaRenovavel < 0 || reciclagem < 0 || emissaoCarbono < 0) {
            throw new IllegalArgumentException("Valores nao podem ser negativos");
        }
        if (energiaRenovavel > 100 || reciclagem > 100) {
            throw new IllegalArgumentException("Porcentagens nao podem ultrapassar 100");
        }
        
        // Formula: (energia * 0.4) + (reciclagem * 0.3) - (emissao * 0.01)
        double indice = (energiaRenovavel * 0.4) + (reciclagem * 0.3) - (emissaoCarbono * 0.01);
        return Math.max(0, Math.min(100, indice)); // Limita entre 0 e 100
    }
    
    // ============================================
    // METODOS COMPLEXOS (Cenarios de borda)
    // ============================================
    
    /**
     * Calcula o consumo estimado de agua baseado no tipo de sensor
     * e na leitura. Tem multiplos caminhos logicos.
     */
    public double calcularConsumoAgua(String tipoSensor, double leitura, int dias) {
        if (tipoSensor == null || tipoSensor.trim().isEmpty()) {
            throw new IllegalArgumentException("Tipo de sensor nao pode ser nulo ou vazio");
        }
        if (leitura < 0) {
            throw new IllegalArgumentException("Leitura nao pode ser negativa");
        }
        if (dias <= 0) {
            throw new IllegalArgumentException("Dias deve ser maior que zero");
        }
        
        double fator;
        String sensorLimpo = tipoSensor.trim().toUpperCase();
        switch (sensorLimpo) {
            case "ULTRASSONICO":
                fator = 1.0;
                break;
            case "ELETROMAGNETICO":
                fator = 0.95;
                break;
            case "MECANICO":
                fator = 1.05;
                break;
            case "DIGITAL":
                fator = 0.98;
                break;
            default:
                fator = 1.1; // Sensor desconhecido - margem de erro maior
        }
        
        return (leitura * fator * dias) / 1000.0; // Converte para m3
    }
    
    /**
     * Detecta anomalia em leituras de temperatura
     * Retorna true se houver variacao abrupta (>10 graus entre leituras consecutivas)
     */
    public boolean detectarAnomaliaTemperatura(double[] leituras) {
        if (leituras == null || leituras.length < 2) {
            return false; // Nao ha como detectar anomalia com menos de 2 leituras
        }
        
        for (int i = 1; i < leituras.length; i++) {
            if (Math.abs(leituras[i] - leituras[i-1]) > 10.0) {
                return true; // Anomalia detectada
            }
        }
        return false; // Nenhuma anomalia
    }
}
