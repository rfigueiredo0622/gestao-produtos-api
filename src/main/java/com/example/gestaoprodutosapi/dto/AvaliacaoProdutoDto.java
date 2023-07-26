package com.example.gestaoprodutosapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AvaliacaoProdutoDto {

    @JsonProperty("idAvaliacaoProduto")
    private String idAvaliacaoProduto;

    @JsonProperty("notaAvaliacaoProduto")
    private long notaAvaliacaoProduto;

    @JsonProperty("comentarioAvaliacaoProduto")
    private String comentarioAvaliacaoProduto;
}
