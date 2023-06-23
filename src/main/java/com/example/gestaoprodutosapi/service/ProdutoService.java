package com.example.gestaoprodutosapi.service;

import com.example.gestaoprodutosapi.model.ProdutoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoService {
    public Page<ProdutoEntity> findAll(Pageable pageable);
    public void incluir(ProdutoEntity produto);
}
