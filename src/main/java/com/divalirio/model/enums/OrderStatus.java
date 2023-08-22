package com.divalirio.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static java.util.Objects.nonNull;

@Getter
@AllArgsConstructor
public enum OrderStatus {

    WAITING_PAYMENT("Aguardando Pagamento"),
    PAYMENT_OK("Pagamento Confirmado"),
    CANCELLED("Pedido Cancelado"),
    WAITING_SEPARATION("Aguardando Separação"),
    DELIVERED_CARRIER("Saiu para Entrega"),
    DELIVERED("Pedido Entregue");


    private String description;

    public static OrderStatus getByDescription(final String description) {

        if (nonNull(description)) {
            for (final OrderStatus codigoEnum : OrderStatus.values()) {
                if (codigoEnum.getDescription().equalsIgnoreCase(description)) {
                    return codigoEnum;
                }
            }
        }
        return null;
    }
}
