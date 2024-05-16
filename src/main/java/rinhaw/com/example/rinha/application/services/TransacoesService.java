package rinhaw.com.example.rinha.application.services;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import rinhaw.com.example.rinha.domain.entities.Cliente;
import rinhaw.com.example.rinha.domain.entities.Transacao;
import rinhaw.com.example.rinha.infraestructure.excecoes.NotFoundRinhaException;
import rinhaw.com.example.rinha.infraestructure.repositories.ClienteRepository;
import rinhaw.com.example.rinha.infraestructure.repositories.TransacaoRepository;

@Service
@AllArgsConstructor
public class TransacoesService {

  private final ClienteRepository clienteRepository;

  private final TransacaoRepository transacaoRepository;

  public Cliente credito(long clientId, long creditValue){
    Cliente cliente = clienteRepository.findById(clientId).orElseThrow(() -> new NotFoundRinhaException("Cliente não encontrado"));
    cliente.deposit(creditValue);
    return clienteRepository.save(cliente);
  }

  public Cliente debito (long clientId, long valor){
    Cliente cliente = clienteRepository.findById(clientId).orElseThrow(() -> new NotFoundRinhaException("Cliente não encontrado"));
    cliente.debit(valor);
    return clienteRepository.save(cliente);
  }

  public List<Transacao> transacoes(final Cliente cliente){
    final Pageable pageable = PageRequest.of(0, 10, Sort.by("realizadaEm"));
    return transacaoRepository.findByCliente(cliente, pageable);
  }
}
