ALTER TABLE rates ALTER COLUMN adults_max_number drop not null;
ALTER TABLE rates ALTER COLUMN children_max_number drop not null;
ALTER TABLE rates ALTER COLUMN pets_max_number drop not null;

ALTER TABLE rates drop COLUMN adults_max_number ;
ALTER TABLE rates drop COLUMN children_max_number ;
ALTER TABLE rates drop COLUMN pets_max_number;


