create table schedule (
    schedule_ID int primary key,
    user_ID int,
    title varchar(50),
    contents varchar(255),
    start_Date timestamp,
    last_Date timestamp,
    update_Date timestamp,
    foreign key (user_ID) references USer(user_ID)
);

create table User (
    user_ID int PRIMARY KEY,
    schedule_ID int,
    name varchar(50),
    password varchar(50),
    FOREIGN KEY (schedule_ID) references schedule(schedule_ID)
);