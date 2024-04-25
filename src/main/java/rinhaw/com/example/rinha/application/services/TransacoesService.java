package rinhaw.com.example.rinha.application.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rinhaw.com.example.rinha.domain.entities.Cliente;
import rinhaw.com.example.rinha.infraestructure.controllers.repositories.ClienteRepository;

@Service
@AllArgsConstructor
public class TransacoesService {

  private final ClienteRepository clienteRepository;

  public Cliente credito(long clientId, long creditValue){
    Cliente cliente = clienteRepository.findById(clientId).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
    cliente.deposit(creditValue);
    return clienteRepository.save(cliente);
  }

  public Cliente debito (long clientId, long valor){
    Cliente cliente = clienteRepository.findById(clientId).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
    cliente.debit(valor);
    return clienteRepository.save(cliente);
  }
}
