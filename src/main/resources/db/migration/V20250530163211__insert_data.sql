insert into aircraft_types(name,created_date,modified_date)
values ('airbus',current_timestamp, current_timestamp),
       ('boeing', current_timestamp,current_timestamp);

insert into class_types(name,created_date,modified_date)
values ('economy',current_timestamp, current_timestamp),
       ('business', current_timestamp,current_timestamp);

insert into luggages (name,created_date,modified_date)
values ('hand luggage',current_timestamp, current_timestamp),
    ('big luggage', current_timestamp,current_timestamp);

insert into directions (name,created_date,modified_date)
values ('Europe',current_timestamp, current_timestamp),
       ('Asia', current_timestamp,current_timestamp),
       ('Africa', current_timestamp,current_timestamp),
       ('USA', current_timestamp,current_timestamp);

insert into flight_tickets (name, uniqueNumber, price, aircraft_type_id, class_id, luggage_id, direction_id, created_date, modified_date)
values ('Turkish Airlines', 123456, 120000, 1, 2, 1, 1, current_timestamp, current_timestamp),
       ('Air Astana', 153456, 150000, 2, 1, 2, 2, current_timestamp, current_timestamp),
       ('Scat', 153412, 50000, 1, 1, 1, 3, current_timestamp, current_timestamp),
       ('Air India', 167496, 153000, 1, 2, 2, 4, current_timestamp, current_timestamp);


