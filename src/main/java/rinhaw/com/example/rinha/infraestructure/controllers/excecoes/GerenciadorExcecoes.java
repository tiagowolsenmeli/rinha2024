package rinhaw.com.example.rinha.infraestructure.controllers.excecoes;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GerenciadorExcecoes {

  @ExceptionHandler(DadosInvalidosException.class)
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  public ResponseEntity<ErroResposta> trataDadosInvalidosException(DadosInvalidosException e) {
    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
        .body(new ErroResposta(Mensagem.PROBLEMA_DADOS_REQUISICAO, e.getMensagens()));
  }

  @ExceptionHandler(SaldoInconsistenceException.class)
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  public ResponseEntity<ErroResposta> trataDadosInvalidosException(SaldoInconsistenceException e) {
    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
        .body(new ErroResposta(Mensagem.PROBLEMA_DADOS_REQUISICAO, List.of(e.getMessage())));
  }
}
