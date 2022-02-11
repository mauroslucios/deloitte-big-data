-- Table: public.tb_departamento

-- DROP TABLE IF EXISTS public.tb_departamento;

CREATE TABLE IF NOT EXISTS public.tb_departamento
(
    id bigint NOT NULL DEFAULT nextval('tb_departamento_id_seq'::regclass),
    nome character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT tb_departamento_pkey PRIMARY KEY (id),
    CONSTRAINT uk_ayglrjjqocpl5sucr4d0y1910 UNIQUE (nome)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tb_departamento
    OWNER to postgres;
