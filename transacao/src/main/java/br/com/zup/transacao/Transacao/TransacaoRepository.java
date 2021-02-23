package br.com.zup.transacao.Transacao;

import br.com.zup.transacao.Transacao.Cartao.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, String> {

    @Query(value = "SELECT * FROM transacao WHERE cartao_id= :id ORDER BY efetivada_em DESC LIMIT 10", nativeQuery = true)
    List<Transacao> findByCartao10(Long id);
}
