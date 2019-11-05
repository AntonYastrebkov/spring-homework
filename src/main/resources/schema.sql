DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS (
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(255),
    email varchar(255),
    phoneNumber varchar(255),
    password varchar(255),
    subscription varchar(255),
    userRole varchar(255)
);