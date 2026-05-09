CREATE DATABASE IF NOT EXISTS ticketdb;
USE ticketdb;

CREATE TABLE users(
 id BIGINT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(100),
 email VARCHAR(100),
 password VARCHAR(100),
 role VARCHAR(20)
);

CREATE TABLE vehicle(
 id BIGINT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(100),
 type VARCHAR(50),
 seat_capacity INT
);

CREATE TABLE route(
 id BIGINT PRIMARY KEY AUTO_INCREMENT,
 source VARCHAR(100),
 destination VARCHAR(100),
 price DOUBLE,
 departure_time DATETIME,
 vehicle_id BIGINT,
 FOREIGN KEY(vehicle_id) REFERENCES vehicle(id)
);

CREATE TABLE booking(
 id BIGINT PRIMARY KEY AUTO_INCREMENT,
 pnr VARCHAR(20),
 seat_number INT,
 journey_date DATE,
 user_id BIGINT,
 route_id BIGINT,
 FOREIGN KEY(user_id) REFERENCES users(id),
 FOREIGN KEY(route_id) REFERENCES route(id)
);