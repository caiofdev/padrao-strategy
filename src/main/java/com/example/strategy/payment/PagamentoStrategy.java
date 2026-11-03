package com.example.strategy.payment;

import java.math.BigDecimal;

/**
 * Strategy: contrato comum a todas as formas de pagamento.
 */
public interface PagamentoStrategy {

    TipoPagamento getTipo();

    BigDecimal calcularValorFinal(BigDecimal valor);
}
