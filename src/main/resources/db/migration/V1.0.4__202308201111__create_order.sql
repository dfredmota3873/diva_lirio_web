CREATE TABLE divalirio.orders (    id     uuid NOT NULL,
                                   total_value numeric(19,2) NOT NULL,
                                   created_at TIMESTAMP NOT NULL,
                                   updated_at TIMESTAMP NOT NULL,
                                   observation text NULL,
                                   CONSTRAINT orders_pkey PRIMARY KEY (id));
