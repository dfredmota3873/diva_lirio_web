CREATE TABLE divalirio.users (     id     uuid NOT NULL,
                                    name  text  NOT NULL,
                                    email text NOT NULL,
                                    password text NOT NULL,
                                    created_at TIMESTAMP NOT NULL,
                                    updated_at TIMESTAMP NULL,
                                    phone text NOT NULL,
                                    CONSTRAINT users_pkey PRIMARY KEY (id));
