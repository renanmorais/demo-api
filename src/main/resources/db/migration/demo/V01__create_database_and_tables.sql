/*
Created: 20/03/2018
Modified: 01/04/2018
Project: demo
Model: demo
Author: Luis Gustavo S. G. de Oliveira
Database: PostgreSQL 9.5
*/


-- Create tables section -------------------------------------------------

-- Table usuario

CREATE TABLE "usuario"(
 "id"         BIGSERIAL NOT NULL,
 "nome"       CHARACTER VARYING(200) NOT NULL,
 "password"   CHARACTER VARYING(100) NOT NULL,
 "login"      CHARACTER VARYING(20) NOT NULL,
 "email"      CHARACTER VARYING(100) NOT NULL,
 "is_inativo" BOOLEAN DEFAULT FALSE NOT NULL
);

-- Add keys for table usuario

ALTER TABLE "usuario"
        ADD CONSTRAINT "id_user" PRIMARY KEY ("id");

ALTER TABLE "usuario"
        ADD CONSTRAINT "usuario_login_unique" UNIQUE ("login");

ALTER TABLE "usuario"
        ADD CONSTRAINT "usuario_email_unique" UNIQUE ("email");

-- Table perfil_acesso

CREATE TABLE "perfil_acesso"(
 "id"         BIGSERIAL NOT NULL,
 "nome"       CHARACTER VARYING(50) NOT NULL,
 "is_inativo" BOOLEAN DEFAULT FALSE NOT NULL
)
;

-- Add keys for table perfil_acesso

ALTER TABLE "perfil_acesso"
        ADD CONSTRAINT "id_perfil_acesso" PRIMARY KEY ("id");

ALTER TABLE "perfil_acesso"
        ADD CONSTRAINT "perfil_acesso_unique_nome" UNIQUE ("nome");

-- Table permissao

CREATE TABLE "permissao"(
 "id"         BIGSERIAL NOT NULL,
 "nome"       CHARACTER VARYING(50) NOT NULL,
 "descricao"  CHARACTER VARYING(100) NOT NULL
);

-- Add keys for table permissao

ALTER TABLE "permissao"
        ADD CONSTRAINT "id_permissao" PRIMARY KEY ("id");

ALTER TABLE "permissao"
        ADD CONSTRAINT "permissao_unique_nome" UNIQUE ("nome");

-- Table usuario_perfil_acesso

CREATE TABLE "usuario_perfil_acesso"(
 "id"               BIGSERIAL NOT NULL,
 "id_usuario"       BIGINT NOT NULL,
 "id_perfil_acesso" BIGINT NOT NULL
);

-- Create indexes for table usuario_perfil_acesso

CREATE UNIQUE INDEX "unique_UsuarioPerfilAcesso" ON "usuario_perfil_acesso" ("id_perfil_acesso", "id_usuario");

-- Add keys for table usuario_perfil_acesso

ALTER TABLE "usuario_perfil_acesso" ADD CONSTRAINT "id_usuario_perfil_acesso" PRIMARY KEY ("id")
;

-- Table perfil_acesso_permissao

CREATE TABLE "perfil_acesso_permissao"(
 "id"               BIGSERIAL NOT NULL,
 "id_permissao"     BIGINT,
 "id_perfil_acesso" BIGINT
);

-- Create indexes for table perfil_acesso_permissao

CREATE UNIQUE INDEX "unique_perfilAcessoPermissao" ON "perfil_acesso_permissao" ("id_permissao", "id_perfil_acesso")
;

-- Add keys for table perfil_acesso_permissao

ALTER TABLE "perfil_acesso_permissao" ADD CONSTRAINT "Key1" PRIMARY KEY ("id")
;
-- Create foreign keys (relationships) section -------------------------------------------------

ALTER TABLE "usuario_perfil_acesso"
        ADD CONSTRAINT "FK_user_userAccessProfile" FOREIGN KEY ("id_usuario")
        REFERENCES "usuario" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE "usuario_perfil_acesso"
        ADD CONSTRAINT "FK_userAccessProfile_accessProfile" FOREIGN KEY ("id_perfil_acesso")
        REFERENCES "perfil_acesso" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE "perfil_acesso_permissao"
        ADD CONSTRAINT "FK_permissao_accessProfilepermissao" FOREIGN KEY ("id_permissao")
        REFERENCES "permissao" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE "perfil_acesso_permissao"
        ADD CONSTRAINT "FK_accessProfile_accessProfilepermissao" FOREIGN KEY ("id_perfil_acesso")
        REFERENCES "perfil_acesso" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;




