package rinhaw.com.example.rinha.application.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rinhaw.com.example.rinha.domain.entities.Saldo;
import rinhaw.com.example.rinha.infraestructure.controllers.repositories.SaldoRepository;
import rinhaw.com.example.rinha.infraestructure.controllers.repositories.TransacaoRepository;
import rinhaw.com.example.rinha.infraestructure.controllers.transacoes.dto.TransacaoInputDTO;
import rinhaw.com.example.rinha.infraestructure.controllers.transacoes.dto.TransacaoOutputDTO;

@Service
@AllArgsConstructor
public class SaldoService {

  private final SaldoRepository saldoRepository;

  public Saldo getSaldo(long clientId){
    return new Saldo();
  }
}
