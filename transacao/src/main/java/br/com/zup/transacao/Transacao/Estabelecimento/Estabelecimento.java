package br.com.zup.transacao.Transacao.Estabelecimento;

import br.com.zup.transacao.Transacao.Transacao;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cidade;
    private String endereco;

    @OneToMany(mappedBy = "estabelecimento", cascade = CascadeType.ALL)
    private Set<Transacao> transacoes = new HashSet<>();

    public Estabelecimento() {

    }

    public Estabelecimento(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public Set<Transacao> getTransacoes() {
        return transacoes;
    }

}
