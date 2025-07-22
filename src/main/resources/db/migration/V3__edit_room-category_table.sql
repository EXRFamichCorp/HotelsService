ALTER TABLE rates
    DROP COLUMN adults_max_number,
    DROP COLUMN children_max_number,
    DROP COLUMN pets_max_number;

ALTER table room_categories
    Add column adults_max_number smallint not null default 1 ,
    add column children_max_number smallint not null default 1,
    add column pets_max_number smallint not null default 0;




