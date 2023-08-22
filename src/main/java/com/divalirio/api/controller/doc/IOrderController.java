package com.divalirio.api.controller.doc;

import com.divalirio.api.dto.CreateOrderDTORequest;
import com.divalirio.api.dto.CreateProductDTORequest;
import com.divalirio.api.dto.OrderDTO;
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

@Tag(name = "Api de Ordens")
public interface IOrderController {

    @Operation(summary = "Salva um nova Order", description = "Realiza o cadastro de um nova order")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Caso a ordem seja cadastrado com sucesso."
            )
    })
    @PostMapping(value = "/create")
    ResponseEntity<OrderDTO> create(@RequestBody CreateOrderDTORequest dtoRequest);

    @Operation(summary = "Lista todos as ordens")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Caso a consulta seja efetuada com sucesso."
            )
    })
    @GetMapping(value = "/findAll")
    ResponseEntity<List<OrderDTO>> findAll();

    @Operation(summary = "Lista uma ordem por id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Caso a consulta seja efetuada com sucesso."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Caso o ID enviado na URL não seja de nenhuma ordem válida."
            ),
    })
    @GetMapping(value = "/findById/{id}")
    ResponseEntity<OrderDTO> findById(@PathVariable(name = "id") UUID id);


    @Operation(summary = "Deleta um produto por id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Caso a ordem seja deletada com sucesso."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Caso o ID enviado na URL não seja de nenhuma ordem."
            )
    })
    @DeleteMapping(value = "/{id}")
    ResponseEntity<String> deleteById(@PathVariable(name = "id") UUID id);

}
