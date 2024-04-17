package rinhaw.com.example.rinha.infraestructure.controllers.extrato;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rinhaw.com.example.rinha.infraestructure.controllers.extrato.dto.ExtratoInputDTO;
import rinhaw.com.example.rinha.infraestructure.controllers.extrato.dto.ExtratoOutputDTO;

@RestController
@RequestMapping("/clientes")
public class ExtratoController {

  @PostMapping("/{id}/extrato")
  public ExtratoOutputDTO transacoes(@RequestBody ExtratoInputDTO transacaoInputDTO) {
    return  new ExtratoOutputDTO();
  }
}
