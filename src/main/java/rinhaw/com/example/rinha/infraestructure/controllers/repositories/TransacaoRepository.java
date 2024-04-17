package rinhaw.com.example.rinha.infraestructure.controllers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rinhaw.com.example.rinha.domain.entities.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
