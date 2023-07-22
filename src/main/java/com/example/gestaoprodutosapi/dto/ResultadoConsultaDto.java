package com.example.gestaoprodutosapi.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResultadoConsultaDto {

    private List<ProdutoDto> produtos = new ArrayList<>();
    private PaginacaoDto paginacao = new PaginacaoDto();

}
