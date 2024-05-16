package rinhaw.com.example.rinha.infraestructure.excecoes;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvalidClientException extends RuntimeException {

  private String mensagem;
  private List<String> detalhes;
}
