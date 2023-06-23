package com.example.gestaoprodutosapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "produto")
public class ProdutoEntity {

    @Id
    private String id;
    private String nome;
    private String marca;
    private Integer qtdeEstoque;
    private Double precoUnitario;
}
