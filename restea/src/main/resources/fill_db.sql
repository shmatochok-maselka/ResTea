USE restea;
SET FOREIGN_KEY_CHECKS=0;
DELETE FROM user;
DELETE FROM role;
DELETE FROM user_role;
DELETE FROM product;
DELETE FROM type;
DELETE FROM origin;
DELETE FROM flavor;
DELETE FROM property;
DELETE FROM product_flavor;
DELETE FROM product_properties;

INSERT INTO origin(id, name)
VALUES(1, 'Китай'),
      (2, 'Індія');

INSERT INTO type(id, name)
VALUES(1, 'Зелений'),
      (2, 'Чорний'),
      (3, 'Фруктовий');

INSERT INTO product(id, name, description, image, price, type_id, origin_id)
VALUES(1, 'product1', 'desc1','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXEA1ARqIgj9GJ8Gj9bSwnrvuMh6fl7eHAgQ&usqp=CAU', 7, 1, 1),
      (2, 'product2', 'desc2', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXEA1ARqIgj9GJ8Gj9bSwnrvuMh6fl7eHAgQ&usqp=CAU', 15, 2, 2),
       (3, 'product3', 'desc3','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXEA1ARqIgj9GJ8Gj9bSwnrvuMh6fl7eHAgQ&usqp=CAU', 11, 3, 1);

INSERT INTO flavor(id, name)
VALUES(1, 'flavor1'),
      (2, 'flavor2'),
      (3, 'flavor3');

INSERT INTO property(id, name)
VALUES(1, 'property1'),
      (2, 'property2'),
      (3, 'property3');

INSERT INTO product_flavor(product_id, flavor_id)
VALUES(1, 1),
      (2, 1),
      (2, 2),
      (2, 3),
      (3, 2);

INSERT INTO product_properties(product_id, property_id)
VALUES(1, 2),
      (2, 1),
      (2, 2),
      (2, 3),
      (3, 1);

INSERT INTO user (name, surname, birthday, bonus, email) VALUES ('Ivan', 'Ivanovich', '2022-10-28', 100, 'test@gmail.com');
INSERT INTO user (name, surname, birthday, bonus, email) VALUES ('Petro', 'Ivanovich', '2022-10-28', 100, 'test@gmail.com');
INSERT INTO user (name, surname, birthday, bonus, email) VALUES ('Dmitriy', 'Ivanovich', '2022-10-28', 100, 'test@gmail.com');
INSERT INTO user (name, surname, birthday, bonus, email) VALUES ('Oleg', 'Ivanovich', '2022-10-28', 100, 'test@gmail.com');

INSERT INTO role VALUES (1, 'customer');
INSERT INTO role VALUES (2, 'seller');
INSERT INTO role VALUES (3, 'admin');

INSERT INTO user_role VALUES (1, 2);
INSERT INTO user_role VALUES (1, 3);
INSERT INTO user_role VALUES (2, 3);
SET FOREIGN_KEY_CHECKS=1;