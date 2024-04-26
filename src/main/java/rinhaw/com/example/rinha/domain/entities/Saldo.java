package rinhaw.com.example.rinha.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import rinhaw.com.example.rinha.infraestructure.controllers.excecoes.SaldoInconsistenceException;

@Entity
@Data
@NoArgsConstructor
public class Saldo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private long saldo;
  private long limite;

  public void deposit(Long valor) {
    if (valor > 0){
      saldo += valor;
    }else {
      throw new SaldoInconsistenceException("Saldo Exception");
    }
  }

  public void debit(Long valorDeDebito) {
    if (valorDeDebito <= 0){
      throw new SaldoInconsistenceException("Valor de debito não pode ser negativo ou zero");
    }
    if (saldoFinal(valorDeDebito) + limite < 0){
      throw new SaldoInconsistenceException("Saldo e limite insuficientes");
    }
    if (valorDeDebito > 0){
      saldo -= valorDeDebito;
    }
  }

  private long saldoFinal(Long valorDeDebito) {
    return saldo - valorDeDebito;
  }

}
