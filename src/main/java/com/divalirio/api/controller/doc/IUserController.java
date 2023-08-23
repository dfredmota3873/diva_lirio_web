package com.divalirio.api.controller.doc;

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

@Tag(name = "Api de Usuários")
public interface IUserController {

    @Operation(summary = "Salva um novo Usuario", description = "Realiza o cadastro de um novo usuário")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Caso o usuário seja cadastrado com sucesso."
            )
    })
    @PostMapping(value = "/create")
    public ResponseEntity<UserDTO> create(@Valid @RequestBody CreateUserDTORequest dtoRequest);

    @Operation(summary = "Lista todos os usuários")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Caso a consulta seja efetuada com sucesso."
            )
    })
    @GetMapping(value = "/findAll")
    ResponseEntity<List<UserDTO>> findAll();


    @Operation(summary = "Lista um usuário por id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Caso a consulta seja efetuada com sucesso."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Caso o ID enviado na URL não seja de nenhum usuário."
            ),
    })
    @GetMapping(value = "/findById/{id}")
    ResponseEntity<UserDTO> findById(@PathVariable(name = "id") UUID id);


    @Operation(summary = "Deleta um usuário por id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Caso o usuário seja deletado com sucesso."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Caso o ID enviado na URL não seja de nenhum usuário."
            )
    })
    @DeleteMapping(value = "/{id}")
    ResponseEntity<String> deleteById(@PathVariable(name = "id") UUID id);

}
