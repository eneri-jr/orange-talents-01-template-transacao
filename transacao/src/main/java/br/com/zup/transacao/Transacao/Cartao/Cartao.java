package br.com.zup.transacao.Transacao.Cartao;

import br.com.zup.transacao.Transacao.Transacao;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    private String email;

    @OneToMany(mappedBy = "cartao", cascade = CascadeType.ALL)
    private Set<Transacao> transacoes = new HashSet<>();

    @Deprecated
    public Cartao() {

    }

    public Cartao(String numero, String email) {
        this.numero = numero;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public String getEmail() {
        return email;
    }

    public Set<Transacao> getTransacoes() {
        return transacoes;
    }

}
