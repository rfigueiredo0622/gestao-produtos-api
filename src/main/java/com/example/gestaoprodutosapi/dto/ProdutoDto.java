package com.example.gestaoprodutosapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProdutoDto {

    @JsonProperty("idProduto")
    private String id;
    @JsonProperty("nomeProduto")
    private String nome;
    @JsonProperty("marcaProduto")
    private String marca;
    @JsonProperty("qtdeEstoqueProduto")
    private Integer qtdeEstoque;
    @JsonProperty("precoUnitarioProduto")
    private Double precoUnitario;

}
