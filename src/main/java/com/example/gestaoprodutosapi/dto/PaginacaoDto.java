package com.example.gestaoprodutosapi.dto;

import lombok.Data;

@Data
public class PaginacaoDto {

    private int currentPage;
    private int totalPages;
    private long totalItems;

}
