package rinhaw.com.example.rinha.infraestructure.controllers.extrato.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExtratoOutputDTO {
   private Saldo saldo;
   private List<TransacaoOutputExtratoDTO> ultimasTransacoes;
   private char tipo;
}
