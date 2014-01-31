=========Tabela ParaEcom============

ALTER TABLE PARAECOM
    ADD CODPARAECOM VARCHAR(20),
    ADD MINUTOSCADASTRO INTEGER,
    ADD MINUTOSMOV INTEGER,
    ADD QTDEREGISTROS INTEGER,
    ADD QTDEMANTIDOS INTEGER,
    ADD ATIVASINCRONIZACAO INTEGER;
COMMIT WORK;
====================================


==========Tabela ParaURL===========
CREATE TABLE PARAURL (
    CODPARAURL  VARCHAR(20),
    URLWSDL VARCHAR(255)),
    URLKEY VARCHAR(100);
COMMIT WORK;
==================================


===========Tabela Produto===========
ALTER TABLE PRODUTO
ADD IMPORTAPRODECOM INTEGER;
COMMIT WORK;
==================================


========Tabela HISTINTEGECOM=========
CREATE TABLE HISTINTEGECOM (
    ID INTEGER,
    ENTIDADE VARCHAR(150),
    CODENTIDADE VARCHAR(50),
    DATAENT DATE,
    DATAINT DATE);
CREATE SEQUENCE GEN_HISTINTEGECOM_ID;
SET TERM ^ ;
create trigger histintegecom_bi for histintegecom
active before insert position 0
as
begin
  if (new.id is null) then
    new.id = gen_id(gen_histintegecom_id,1);
end^
SET TERM ; ^
====================================

=======Trigger PRODUTO_ECOMM_AU===========
SET TERM ^ ;
CREATE OR ALTER trigger produto_ecomm_au for produto
active after update position 0
AS
begin
  if(New.importaprodecom = 1)then begin
    INSERT INTO HISTINTEGECOM (ENTIDADE, CODENTIDADE, DATAENT, DATAINT)
    VALUES ('produto', NEW.codprod, current_timestamp, NULL);
    end
end^
SET TERM ; ^
=============================================




