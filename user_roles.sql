create table user_roles
(
    user_id integer not null
        constraint fkhfh9dx7w3ubf1co1vdev94g3f
            references users,
    role_id integer not null
        constraint fkh8ciramu9cc9q3qcqiv4ue8a6
            references roles
);

alter table user_roles
    owner to postgres;

INSERT INTO public.user_roles (user_id, role_id) VALUES (6, 2);
INSERT INTO public.user_roles (user_id, role_id) VALUES (6, 1);
INSERT INTO public.user_roles (user_id, role_id) VALUES (7, 2);
INSERT INTO public.user_roles (user_id, role_id) VALUES (7, 1);
