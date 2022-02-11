-- Table: public.tb_funcionario

-- DROP TABLE IF EXISTS public.tb_funcionario;

CREATE TABLE IF NOT EXISTS public.tb_funcionario
(
    id bigint NOT NULL DEFAULT nextval('tb_funcionario_id_seq'::regclass),
    cpf character varying(11) COLLATE pg_catalog."default",
    email character varying(255) COLLATE pg_catalog."default",
    nome character varying(30) COLLATE pg_catalog."default",
    senha character varying(255) COLLATE pg_catalog."default",
    tipo character varying(255) COLLATE pg_catalog."default" NOT NULL,
    departamento_id bigint,
    CONSTRAINT tb_funcionario_pkey PRIMARY KEY (id),
    CONSTRAINT uk_h483q8xwbxkhk56ceeww2pvhw UNIQUE (cpf),
    CONSTRAINT uk_nt71h6xkn60cxsh8q58iyk7jr UNIQUE (senha),
    CONSTRAINT uk_onjc1xoei8x59dt76x2xnd3wc UNIQUE (email),
    CONSTRAINT fkatmyvejd2vst2t9pbfdd89cm3 FOREIGN KEY (departamento_id)
        REFERENCES public.tb_departamento (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tb_funcionario
    OWNER to postgres;
