CREATE TABLE divalirio.products (   id     uuid NOT NULL,
                                    name  text  NOT NULL,
                                    description text NOT NULL,
                                    size text NOT NULL,
                                    value numeric(19,2) NOT NULL ,
                                    stock integer NOT NULL,
                                    created_at TIMESTAMP NOT NULL,
                                    updated_at TIMESTAMP NOT NULL,
                                    CONSTRAINT products_pkey PRIMARY KEY (id));
