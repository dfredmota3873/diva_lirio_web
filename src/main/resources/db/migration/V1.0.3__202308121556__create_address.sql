CREATE TABLE divalirio.address (    id     uuid NOT NULL,
                                    street  text  NOT NULL,
                                    number text NOT NULL,
                                    neighborhood text NOT NULL,
                                    state text NOT NULL ,
                                    created_at TIMESTAMP NOT NULL,
                                    updated_at TIMESTAMP NOT NULL,
                                    CONSTRAINT address_pkey PRIMARY KEY (id));
