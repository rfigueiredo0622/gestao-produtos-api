package com.example.gestaoprodutosapi.repository;

import com.example.gestaoprodutosapi.model.AvaliacaoProdutoEntity;
import com.example.gestaoprodutosapi.model.ProdutoEntity;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class ProdutoRepositoryImpl {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void avaliar(String idProduto, AvaliacaoProdutoEntity avaliacao) {

        mongoTemplate.updateFirst(
                Query.query(Criteria.where("_id").is(idProduto)),
                new Update().push("avaliacoes", avaliacao),
                ProdutoEntity.class);

    }
}
