CREATE VIEW boats AS
    SELECT
        boat.id,
        boat.name,
        boat_category.name AS type,
        boat_detail.length,
        boat_detail.width,
        boat_detail.depth,
        boat_detail.weight,
        boat_detail.towing,
        boat_flag.origin
    FROM boat
    JOIN boat_category
    ON boat.type = boat_category.id
    JOIN boat_detail
    ON boat.detail = boat_detail.id
    JOIN boat_flag
    ON boat.flag = boat_flag.id

CREATE VIEW services AS
    SELECT
        service.id,
        service.name,
        service_price.id AS service_price_id
        service_price.boat_category_id,
        service_price.hourly_tier,
        service_price.duration
    FROM service
    JOIN service_price
    ON service_price.service_id = service.id

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