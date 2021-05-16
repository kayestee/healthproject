CREATE USER 'healthadmin'@'%' IDENTIFIED BY 'healthycheck';
GRANT ALL ON * . * TO 'healthadmin'@'%';
CREATE DATABASE IF NOT EXISTS healthdb;
USE healthdb;

SET GLOBAL time_zone=UTC;
SET time_zone=UTC;

SELECT 'CREATING DATABASE STRUCTURE' as 'INFO';
DROP TABLE IF EXISTS health,patient, contactinfo;

CREATE TABLE health (
        id BIGINT NOT NULL AUTO_INCREMENT,
        status VARCHAR (255),
        CONSTRAINT id PRIMARY KEY (id)
)Engine=InnoDB;

CREATE TABLE patient (
                         id BIGINT NOT NULL AUTO_INCREMENT,
                         name VARCHAR (255) NOT NULL,
                         status VARCHAR (255) NOT NULL,
                         sex VARCHAR(255) NOT NULL,
                         birthdate DATE NOT NULL,
                         contactid BIGINT UNIQUE,
                         CONSTRAINT id PRIMARY KEY (id),
                         FOREIGN KEY (id)  REFERENCES health(id)  ON DELETE CASCADE ON UPDATE CASCADE
)Engine=InnoDB;


CREATE TABLE contactinfo (
                             contactid BIGINT NOT NULL,
                             firstname VARCHAR (255),
                             lastname VARCHAR (255),
                             address VARCHAR (255),
                             state VARCHAR (255),
                             country VARCHAR (255),
                             phone VARCHAR (255),
                             CONSTRAINT contact_id PRIMARY KEY (contactid),
                             FOREIGN KEY (contactid)  REFERENCES patient(contactid)  ON DELETE CASCADE ON UPDATE CASCADE
)Engine=InnoDB;

SELECT 'Loading health' as 'INFO';
source load_health.dump;
SELECT 'Loading patient' as 'INFO';
source load_patient.dump;
SELECT 'Loading patient' as 'INFO';
source load_contactinfo.dump;
