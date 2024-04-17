package rinhaw.com.example.rinha.application.usecases;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rinhaw.com.example.rinha.application.services.TransacoesService;
import rinhaw.com.example.rinha.infraestructure.controllers.excecoes.DadosInvalidosException;
import rinhaw.com.example.rinha.infraestructure.controllers.transacoes.dto.TransacaoInputDTO;
import rinhaw.com.example.rinha.infraestructure.controllers.transacoes.dto.TransacaoOutputDTO;

@Service
@AllArgsConstructor
public class TransacaoUseCase {

  private final TransacoesService transacoesService;
  public TransacaoOutputDTO execute(TransacaoInputDTO transacaoInputDTO) {

    switch (transacaoInputDTO.getTipo()){
      case 'c':
        return transacoesService.credito(transacaoInputDTO);
      case 'd':
        return transacoesService.debito(transacaoInputDTO);
      default:
            throw new DadosInvalidosException(List.of("erro1", "erro2"));

    }
  }
}