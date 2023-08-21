package com.divalirio.api.controller.impl;

import com.divalirio.api.controller.doc.IUserController;
import com.divalirio.api.dto.CreateUserDTORequest;
import com.divalirio.api.dto.UserDTO;
import com.divalirio.mapper.UserConverter;
import com.divalirio.model.User;
import com.divalirio.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController implements IUserController{

    private final UserService service;

    private final UserConverter converter;


    @Override
    public ResponseEntity<UserDTO> create(@RequestBody CreateUserDTORequest dtoRequest){

        User user = service.create(converter.convertDTOtoModel(dtoRequest));

        return ResponseEntity.ok(converter.convertModelToDTO(user));
    }


    @Override
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok(converter.convertListModelToDTO(service.findAll()));
    }

    @Override
    public ResponseEntity<UserDTO> findById(@PathVariable(name = "id") UUID id) {
        return ResponseEntity.ok(converter.convertModelToDTO(service.findById(id)));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "id") UUID id){
        service.deleteById(id);
        return ResponseEntity.ok("Usuário excluído com sucesso");
    }
}
