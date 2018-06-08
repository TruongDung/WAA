INSERT INTO ADDRESS (ID, CITY, STATE, COUNTRY, zipcode) VALUES (1, 'Fairfield', 'Iowa', 'US', '52556');
INSERT INTO ADDRESS (ID, CITY, STATE, COUNTRY, ZIPCODE) VALUES (2, 'IOWA', 'Iowa', 'US', '52558');

INSERT INTO PERSON (ID, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS_ID, PHONE, enable) VALUES (1, 'Admin', 'Admin', 'admin', 1, '+123456789', 1);
INSERT INTO PERSON (ID, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS_ID, PHONE, ENABLE) VALUES (2, 'Customer', 'Customer', 'customer', 2, '+111111111', 1);

INSERT INTO PRODUCT(ID, product_Name, DESCRIPTION, PRICE, PRODUCT_TYPE) VALUES (1, 'Capuchino', 'The variety of discernable tastes, such as chocolate, berry, citrus, caramel, sweet, used in describing coffee. Some become more evident as the coffee cools.', '100.00', 'BREAKFAST');
