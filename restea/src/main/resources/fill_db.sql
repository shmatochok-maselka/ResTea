USE restea;
SET FOREIGN_KEY_CHECKS = 0;
DELETE
FROM user;
DELETE
FROM role;
DELETE
FROM user_role;
DELETE
FROM product;
DELETE
FROM type;
DELETE
FROM origin;
DELETE
FROM flavor;
DELETE
FROM properties;
DELETE
FROM product_flavor;
DELETE
FROM product_properties;

INSERT INTO origin(origin_id, name)
VALUES (1, 'Китай'),
       (2, 'Індія');

INSERT INTO type(type_id, name)
VALUES (1, 'Зелений'),
       (2, 'Чорний'),
       (3, 'Фруктовий');

INSERT INTO product(product_id, name, description, price, type_id, origin_id)
VALUES (1, 'product1', 'desc1', 150, 1, 2),
       (2, 'product2', 'desc2', 180, 2, 3),
       (3, 'product3', 'desc3', 200, 2, 1);

INSERT INTO flavor(flavor_id, name)
VALUES (1, 'flavor1'),
       (2, 'flavor2'),
       (3, 'flavor3');

INSERT INTO properties(properties_id, name)
VALUES (1, 'property1'),
       (2, 'property2'),
       (3, 'property3');

INSERT INTO product_flavor(product_id, flavor_id)
VALUES (1, 1),
       (2, 1),
       (2, 2),
       (2, 3),
       (3, 2);

INSERT INTO product_properties(product_id, properties_id)
VALUES (1, 2),
       (2, 1),
       (2, 2),
       (2, 3),
       (3, 1);

-- Password 1234 is encrypted
INSERT INTO user (name, surname, birthday, bonus, email, password)
VALUES ('Ivan', 'Ivanovich', '2022-10-28', 100, 'test1@gmail.com', '$2a$10$9RwGiLB.ydD8c8oVxVamzOXxHYF1FQMhjrlHKY3pkCsjifrwCeJKK'),
       ('Petro', 'Ivanovich', '2022-10-28', 100, 'test2@gmail.com', '$2a$10$9RwGiLB.ydD8c8oVxVamzOXxHYF1FQMhjrlHKY3pkCsjifrwCeJKK'),
       ('Dmitriy', 'Ivanovich', '2022-10-28', 100, 'test3@gmail.com', '$2a$10$9RwGiLB.ydD8c8oVxVamzOXxHYF1FQMhjrlHKY3pkCsjifrwCeJKK'),
       ('Oleg', 'Ivanovich', '2022-10-28', 100, 'test4@gmail.com', '$2a$10$9RwGiLB.ydD8c8oVxVamzOXxHYF1FQMhjrlHKY3pkCsjifrwCeJKK');

INSERT INTO role
VALUES (1, 'customer');
INSERT INTO role
VALUES (2, 'seller');
INSERT INTO role
VALUES (3, 'admin');

INSERT INTO user_role
VALUES (1, 2);
INSERT INTO user_role
VALUES (1, 3);
INSERT INTO user_role
VALUES (2, 3);
SET FOREIGN_KEY_CHECKS = 1;