package com.example.gestaoprodutosapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@EqualsAndHashCode
@Document(collection = "produtos")
public class ProdutoEntity {

    @Id
    private String id = UUID.randomUUID().toString();
    private String nome;
    private String data;
    private Integer qtdeEstoque;
    private Double precoUnitario;

    private FabricanteProdutoEntity fabricante;
    private List<AvaliacaoProdutoEntity> avaliacoes = new ArrayList<>();
}
