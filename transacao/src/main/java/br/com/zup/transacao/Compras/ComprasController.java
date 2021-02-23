package br.com.zup.transacao.Compras;

import br.com.zup.transacao.Transacao.Cartao.Cartao;
import br.com.zup.transacao.Transacao.Cartao.CartaoRepository;
import br.com.zup.transacao.Transacao.Transacao;
import br.com.zup.transacao.Transacao.TransacaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/compras")
public class ComprasController {

    private final CartaoRepository cartaoRepository;
    private final TransacaoRepository transacaoRepository;

    public ComprasController(CartaoRepository cartaoRepository, TransacaoRepository transacaoRepository) {
        this.cartaoRepository = cartaoRepository;
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaCompras(@PathVariable Long id) {

        Optional<Cartao> possivelCartao = cartaoRepository.findById(id);

        if(!possivelCartao.isPresent()){
            return ResponseEntity.notFound().build();
        }

        List<Transacao> transacoes = transacaoRepository.findByCartao10(id);
        List<TransacaoResponse> transacoesResponses = new ArrayList<>();
        for(Transacao transacao: transacoes) {
            TransacaoResponse transacaoResponse = new TransacaoResponse(transacao);
            transacoesResponses.add(transacaoResponse);
        }
        return ResponseEntity.ok(transacoesResponses);
    }
}
