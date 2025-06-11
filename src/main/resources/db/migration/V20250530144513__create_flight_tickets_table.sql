create table flight_tickets
(
    id            bigserial primary key,
    name          varchar(255) not null,
    uniqueNumber  int not null ,
    price         int not null ,
    created_date  timestamp,
    modified_date timestamp,
    aircraft_type_id bigint not null references aircraft_types(id),
    class_id bigint not null references class_types(id),
    luggage_id bigint not null references luggages(id),
    direction_id bigint not null references directions(id)
);