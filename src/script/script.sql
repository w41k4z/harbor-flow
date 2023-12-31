CREATE SEQUENCE source_sequence; 
CREATE SEQUENCE user_account_sequence;
CREATE SEQUENCE currency_sequence;
CREATE SEQUENCE exchange_rate_sequence;
CREATE SEQUENCE boat_category_sequence;  
CREATE SEQUENCE boat_flag_sequence; 
CREATE SEQUENCE boat_sequence; 
CREATE SEQUENCE service_sequence; 
CREATE SEQUENCE dock_sequence; 
CREATE SEQUENCE dock_service_sequence; 
CREATE SEQUENCE dock_service_price_sequence; 
CREATE SEQUENCE dock_service_price_details_sequence; 
CREATE SEQUENCE stopover_forecast_sequence; 
CREATE SEQUENCE pending_forecast_sequence; 
CREATE SEQUENCE stopover_sequence;
CREATE SEQUENCE stopover_services_sequence;
CREATE SEQUENCE stopover_services_details_sequence;
CREATE SEQUENCE validated_stopover_service_sequence;
CREATE SEQUENCE stopover_invoice_sequence;
CREATE SEQUENCE stopover_invoice_details_sequence;
CREATE SEQUENCE validated_stopover_invoice_sequence;

CREATE TABLE source (
    id VARCHAR(7) PRIMARY KEY,
    ip VARCHAR(15) NOT NULL UNIQUE
);

CREATE TABLE user_account (
    id VARCHAR(7) PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    first_name VARCHAR(20),
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    profile VARCHAR(50) NOT NULL,
    source_id VARCHAR(7) REFERENCES source(id) NOT NULL
);

CREATE TABLE currency (
    id VARCHAR(7) PRIMARY KEY,
    label CHAR(3) NOT NULL UNIQUE
);
CREATE TABLE exchange_rate (
    id VARCHAR(7) PRIMARY KEY,
    change_date TIMESTAMP NOT NULL UNIQUE,
    currency_1 VARCHAR(7) REFERENCES currency(id) NOT NULL,
    currency_2 VARCHAR(7) REFERENCES currency(id) NOT NULL,
    value FLOAT NOT NULL
);

CREATE TABLE boat_category (
    id VARCHAR(7) PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);
CREATE TABLE boat_flag (
    id VARCHAR(7) PRIMARY KEY,
    origin VARCHAR(20) NOT NULL
);
CREATE TABLE boat (
    id VARCHAR(7) PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    type VARCHAR(7) REFERENCES boat_category(id),
    length FLOAT NOT NULL,
    width FLOAT NOT NULL,
    depth FLOAT NOT NULL,
    weight FLOAT NOT NULL,
    towing FLOAT NOT NULL, 
    flag VARCHAR(7) REFERENCES boat_flag(id),
    currency_id VARCHAR(7) REFERENCES currency(id),
    CHECK (towing > 0),
    CHECK (length > 0),
    CHECK (width > 0),
    CHECK (depth > 0),
    CHECK (weight > 0)
);

CREATE TABLE service (
    id VARCHAR(7) PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE dock (
    id VARCHAR(7) PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    length FLOAT NOT NULL,
    width FLOAT NOT NULL,
    depth FLOAT NOT NULL,
    currency_id VARCHAR(7) REFERENCES currency(id),
    CHECK (length > 0),
    CHECK (width > 0),
    CHECK (depth > 0)
);
CREATE TABLE dock_service (
    id VARCHAR(8) PRIMARY KEY,
    dock_id VARCHAR(7) REFERENCES dock(id),
    service_id VARCHAR(7) REFERENCES service(id),
    UNIQUE(dock_id, service_id)
);
CREATE TABLE dock_service_price (
    id VARCHAR(10) PRIMARY KEY,
    dock_service_id VARCHAR(8) REFERENCES dock_service(id),
    boat_category_id VARCHAR(7) REFERENCES boat_category(id),
    hourly_tier FLOAT NOT NULL, -- ex: 15mn
    UNIQUE(dock_service_id, boat_category_id)
);
CREATE TABLE dock_service_price_details (
    id VARCHAR(11) PRIMARY KEY,
    dock_service_price_id VARCHAR(10) REFERENCES dock_service_price(id),
    i_th_hourly_tier INT NOT NULL,
    from_time TIME NOT NULL,
    to_time TIME NOT NULL,
    national_price FLOAT NOT NULL,
    international_price FLOAT NOT NULL,
    CHECK (i_th_hourly_tier > 0),
    CHECK (national_price > 0),
    CHECK (international_price > 0)
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
    start_date TIMESTAMP NOT NULL,
    boat_id VARCHAR(7) REFERENCES boat(id),
    end_date TIMESTAMP,
    CHECK(start_date < end_date)
);
CREATE TABLE stopover_services (
    id VARCHAR(9) PRIMARY KEY,
    stopover_id VARCHAR(9) REFERENCES stopover(id),
    dock_id VARCHAR(7) REFERENCES dock(id),
    arrival_date TIMESTAMP NOT NULL,
    departure_date TIMESTAMP
);
CREATE TABLE stopover_services_details (
    id VARCHAR(9) PRIMARY KEY,
    stopover_services_id VARCHAR(9) REFERENCES stopover_services(id),
    dock_service_id VARCHAR(8) REFERENCES dock_service(id),
    user_account_id VARCHAR(7) REFERENCES user_account(id),
    action_date TIMESTAMP NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    state INT NOT NULL, -- 1: pending, 11: validated, 21: paid
    CHECK(start_date < end_date)
);
CREATE TABLE validated_stopover_service (
    id VARCHAR(9) PRIMARY KEY,
    stopover_services_details_id VARCHAR(9) REFERENCES stopover_services_details(id),
    user_account_id VARCHAR(7) REFERENCES user_account(id),
    action_date TIMESTAMP NOT NULL
);
CREATE TABLE stopover_invoice (
    id VARCHAR(9) PRIMARY KEY,
    stopover_id VARCHAR(9) REFERENCES stopover(id),
    user_account_id VARCHAR(7) REFERENCES user_account(id),
    action_date TIMESTAMP NOT NULL,
    state INT NOT NULL, -- 1: pending, 11: validated, 21: paid
    UNIQUE(stopover_id, action_date)
);
CREATE TABLE stopover_invoice_details (
    id VARCHAR(9) PRIMARY KEY,
    stopover_invoice_id VARCHAR(9) REFERENCES stopover_invoice(id),
    validated_stopover_service_id VARCHAR(9) REFERENCES validated_stopover_service(id)
);
CREATE TABLE validated_stopover_invoice (
    id VARCHAR(9) PRIMARY KEY,
    stopover_invoice_id VARCHAR(9) REFERENCES stopover_invoice(id),
    user_account_id VARCHAR(7) REFERENCES user_account(id),
    action_date TIMESTAMP NOT NULL
);