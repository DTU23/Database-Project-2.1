# Raavare Batch Liste (Foreman)
CREATE OR REPLACE VIEW produce_batch_list AS
  SELECT raavarebatch.rb_id, raavare.raavare_navn, raavare.leverandoer, raavarebatch.maengde FROM raavarebatch
    INNER JOIN raavare WHERE raavare.raavare_id = raavarebatch.raavare_id;

# Raavare Overview (Foreman)
CREATE OR REPLACE VIEW produce_overview AS
  SELECT raavare.raavare_id, raavare.raavare_navn, SUM(raavarebatch.maengde) AS "maengde" FROM raavare
    NATURAL JOIN raavarebatch
  GROUP BY raavare.raavare_navn;

# Product Batch List (Foreman)
CREATE OR REPLACE VIEW product_batch_list AS
  SELECT produktbatch.recept_id, produktbatch.status, recept.recept_navn FROM produktbatch
    NATURAL JOIN recept;

# Operator List (Admin)
CREATE OR REPLACE VIEW user_list AS
  SELECT opr_id, opr_navn, cpr, admin, role FROM operatoer;

# Recipe List (Pharmacist)
CREATE OR REPLACE VIEW recipe_list AS
  SELECT recept_id, recept_navn, raavare_navn, nom_netto, tolerance
  FROM recept NATURAL JOIN receptkomponent NATURAL JOIN raavare;