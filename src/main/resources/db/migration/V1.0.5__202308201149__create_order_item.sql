CREATE TABLE divalirio.order_itens (    id     uuid NOT NULL,
                                   product_id uuid NOT NULL,
                                   order_id uuid NOT NULL,
                                   quantity integer NOT NULL,
                                   observation text NULL,
                                   created_at TIMESTAMP NOT NULL,
                                   updated_at TIMESTAMP NULL,
                                   CONSTRAINT order_itens_pkey PRIMARY KEY (id));


ALTER TABLE divalirio.order_itens
    ADD CONSTRAINT order_itens_products_fkey
        FOREIGN KEY (product_id) REFERENCES divalirio.products(id);


ALTER TABLE divalirio.order_itens
    ADD CONSTRAINT order_itens_orders_fkey
        FOREIGN KEY (order_id) REFERENCES divalirio.orders(id);
