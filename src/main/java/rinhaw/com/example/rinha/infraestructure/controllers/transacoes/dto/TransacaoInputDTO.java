package rinhaw.com.example.rinha.infraestructure.controllers.transacoes.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TransacaoInputDTO {
  @NotBlank(message = "deve ser um número inteiro positivo que representa centavos (não vamos trabalhar com frações de centavos). Por exemplo, R$ 10 são 1000 centavos.")
  final int valor;
  @NotBlank(message = "deve ser uma string de 1 a 10 caracteres")
  @Max(value = 10, message = "deve ser uma string de 1 a 10 caracteres")
  @Min(value = 1, message = "deve ser uma string de 1 a 10 caracteres")
  final String descricao;
  @NotBlank
  @Max(value = 1, message = "deve ser apenas `c` para crédito ou `d` para débito")
  final char tipo;
}
