CREATE TABLE divalirio.product_images (   id    uuid NOT NULL,
                                         path  text  NOT NULL,
                                         product_id uuid NOT NULL,
                                         CONSTRAINT product_images_pkey PRIMARY KEY (id));

ALTER TABLE divalirio.product_images
    ADD CONSTRAINT product_images_products_fkey
        FOREIGN KEY (product_id) REFERENCES divalirio.products(id);
