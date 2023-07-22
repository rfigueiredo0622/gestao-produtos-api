package com.example.gestaoprodutosapi.model;

import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class AvaliacaoProdutoEntity {

    @Id
    private String idAvaliacaoProduto = UUID.randomUUID().toString();
    private long notaAvaliacaoProduto;
    private String comentarioAvaliacaoProduto;
}
