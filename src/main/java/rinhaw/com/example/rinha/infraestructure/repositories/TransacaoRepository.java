package rinhaw.com.example.rinha.infraestructure.repositories;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rinhaw.com.example.rinha.domain.entities.Cliente;
import rinhaw.com.example.rinha.domain.entities.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

  public List<Transacao> findByCliente(Cliente cliente, Pageable pageable);
}
