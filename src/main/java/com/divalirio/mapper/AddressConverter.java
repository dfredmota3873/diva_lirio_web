package com.divalirio.mapper;

import com.divalirio.api.dto.AddressDTO;
import com.divalirio.api.dto.CreateAddressDTORequest;
import com.divalirio.api.dto.UserDTO;
import com.divalirio.model.Address;
import com.divalirio.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressConverter {

    public AddressDTO convertModelToDTO(Address address){
        return AddressDTO.builder()
                .id(address.getId())
                .street(address.getStreet())
                .state(address.getState())
                .neighborhood(address.getNeighborhood())
                .number(address.getNumber())
                .complement(address.getComplement())
                .zipCode(address.getZipCode())
                .userId(address.getUser().getId())
                .build();
    }

    public Address convertDTOToModel(CreateAddressDTORequest dto){
        return Address.builder()
                .street(dto.getStreet())
                .state(dto.getState())
                .neighborhood(dto.getNeighborhood())
                .number(dto.getNumber())
                .complement(dto.getComplement())
                .zipCode(dto.getZipCode())
                .user(User.builder()
                        .id(dto.getUsuario())
                        .build())
                .build();
    }

    public List<AddressDTO> convertListModelToDTO(List<Address> list){
        return list.stream().map(from -> convertModelToDTO(from)).collect(Collectors.toList());
    }

}
