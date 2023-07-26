package com.example.gestaoprodutosapi.dto;

import com.example.gestaoprodutosapi.model.AvaliacaoProdutoEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProdutoDto {

    @JsonProperty("idProduto")
    private String id;

    @JsonProperty("nomeProduto")
    private String nome;

    @JsonProperty("data")
    private String data;

    @JsonProperty("qtdeEstoqueProduto")
    private Integer qtdeEstoque;

    @JsonProperty("precoUnitarioProduto")
    private Double precoUnitario;

    @JsonProperty("fabricanteProduto")
    private FabricanteProdutoDto fabricante;

    @JsonProperty("avaliacoesProduto")
    private List<AvaliacaoProdutoDto> avaliacoes = new ArrayList<>();


}
