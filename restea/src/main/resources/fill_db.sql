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
DELETE FROM blog_post;
DELETE FROM cart;


INSERT INTO origin(id, name)
VALUES (1, 'Китай'),
       (2, 'Індія');

INSERT INTO type(id, name)
VALUES (1, 'Зелений'),
       (2, 'Чорний'),
       (3, 'Фруктовий');

INSERT INTO product(id, name, description, image, price, type_id, origin_id)
VALUES (1, 'product1', 'desc1',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXEA1ARqIgj9GJ8Gj9bSwnrvuMh6fl7eHAgQ&usqp=CAU', 7, 1, 1),
       (2, 'product2', 'desc2',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXEA1ARqIgj9GJ8Gj9bSwnrvuMh6fl7eHAgQ&usqp=CAU', 15, 2,
        2),
       (3, 'product3', 'desc3',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXEA1ARqIgj9GJ8Gj9bSwnrvuMh6fl7eHAgQ&usqp=CAU', 11, 3,
        1),
       (4, 'product4', 'desc4',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXEA1ARqIgj9GJ8Gj9bSwnrvuMh6fl7eHAgQ&usqp=CAU', 8, 1,
        2),
       (5, 'product5', 'desc5',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXEA1ARqIgj9GJ8Gj9bSwnrvuMh6fl7eHAgQ&usqp=CAU', 10, 1,
        1);

INSERT INTO flavor(id, name)
VALUES (1, 'flavor1'),
       (2, 'flavor2'),
       (3, 'flavor3');

INSERT INTO property(id, name)
VALUES (1, 'property1'),
       (2, 'property2'),
       (3, 'property3');

INSERT INTO product_flavor(product_id, flavor_id)
VALUES (1, 1),
       (2, 1),
       (2, 2),
       (2, 3),
       (3, 2),
       (4, 1),
       (4, 3),
       (5, 2),
       (5, 3);


INSERT INTO product_properties(product_id, property_id)
VALUES (1, 2),
       (2, 1),
       (2, 2),
       (2, 3),
       (3, 1),
       (4, 2),
       (4, 3),
       (5, 1),
       (5, 2);

# INSERT INTO cart(cart_user_id, cart_product_id, weight)
# VALUES(1, 1, 25),
#     (1, 2, 50),
#     (1, 3, 75),
#     (2, 2, 80),
#     (2, 3, 80);

INSERT INTO blog_post(id, title, image, content)
VALUES(1, 'title1','https://kiev.karavan.com.ua/wp-content/uploads/2020/10/dimc-min.jpg', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'),
    (2, 'title2','https://kiev.karavan.com.ua/wp-content/uploads/2020/10/dimc-min.jpg', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'),
    (3, 'title3','https://kiev.karavan.com.ua/wp-content/uploads/2020/10/dimc-min.jpg', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'),
    (4, 'title4','https://kiev.karavan.com.ua/wp-content/uploads/2020/10/dimc-min.jpg', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'),
    (5, 'title5','https://kiev.karavan.com.ua/wp-content/uploads/2020/10/dimc-min.jpg', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');

-- INSERT INTO cart(cart_user_id, cart_product_id, weight)

-- Password 1234 is encrypted

INSERT INTO user (id, name, surname, patronymic, birthday, email, password, image)
VALUES (1, 'Ivan', 'Ivanovich','Ivanovich', '2022-10-28', 'test1@gmail.com', '$2a$10$9RwGiLB.ydD8c8oVxVamzOXxHYF1FQMhjrlHKY3pkCsjifrwCeJKK', 'https://images.unsplash.com/photo-1633332755192-727a05c4013d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8dXNlcnxlbnwwfHwwfHw%3D&w=1000&q=80'),
       (2, 'Petro', 'Ivanovich','Ivanovich', '2022-10-28', 'test2@gmail.com', '$2a$10$9RwGiLB.ydD8c8oVxVamzOXxHYF1FQMhjrlHKY3pkCsjifrwCeJKK', 'https://images.unsplash.com/photo-1633332755192-727a05c4013d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8dXNlcnxlbnwwfHwwfHw%3D&w=1000&q=80'),
       (3, 'Dmitriy', 'Ivanovich','Ivanovich', '2022-10-28', 'test3@gmail.com', '$2a$10$9RwGiLB.ydD8c8oVxVamzOXxHYF1FQMhjrlHKY3pkCsjifrwCeJKK', 'https://images.unsplash.com/photo-1633332755192-727a05c4013d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8dXNlcnxlbnwwfHwwfHw%3D&w=1000&q=80'),
       (4, 'Oleg', 'Ivanovich','Ivanovich', '2022-10-28', 'test4@gmail.com', '$2a$10$9RwGiLB.ydD8c8oVxVamzOXxHYF1FQMhjrlHKY3pkCsjifrwCeJKK', 'https://images.unsplash.com/photo-1633332755192-727a05c4013d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8dXNlcnxlbnwwfHwwfHw%3D&w=1000&q=80');

INSERT INTO role
VALUES (1, 'customer'),
       (3, 'admin');


INSERT INTO user_role
VALUES (1, 1),
       (1, 3),
       (2, 1),
       (3, 1),
       (4, 1);

SET FOREIGN_KEY_CHECKS = 1;