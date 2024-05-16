package rinhaw.com.example.rinha.application.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rinhaw.com.example.rinha.domain.entities.Cliente;
import rinhaw.com.example.rinha.infraestructure.repositories.ClienteRepository;

@Service
@AllArgsConstructor
public class ClienteService {

  private final ClienteRepository clienteRepository;

  public Cliente findCliente(Long clientId){
    return  clienteRepository.findById(clientId).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
  }
}
