create schema if not exists hillel;

create table if not exists hillel.groups
(
    id   serial not null,
    name text   not null,
    constraint groups_pk primary key (id)
);

create table if not exists hillel.students
(
    id       serial not null,
    name     text   not null,
    email    text   not null,
    group_id int    not null,
    constraint students_pk primary key (id),
    constraint students_groups__fk foreign key (group_id) references hillel.groups (id)
);

create table if not exists hillel.courses
(
    id   serial not null,
    name text   not null,
    constraint courses_pk primary key (id)
);

create table if not exists hillel.students_courses
(
    student_id int not null,
    course_id  int not null,
    constraint students_courses_pk primary key (student_id, course_id),
    constraint students_courses__students__fk foreign key (student_id) references hillel.students (id),
    constraint students_courses__courses__fk foreign key (course_id) references hillel.courses (id)
);
