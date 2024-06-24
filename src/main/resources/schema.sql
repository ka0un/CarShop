CREATE TABLE IF NOT EXISTS Vehicle (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255),
                         vehicle_brand VARCHAR(255),
                         vehicle_type VARCHAR(255),
                         vehicle_year VARCHAR(4)
);

CREATE TABLE IF NOT EXISTS UserDetails (
                      username VARCHAR(255) NOT NULL PRIMARY KEY,
                      password VARCHAR(255) NOT NULL,
                      role ENUM('ADMIN', 'BUYER', 'SELLER') NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
                      username varchar_ignorecase(50) not null primary key,
                        password varchar_ignorecase(500) not null,
                        enabled boolean not null
);

CREATE TABLE IF NOT EXISTS authorities (
                      username varchar_ignorecase(50) not null,
                        authority varchar_ignorecase(50) not null,
                        constraint fk_authorities_users foreign key(username) references users(username)
);

CREATE UNIQUE INDEX IF NOT EXISTS ix_auth_username on authorities (username,authority);