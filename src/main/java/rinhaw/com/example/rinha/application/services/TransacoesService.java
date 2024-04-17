package rinhaw.com.example.rinha.application.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rinhaw.com.example.rinha.infraestructure.controllers.repositories.TransacaoRepository;
import rinhaw.com.example.rinha.infraestructure.controllers.transacoes.dto.TransacaoInputDTO;
import rinhaw.com.example.rinha.infraestructure.controllers.transacoes.dto.TransacaoOutputDTO;

@Service
@AllArgsConstructor
public class TransacoesService {

  private final TransacaoRepository transacaoRepository;

  public TransacaoOutputDTO credito(TransacaoInputDTO transacaoInputDTO){
    return new TransacaoOutputDTO();
  }

  public TransacaoOutputDTO debito(TransacaoInputDTO transacaoInputDTO){
    return new TransacaoOutputDTO();
  }
}
