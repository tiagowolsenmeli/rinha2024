package rinhaw.com.example.rinha.application.usecases;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rinhaw.com.example.rinha.application.services.SaldoService;
import rinhaw.com.example.rinha.application.services.TransacoesService;
import rinhaw.com.example.rinha.infraestructure.controllers.excecoes.DadosInvalidosException;
import rinhaw.com.example.rinha.infraestructure.controllers.transacoes.dto.TransacaoInputDTO;
import rinhaw.com.example.rinha.infraestructure.controllers.transacoes.dto.TransacaoOutputDTO;

@Service
@AllArgsConstructor
public class TransacaoUseCase {

  private final TransacoesService transacoesService;
  private final SaldoService saldoService;

  public TransacaoOutputDTO execute(long clientId, TransacaoInputDTO transacaoInputDTO) {

    switch (transacaoInputDTO.getTipo()){
      case 'c':
        return applyTransactionCreditAndReturnResult(clientId, transacaoInputDTO);
      case 'd':
        return applyTrasactionDebitAndReturnResult(clientId, transacaoInputDTO);
      default:
            throw new DadosInvalidosException(List.of("erro1", "erro2"));
    }
  }

  private TransacaoOutputDTO applyTrasactionDebitAndReturnResult(long clientId, TransacaoInputDTO transacaoInputDTO) {
    saldoService.getSaldo(clientId);
    return transacoesService.debito(clientId, transacaoInputDTO);
  }

  private TransacaoOutputDTO applyTransactionCreditAndReturnResult(long clientId, TransacaoInputDTO transacaoInputDTO) {
    long valor = transacaoInputDTO.getValor();
    return transacoesService.credito(clientId, valor);
  }
}