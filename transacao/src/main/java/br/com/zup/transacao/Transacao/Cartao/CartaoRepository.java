package br.com.zup.transacao.Transacao.Cartao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {

    @Query(value = "SELECT c FROM Cartao c WHERE c.numero= :numero")
    List<Cartao> findByCartao(String numero);

}
