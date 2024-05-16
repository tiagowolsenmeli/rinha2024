package rinhaw.com.example.rinha.infraestructure.excecoes;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
abstract class BusinessException extends RuntimeException {
  private List<String> mensagens;
  private String mensagem;

  public BusinessException(String message) {
    super(message);
  }
}
