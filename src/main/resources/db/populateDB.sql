DELETE
FROM user_roles;
DELETE
FROM vote_users;
DELETE
FROM users;
DELETE
FROM launch_menu;
DELETE
FROM restaurants;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

INSERT INTO restaurants (name)
VALUES ('Браво'),
       ('Крыша'),
       ('Перекрёсток'),
       ('Жанар'),
       ('Траткир');

INSERT INTO launch_menu (restaurant_id, name, price, date)
VALUES (100002, 'Шашлык Свинина', 2000, '2021-11-14'),
       (100003, 'Шашлык Баранина', 2400, '2021-11-14'),
       (100004, 'Салат Цезарь', 1800, '2021-11-14'),
       (100005, 'Королевский салат', 1500, '2021-11-14'),
       (100006, 'Донер в лаваше', 1000, '2021-11-17');

INSERT INTO vote_users (user_id, restaurant_id, date_vote)
VALUES (100000, 100003, '2021-11-14'),
       (100001, 100006, '2021-11-17');
