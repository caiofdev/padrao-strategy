package com.example.strategy.payment.strategies;

import com.example.strategy.payment.PagamentoStrategy;
import com.example.strategy.payment.TipoPagamento;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Pix: 10% de desconto.
 */
@Component
public class PixStrategy implements PagamentoStrategy {

    private static final BigDecimal DESCONTO = new BigDecimal("0.10");

    @Override
    public TipoPagamento getTipo() {
        return TipoPagamento.PIX;
    }

    @Override
    public BigDecimal calcularValorFinal(BigDecimal valor) {
        return valor.subtract(valor.multiply(DESCONTO)).setScale(2, RoundingMode.HALF_EVEN);
    }
}
