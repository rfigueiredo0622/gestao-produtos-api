package com.example.gestaoprodutosapi.rest;

import com.example.gestaoprodutosapi.dto.ProdutoDto;
import com.example.gestaoprodutosapi.mappers.ProdutoMapper;
import com.example.gestaoprodutosapi.model.ProdutoEntity;
import com.example.gestaoprodutosapi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getProdutos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int pageSize
    ) {
        try {
            Pageable pageable = PageRequest.of(page, pageSize);
            Page<ProdutoEntity> pageResult = service.findAll(pageable);

            if (pageResult.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            List<ProdutoDto> produtos = new ArrayList<ProdutoDto>();

            pageResult.getContent().forEach(
                    entity -> produtos.add(ProdutoMapper.INSTANCE.mapEntityToDto(entity))
            );

            Map<String, Object> response = new HashMap<>();
            response.put("produtos", produtos);
            response.put("currentPage", pageResult.getNumber());
            response.put("totalItems", pageResult.getTotalElements());
            response.put("totalPages", pageResult.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity inserir(@RequestBody final ProdutoDto produtoDto) {
        try {
            ProdutoEntity produto = ProdutoMapper.INSTANCE.mapDtoToEntity(produtoDto);
            service.incluir(produto);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
