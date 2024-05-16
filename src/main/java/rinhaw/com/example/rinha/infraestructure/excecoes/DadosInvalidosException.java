package rinhaw.com.example.rinha.infraestructure.excecoes;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DadosInvalidosException extends BusinessException {
  private List<String> mensagens;

  @Override
  public String getMessage() {
    if (this.mensagens == null) {
      return "";
    }
    return String.join("|", this.mensagens);
  }
}
