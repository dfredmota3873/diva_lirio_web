package com.divalirio.api;

import com.divalirio.api.dto.CreateUserDTORequest;
import com.divalirio.api.dto.UserDTO;
import com.divalirio.mapper.UserConverter;
import com.divalirio.model.User;
import com.divalirio.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    private final UserConverter converter;

    @PostMapping(value = "/sign-up")
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserDTORequest dtoRequest){

        User user = service.create(converter.convertDTOtoModel(dtoRequest));

        return ResponseEntity.ok(converter.convertModelToDTO(user));
    }
}
