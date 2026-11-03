package com.example.strategy;

import com.example.strategy.payment.PagamentoService;
import com.example.strategy.payment.TipoPagamento;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PagamentoServiceTest {

    @Autowired
    private PagamentoService pagamentoService;

    @Test
    void pixAplicaDesconto() {
        assertThat(pagamentoService.calcular(TipoPagamento.PIX, new BigDecimal("100")))
                .isEqualByComparingTo("90.00");
    }

    @Test
    void cartaoAplicaTaxa() {
        assertThat(pagamentoService.calcular(TipoPagamento.CARTAO_CREDITO, new BigDecimal("100")))
                .isEqualByComparingTo("105.00");
    }

    @Test
    void boletoAplicaTarifaFixa() {
        assertThat(pagamentoService.calcular(TipoPagamento.BOLETO, new BigDecimal("100")))
                .isEqualByComparingTo("103.50");
    }
}
