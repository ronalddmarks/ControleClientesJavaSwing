  CREATE TABLE "SYSTEM"."CLIENTE" 
   (	"CLI_COD" NUMBER NOT NULL ENABLE, 
	"CLI_NOME" VARCHAR2(100 BYTE), 
	"CLI_CPF" VARCHAR2(20 BYTE), 
	"CLI_DT_NASC" DATE, 
	"CLI_SEXO" VARCHAR2(1 BYTE), 
	"CLI_FONE" VARCHAR2(20 BYTE), 
	"CLI_ENDERECO" VARCHAR2(50 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;


 CREATE TABLE "SYSTEM"."LOGIN" 
   (	"LOG_SEQ" NUMBER, 
	"LOG_NOME" VARCHAR2(30 BYTE), 
	"LOG_SENHA" VARCHAR2(20 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;

