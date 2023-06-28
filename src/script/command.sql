CREATE VIEW boats AS
    SELECT
        boat.id,
        boat.name,
        boat_category.id AS boat_category_id,
        boat_category.name AS type,
        length,
        width,
        depth,
        weight,
        towing,
        boat_flag.id AS boat_flag_id,
        boat_flag.origin,
        currency.label AS currency
    FROM boat
    JOIN boat_category
    ON boat.type = boat_category.id
    JOIN boat_flag
    ON boat.flag = boat_flag.id
    JOIN currency
    ON boat.currency_id = currency.id
;

CREATE VIEW docks AS
    SELECT
        dock.id,
        dock.name,
        length,
        width,
        depth,
        currency.label AS currency
    FROM dock
    JOIN currency
    ON dock.currency_id = currency.id
;