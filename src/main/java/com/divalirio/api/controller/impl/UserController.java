package com.divalirio.api.controller.impl;

import com.divalirio.api.dto.CreateUserDTORequest;
import com.divalirio.api.dto.UserDTO;
import com.divalirio.mapper.UserConverter;
import com.divalirio.model.User;
import com.divalirio.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController implements IUserController {

    private final UserService service;

    private final UserConverter converter;

    @PostMapping(value = "/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserDTORequest dtoRequest){

        User user = service.create(converter.convertDTOtoModel(dtoRequest));

        return ResponseEntity.ok(converter.convertModelToDTO(user));
    }

    @Override
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok(converter.convertListModelToDTO(service.findAll()));
    }
}
