INSERT INTO source VALUES
('SRC0001', '192.168.1.24');
SELECT nextval('source_sequence');


INSERT INTO user_account VALUES
('USR0001', 'Cap', 'C1', 'cap@gmail.com', '1234', 'capitainerie', 'SRC0001'),
('USR0002', 'Chef Cap', 'CC1', 'chefcap@gmail.com', '1234', 'chef capitainerie', 'SRC0001'),
('USR0003', 'Fact', 'F1', 'fact@gmail.com', '1234', 'facturation', 'SRC0001'),
('USR0004', 'Chef Fact', 'CF1', 'cheffact@gmail.com', '1234', 'chef facturation', 'SRC0001');
SELECT nextval('user_account_sequence');
SELECT nextval('user_account_sequence');
SELECT nextval('user_account_sequence');
SELECT nextval('user_account_sequence');


INSERT INTO currency VALUES
('CUR0001', 'EUR'),
('CUR0002', 'USD'),
('CUR0003', 'AR');
SELECT nextval('currency_sequence');
SELECT nextval('currency_sequence');
SELECT nextval('currency_sequence');


INSERT INTO exchange_rate VALUES
('ER00001', NOW(), 'CUR0001', 'CUR0001', 1);
INSERT INTO exchange_rate VALUES
('ER00002', NOW(), 'CUR0002', 'CUR0002', 1);
INSERT INTO exchange_rate VALUES
('ER00003', NOW(), 'CUR0003', 'CUR0003', 1);
INSERT INTO exchange_rate VALUES
('ER00004', NOW(), 'CUR0001', 'CUR0003', 4960.86);
INSERT INTO exchange_rate VALUES
('ER00005', NOW(), 'CUR0001', 'CUR0002', 1.09);
INSERT INTO exchange_rate VALUES
('ER00006', NOW(), 'CUR0002', 'CUR0003', 4543.72);
SELECT nextval('exchange_rate_sequence');
SELECT nextval('exchange_rate_sequence');
SELECT nextval('exchange_rate_sequence');
SELECT nextval('exchange_rate_sequence');
SELECT nextval('exchange_rate_sequence');
SELECT nextval('exchange_rate_sequence');


INSERT INTO boat_category VALUES
('BTC0001', 'Paquetbots'),
('BTC0002', 'Petroliers'),
('BTC0003', 'Marchandises'),
('BTC0004', 'Pecheurs');
SELECT nextval('boat_category_sequence');
SELECT nextval('boat_category_sequence');
SELECT nextval('boat_category_sequence');
SELECT nextval('boat_category_sequence');


INSERT INTO boat_flag VALUES
('BTF0001', 'French'),
('BTF0002', 'United States'),
('BTF0003', 'Madagascar');
SELECT nextval('boat_flag_sequence');
SELECT nextval('boat_flag_sequence');
SELECT nextval('boat_flag_sequence');