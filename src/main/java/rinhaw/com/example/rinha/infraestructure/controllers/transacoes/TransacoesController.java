package rinhaw.com.example.rinha.infraestructure.controllers.transacoes;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rinhaw.com.example.rinha.application.usecases.TransacaoUseCase;
import rinhaw.com.example.rinha.application.validators.InputValidator;
import rinhaw.com.example.rinha.infraestructure.controllers.transacoes.dto.TransacaoInputDTO;
import rinhaw.com.example.rinha.infraestructure.controllers.transacoes.dto.TransacaoOutputDTO;

@RestController
@RequestMapping("/clientes")
@Validated
@AllArgsConstructor
public class TransacoesController {

  private final  TransacaoUseCase transacaoUseCase;
  private final InputValidator inputValidator;

  @PostMapping("/{clientId}/transacoes")
    public ResponseEntity<TransacaoOutputDTO> transacoesController(@RequestBody @Validated TransacaoInputDTO transacaoInputDTO,
                                                         @PathVariable long clientId) {
      validInputs(clientId);
      return ResponseEntity.ok(transacaoUseCase.execute(clientId, transacaoInputDTO));
  }

  private void validInputs(Long clientId) {
    inputValidator.validInputs(clientId);
  }
}
