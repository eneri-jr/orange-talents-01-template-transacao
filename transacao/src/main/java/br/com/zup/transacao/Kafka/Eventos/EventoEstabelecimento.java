package br.com.zup.transacao.Kafka.Eventos;

import br.com.zup.transacao.Transacao.Estabelecimento.Estabelecimento;
import br.com.zup.transacao.Transacao.Estabelecimento.EstabelecimentoRepository;

import java.util.List;

public class EventoEstabelecimento {

    private String nome;
    private String cidade;
    private String endereco;

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public Estabelecimento toModel(EstabelecimentoRepository estabelecimentoRepository) {
        List<Estabelecimento> possivelEstabelecimento = estabelecimentoRepository.findByEstabelecimento(nome, cidade, endereco);
        if(possivelEstabelecimento.isEmpty()) {
            return new Estabelecimento(nome, cidade, endereco);
        }
        return possivelEstabelecimento.get(0);
    }
}
