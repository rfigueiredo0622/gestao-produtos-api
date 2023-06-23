package com.example.gestaoprodutosapi.mappers;

import com.example.gestaoprodutosapi.dto.ProdutoDto;
import com.example.gestaoprodutosapi.model.ProdutoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class ProdutoMapper {

    public static final ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "marca", source = "marca")
    @Mapping(target = "qtdeEstoque", source = "qtdeEstoque")
    @Mapping(target = "precoUnitario", source = "precoUnitario")
    public abstract ProdutoEntity mapDtoToEntity(final ProdutoDto source);

    @InheritInverseConfiguration
    public abstract ProdutoDto mapEntityToDto(final ProdutoEntity source);

}
