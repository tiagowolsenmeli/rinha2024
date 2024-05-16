package rinhaw.com.example.rinha.infraestructure.excecoes;


public abstract class Mensagem {

  public static final String SUCESSO = "Operação bem-sucedida!";
  public static final String ERRO = "Houve erro no processamento da operação.";

  public static final String PROBLEMA_DADOS_REQUISICAO = "Não foi possível processar a operação devido a problemas " +
      "nos dados informados. ";

  public static final String DADOS_NAO_LOCALIZADOS = "Dados não localizados.";
}
