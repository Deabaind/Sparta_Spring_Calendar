create schema calendar;

create table calendar.user
(
    user_ID  int PRIMARY KEY,
    name     varchar(50),
    password varchar(50)
);

create table calendar.schedule
(
    schedule_ID int primary key,
    user_ID     int,
    title       varchar(50),
    contents    varchar(255),
    start_Date  timestamp,
    last_Date   timestamp,
    update_Date timestamp,
    foreign key (user_ID) references calendar.user (user_ID)
);