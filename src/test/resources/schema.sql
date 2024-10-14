CREATE TABLE public.category
(
    id          bigint NOT NULL,
    description character varying(255),
    name        character varying(255)
);
CREATE TABLE public."order"
(
    id             bigint NOT NULL,
    customer_email character varying(255),
    customer_name  character varying(255),
    order_date     timestamp(6) without time zone,
    total_amount   double precision
);

CREATE TABLE public.order_order_details
(
    order_id         bigint NOT NULL,
    order_details_id bigint NOT NULL
);
CREATE TABLE public.product
(
    id          bigint NOT NULL,
    description character varying(255),
    name        character varying(255),
    price       double precision,
    category_id bigint NOT NULL,
    order_id    bigint NOT NULL
);
CREATE TABLE public.stock
(
    id       bigint NOT NULL,
    quantity integer
);