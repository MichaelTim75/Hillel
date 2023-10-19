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

create table if not exists hillel.homeworks
(
    id          int  not null generated always as identity,
    name        text not null,
    description text not null,

    constraint homeworks_pk primary key (id)
);
alter table hillel.homeworks
    owner to developers;
grant select, insert, update, delete on hillel.homeworks to api_user;

create table if not exists hillel.lessons
(
    id          int       not null generated always as identity,
    name        text      not null,
    updated_at  timestamp not null,
    homework_id int       not null,

    constraint lessons_pk primary key (id),
    constraint lessons__homeworks_fk foreign key (homework_id) references hillel.homeworks (id)
        on delete restrict on update cascade
);
alter table hillel.lessons
    owner to developers;
grant select, insert, update, delete on hillel.lessons to api_user;

create table if not exists hillel.schedules
(
    id         int       not null generated always as identity,
    name       text      not null,
    updated_at timestamp not null,

    constraint schedules_pk primary key (id)
);
alter table hillel.schedules
    owner to developers;
grant select, insert, update, delete on hillel.schedules to api_user;

create table if not exists hillel.schedules__lessons
(
    schedule_id int not null,
    lesson_id   int not null,

    constraint schedules__lessons_pk primary key (schedule_id, lesson_id),
    constraint schedules__lessons__schedules_fk foreign key (schedule_id)
        references hillel.schedules (id) on delete restrict on update cascade,
    constraint schedules__lessons__lessons_fk foreign key (lesson_id)
        references hillel.lessons (id) on delete restrict on update cascade
);
alter table hillel.schedules__lessons
    owner to developers;
grant select, insert, update, delete on hillel.schedules__lessons to api_user;
create index if not exists ix_schedules__lessons__lesson_id on hillel.schedules__lessons (lesson_id);

