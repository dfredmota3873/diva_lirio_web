package com.divalirio.api.controller.impl;

import com.divalirio.api.controller.doc.IOrderController;
import com.divalirio.api.dto.CreateOrderDTORequest;
import com.divalirio.api.dto.OrderDTO;
import com.divalirio.mapper.OrderConverter;
import com.divalirio.model.Order;
import com.divalirio.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController implements IOrderController {

    private final OrderService service;

    private final OrderConverter converter;

    @Override
    public ResponseEntity<OrderDTO> create(CreateOrderDTORequest dtoRequest) {
        Order order = service.create(converter.convertDTOtoModel(dtoRequest));
        return ResponseEntity.ok(converter.convertModelToDTO(order));
    }

    @Override
    public ResponseEntity<List<OrderDTO>> findAll() {
        return ResponseEntity.ok(converter.convertListModelToDTO(service.findAll()));
    }

    @Override
    public ResponseEntity<OrderDTO> findById(UUID id) {
        return ResponseEntity.ok(converter.convertModelToDTO(service.findById(id)));
    }

    @Override
    public ResponseEntity<String> deleteById(UUID id) {
        service.deleteById(id);
        return ResponseEntity.ok("Ordem excluída com sucesso");
    }
}
