create schema calendar;

create table calendar.schedule
(
    id BIGINT AUTO_INCREMENT primary key,
    title       varchar(50),
    contents    varchar(255),
    startDate  timestamp,
    lastDate   timestamp,
    updateDate timestamp,
    name varchar(50),
    password varchar(50)
);

