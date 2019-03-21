create database req;

create schema req authorization postgres;

create table req.category (
id_category serial primary key,
name_category varchar(255)
);

create table req.rules (
id_rule serial primary key,
name_rule varchar(255)
);

create table req.roles (
id_role serial primary key,
name_role varchar(255)
);

create table req.add_rules (
id_role int references req.roles (id_role),
id_rule int references req.rules (id_rule)
);

create table req.users (
id_user serial primary key,
id_role int references req.roles(id_role),
name_user varchar(255)
);

create table req.requests (
id_request serial primary key,
id_category int references req.category(id_category),
id_user int references req.users(id_user)
);

create table req.comments (
id_comment serial primary key,
id_request int references req.requests(id_request),
comment varchar(255)
);

create table req.attachments (
id_attach serial primary key,
id_request int references req.requests(id_request),
attach varchar(255)
);

create table req.state (
id_state serial primary key,
id_request int references req.requests(id_request),
name_state varchar(255)
);
INSERT INTO req.rules (id_rule, name_rule) VALUES (1, 'add'), (2, 'delete'), (3, 'remove'),(4, 'change');
INSERT INTO req.roles (id_role, name_role) VALUES (1, 'Administrator'), (2, 'User');
INSERT INTO req.add_rules (id_role, id_rule) VALUES (1, 1), (1, 2), (1, 3), (1, 4), (2, 1);
INSERT INTO req.users (id_user, id_role, name_user) VALUES (1, 'Admin'), (2, 'User1');