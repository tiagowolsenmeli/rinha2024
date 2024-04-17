package rinhaw.com.example.rinha.infraestructure.controllers.excecoes;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErroResposta {

  private String mensagem;
  private List<String> detalhes;
}
