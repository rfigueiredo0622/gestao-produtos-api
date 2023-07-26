package com.example.gestaoprodutosapi.service;

import com.example.gestaoprodutosapi.exceptions.ProdutoNaoEncontradoException;
import com.example.gestaoprodutosapi.dto.AvaliacaoProdutoDto;
import com.example.gestaoprodutosapi.dto.ProdutoDto;
import com.example.gestaoprodutosapi.dto.ResultadoConsultaDto;
import com.example.gestaoprodutosapi.model.ProdutoEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProdutoService {
    public ResultadoConsultaDto findAll(Pageable pageable);

    public ProdutoDto findById(String idProduto)  throws ProdutoNaoEncontradoException;

    public void incluir(ProdutoDto produtoDto);

    public void incluirVarios(List<ProdutoEntity> produtos);

    public void excluir(String idProduto);

    public void avaliar(String idProduto, AvaliacaoProdutoDto avaliacao);
}
