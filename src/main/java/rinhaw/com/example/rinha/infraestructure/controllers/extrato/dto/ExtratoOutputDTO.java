package rinhaw.com.example.rinha.infraestructure.controllers.extrato.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rinhaw.com.example.rinha.domain.entities.Saldo;
import rinhaw.com.example.rinha.domain.entities.Transacao;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExtratoOutputDTO {
   private ExtratoSaldoOutputDTO saldo;
   private List<ExtratoUltimasTransacoesOutputDTO> ultimasTransacoes;

   public ExtratoOutputDTO(final Saldo saldo, final List<Transacao> transacaoList) {
      this.saldo = new ExtratoSaldoOutputDTO(saldo);
      this.ultimasTransacoes = ExtratoUltimasTransacoesOutputDTO.extratoUltimasTransacoesOutputDTOList(transacaoList);
   }
}