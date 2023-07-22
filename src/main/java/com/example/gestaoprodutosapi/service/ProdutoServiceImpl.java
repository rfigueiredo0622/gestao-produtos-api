package com.example.gestaoprodutosapi.service;

import com.example.gestaoprodutosapi.exceptions.ProdutoNaoEncontradoException;
import com.example.gestaoprodutosapi.dto.AvaliacaoProdutoDto;
import com.example.gestaoprodutosapi.dto.ProdutoDto;
import com.example.gestaoprodutosapi.dto.ResultadoConsultaDto;
import com.example.gestaoprodutosapi.mappers.AvaliacaoProdutoMapper;
import com.example.gestaoprodutosapi.mappers.ProdutoMapper;
import com.example.gestaoprodutosapi.model.AvaliacaoProdutoEntity;
import com.example.gestaoprodutosapi.model.ProdutoEntity;
import com.example.gestaoprodutosapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public ResultadoConsultaDto findAll(Pageable pageable) {

        Page<ProdutoEntity> pageResult = repository.findAll(pageable);

        ResultadoConsultaDto pagina = new ResultadoConsultaDto();

        List<ProdutoDto> produtos = new ArrayList<ProdutoDto>();

        if(!pageResult.isEmpty()) {
            pageResult.getContent().forEach(
                    entity -> produtos.add(ProdutoMapper.INSTANCE.mapEntityToDto(entity))
            );


            pagina.setProdutos(produtos);
            pagina.getPaginacao().setCurrentPage(pageResult.getNumber());
            pagina.getPaginacao().setTotalItems(pageResult.getTotalElements());
            pagina.getPaginacao().setTotalPages(pageResult.getTotalPages());
        }
        return pagina;
    }

    public ProdutoDto findById(String idProduto) throws ProdutoNaoEncontradoException {

        Optional<ProdutoEntity> optional = repository.findById(idProduto);

        ProdutoDto produtoDto = new ProdutoDto();

        if(!optional.isEmpty()) {
            produtoDto = ProdutoMapper.INSTANCE.mapEntityToDto(optional.get());
        } else {
            optional.orElseThrow(ProdutoNaoEncontradoException::new);
        }

        return produtoDto;

    }

    public void incluir(ProdutoDto produtoDto) {
        ProdutoEntity produto = ProdutoMapper.INSTANCE.mapDtoToEntity(produtoDto);
        repository.save(produto);
    }

    public void excluir(String idProduto) {
        repository.deleteById(idProduto);
    }

    public void avaliar(String idProduto, AvaliacaoProdutoDto avaliacao) {
        try {
            AvaliacaoProdutoEntity avaliacaoEntity = AvaliacaoProdutoMapper.INSTANCE.mapDtoToEntity(avaliacao);

            //Inclui uma nova avaliação à lista de avaliações do produto sem recuperar o produto.
            repository.avaliar(idProduto, avaliacaoEntity);

            //Recupera o produto, adiciona a avaliação na lista de avaliações do produto e atualiza o produto inteiro.
//            ProdutoDto produtoDto = this.findById(idProduto);
//            ProdutoEntity produtoEntity = ProdutoMapper.INSTANCE.mapDtoToEntity(produtoDto);
//            produtoEntity.getAvaliacoes().add(avaliacaoEntity);
//            repository.save(produtoEntity);

        } catch (Exception e) {

        }
    }

}
