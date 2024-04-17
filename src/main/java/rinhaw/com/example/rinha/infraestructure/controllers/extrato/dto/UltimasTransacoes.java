package rinhaw.com.example.rinha.infraestructure.controllers.extrato.dto;

import lombok.Data;

@Data
public class UltimasTransacoes {
    private int valor;
    private char tipo;
    private String descricao;
    private String realizadaEm;
}
