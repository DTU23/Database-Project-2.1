DROP TRIGGER IF EXISTS after_component_insert;
DELIMITER //
CREATE TRIGGER after_component_insert
  AFTER INSERT ON produktbatchkomponent
  FOR EACH ROW
BEGIN
  UPDATE raavarebatch SET maengde = maengde-new.netto WHERE raavarebatch.rb_id = new.rb_id;
  UPDATE produktbatch SET status = 1 WHERE produktbatch.pb_id = new.pb_id;
END //
DELIMITER ;