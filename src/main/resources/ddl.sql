CREATE TABLE orders
(
    id character varying(40) NOT NULL,
    id_customer character varying(40) NOT NULL,
    date_creation date DEFAULT 0,
    CONSTRAINT order_pkey PRIMARY KEY (id)
);

CREATE TABLE order_item
(
    id character varying(40) NOT NULL,
    id_product character varying(40) NOT NULL,
    qtd integer DEFAULT 0,
    total numeric DEFAULT 0,
    CONSTRAINT order_item_pkey PRIMARY KEY (id)
);
