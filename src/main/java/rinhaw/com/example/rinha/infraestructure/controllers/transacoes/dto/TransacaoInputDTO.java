package rinhaw.com.example.rinha.infraestructure.controllers.transacoes.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TransacaoInputDTO {
  @NotNull(message = "deve ser um número inteiro positivo que representa centavos (não vamos trabalhar com frações de centavos). Por exemplo, R$ 10 são 1000 centavos.")
  final Integer valor;

  @NotBlank(message = "deve ser uma string de 1 a 10 caracteres")
  final String descricao;

  @NotNull
  final Character tipo;
}