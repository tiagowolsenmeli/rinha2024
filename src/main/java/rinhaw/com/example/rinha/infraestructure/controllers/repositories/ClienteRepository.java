package rinhaw.com.example.rinha.infraestructure.controllers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rinhaw.com.example.rinha.domain.entities.Cliente;
import rinhaw.com.example.rinha.domain.entities.Saldo;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
