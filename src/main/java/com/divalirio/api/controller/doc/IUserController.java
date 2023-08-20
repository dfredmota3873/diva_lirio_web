package com.divalirio.api.controller.doc;

import com.divalirio.api.dto.CreateUserDTORequest;
import com.divalirio.api.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Api de Usuários")
public interface IUserController {

    @Operation(summary = "Salva um novo Usuario", description = "Realiza o cadastro de um novo usuário")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Caso o usuário seja cadastrado com sucesso."
            )
    })
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserDTORequest dtoRequest);
    @Operation(summary = "Lista todos os usuários")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Caso a consulta seja efetuada com sucesso."
            )
    })
    @GetMapping()
    ResponseEntity<List<UserDTO>> findAll();

}
