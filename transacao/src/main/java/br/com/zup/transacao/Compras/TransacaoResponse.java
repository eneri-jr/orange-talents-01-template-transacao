package br.com.zup.transacao.Compras;

import br.com.zup.transacao.Transacao.Transacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransacaoResponse {

    private BigDecimal valor;
    private EstabelecimentoResponse estabelecimento;
    private LocalDate efetivadaEm;

    public TransacaoResponse(BigDecimal valor, EstabelecimentoResponse estabelecimento, LocalDate efetivadaEm) {
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.efetivadaEm = efetivadaEm;
    }

    public TransacaoResponse(Transacao transacao) {
        this.valor = transacao.getValor();
        this.estabelecimento = new EstabelecimentoResponse(transacao.getEstabelecimento().getNome(),
                                                            transacao.getEstabelecimento().getCidade(),
                                                            transacao.getEstabelecimento().getEndereco());
        this.efetivadaEm = transacao.getEfetivadaEm();
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    public LocalDate getEfetivadaEm() {
        return efetivadaEm;
    }
}
