CREATE TABLE divalirio.address (    id     uuid NOT NULL,
                                    street  text  NOT NULL,
                                    number text NOT NULL,
                                    neighborhood text NOT NULL,
                                    state text NOT NULL ,
                                    user_id uuid NOT NULL,
                                    complement text NULL,
                                    zip_code text NULL,
                                    created_at TIMESTAMP NOT NULL,
                                    updated_at TIMESTAMP NULL,
                                    CONSTRAINT address_pkey PRIMARY KEY (id));

ALTER TABLE divalirio.address
    ADD CONSTRAINT address_users_fkey
        FOREIGN KEY (user_id) REFERENCES divalirio.users(id);
