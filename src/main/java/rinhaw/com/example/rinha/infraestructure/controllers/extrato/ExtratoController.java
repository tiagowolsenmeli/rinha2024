package rinhaw.com.example.rinha.infraestructure.controllers.extrato;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rinhaw.com.example.rinha.application.usecases.ExtratoUseCase;
import rinhaw.com.example.rinha.infraestructure.controllers.extrato.dto.ExtratoOutputDTO;
import rinhaw.com.example.rinha.infraestructure.excecoes.InvalidClientException;
import rinhaw.com.example.rinha.application.validators.InputValidator;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ExtratoController {

  private final ExtratoUseCase extratoUseCase;
  private final InputValidator inputValidator;

  @GetMapping("/{clienteId}/extrato")
  public ExtratoOutputDTO transacoes(@PathVariable Long clienteId) {

      validInputs(clienteId);
      return  extratoUseCase.execute(clienteId);
  }
  private void validInputs(Long clientId) {
    inputValidator.validInputs(clientId);
  }
}
