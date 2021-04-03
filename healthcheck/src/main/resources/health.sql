CREATE USER 'healthadmin'@'%' IDENTIFIED BY 'healthycheck';
GRANT ALL ON * . * TO 'healthadmin'@'%';
CREATE DATABASE IF NOT EXISTS healthdb;
USE healthdb;

CREATE TABLE health (
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR (255),
status VARCHAR (255),
CONSTRAINT PK_health PRIMARY KEY (id)
);

SET GLOBAL time_zone=UTC;
SET time_zone=UTC;

INSERT INTO health VALUES (1, 'Kalyan', 'Good health');
INSERT INTO health VALUES (2, 'Sundar', 'suffers from tiredness');

SELECT * FROM health;