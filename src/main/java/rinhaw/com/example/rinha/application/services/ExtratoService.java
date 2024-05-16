package rinhaw.com.example.rinha.application.services;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import rinhaw.com.example.rinha.domain.entities.Cliente;
import rinhaw.com.example.rinha.domain.entities.Transacao;
import rinhaw.com.example.rinha.infraestructure.repositories.TransacaoRepository;

@Service
@AllArgsConstructor
public class ExtratoService {

  private final TransacaoRepository transacaoRepository;

  public List<Transacao> getExtrato(Cliente cliente){
//    final Pageable pageable = Pageable.ofSize(10);
    final Pageable pageable = PageRequest.of(0, 10, Sort.by("realizadaEm"));
//    final Sort sort = Sort.by(Sort.Direction.DESC, "realizadaEm");
    return transacaoRepository.findByCliente(cliente, pageable);
  }
}
