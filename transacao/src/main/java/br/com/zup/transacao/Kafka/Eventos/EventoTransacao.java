package br.com.zup.transacao.Kafka.Eventos;

import br.com.zup.transacao.Transacao.Cartao.CartaoRepository;
import br.com.zup.transacao.Transacao.Estabelecimento.EstabelecimentoRepository;
import br.com.zup.transacao.Transacao.Transacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EventoTransacao {

    private String id;
    private BigDecimal valor;
    private EventoEstabelecimento estabelecimento;
    private EventoCartao cartao;
    private LocalDate efetivadaEm;

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EventoEstabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public EventoCartao getCartao() {
        return cartao;
    }

    public LocalDate getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transacao toModel(EstabelecimentoRepository estabelecimentoRepository, CartaoRepository cartaoRepository) {
        return new Transacao(id, valor, estabelecimento.toModel(estabelecimentoRepository), cartao.toModel(cartaoRepository), efetivadaEm);
    }
}
