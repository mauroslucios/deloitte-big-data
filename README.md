# deloitte-big-data
## Tecnologia usadas:
- java
- jpa
- spring
- postgresql
- docker(container postgresql - localhost)
- spring security(encriptar senha)
- lombok
- swagger
- flyway
- Heroku
- postgresql(heroku)
- git

## Endpoints
- /swagger-ui.html

## SQL das tabelas
```
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
```

```
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
```

```
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
```
## Imagens
![Captura de tela de 2022-02-10 23-06-44](https://user-images.githubusercontent.com/671694/153529315-bbe64fdd-a423-4aec-b6e9-ac8835f6e4ef.png)
![Captura de tela de 2022-02-10 23-07-20](https://user-images.githubusercontent.com/671694/153529319-00e89038-aca2-4d0f-b44f-94c5e7bb21c5.png)
![Captura de tela de 2022-02-10 23-13-09](https://user-images.githubusercontent.com/671694/153529321-1a6cabcf-105e-449e-9547-bb0cdc718fde.png)
![Captura de tela de 2022-02-10 23-31-54](https://user-images.githubusercontent.com/671694/153529322-e5851581-32d8-4f79-85f8-4cc02a9446ba.png)
![Captura de tela de 2022-02-10 23-35-07](https://user-images.githubusercontent.com/671694/153529323-e38a1dc3-c4f8-418c-90a2-e1c7faf49ae9.png)
![Captura de tela de 2022-02-10 23-35-25](https://user-images.githubusercontent.com/671694/153529326-cc412176-8f7c-4c2e-9bf5-7a98c3548a31.png)
![deloitte](https://user-images.githubusercontent.com/671694/153688418-247579ee-a685-4c87-a752-83210363d7e7.jpg)
