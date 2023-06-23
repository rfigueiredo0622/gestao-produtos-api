package com.example.gestaoprodutosapi.repository;


import com.example.gestaoprodutosapi.model.ProdutoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends MongoRepository<ProdutoEntity, String> {

    public Page<ProdutoEntity> findAll(Pageable pageable);
}
