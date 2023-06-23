package com.example.gestaoprodutosapi.service;

import com.example.gestaoprodutosapi.model.ProdutoEntity;
import com.example.gestaoprodutosapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Page<ProdutoEntity> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void incluir(ProdutoEntity produto) {
        repository.save(produto);
    }
}
