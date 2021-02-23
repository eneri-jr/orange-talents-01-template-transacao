package br.com.zup.transacao.Transacao.Estabelecimento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {

    @Query(value = "SELECT e FROM Estabelecimento e WHERE e.nome= :nome AND e.cidade= :cidade AND e.endereco= :endereco")
    List<Estabelecimento> findByEstabelecimento(String nome, String cidade, String endereco);
}
