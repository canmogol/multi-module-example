BEGIN;

create table if not exists employee (
    id character(36) not null unique,
    name text NOT NULL,
    retired boolean not null
);

alter TABLE ONLY employee ADD CONSTRAINT employee_pkey PRIMARY KEY (id);

insert into employee(id, name, retired) values('8bf65586-797c-47c1-993c-e0567796f724', 'William Shakespeare', true);
insert into employee(id, name, retired) values('c245ad0e-8340-4ff6-9852-eb3cecb29dec', 'Mary Queen of Scots', true);
insert into employee(id, name, retired) values('7459ea99-08c3-4cda-ac0f-0ce059f6458f', 'Galileo Galilei', false);
insert into employee(id, name, retired) values('2b6baf5e-5438-42cd-8ac4-4e0922cf1020', 'Ivan The Terrible', false);

COMMIT;