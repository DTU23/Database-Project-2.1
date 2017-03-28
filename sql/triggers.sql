DROP TRIGGER IF EXISTS after_component_insert;
DELIMITER //
CREATE TRIGGER after_component_insert
  AFTER INSERT ON productbatchcomponent
  FOR EACH ROW
BEGIN
  UPDATE producebatch SET amount = amount-new.netto WHERE producebatch.rb_id = new.rb_id;
  UPDATE productbatch SET status = 1 WHERE productbatch.pb_id = new.pb_id;
END //
DELIMITER ;