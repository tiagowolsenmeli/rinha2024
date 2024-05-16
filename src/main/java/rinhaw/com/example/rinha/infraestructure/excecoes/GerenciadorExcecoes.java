package rinhaw.com.example.rinha.infraestructure.excecoes;

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

  @ExceptionHandler(InputValidationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ErroResposta> inputValidationBadRequestException(SaldoInconsistenceException e) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new ErroResposta(Mensagem.PROBLEMA_DADOS_REQUISICAO, List.of(e.getMessage())));
  }

  @ExceptionHandler(InvalidClientException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<Object> invalidClientIdException(SaldoInconsistenceException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new ErroResposta(Mensagem.PROBLEMA_DADOS_REQUISICAO, List.of(e.getMessage())));
  }

  @ExceptionHandler(NotFoundRinhaException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<Object> notFoundRinhaExcpetion(NotFoundRinhaException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new ErroResposta(Mensagem.PROBLEMA_DADOS_REQUISICAO, List.of(e.getMessage())));
  }
}
