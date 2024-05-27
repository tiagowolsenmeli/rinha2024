package rinhaw.com.example.rinha.infraestructure.controllers.extrato.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import rinhaw.com.example.rinha.domain.entities.Transacao;

@Data
public class ExtratoUltimasTransacoesOutputDTO {

  private long valor;
  private char tipo;
  private String descricao;
  private LocalDateTime realizadaEm;

  public ExtratoUltimasTransacoesOutputDTO (Transacao transacao) {
    this.valor = transacao.getValor();
    this.tipo = transacao.getTipo();
    this.descricao = transacao.getDescricao();
    this.realizadaEm = transacao.getRealizadaEm();
  }

  public static List<ExtratoUltimasTransacoesOutputDTO> extratoUltimasTransacoesOutputDTOList (List<Transacao> transacaoList) {
    List<ExtratoUltimasTransacoesOutputDTO> extratoUltimasTransacoesOutputDTOList = new ArrayList<>();
    transacaoList.forEach(
        transacao ->  extratoUltimasTransacoesOutputDTOList.add( new ExtratoUltimasTransacoesOutputDTO(transacao))
    );
    return extratoUltimasTransacoesOutputDTOList;
  }
}
