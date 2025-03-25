create schema calendar;

create table calendar.schedule
(
    id BIGINT AUTO_INCREMENT primary key,
    name varchar(50),
    password varchar(50),
    title       varchar(50),
    contents    varchar(255),
    startDate  timestamp,
    lastDate   timestamp,
    createDate timestamp,
    updateDate timestamp

);

