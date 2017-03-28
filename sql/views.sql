# Raavare Batch Liste (Foreman)
CREATE OR REPLACE VIEW produce_batch_list AS
  SELECT producebatch.rb_id, raavare.produce_name, raavare.supplier, producebatch.amount FROM producebatch
    INNER JOIN raavare WHERE raavare.produce_id = producebatch.produce_id;

# Raavare Overview (Foreman)
CREATE OR REPLACE VIEW produce_overview AS
  SELECT raavare.produce_id, raavare.produce_name, SUM(producebatch.amount) AS "amount" FROM raavare
    NATURAL JOIN producebatch
  GROUP BY raavare.produce_name;

# Product Batch List (Foreman)
CREATE OR REPLACE VIEW product_batch_list AS
  SELECT productbatch.recipe_id, productbatch.status, recipe.recipe_name FROM productbatch
    NATURAL JOIN recipe;

# Operator List (Admin)
CREATE OR REPLACE VIEW operator_list AS
  SELECT opr_id, opr_name, cpr, admin, role FROM operator;