#Create Databases
CREATE DATABASE device_db_dev;
CREATE DATABASE device_db_prod;

#Create database service accounts
CREATE USER 'device_db_dev'@'localhost' IDENTIFIED BY 'jt';
CREATE USER 'device_db_prod'@'localhost' IDENTIFIED BY 'jt';
CREATE USER 'device_db_dev'@'%' IDENTIFIED BY 'jt';
CREATE USER 'device_db_prod'@'%' IDENTIFIED BY 'jt';

#Database grants
GRANT SELECT ON device_db_dev.* to 'device_db_dev'@'localhost';
GRANT INSERT ON device_db_dev.* to 'device_db_dev'@'localhost';
GRANT DELETE ON device_db_dev.* to 'device_db_dev'@'localhost';
GRANT UPDATE ON device_db_dev.* to 'device_db_dev'@'localhost';
GRANT SELECT ON device_db_prod.* to 'device_db_prod'@'localhost';
GRANT INSERT ON device_db_prod.* to 'device_db_prod'@'localhost';
GRANT DELETE ON device_db_prod.* to 'device_db_prod'@'localhost';
GRANT UPDATE ON device_db_prod.* to 'device_db_prod'@'localhost';
GRANT SELECT ON device_db_dev.* to 'device_db_dev'@'%';
GRANT INSERT ON device_db_dev.* to 'device_db_dev'@'%';
GRANT DELETE ON device_db_dev.* to 'device_db_dev'@'%';
GRANT UPDATE ON device_db_dev.* to 'device_db_dev'@'%';
GRANT SELECT ON device_db_prod.* to 'device_db_prod'@'%';
GRANT INSERT ON device_db_prod.* to 'device_db_prod'@'%';
GRANT DELETE ON device_db_prod.* to 'device_db_prod'@'%';
GRANT UPDATE ON device_db_prod.* to 'device_db_prod'@'%';