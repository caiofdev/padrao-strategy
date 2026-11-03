package com.example.strategy.payment.strategies;

import com.example.strategy.payment.PagamentoStrategy;
import com.example.strategy.payment.TipoPagamento;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Boleto: tarifa fixa de R$ 3,50.
 */
@Component
public class BoletoStrategy implements PagamentoStrategy {

    private static final BigDecimal TARIFA = new BigDecimal("3.50");

    @Override
    public TipoPagamento getTipo() {
        return TipoPagamento.BOLETO;
    }

    @Override
    public BigDecimal calcularValorFinal(BigDecimal valor) {
        return valor.add(TARIFA).setScale(2, RoundingMode.HALF_EVEN);
    }
}
