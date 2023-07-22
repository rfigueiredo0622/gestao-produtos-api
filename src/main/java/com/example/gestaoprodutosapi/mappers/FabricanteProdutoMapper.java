package com.example.gestaoprodutosapi.mappers;

import com.example.gestaoprodutosapi.dto.FabricanteProdutoDto;
import com.example.gestaoprodutosapi.model.FabricanteProdutoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class FabricanteProdutoMapper {

    public static final FabricanteProdutoMapper INSTANCE = Mappers.getMapper(FabricanteProdutoMapper.class);


    @Mapping(target = "nomeFabricanteProduto", source = "nomeFabricanteProduto")
    public abstract FabricanteProdutoEntity mapDtoToEntity(final FabricanteProdutoDto source);

    @InheritInverseConfiguration
    public abstract FabricanteProdutoDto mapEntityToDto(final FabricanteProdutoEntity source);

}
