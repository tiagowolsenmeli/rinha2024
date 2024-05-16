package rinhaw.com.example.rinha.infraestructure.controllers.extrato.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rinhaw.com.example.rinha.domain.entities.Saldo;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExtratoSaldoOutputDTO {
   private long total;
   private LocalDateTime dataExtrato;
   private long limite;

   public ExtratoSaldoOutputDTO(final Saldo saldo){
      this.total = saldo.getSaldo();
      this.dataExtrato = LocalDateTime.now();
      this.limite = saldo.getLimite();
   }
}
