package com.divalirio.mapper;

import com.divalirio.api.dto.CreateUserDTORequest;
import com.divalirio.api.dto.UserDTO;
import com.divalirio.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {

    public UserDTO convertModelToDTO(User user){

        return UserDTO.builder()
                .id(user.getId())
                .phone(user.getPhone())
                .email(user.getEmail())
                .name(user.getName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .build();
    }

    public User convertDTOtoModel(CreateUserDTORequest request){

        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .lastName(request.getLastName())
                .password(request.getPassword())
                .build();
    }

    public List<UserDTO> convertListModelToDTO(List<User> list){
        return list.stream().map(from -> convertModelToDTO(from)).collect(Collectors.toList());
    }


}
