package br.com.zup.transacao.Kafka.Eventos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventoCartao {

    private String id;
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "EventoCartao{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
