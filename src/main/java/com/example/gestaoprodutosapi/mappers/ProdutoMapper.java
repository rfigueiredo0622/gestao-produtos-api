package com.example.gestaoprodutosapi.mappers;

import com.example.gestaoprodutosapi.dto.AvaliacaoProdutoDto;
import com.example.gestaoprodutosapi.dto.ProdutoDto;
import com.example.gestaoprodutosapi.model.AvaliacaoProdutoEntity;
import com.example.gestaoprodutosapi.model.ProdutoEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {
        FabricanteProdutoMapper.class,
        AvaliacaoProdutoMapper.class
})
public abstract class ProdutoMapper {

    public static final ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "qtdeEstoque", source = "qtdeEstoque")
    @Mapping(target = "data", source = "data")
    @Mapping(target = "precoUnitario", source = "precoUnitario")
    @Mapping(target = "avaliacoes", source = "avaliacoes")
    @Mapping(target = "fabricante.nomeFabricanteProduto", source = "fabricante.nomeFabricanteProduto")
    public abstract ProdutoEntity mapDtoToEntity(final ProdutoDto source);

    @InheritInverseConfiguration
    public abstract ProdutoDto mapEntityToDto(final ProdutoEntity source);

}
