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
}
