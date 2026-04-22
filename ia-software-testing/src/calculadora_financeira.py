def calcular_juros_compostos(principal, taxa, tempo):
    """Calcula o montante final com juros compostos."""
    if principal <= 0 or taxa < 0 or tempo < 0:
        raise ValueError("Argumentos devem ser positivos.")
    
    montante = principal * (1 + taxa) ** tempo
    return round(montante, 2)

def classificar_risco(score_credito):
    """Classifica o risco baseado no score."""
    if score_credito < 300:
        return "ALTO"
    elif score_credito < 700:
        return "MEDIO"
    else:
        return "BAIXO"