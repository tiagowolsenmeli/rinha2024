package rinhaw.com.example.rinha.application.usecases;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rinhaw.com.example.rinha.application.services.ClienteService;
import rinhaw.com.example.rinha.application.services.TransacoesService;
import rinhaw.com.example.rinha.domain.entities.Cliente;
import rinhaw.com.example.rinha.domain.entities.Saldo;
import rinhaw.com.example.rinha.domain.entities.Transacao;
import rinhaw.com.example.rinha.infraestructure.controllers.extrato.dto.ExtratoOutputDTO;

@Service
@AllArgsConstructor
public class ExtratoUseCase {

  private final ClienteService clienteService;
  private final TransacoesService transacoesService;

  public ExtratoOutputDTO execute(Long clientId) {
    final Cliente cliente = clienteService.findCliente(clientId);
    final List<Transacao> transacaoList = transacoesService.transacoes(cliente);
    return createExtratoOutputDTO(cliente, transacaoList);
  }

  private ExtratoOutputDTO createExtratoOutputDTO(final Cliente cliente, final List<Transacao> transacaoList ) {
    final Saldo saldo = cliente.getSaldo();
    return  new ExtratoOutputDTO(saldo, transacaoList);
  }
}