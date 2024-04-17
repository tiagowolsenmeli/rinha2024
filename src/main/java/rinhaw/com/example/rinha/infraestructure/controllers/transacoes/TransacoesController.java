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
import rinhaw.com.example.rinha.infraestructure.controllers.transacoes.dto.TransacaoInputDTO;
import rinhaw.com.example.rinha.infraestructure.controllers.transacoes.dto.TransacaoOutputDTO;

@RestController
@RequestMapping("/clientes")
@Validated
@AllArgsConstructor
public class TransacoesController {

  private final  TransacaoUseCase transacaoUseCase;

  @PostMapping("/{id}/transacoes")
    public ResponseEntity<TransacaoOutputDTO> transacoes(@RequestBody TransacaoInputDTO transacaoInputDTO, @PathVariable Long id) {

    return ResponseEntity.ok(transacaoUseCase.execute(transacaoInputDTO));
//    throw new DadosInvalidosException(List.of("erro1", "erro2"));
  }
}
