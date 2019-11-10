CREATE TABLE IF NOT EXISTS USERS (
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(255) not null,
    email varchar(255) not null unique,
    phoneNumber varchar(255),
    password varchar(255) not null,
    subscription varchar(255),
    userRole varchar(255)
);