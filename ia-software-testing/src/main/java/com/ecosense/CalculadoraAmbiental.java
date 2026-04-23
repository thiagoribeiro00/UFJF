package com.ecosense;

/**
 * CalculadoraAmbiental - Uma ferramenta para análise de impacto ambiental.
 * Segue princípios de Clean Code para facilitar a manutenção e testabilidade.
 */
public class CalculadoraAmbiental {

    /**
     * Calcula a pegada de carbono mensal baseada no meio de transporte.
     * 
     * @param quilometros Rodados no mês.
     * @param tipoTransporte Tipo do veículo (CARRO, ONIBUS, ELETRICO).
     * @return Valor em Kg de CO2.
     * @throws IllegalArgumentException se quilometros < 0 ou transporte for inválido.
     */
    public double calcularPegadaCarbonoTransporte(double quilometros, String tipoTransporte) {
        if (quilometros < 0) {
            throw new IllegalArgumentException("Quilometragem não pode ser negativa.");
        }

        if (tipoTransporte == null || tipoTransporte.isEmpty()) {
            throw new IllegalArgumentException("Tipo de transporte deve ser informado.");
        }

        double fatorEmissao;
        switch (tipoTransporte.toUpperCase()) {
            case "CARRO":
                fatorEmissao = 0.18; // 180g por km
                break;
            case "ONIBUS":
                fatorEmissao = 0.08; // 80g por km por passageiro
                break;
            case "ELETRICO":
                fatorEmissao = 0.02; // Baixa emissão
                break;
            default:
                throw new IllegalArgumentException("Tipo de transporte não reconhecido.");
        }

        return quilometros * fatorEmissao;
    }

    /**
     * Avalia a eficiência energética de um aparelho baseado no consumo e classificação.
     * 
     * @param consumoKwh Consumo mensal em Kwh.
     * @param classificacao Classificação Procel (A, B, C, D, E).
     * @return Mensagem sobre a eficiência.
     */
    public String avaliarEficienciaEnergetica(double consumoKwh, char classificacao) {
        if (consumoKwh <= 0) {
            return "Consumo inexistente ou inválido.";
        }

        char classe = Character.toUpperCase(classificacao);

        if (classe == 'A') {
            if (consumoKwh < 30) {
                return "Eficiência Excelente";
            } else {
                return "Eficiência Alta";
            }
        } else if (classe == 'B' || classe == 'C') {
            return "Eficiência Moderada";
        } else if (classe == 'D' || classe == 'E') {
            if (consumoKwh > 100) {
                return "Eficiência Crítica: Alto Consumo";
            }
            return "Eficiência Baixa";
        } else {
            return "Classificação Desconhecida";
        }
    }

    /**
     * Sugere ações de melhoria baseada no impacto total.
     * 
     * @param pegadaTotal Pegada de carbono total em Kg.
     * @return Sugestão de ação.
     */
    public String sugerirAcaoAmbiental(double pegadaTotal) {
        if (pegadaTotal > 500) {
            return "Considere o plantio de 5 árvores este mês.";
        } else if (pegadaTotal > 200) {
            return "Tente reduzir o uso de veículos a combustão.";
        } else if (pegadaTotal > 0) {
            return "Parabéns! Sua pegada está dentro da média sustentável.";
        } else {
            return "Pegada zerada ou negativa. Continue assim!";
        }
    }
}
