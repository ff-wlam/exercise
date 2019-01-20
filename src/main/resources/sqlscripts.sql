create schema applause;

use applause;

drop table bugs;
drop table tester_device;
drop table devices;
drop table testers;

create table devices ( id INT, description VARCHAR(64), UNIQUE KEY unique_desc (description), PRIMARY KEY(id) ) ENGINE=InnoDB;
create table testers ( id INT, first_name VARCHAR(64), last_name VARCHAR(64), country VARCHAR(3), last_login DATE, PRIMARY KEY(id) ) ENGINE=InnoDB;
create table tester_device ( tester_id INT, device_id INT, CONSTRAINT `fk_tester` FOREIGN KEY (`tester_id`) REFERENCES `testers` (`id`), CONSTRAINT `fk_device` FOREIGN KEY (`device_id`) REFERENCES `devices` (`id`) ) ENGINE=InnoDB;
create table bugs ( id INT, tester_id INT, device_id INT, PRIMARY KEY(id), CONSTRAINT `fk_bugs_tester` FOREIGN KEY (`tester_id`) REFERENCES `testers` (`id`), CONSTRAINT `fk_bugs_device` FOREIGN KEY (`device_id`) REFERENCES `devices` (`id`) ) ENGINE=InnoDB;


load data local infile '/Users/wlam/Downloads/testers.csv' into table testers fields terminated by ',' enclosed by '"' lines terminated by '\n' ignore 1 rows (id, first_name, last_name, country, last_login);
load data local infile '/Users/wlam/Downloads/devices.csv' into table devices fields terminated by ',' enclosed by '"' lines terminated by '\n' ignore 1 rows (id, description);
load data local infile '/Users/wlam/Downloads/bugs.csv' into table bugs fields terminated by ',' enclosed by '"' lines terminated by '\n' ignore 1 rows (id, device_id, tester_id);