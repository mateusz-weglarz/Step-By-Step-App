INSERT INTO role (name)VALUES ('ROLE_USER'),('ROLE_ADMIN'),('ROLE_GROUP_ADMIN');

INSERT INTO users VALUES (1, '2021-01-01 10:44:52', 'admin@wp.pl', true, 'admin', 100000000, 'admin','$2a$10$xNnfVYMOWBzu.f/4Rw1XBuZFg8/4UCSjSNru/..oUPW45sFveehxa', '2021-01-01 10:44:52', 'admin'),(2, '2021-01-01 10:44:52', 'user@wp.pl', true, 'user', 0, 'user','$2a$10$oTbnRpcdGUf30PHMuPmWr.LMV85ExRm9OqiQskztI/ompT0NQAHOK', '2021-01-01 10:44:52', 'testuser');

INSERT INTO user_role VALUES (1, 2),(2, 1);

INSERT INTO activities VALUES (1, '2021-01-01 11:44:52', 'Spacer poranny1', 1001, '2021-01-01 11:44:52', 1),(2, '2021-02-02 12:44:52', 'Spacer poranny2', 1002, '2021-02-02 12:44:52', 1),(3, '2021-03-03 13:44:52', 'Spacer poranny3', 1003, '2021-03-03 13:44:52', 1),(4, '2021-04-04 14:44:52', 'Spacer poranny4', 1004, '2021-04-04 14:44:52', 1),(5, '2021-05-05 15:44:52', 'Spacer poranny5', 1005, '2021-05-05 15:44:52', 1),(6, '2021-06-06 16:44:52', 'Spacer poranny6', 1006, '2021-06-06 16:44:52', 1);
INSERT INTO activities VALUES (7, '2021-01-01 21:44:52', 'Spacer wieczorny1', 1001, '2021-01-01 21:44:52', 2),(8, '2021-02-02 21:44:52', 'Spacer wieczorny2', 1002, '2021-02-02 21:44:52', 2),(9, '2021-03-03 21:44:52', 'Spacer wieczorny3', 1003, '2021-03-03 21:44:52', 2),(10, '2021-04-04 21:44:52', 'Spacer wieczorny4', 1004, '2021-04-04 21:44:52', 2),(11, '2021-04-05 21:44:52', 'Spacer wieczorny5', 1005, '2021-05-05 21:44:52', 2),(12, '2021-05-06 21:44:52', 'Spacer wieczorny6', 1006, '2021-06-06 21:44:52', 2);

INSERT INTO teams VALUES (1,'2021-01-01 21:44:52','Opis pierwszej grupy',1200000,1,'Grupa 1','2021-01-01 21:44:52'),(2,'2021-01-01 21:44:52','Opis drugiej grupy',999999,2,'Grupa 2','2021-01-01 21:44:52');;

INSERT INTO user_groups VALUES (1,1),(2,1),(2,2);