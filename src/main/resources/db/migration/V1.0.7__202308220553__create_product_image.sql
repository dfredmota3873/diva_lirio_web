CREATE TABLE divalirio.product_image (   id    uuid NOT NULL,
                                    path  text  NOT NULL,
                                    product_id uuid NOT NULL,
                                    created_at TIMESTAMP NOT NULL,
                                    updated_at TIMESTAMP NULL,
                                    CONSTRAINT product_image_pkey PRIMARY KEY (id));


ALTER TABLE divalirio.product_image
    ADD CONSTRAINT product_image_product_fkey
        FOREIGN KEY (product_id) REFERENCES divalirio.products(id);
