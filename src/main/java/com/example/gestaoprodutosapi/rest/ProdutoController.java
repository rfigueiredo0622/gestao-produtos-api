package com.example.gestaoprodutosapi.rest;

import com.example.gestaoprodutosapi.exceptions.ProdutoNaoEncontradoException;
import com.example.gestaoprodutosapi.dto.AvaliacaoProdutoDto;
import com.example.gestaoprodutosapi.dto.ProdutoDto;
import com.example.gestaoprodutosapi.dto.ResultadoConsultaDto;
import com.example.gestaoprodutosapi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @GetMapping
    public ResponseEntity<ResultadoConsultaDto> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int pageSize
    ) {
        try {
            Pageable pageable = PageRequest.of(page, pageSize);
            ResultadoConsultaDto pagina = service.findAll(pageable);

            if ( pagina.getProdutos().isEmpty() ) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(pagina, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{idProduto}")
    public ResponseEntity<ProdutoDto> findById(@PathVariable final String idProduto) {
        try {
            ProdutoDto produto = service.findById(idProduto);
            return new ResponseEntity<>(produto, HttpStatus.OK);
        } catch (ProdutoNaoEncontradoException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity inserir(@RequestBody final ProdutoDto produtoDto) {
        try {
            service.incluir(produtoDto);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{idProduto}")
    public ResponseEntity excluir(@PathVariable final String idProduto) {
        try {
            service.excluir(idProduto);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PatchMapping("/{idProduto}/avaliar")
    public ResponseEntity avaliar(@PathVariable String idProduto,
                                  @RequestBody final AvaliacaoProdutoDto avaliacaoProdutoDto) {
        try {
//            System.out.println("idProduto = " + idProduto + ", ProdutoDto = " + ProdutoDto);
            service.avaliar(idProduto, avaliacaoProdutoDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
