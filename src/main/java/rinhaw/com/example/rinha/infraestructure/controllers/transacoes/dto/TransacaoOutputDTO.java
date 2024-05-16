package rinhaw.com.example.rinha.infraestructure.controllers.transacoes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rinhaw.com.example.rinha.domain.entities.Cliente;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoOutputDTO {
   long saldo;
   long limite;

   public TransacaoOutputDTO(Cliente cliente) {
      this.saldo = cliente.getSaldo().getSaldo();
      this.limite = cliente.getSaldo().getLimite();
   }
}
