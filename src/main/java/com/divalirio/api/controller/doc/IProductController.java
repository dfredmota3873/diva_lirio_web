package com.divalirio.api.controller.doc;

import com.divalirio.api.dto.AddressDTO;
import com.divalirio.api.dto.CreateAddressDTORequest;
import com.divalirio.api.dto.CreateProductDTORequest;
import com.divalirio.api.dto.ProductDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Api de Produtos")
public interface IProductController {

    @Operation(summary = "Salva um novo Produto", description = "Realiza o cadastro de um novo produto")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Caso o produto seja cadastrado com sucesso."
            )
    })
    @PostMapping(value = "/create")
    ResponseEntity<ProductDTO> create(@Valid @RequestBody CreateProductDTORequest dtoRequest);

    @Operation(summary = "Lista todos os produtos")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Caso a consulta seja efetuada com sucesso."
            )
    })
    @GetMapping(value = "/findAll")
    ResponseEntity<List<ProductDTO>> findAll();

    @Operation(summary = "Realiza a atualização de um produto")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Caso os dados sejam atualizados com sucesso!"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Caso o ID enviado na URL não seja de nenhum produto."
            ),
    })
    @PutMapping(value = "/update/{id}")
    ResponseEntity<ProductDTO> update(@PathVariable(name = "id") UUID id, @Valid @RequestBody CreateProductDTORequest productRequest);


    @Operation(summary = "Lista um produto por id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Caso a consulta seja efetuada com sucesso."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Caso o ID enviado na URL não seja de nenhum produto válido."
            ),
    })
    @GetMapping(value = "/findById/{id}")
    ResponseEntity<ProductDTO> findById(@PathVariable(name = "id") UUID id);


    @Operation(summary = "Deleta um produto por id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Caso o produto seja deletado com sucesso."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Caso o ID enviado na URL não seja de nenhum produto."
            )
    })
    @DeleteMapping(value = "/{id}")
    ResponseEntity<String> deleteById(@PathVariable(name = "id") UUID id);

}
