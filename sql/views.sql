CREATE OR REPLACE VIEW user_list AS
SELECT opr_id, opr_navn, ini FROM operatoer;

CREATE OR REPLACE VIEW produce_overview AS
SELECT raavare.raavare_id, raavare.raavare_navn, raavare.leverandoer, SUM(maengde) AS "maengde" FROM raavare, raavarebatch
WHERE raavare.raavare_id = raavarebatch.raavare_id OR raavare.raavare_id;

CREATE OR REPLACE VIEW recipe_list AS
  SELECT recept_id, recept_navn, raavare_navn, nom_netto, tolerance
  FROM recept NATURAL JOIN receptkomponent NATURAL JOIN raavare;

CREATE OR REPLACE VIEW produce_batches AS
SELECT raavarebatch.rb_id, raavare.raavare_navn, raavare.leverandoer, raavarebatch.maengde FROM raavarebatch
  INNER JOIN raavare WHERE raavare.raavare_id = raavarebatch.raavare_id;

CREATE OR REPLACE VIEW product_batches AS
SELECT produktbatch.pb_id, produktbatch.status, produktbatch.recept_id, recept.recept_navn FROM produktbatch, recept;
