package rinhaw.com.example.rinha.infraestructure.excecoes;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SaldoInconsistenceException extends RuntimeException {
  public SaldoInconsistenceException(String message) {
    super(message);
  }

  public SaldoInconsistenceException(String message, Throwable cause) {
    super(message, cause);
  }
}
