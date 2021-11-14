DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS vote_users;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS launch_menu;
DROP TABLE IF EXISTS restaurants;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE users
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name       VARCHAR                           NOT NULL,
    email      VARCHAR                           NOT NULL,
    password   VARCHAR                           NOT NULL,
    registered TIMESTAMP           DEFAULT now() NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE restaurants
(
    id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name VARCHAR NOT NULL
);

CREATE TABLE launch_menu
(
    id             INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    restaurants_id INTEGER NOT NULL,
    name           VARCHAR NOT NULL,
    price          DECIMAL NOT NULL,
    date           DATE    NOT NULL,
    FOREIGN KEY (restaurants_id) REFERENCES restaurants (id) ON DELETE CASCADE
);

CREATE TABLE vote_users
(
    user_id        INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    restaurants_id INTEGER NOT NULL,
    date_vote      DATE    NOT NULL,
    FOREIGN KEY (restaurants_id) REFERENCES restaurants (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX vote_users_unique_user_date_vote_idx ON vote_users (user_id, date_vote);

