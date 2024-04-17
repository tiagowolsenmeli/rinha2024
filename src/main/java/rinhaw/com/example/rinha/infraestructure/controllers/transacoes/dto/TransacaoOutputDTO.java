package rinhaw.com.example.rinha.infraestructure.controllers.transacoes.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoOutputDTO {
   BigDecimal saldo;
   BigDecimal limite;
}