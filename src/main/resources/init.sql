DROP TABLE IF EXISTS SATELLITE;
CREATE TABLE SATELLITE (
    NAME VARCHAR(50) PRIMARY KEY,
    DISTANCE INT(8,2) NOT NULL,
    MESSAGE ARRAY
);