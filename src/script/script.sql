CREATE DATABASE harbor_flow WITH OWNER walker;

CREATE SEQUENCE boat_category_sequence; 
CREATE SEQUENCE boat_detail_sequence; 
CREATE SEQUENCE boat_flag_sequence; 
CREATE SEQUENCE boat_sequence; 
CREATE SEQUENCE service_sequence; 
CREATE SEQUENCE service_price_sequence; 
CREATE SEQUENCE service_price_detail_sequence; 
CREATE SEQUENCE dock_sequence; 
CREATE SEQUENCE dock_detail_sequence; 
CREATE SEQUENCE dock_service_sequence; 
CREATE SEQUENCE source_sequence; 
CREATE SEQUENCE stopover_forecast_sequence; 
CREATE SEQUENCE pending_forecast_sequence; 
CREATE SEQUENCE stopover_sequence;

CREATE TABLE boat_category (
    id VARCHAR(7) PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);
CREATE TABLE boat_detail (
    id VARCHAR(7) PRIMARY KEY,
    length FLOAT NOT NULL,
    width FLOAT NOT NULL,
    depth FLOAT NOT NULL,
    weight FLOAT NOT NULL,
    towing FLOAT NOT NULL, -- ex: 30mn
    CHECK (towing > 0),
    CHECK (length > 0),
    CHECK (width > 0),
    CHECK (depth > 0),
    CHECK (weight > 0)
);
CREATE TABLE boat_flag (
    id VARCHAR(7) PRIMARY KEY,
    origin VARCHAR(20) NOT NULL
);
CREATE TABLE boat (
    id VARCHAR(7) PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    type VARCHAR(7) REFERENCES boat_category(id),
    detail VARCHAR(7) REFERENCES boat_detail(id),
    flag VARCHAR(7) REFERENCES boat_flag(id)
);

CREATE TABLE service (
    id VARCHAR(7) PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE dock_detail (
    id VARCHAR(7) PRIMARY KEY,
    length FLOAT NOT NULL,
    width FLOAT NOT NULL,
    depth FLOAT NOT NULL,
    CHECK (length > 0),
    CHECK (width > 0),
    CHECK (depth > 0)
);
CREATE TABLE dock (
    id VARCHAR(7) PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    detail VARCHAR(7) REFERENCES dock_detail(id)
);
CREATE TABLE dock_service (
    id VARCHAR(8) PRIMARY KEY,
    dock_id VARCHAR(7) REFERENCES dock(id),
    service_id VARCHAR(7) REFERENCES service(id)
);
CREATE TABLE dock_service_price (
    id VARCHAR(8) PRIMARY KEY,
    dock_service_id VARCHAR(8) REFERENCES dock_service(id),
    boat_category_id VARCHAR(7) REFERENCES boat_category(id),
    hourly_tier FLOAT NOT NULL, -- ex: 15mn
    duration FLOAT NOT NULL, -- ex: 3h
    UNIQUE(dock_service_id, boat_category_id)
);
CREATE TABLE dock_service_price_details (
    id VARCHAR(9) PRIMARY KEY,
    dock_service_price_id VARCHAR(8) REFERENCES dock_service_price(id),
    i_th_hourly_tier INT NOT NULL,
    national_price FLOAT NOT NULL,
    international_price FLOAT NOT NULL,
    CHECK (i_th_hourly_tier > 0),
    CHECK (national_price > 0),
    CHECK (international_price > 0)
);

CREATE TABLE source (
    id VARCHAR(7) PRIMARY KEY,
    ip VARCHAR(15) NOT NULL UNIQUE
);
CREATE TABLE stopover_forecast (
    id VARCHAR(9) PRIMARY KEY,
    source_id VARCHAR(7) REFERENCES source(id),
    source_date TIMESTAMP NOT NULL,
    boat_id VARCHAR(7) REFERENCES boat(id),
    arrival_date TIMESTAMP NOT NULL,
    departure_date TIMESTAMP NOT NULL,
    CHECK(arrival_date < departure_date)
);
CREATE TABLE pending_forecast (
    id VARCHAR(9) PRIMARY KEY,
    stopover_forecast_id VARCHAR(9) REFERENCES stopover_forecast(id)
);
CREATE TABLE stopover (
    id VARCHAR(9) PRIMARY KEY,
    stopover_forecast_id VARCHAR(9) REFERENCES stopover_forecast(id)
);