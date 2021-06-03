INSERT INTO role (name) VALUES ('ROLE_USER'), ('ROLE_ADMIN');

INSERT INTO users  VALUES (1,'2021-01-01 10:44:52','admin@wp.pl',true,'admin',100000000,'admin','$2a$10$xNnfVYMOWBzu.f/4Rw1XBuZFg8/4UCSjSNru/..oUPW45sFveehxa','2021-01-01 10:44:52','admin');
INSERT INTO users  VALUES (2,'2021-01-01 10:44:52','user@wp.pl',true,'user',0,'user','$2a$10$oTbnRpcdGUf30PHMuPmWr.LMV85ExRm9OqiQskztI/ompT0NQAHOK','2021-01-01 10:44:52','testuser');

INSERT INTO user_role VALUES (1,2);
INSERT INTO user_role VALUES (2,1);