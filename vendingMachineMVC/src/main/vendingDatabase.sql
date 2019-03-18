BEGIN TRANSACTION;
CREATE TABLE slots(
        slot_number varchar,
        name varchar,
        type varchar,
        quantity int,
        price decimal);

INSERT INTO slots(slot_number, name, type, quantity, price)
VALUES(    'A1', 'Potato Crisps', 'Chip', '5', '3.05');
INSERT INTO slots(slot_number, name, type, quantity, price)
VALUES(    'A2', 'Stackers', 'Chip', '5', '1.45');
INSERT INTO slots(slot_number, name, type, quantity, price)
VALUES(    'A3', 'Grain Waves', 'Chip', '5', '2.75');
INSERT INTO slots(slot_number, name, type, quantity, price)
VALUES(    'A4', 'Cloud Popcorn', 'Chip', '5', '3.65');

INSERT INTO slots(slot_number, name, type, quantity, price)
VALUES(    'B1', 'Moonpie', 'Candy', '5', '1.80');
INSERT INTO slots(slot_number, name, type, quantity, price)
VALUES(    'B2', 'Cowtales', 'Candy', '5', '1.50');
INSERT INTO slots(slot_number, name, type, quantity, price)
VALUES(    'B3', 'Wonka Bar', 'Candy', '5', '1.50');
INSERT INTO slots(slot_number, name, type, quantity, price)
VALUES(    'B4', 'Crunchie', 'Candy', '5', '1.75');

INSERT INTO slots(slot_number, name, type, quantity, price)
VALUES(    'C1', 'Cola', 'Drink', '5', '1.25');
INSERT INTO slots(slot_number, name, type, quantity, price)
VALUES(    'C2', 'Dr. Salt', 'Drink', '5', '1.50');
INSERT INTO slots(slot_number, name, type, quantity, price)
VALUES(    'C3', 'Mountain Melter', 'Drink', '5', '1.50');
INSERT INTO slots(slot_number, name, type, quantity, price)
VALUES(    'C4', 'Heavy', 'Drink', '5', '1.50');

INSERT INTO slots(slot_number, name, type, quantity, price)
VALUES(    'D1', 'U-Chews', 'Gum', '5', '0.85');
INSERT INTO slots(slot_number, name, type, quantity, price)
VALUES(    'D2', 'Little League Chew', 'Gum', '5', '0.95');
INSERT INTO slots(slot_number, name, type, quantity, price)
VALUES(    'D3', 'Chiclets', 'Gum', '5', '0.75');
INSERT INTO slots(slot_number, name, type, quantity, price)
VALUES(    'D4', 'Triplemint', 'Gum', '5', '0.75');

ROLLBACK; 
        