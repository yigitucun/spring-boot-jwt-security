create table users
(
    id       serial
        primary key,
    name     varchar(255),
    password varchar(255),
    username varchar(255)
);

alter table users
    owner to postgres;

INSERT INTO public.users (id, name, password, username) VALUES (6, 'yiğit ali', '$2a$10$jz.69DgXlqlmESjc9SQMmObwiDyyYgiyeY0wM8SSvs7GfeGIwqUrC', 'yigit1232');
INSERT INTO public.users (id, name, password, username) VALUES (7, 'yiğit ali', '$2a$10$rbTzCBU3ImDwqPG2E9PJbuHg3JW.rh1TNhsVTkgj6Bh4fXeUf0y4y', 'efe');
