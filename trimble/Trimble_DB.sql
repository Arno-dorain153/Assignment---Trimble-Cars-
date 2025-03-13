CREATE DATABASE trimble_cars_db;
USE trimble_cars_db;

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('OWNER', 'CUSTOMER', 'ADMIN') NOT NULL
);

CREATE TABLE roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE authorities (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE user_roles (
    user_id BIGINT,
    role_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

CREATE TABLE role_authorities (
    role_id BIGINT,
    authority_id BIGINT,
    FOREIGN KEY (role_id) REFERENCES roles(id),
    FOREIGN KEY (authority_id) REFERENCES authorities(id)
);

CREATE TABLE cars (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    owner_id BIGINT,
    model VARCHAR(100) NOT NULL,
    status ENUM('IDLE', 'ON_LEASE', 'ON_SERVICE') DEFAULT 'IDLE',
    FOREIGN KEY (owner_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE leases (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    car_id BIGINT,
    customer_id BIGINT,
    lease_start TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    lease_end TIMESTAMP NULL,
    FOREIGN KEY (car_id) REFERENCES cars(id) ON DELETE CASCADE,
    FOREIGN KEY (customer_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Insert Roles
INSERT INTO roles (name) VALUES ('OWNER'), ('CUSTOMER'), ('ADMIN');

-- Insert Authorities
INSERT INTO authorities (name) VALUES ('REGISTER_CAR'), ('START_LEASE'), ('END_LEASE'), ('VIEW_CAR_STATUS');

-- OWNER Authorities
INSERT INTO role_authorities (role_id, authority_id) VALUES (1, 1), (1, 4);

-- CUSTOMER Authorities
INSERT INTO role_authorities (role_id, authority_id) VALUES (2, 2), (2, 3), (2, 4);

-- ADMIN Authorities (All Access)
INSERT INTO role_authorities (role_id, authority_id) VALUES (3, 1), (3, 2), (3, 3), (3, 4);

INSERT INTO users (username, password, role) VALUES
('owner1', 'encrypted_password1', 'OWNER'),
('customer1', 'encrypted_password2', 'CUSTOMER'),
('admin1', 'encrypted_password3', 'ADMIN');
