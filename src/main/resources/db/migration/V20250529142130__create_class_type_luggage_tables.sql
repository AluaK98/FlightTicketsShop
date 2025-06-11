create table class_types
(
    id            bigserial primary key,
    name          varchar(255) not null,
    created_date  timestamp,
    modified_date timestamp
);

create table luggages
(
    id            bigserial primary key,
    name          varchar(255) not null,
    created_date  timestamp,
    modified_date timestamp
)

