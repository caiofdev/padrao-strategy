package com.example.strategy.payment.strategies;

import com.example.strategy.payment.PagamentoStrategy;
import com.example.strategy.payment.TipoPagamento;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Cartão de crédito: 5% de taxa.
 */
@Component
public class CartaoCreditoStrategy implements PagamentoStrategy {

    private static final BigDecimal TAXA = new BigDecimal("0.05");

    @Override
    public TipoPagamento getTipo() {
        return TipoPagamento.CARTAO_CREDITO;
    }

    @Override
    public BigDecimal calcularValorFinal(BigDecimal valor) {
        return valor.add(valor.multiply(TAXA)).setScale(2, RoundingMode.HALF_EVEN);
    }
}
