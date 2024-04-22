package rinhaw.com.example.rinha.infraestructure.controllers.transacoes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoOutputDTO {
   long saldo;
   long limite;
}
