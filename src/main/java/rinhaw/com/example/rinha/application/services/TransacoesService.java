package rinhaw.com.example.rinha.application.services;

import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rinhaw.com.example.rinha.domain.entities.Cliente;
import rinhaw.com.example.rinha.infraestructure.controllers.repositories.ClienteRepository;
import rinhaw.com.example.rinha.infraestructure.controllers.repositories.TransacaoRepository;
import rinhaw.com.example.rinha.infraestructure.controllers.transacoes.dto.TransacaoInputDTO;
import rinhaw.com.example.rinha.infraestructure.controllers.transacoes.dto.TransacaoOutputDTO;

@Service
@AllArgsConstructor
public class TransacoesService {

  private final TransacaoRepository transacaoRepository;
  private final ClienteRepository clienteRepository;

  public TransacaoOutputDTO credito(long clientId, long creditValue){
    Optional<Cliente> cliente = clienteRepository.findById(clientId);
    if (cliente.isPresent()){
      cliente.get().deposit(creditValue);
      clienteRepository.save(cliente.get());
    }
    return new TransacaoOutputDTO(50, 20);
  }

  public TransacaoOutputDTO debito(long clientId, TransacaoInputDTO transacaoInputDTO){
    transacaoRepository.findById(clientId);
    return new TransacaoOutputDTO(10,20);
  }
}
