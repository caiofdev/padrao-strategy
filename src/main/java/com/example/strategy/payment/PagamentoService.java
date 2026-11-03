package com.example.strategy.payment;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * Context: escolhe a estratégia em tempo de execução de acordo com o tipo de pagamento.
 * O Spring injeta todas as implementações de PagamentoStrategy automaticamente.
 */
@Service
public class PagamentoService {

    private final Map<TipoPagamento, PagamentoStrategy> estrategias = new EnumMap<>(TipoPagamento.class);

    public PagamentoService(List<PagamentoStrategy> estrategias) {
        estrategias.forEach(e -> this.estrategias.put(e.getTipo(), e));
    }

    public BigDecimal calcular(TipoPagamento tipo, BigDecimal valor) {
        PagamentoStrategy estrategia = estrategias.get(tipo);
        if (estrategia == null) {
            throw new IllegalArgumentException("Tipo de pagamento não suportado: " + tipo);
        }
        return estrategia.calcularValorFinal(valor);
    }
}
