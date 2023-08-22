CREATE TABLE divalirio.orders (    id     uuid NOT NULL,
                                   total_value numeric(19,2) NOT NULL,
                                   freight numeric(19,2) NOT NULL,
                                   user_id uuid NOT NULL,
                                   status  text NOT NULL,
                                   created_at TIMESTAMP NOT NULL,
                                   updated_at TIMESTAMP NULL,
                                   deleted_at TIMESTAMP NULL,
                                   observation text NULL,
                                   CONSTRAINT orders_pkey PRIMARY KEY (id));


ALTER TABLE divalirio.orders
    ADD CONSTRAINT orders_users_fkey
        FOREIGN KEY (user_id) REFERENCES divalirio.users(id);
