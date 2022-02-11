-- Table: public.tb_post

-- DROP TABLE IF EXISTS public.tb_post;

CREATE TABLE IF NOT EXISTS public.tb_post
(
    id bigint NOT NULL DEFAULT nextval('tb_post_id_seq'::regclass),
    descricao character varying(255) COLLATE pg_catalog."default",
    titulo character varying(255) COLLATE pg_catalog."default",
    funcionario_id bigint,
    CONSTRAINT tb_post_pkey PRIMARY KEY (id),
    CONSTRAINT uk_fyqo7f8r1tiriyq05fpkh20ls UNIQUE (descricao),
    CONSTRAINT uk_po36ffb4juc91t8oxquk3vnh4 UNIQUE (titulo),
    CONSTRAINT fke6hfbpa6uxtd59wi00ymrm5kd FOREIGN KEY (funcionario_id)
        REFERENCES public.tb_funcionario (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tb_post
    OWNER to postgres;
