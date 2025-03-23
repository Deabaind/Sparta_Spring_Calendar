create table Calendar (
    Calendar_ID int primary key,
    Title varchar(150),
    Contents varchar(255),
    Start_Date timestamp,
    Last_Date timestamp,
    User_ID int,
    foreign key (User_ID) references USer(User_ID)
);

create table User (
    User_ID int PRIMARY KEY,
    First_Name varchar(100),
    Last_Name varchar(100),
    Email varchar(100),
    Calendar_ID int,
    FOREIGN KEY (Calendar_ID) references Calendar(Calendar_ID)
);