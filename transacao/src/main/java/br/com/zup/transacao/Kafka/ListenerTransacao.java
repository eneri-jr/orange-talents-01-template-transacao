package br.com.zup.transacao.Kafka;

import br.com.zup.transacao.Kafka.Eventos.EventoTransacao;
import br.com.zup.transacao.Transacao.Cartao.CartaoRepository;
import br.com.zup.transacao.Transacao.Estabelecimento.EstabelecimentoRepository;
import br.com.zup.transacao.Transacao.Transacao;
import br.com.zup.transacao.Transacao.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class ListenerTransacao {

    private final TransacaoRepository transacaoRepository;
    private final CartaoRepository cartaoRepository;
    private final EstabelecimentoRepository estabelecimentoRepository;

    @Autowired
    public ListenerTransacao(TransacaoRepository transacaoRepository, CartaoRepository cartaoRepository, EstabelecimentoRepository estabelecimentoRepository) {
        this.transacaoRepository = transacaoRepository;
        this.cartaoRepository = cartaoRepository;
        this.estabelecimentoRepository = estabelecimentoRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    @Transactional
    public void ouvir(EventoTransacao eventoDeTransacao) {

        Transacao transacao =eventoDeTransacao.toModel(estabelecimentoRepository, cartaoRepository);
        transacaoRepository.save(transacao);

    }
}
