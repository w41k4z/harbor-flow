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
('BTC0001', 'Sailboat'),
('BTC0002', 'Motorboat'),
('BTC0003', 'Kayak'),
('BTC0004', 'Canoe');
SELECT nextval('boat_category_sequence');
SELECT nextval('boat_category_sequence');
SELECT nextval('boat_category_sequence');
SELECT nextval('boat_category_sequence');


INSERT INTO boat_detail VALUES
('BTD0001', 10.5, 3.2, 1.5, 500, 30),
('BTD0002', 8.7, 2.9, 1.2, 350, 20),
('BTD0003', 5.4, 1.8, 0.9, 150, 15),
('BTD0004', 6.2, 2.5, 1.3, 200, 25);
SELECT nextval('boat_detail_sequence');
SELECT nextval('boat_detail_sequence');
SELECT nextval('boat_detail_sequence');
SELECT nextval('boat_detail_sequence');


INSERT INTO boat_flag VALUES
('BTF0001', 'French'),
('BTF0002', 'United States'),
('BTF0003', 'Madagascar');
SELECT nextval('boat_flag_sequence');
SELECT nextval('boat_flag_sequence');
SELECT nextval('boat_flag_sequence');


INSERT INTO boat VALUES
('BT00001', 'Sailboat 1', 'BTC0001', 'BTD0001', 'BTF0001', 'CUR0001'),
('BT00002', 'Motorboat 1', 'BTC0002', 'BTD0002', 'BTF0002', 'CUR0001'),
('BT00003', 'Sailboat 2', 'BTC0001', 'BTD0003', 'BTF0003', 'CUR0002'),
('BT00004', 'Motorboat 2', 'BTC0002', 'BTD0004', 'BTF0001', 'CUR0002'),
('BT00005', 'Kayak 1', 'BTC0003', 'BTD0001', 'BTF0003', 'CUR0003'),
('BT00006', 'Canoe 1', 'BTC0004', 'BTD0002', 'BTF0001', 'CUR0003'),
('BT00007', 'Sailboat 3', 'BTC0001', 'BTD0003', 'BTF0002', 'CUR0003'),
('BT00008', 'Motorboat 3', 'BTC0002', 'BTD0004', 'BTF0001', 'CUR0002'),
('BT00009', 'Kayak 2', 'BTC0003', 'BTD0001', 'BTF0003', 'CUR0003'),
('BT00010', 'Canoe 2', 'BTC0004', 'BTD0002', 'BTF0003', 'CUR0001');
SELECT nextval('boat_sequence');
SELECT nextval('boat_sequence');
SELECT nextval('boat_sequence');
SELECT nextval('boat_sequence');
SELECT nextval('boat_sequence');
SELECT nextval('boat_sequence');
SELECT nextval('boat_sequence');
SELECT nextval('boat_sequence');
SELECT nextval('boat_sequence');
SELECT nextval('boat_sequence');

INSERT INTO service VALUES
('SRV0001', 'Remorquage'),
('SRV0002', 'Stationnement'),
('SRV0003', 'Cession d eau douce'),
('SRV0004', 'Reparation');
SELECT nextval('service_sequence');
SELECT nextval('service_sequence');
SELECT nextval('service_sequence');
SELECT nextval('service_sequence');


INSERT INTO dock_detail VALUES
('DKD0001', 15.2, 4.5, 2.3),
('DKD0002', 12.6, 3.8, 1.9),
('DKD0003', 10.8, 3.2, 1.6),
('DKD0004', 9.5, 2.7, 1.3),
('DKD0005', 7.3, 2.1, 1.0);
SELECT nextval('dock_detail_sequence');
SELECT nextval('dock_detail_sequence');
SELECT nextval('dock_detail_sequence');
SELECT nextval('dock_detail_sequence');
SELECT nextval('dock_detail_sequence');


INSERT INTO dock (id, name, detail, currency_id) VALUES
('DOK0001', 'Dock 1', 'DKD0001', 'CUR0001'),
('DOK0002', 'Dock 2', 'DKD0002', 'CUR0002');
SELECT nextval('dock_sequence');
SELECT nextval('dock_sequence');


INSERT INTO dock_service VALUES
-- Dock1 'Remorquage'
('DKS00001', 'DOK0001', 'SRV0001'),
-- Dock1 'Stationnement'
('DKS00002', 'DOK0001', 'SRV0002'),
-- Dock1 'Reparation'
('DKS00003', 'DOK0001', 'SRV0004'),
-- Dock2 'Remorquage'
('DKS00004', 'DOK0002', 'SRV0001'),
-- Dock2 'Stationnement'
('DKS00005', 'DOK0002', 'SRV0002'),
-- Dock2 'Cession d eau douce'
('DKS00006', 'DOK0002', 'SRV0003');
SELECT nextval('dock_service_sequence');
SELECT nextval('dock_service_sequence');
SELECT nextval('dock_service_sequence');
SELECT nextval('dock_service_sequence');
SELECT nextval('dock_service_sequence');
SELECT nextval('dock_service_sequence');


INSERT INTO dock_service_price VALUES
-- Dock1 'Remorquage' for 'Sailboat'
('SRP000001', 'DKS00001', 'BTC0001', 10),
-- Dock1 'Remorquage' for 'Motorboat'
('SRP000002', 'DKS00001', 'BTC0002', 10),
-- Dock1 'Remorquage' for 'Kayak'
('SRP000003', 'DKS00001', 'BTC0003', 10),
-- Dock1 'Remorquage' for 'Canoe'
('SRP000004', 'DKS00001', 'BTC0004', 10),
-- Dock1 'Stationnement' for 'Sailboat'
('SRP000005', 'DKS00002', 'BTC0001', 15),
-- Dock1 'Stationnement' for 'Motorboat'
('SRP000006', 'DKS00002', 'BTC0002', 15),
-- Dock1 'Stationnement' for 'Kayak'
('SRP000007', 'DKS00002', 'BTC0003', 15),
-- Dock1 'Stationnement' for 'Canoe'
('SRP000008', 'DKS00002', 'BTC0004', 15),
-- Dock1 'Reparation' for 'Sailboat'
('SRP000009', 'DKS00003', 'BTC0001', 20),
-- Dock1 'Reparation' for 'Motorboat'
('SRP000010', 'DKS00003', 'BTC0002', 20),
-- Dock1 'Reparation' for 'Kayak'
('SRP000011', 'DKS00003', 'BTC0003', 20),
-- Dock1 'Reparation' for 'Canoe'
('SRP000012', 'DKS00003', 'BTC0004', 20),
-- Dock2 'Remorquage' for 'Sailboat'
('SRP000013', 'DKS00004', 'BTC0001', 10),
-- Dock2 'Remorquage' for 'Motorboat'
('SRP000014', 'DKS00004', 'BTC0002', 10),
-- Dock2 'Remorquage' for 'Kayak'
('SRP000015', 'DKS00004', 'BTC0003', 10),
-- Dock2 'Remorquage' for 'Canoe'
('SRP000016', 'DKS00004', 'BTC0004', 10),
-- Dock2 'Stationnement' for 'Sailboat'
('SRP000017', 'DKS00005', 'BTC0001', 15),
-- Dock2 'Stationnement' for 'MotorBoat'
('SRP000018', 'DKS00005', 'BTC0002', 15),
-- Dock2 'Stationnement' for 'Kayak'
('SRP000019', 'DKS00005', 'BTC0003', 15),
-- Dock2 'Stationnement' for 'Canoe'
('SRP000020', 'DKS00005', 'BTC0004', 15),
-- Dock2 'Cession d eau douce' for 'Sailboat'
('SRP000021', 'DKS00006', 'BTC0001', 1), -- Cession d'eau douce instantanee
-- Dock2 'Cession d eau douce' for 'Motorboat'
('SRP000022', 'DKS00006', 'BTC0002', 1),
-- Dock2 'Cession d eau douce' for 'Kayak'
('SRP000023', 'DKS00006', 'BTC0003', 1),
-- Dock2 'Cession d eau douce' for 'Canoe'
('SRP000024', 'DKS00006', 'BTC0004', 1);
SELECT nextval('dock_service_price_sequence');
SELECT nextval('dock_service_price_sequence');
SELECT nextval('dock_service_price_sequence');
SELECT nextval('dock_service_price_sequence');
SELECT nextval('dock_service_price_sequence');
SELECT nextval('dock_service_price_sequence');
SELECT nextval('dock_service_price_sequence');
SELECT nextval('dock_service_price_sequence');
SELECT nextval('dock_service_price_sequence');
SELECT nextval('dock_service_price_sequence');
SELECT nextval('dock_service_price_sequence');
SELECT nextval('dock_service_price_sequence');
SELECT nextval('dock_service_price_sequence');
SELECT nextval('dock_service_price_sequence');
SELECT nextval('dock_service_price_sequence');
SELECT nextval('dock_service_price_sequence');
SELECT nextval('dock_service_price_sequence');
SELECT nextval('dock_service_price_sequence');
SELECT nextval('dock_service_price_sequence');
SELECT nextval('dock_service_price_sequence');
SELECT nextval('dock_service_price_sequence');
SELECT nextval('dock_service_price_sequence');
SELECT nextval('dock_service_price_sequence');
SELECT nextval('dock_service_price_sequence');


INSERT INTO dock_service_price_details VALUES
-- Dock1 'Remorquage' for 'Sailboat'
('SRPD0000001', 'SRP000001', 1, '00:00', '23:59', 50, 100),
('SRPD0000002', 'SRP000001', 2, '00:00', '23:59', 70, 140),
('SRPD0000003', 'SRP000001', 3, '00:00', '23:59', 100, 200),
('SRPD0000004', 'SRP000001', 4, '00:00', '23:59', 150, 300),
-- Dock1 'Remorquage' for 'Motorboat'
('SRPD0000005', 'SRP000002', 1, '00:00', '23:59', 50, 100),
('SRPD0000006', 'SRP000002', 2, '00:00', '23:59', 70, 140),
('SRPD0000007', 'SRP000002', 3, '00:00', '23:59', 100, 200),
('SRPD0000008', 'SRP000002', 4, '00:00', '23:59', 150, 300),
-- Dock1 'Remorquage' for 'Kayak'
('SRPD0000009', 'SRP000003', 1, '00:00', '23:59', 50, 100),
('SRPD0000010', 'SRP000003', 2, '00:00', '23:59', 70, 140),
('SRPD0000011', 'SRP000003', 3, '00:00', '23:59', 100, 200),
('SRPD0000012', 'SRP000003', 4, '00:00', '23:59', 150, 300),
-- Dock1 'Remorquage' for 'Canoe'
('SRPD0000013', 'SRP000004', 1, '00:00', '23:59', 50, 100),
('SRPD0000014', 'SRP000004', 2, '00:00', '23:59', 70, 140),
('SRPD0000015', 'SRP000004', 3, '00:00', '23:59', 100, 200),
('SRPD0000016', 'SRP000004', 4, '00:00', '23:59', 150, 300),

-- Dock1 'Stationnement' for 'Sailboat'
('SRPD0000017', 'SRP000005', 1, '00:00', '23:59', 50, 100),
('SRPD0000018', 'SRP000005', 2, '00:00', '23:59', 70, 140),
('SRPD0000019', 'SRP000005', 3, '00:00', '23:59', 100, 200),
('SRPD0000020', 'SRP000005', 4, '00:00', '23:59', 150, 300),
('SRPD0000021', 'SRP000005', 5, '00:00', '23:59', 250, 500),
-- Dock1 'Stationnement' for 'Motorboat'
('SRPD0000022', 'SRP000006', 1, '00:00', '23:59', 50, 100),
('SRPD0000023', 'SRP000006', 2, '00:00', '23:59', 70, 140),
('SRPD0000024', 'SRP000006', 3, '00:00', '23:59', 100, 200),
('SRPD0000025', 'SRP000006', 4, '00:00', '23:59', 150, 300),
('SRPD0000026', 'SRP000006', 5, '00:00', '23:59', 250, 500),
-- Dock1 'Stationnement' for 'Kayak'
('SRPD0000027', 'SRP000007', 1, '00:00', '23:59', 50, 100),
('SRPD0000028', 'SRP000007', 2, '00:00', '23:59', 70, 140),
('SRPD0000029', 'SRP000007', 3, '00:00', '23:59', 100, 200),
('SRPD0000030', 'SRP000007', 4, '00:00', '23:59', 150, 300),
('SRPD0000031', 'SRP000007', 5, '00:00', '23:59', 250, 500),
-- Dock1 'Stationnement' for 'Canoe'
('SRPD0000032', 'SRP000008', 1, '00:00', '23:59', 50, 100),
('SRPD0000033', 'SRP000008', 2, '00:00', '23:59', 70, 140),
('SRPD0000034', 'SRP000008', 3, '00:00', '23:59', 100, 200),
('SRPD0000035', 'SRP000008', 4, '00:00', '23:59', 150, 300),
('SRPD0000036', 'SRP000008', 5, '00:00', '23:59', 250, 500),

-- Dock1 'Reparation' for 'Sailboat'
('SRPD0000037', 'SRP000009', 1, '00:00', '23:59', 50, 100),
('SRPD0000038', 'SRP000009', 2, '00:00', '23:59', 70, 140),
('SRPD0000039', 'SRP000009', 3, '00:00', '23:59', 100, 200),
('SRPD0000040', 'SRP000009', 4, '00:00', '23:59', 150, 300),
('SRPD0000041', 'SRP000009', 5, '00:00', '23:59', 250, 500),
-- Dock1 'Reparation' for 'Motorboat'
('SRPD0000042', 'SRP000010', 1, '00:00', '23:59', 50, 100),
('SRPD0000043', 'SRP000010', 2, '00:00', '23:59', 70, 140),
('SRPD0000044', 'SRP000010', 3, '00:00', '23:59', 100, 200),
('SRPD0000045', 'SRP000010', 4, '00:00', '23:59', 150, 300),
('SRPD0000046', 'SRP000010', 5, '00:00', '23:59', 250, 500),
-- Dock1 'Reparation' for 'Kayak'
('SRPD0000047', 'SRP000011', 1, '00:00', '23:59', 50, 100),
('SRPD0000048', 'SRP000011', 2, '00:00', '23:59', 70, 140),
('SRPD0000049', 'SRP000011', 3, '00:00', '23:59', 100, 200),
('SRPD0000050', 'SRP000011', 4, '00:00', '23:59', 150, 300),
('SRPD0000051', 'SRP000011', 5, '00:00', '23:59', 250, 500),
-- Dock1 'Reparation' for 'Canoe'
('SRPD0000052', 'SRP000012', 1, '00:00', '23:59', 50, 100),
('SRPD0000053', 'SRP000012', 2, '00:00', '23:59', 70, 140),
('SRPD0000054', 'SRP000012', 3, '00:00', '23:59', 100, 200),
('SRPD0000055', 'SRP000012', 4, '00:00', '23:59', 150, 300),
('SRPD0000056', 'SRP000012', 5, '00:00', '23:59', 250, 500),

-- Dock2 'Remorquage' for 'Sailboat'
('SRPD0000057', 'SRP000013', 1, '00:00', '23:59', 50, 100),
('SRPD0000058', 'SRP000013', 2, '00:00', '23:59', 70, 140),
('SRPD0000059', 'SRP000013', 3, '00:00', '23:59', 100, 200),
('SRPD0000060', 'SRP000013', 4, '00:00', '23:59', 150, 300),
-- Dock2 'Remorquage' for 'Motorboat'
('SRPD0000061', 'SRP000014', 1, '00:00', '23:59', 50, 100),
('SRPD0000062', 'SRP000014', 2, '00:00', '23:59', 70, 140),
('SRPD0000063', 'SRP000014', 3, '00:00', '23:59', 100, 200),
('SRPD0000064', 'SRP000014', 4, '00:00', '23:59', 150, 300),
-- Dock2 'Remorquage' for 'Kayak'
('SRPD0000065', 'SRP000015', 1, '00:00', '23:59', 50, 100),
('SRPD0000066', 'SRP000015', 2, '00:00', '23:59', 70, 140),
('SRPD0000067', 'SRP000015', 3, '00:00', '23:59', 100, 200),
('SRPD0000068', 'SRP000015', 4, '00:00', '23:59', 150, 300),
-- Dock2 'Remorquage' for 'Canoe'
('SRPD0000069', 'SRP000016', 1, '00:00', '23:59', 50, 100),
('SRPD0000070', 'SRP000016', 2, '00:00', '23:59', 70, 140),
('SRPD0000071', 'SRP000016', 3, '00:00', '23:59', 100, 200),
('SRPD0000072', 'SRP000016', 4, '00:00', '23:59', 150, 300),

-- Dock2 'Stationnement' for 'Sailboat'
('SRPD0000073', 'SRP000017', 1, '00:00', '23:59', 50, 100),
('SRPD0000074', 'SRP000017', 2, '00:00', '23:59', 70, 140),
('SRPD0000075', 'SRP000017', 3, '00:00', '23:59', 100, 200),
('SRPD0000076', 'SRP000017', 4, '00:00', '23:59', 150, 300),
('SRPD0000077', 'SRP000017', 5, '00:00', '23:59', 250, 500),
-- Dock2 'Stationnement' for 'Motorboat'
('SRPD0000078', 'SRP000018', 1, '00:00', '23:59', 50, 100),
('SRPD0000079', 'SRP000018', 2, '00:00', '23:59', 70, 140),
('SRPD0000080', 'SRP000018', 3, '00:00', '23:59', 100, 200),
('SRPD0000081', 'SRP000018', 4, '00:00', '23:59', 150, 300),
('SRPD0000082', 'SRP000018', 5, '00:00', '23:59', 250, 500),
-- Dock2 'Stationnement' for 'Kayak'
('SRPD0000083', 'SRP000019', 1, '00:00', '23:59', 50, 100),
('SRPD0000084', 'SRP000019', 2, '00:00', '23:59', 70, 140),
('SRPD0000085', 'SRP000019', 3, '00:00', '23:59', 100, 200),
('SRPD0000086', 'SRP000019', 4, '00:00', '23:59', 150, 300),
('SRPD0000087', 'SRP000019', 5, '00:00', '23:59', 250, 500),
-- Dock2 'Stationnement' for 'Canoe'
('SRPD0000088', 'SRP000020', 1, '00:00', '23:59', 50, 100),
('SRPD0000089', 'SRP000020', 2, '00:00', '23:59', 70, 140),
('SRPD0000090', 'SRP000020', 3, '00:00', '23:59', 100, 200),
('SRPD0000091', 'SRP000020', 4, '00:00', '23:59', 150, 300),
('SRPD0000092', 'SRP000020', 5, '00:00', '23:59', 250, 500),

-- Dock2 'Cession d eau douce' for 'Sailboat'
('SRPD0000093', 'SRP000021', 1, '00:00', '23:59', 250, 500),
-- Dock2 'Cession d eau douce' for 'Motorboat'
('SRPD0000094', 'SRP000022', 1, '00:00', '23:59', 250, 500),
-- Dock2 'Cession d eau douce' for 'Kayak'
('SRPD0000095', 'SRP000023', 1, '00:00', '23:59', 250, 500),
-- Dock2 'Cession d eau douce' for 'Motorboat'
('SRPD0000096', 'SRP000024', 1, '00:00', '23:59', 250, 500);

SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');
SELECT nextval('dock_service_price_details_sequence');