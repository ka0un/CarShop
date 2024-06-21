CREATE TABLE IF NOT EXISTS Vehicle (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255),
                         vehicle_brand VARCHAR(255),
                         vehicle_type VARCHAR(255),
                         vehicle_year VARCHAR(4)
);

CREATE TABLE User (
                      username VARCHAR(255) NOT NULL PRIMARY KEY,
                      password VARCHAR(255) NOT NULL,
                      role ENUM('ADMIN', 'BUYER', 'SELLER') NOT NULL
);