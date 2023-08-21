package com.divalirio.api.controller.impl;

import com.divalirio.api.controller.doc.IAddressController;
import com.divalirio.api.dto.AddressDTO;
import com.divalirio.api.dto.CreateAddressDTORequest;
import com.divalirio.mapper.AddressConverter;
import com.divalirio.model.Address;
import com.divalirio.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController implements IAddressController {

    private final AddressService service;

    private final AddressConverter converter;

    @Override
    public ResponseEntity<AddressDTO> create(CreateAddressDTORequest dtoRequest) {
        Address address = service.create(converter.convertDTOToModel(dtoRequest));

        return ResponseEntity.ok(converter.convertModelToDTO(address));
    }

    @Override
    public ResponseEntity<List<AddressDTO>> findAll() {
        return ResponseEntity.ok(converter.convertListModelToDTO(service.findAll()));
    }

    @Override
    public ResponseEntity<AddressDTO> update(UUID id, CreateAddressDTORequest dto) {
        Address address = service.update(id,converter.convertDTOToModel(dto));
        return ResponseEntity.ok(converter.convertModelToDTO(address));
    }

    @Override
    public ResponseEntity<AddressDTO> findById(UUID id) {
        return ResponseEntity.ok(converter.convertModelToDTO(service.findById(id)));
    }

    @Override
    public ResponseEntity<String> deleteById(UUID id) {
        service.deleteById(id);
        return ResponseEntity.ok("Endereço excluído com sucesso");
    }
}
