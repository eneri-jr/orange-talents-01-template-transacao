package br.com.zup.transacao.Kafka;

import br.com.zup.transacao.Kafka.Eventos.EventoTransacao;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerTransacao {


    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(EventoTransacao eventoDeTransacao) {
        System.out.println(eventoDeTransacao);
    }
}
