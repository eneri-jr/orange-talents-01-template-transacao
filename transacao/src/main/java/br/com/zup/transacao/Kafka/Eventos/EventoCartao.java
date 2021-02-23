package br.com.zup.transacao.Kafka.Eventos;

import br.com.zup.transacao.Transacao.Cartao.Cartao;
import br.com.zup.transacao.Transacao.Cartao.CartaoRepository;

import java.util.List;

public class EventoCartao {

    private String id;
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao toModel(CartaoRepository cartaoRepository) {

        List<Cartao> possivelCartao = cartaoRepository.findByCartao(id);

        if(possivelCartao.isEmpty()) {
            return new Cartao(id, email);
        }
        return possivelCartao.get(0);

    }
}
