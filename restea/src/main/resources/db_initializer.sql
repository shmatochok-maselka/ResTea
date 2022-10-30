USE restea;
SET FOREIGN_KEY_CHECKS=0;
DELETE FROM user;
DELETE FROM role;
DELETE FROM user_role;

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