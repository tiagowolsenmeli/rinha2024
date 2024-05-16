package rinhaw.com.example.rinha.application.validators;

import java.util.List;
import org.springframework.stereotype.Service;
import rinhaw.com.example.rinha.infraestructure.excecoes.InvalidClientException;

@Service
public class InputValidator {

  public void validInputs(Long clientId) {
    if (clientId<=0){
      throw new InvalidClientException("Dados inválidos", List.of("id do Cliente Inválido"));
    }
  }
}
