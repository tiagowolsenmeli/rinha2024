package rinhaw.com.example.rinha.application.usecases;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rinhaw.com.example.rinha.application.services.TransacoesService;
import rinhaw.com.example.rinha.domain.entities.Cliente;
import rinhaw.com.example.rinha.infraestructure.excecoes.DadosInvalidosException;
import rinhaw.com.example.rinha.infraestructure.controllers.transacoes.dto.TransacaoInputDTO;
import rinhaw.com.example.rinha.infraestructure.controllers.transacoes.dto.TransacaoOutputDTO;

@Service
@AllArgsConstructor
public class TransacaoUseCase {

  private final TransacoesService transacoesService;

  public TransacaoOutputDTO execute(long clientId, TransacaoInputDTO transacaoInputDTO) {

    switch (transacaoInputDTO.getTipo()){
      case 'c':
        return applyTransactionCreditAndReturnResult(clientId, transacaoInputDTO);
      case 'd':
        return applyTrasactionDebitAndReturnResult(clientId, transacaoInputDTO);
      default:
            throw new DadosInvalidosException(List.of("Tipo deve ser 'c' ou 'd)"));
    }
  }

  private TransacaoOutputDTO applyTrasactionDebitAndReturnResult(long clientId, TransacaoInputDTO transacaoInputDTO) {
    final long valor = transacaoInputDTO.getValor();
    final String descricao = transacaoInputDTO.getDescricao();
    final Cliente cliente = transacoesService.debito(clientId, valor, descricao);
    return getTransacaoOutputDTO(cliente);
  }

  private TransacaoOutputDTO applyTransactionCreditAndReturnResult(long clientId, TransacaoInputDTO transacaoInputDTO) {
    final long valor = transacaoInputDTO.getValor();
    final String descricao = transacaoInputDTO.getDescricao();
    final Cliente cliente = transacoesService.credito(clientId, valor, descricao);
    return getTransacaoOutputDTO(cliente);
  }

  private static TransacaoOutputDTO getTransacaoOutputDTO(Cliente cliente) {
    return new TransacaoOutputDTO(cliente);
  }
}