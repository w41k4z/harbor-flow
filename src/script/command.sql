CREATE VIEW boats AS
    SELECT
        boat.id,
        boat.name,
        boat_category.id AS boat_category_id,
        boat_category.name AS type,
        boat_detail.id AS boat_detail_id,
        boat_detail.length,
        boat_detail.width,
        boat_detail.depth,
        boat_detail.weight,
        boat_detail.towing,
        boat_flag.id AS boat_flag_id,
        boat_flag.origin
    FROM boat
    JOIN boat_category
    ON boat.type = boat_category.id
    JOIN boat_detail
    ON boat.detail = boat_detail.id
    JOIN boat_flag
    ON boat.flag = boat_flag.id

CREATE VIEW docks AS
    SELECT
        dock.id,
        dock.name,
        dock_detail.length,
        dock_detail.width,
        dock_detail.depth
    FROM dock
    JOIN dock_detail
    ON dock.detail = dock_detail.id