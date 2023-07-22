package com.example.gestaoprodutosapi.mappers;

import com.example.gestaoprodutosapi.dto.AvaliacaoProdutoDto;
import com.example.gestaoprodutosapi.model.AvaliacaoProdutoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class AvaliacaoProdutoMapper {

    public static final AvaliacaoProdutoMapper INSTANCE = Mappers.getMapper(AvaliacaoProdutoMapper.class);

    @Mapping(target = "idAvaliacaoProduto", source = "idAvaliacaoProduto")
    @Mapping(target = "notaAvaliacaoProduto", source = "notaAvaliacaoProduto")
    @Mapping(target = "comentarioAvaliacaoProduto", source = "comentarioAvaliacaoProduto")
    public abstract AvaliacaoProdutoEntity mapDtoToEntity(final AvaliacaoProdutoDto source);

    @InheritInverseConfiguration
    public abstract AvaliacaoProdutoDto mapEntityToDto(final AvaliacaoProdutoEntity source);

}
