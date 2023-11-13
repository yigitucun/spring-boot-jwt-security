create table roles
(
    id   serial
        primary key,
    role varchar(255)
);

alter table roles
    owner to postgres;

INSERT INTO public.roles (id, role) VALUES (1, 'ADMIN');
INSERT INTO public.roles (id, role) VALUES (2, 'USER');
