package com.divalirio.api.controller.doc;

import com.divalirio.api.dto.AddressDTO;
import com.divalirio.api.dto.CreateAddressDTORequest;
import com.divalirio.api.dto.CreateUserDTORequest;
import com.divalirio.api.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Api de Endereço de Usuário")
public interface IAddressController {

    @Operation(summary = "Salva um novo Endereço", description = "Realiza o cadastro de um novo endereço")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Caso o endereço seja cadastrado com sucesso."
            )
    })
    @PostMapping(value = "/create")
    ResponseEntity<AddressDTO> create(@Valid @RequestBody CreateAddressDTORequest dtoRequest);

    @Operation(summary = "Lista todos os endereços")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Caso a consulta seja efetuada com sucesso."
            )
    })
    @GetMapping(value = "/findAll")
    ResponseEntity<List<AddressDTO>> findAll();

    @Operation(summary = "Realiza a atualização de um Endereço")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Caso os dados sejam atualizados com sucesso!"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Caso o ID enviado na URL não seja de nenhum endereço."
            ),
    })
    @PutMapping(value = "/update/{id}")
    ResponseEntity<AddressDTO> update(@PathVariable(name = "id") UUID id, @Valid @RequestBody CreateAddressDTORequest profileDto);


    @Operation(summary = "Lista um endereço por id de usuário")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Caso a consulta seja efetuada com sucesso."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Caso o ID enviado na URL não seja de nenhum endereço de usuário válido."
            ),
    })
    @GetMapping(value = "/findById/{id}")
    ResponseEntity<AddressDTO> findById(@PathVariable(name = "id") UUID id);


    @Operation(summary = "Deleta um endereço por id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Caso o endereço seja deletado com sucesso."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Caso o ID enviado na URL não seja de nenhum endereço."
            )
    })
    @DeleteMapping(value = "/{id}")
    ResponseEntity<String> deleteById(@PathVariable(name = "id") UUID id);

}
