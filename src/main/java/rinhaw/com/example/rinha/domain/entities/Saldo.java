package rinhaw.com.example.rinha.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

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
      throw new IllegalArgumentException("Saldo Exception");
    }
  }

  public void debit(Long valorDeDebito) {
    if (saldoFinal(valorDeDebito) + limite < 0){
      throw new IllegalArgumentException("Saldo e limite insuficientes");
    }
    if (valorDeDebito > 0){
      saldo -= valorDeDebito;
    }else {
      throw new IllegalArgumentException("Valor de debito não pode ser negativo");
    }
  }

  private long saldoFinal(Long valorDeDebito) {
    return saldo - valorDeDebito;
  }

}
