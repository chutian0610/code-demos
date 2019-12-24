create user 'demo'@'localhost' identified BY '1qazXSW@';
create database tests character set utf8;
grant all privileges on tests.* to 'demo'@'localhost';--
flush privileges;