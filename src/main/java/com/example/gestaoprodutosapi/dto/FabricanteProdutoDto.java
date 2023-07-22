package com.example.gestaoprodutosapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FabricanteProdutoDto {

    @JsonProperty("nomeFabricanteProduto")
    private String nomeFabricanteProduto;

}
