package rinhaw.com.example.rinha.application.services;

import java.time.LocalDateTime;
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

  private final char TYPE_CREDIT = 'c';
  private final char TYPE_DEBIT = 'd';

  public Cliente credito(final long clientId, final long creditValue, final String descricao ){
    Cliente cliente = clienteRepository.findById(clientId).orElseThrow(() -> new NotFoundRinhaException("Cliente não encontrado"));
    cliente.deposit(creditValue);
    Transacao transacao = new Transacao(null, creditValue,descricao, TYPE_CREDIT, LocalDateTime.now(), cliente);
    transacaoRepository.save(transacao);
    return clienteRepository.save(cliente);
  }

  public Cliente debito (long clientId, long debitValue, String descricao){
    Cliente cliente = clienteRepository.findById(clientId).orElseThrow(() -> new NotFoundRinhaException("Cliente não encontrado"));
    cliente.debit(debitValue);
    Transacao transacao = new Transacao(null, debitValue,descricao, TYPE_DEBIT, LocalDateTime.now(), cliente);
    transacaoRepository.save(transacao);
    return clienteRepository.save(cliente);
  }

  public List<Transacao> transacoes(final Cliente cliente){
    final Pageable pageable = PageRequest.of(0, 10, Sort.by("realizadaEm"));
    return transacaoRepository.findByCliente(cliente, pageable);
  }
}
