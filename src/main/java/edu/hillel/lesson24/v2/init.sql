do
$$
    BEGIN
        if not exists(select 1 from pg_roles where rolname = 'developers') then
            create role developers superuser nologin;
        end if;
    end;
$$;

do
$$
    BEGIN
        if not exists(select 1 from pg_roles where rolname = 'api_user') then
            create role api_user login password 'password';
        end if;
    end;
$$;

create schema if not exists hillel authorization developers;
grant usage on schema hillel to api_user;

create table if not exists hillel.data
(
    data text not null
);
alter table hillel.data
    owner to developers;
grant select, insert, update, delete on hillel.data to api_user;
