INSERT INTO country VALUES ('IN','India');
INSERT INTO country VALUES ('US','United States of America');
INSERT INTO country VALUES ('ZA','South Africa');
INSERT INTO country VALUES ('ZM','Zambia');
INSERT INTO country VALUES ('ZW','Zimbabwe');
INSERT INTO country VALUES ('LU','Luxembourg');
INSERT INTO country VALUES ('DJ','Djibouti');
INSERT INTO country VALUES ('BV','Bouvet Island');
INSERT INTO country VALUES ('TF','French Southern Territories');
INSERT INTO country VALUES ('UM','United States Minor Outlying Islands');
INSERT INTO country VALUES ('GS','South Georgia and the South Sandwich Islands');
INSERT INTO country VALUES ('SS','South Sudan');
INSERT INTO country VALUES ('GP','Guadeloupe');

INSERT INTO stock(st_code,st_date,st_open,st_close,st_volume) VALUES
('FB','2019-09-03',184.00,182.39,9779400),
('FB','2019-09-10',187.44,186.17,15455900),
('FB','2019-09-20',190.66,189.93,19934200),

('GOOGL','2019-04-22',1236.67,1253.76,954200),
('GOOGL','2019-04-23',1256.64,1270.59,1593400),
('GOOGL','2019-10-17',1251.40,1252.80,1047900),

('NFLX','2018-12-24',242.00,233.88,9547600),
('NFLX','2018-12-21',263.83,246.39,21397600),
('NFLX','2018-12-26',233.92,253.67,14402700);

INSERT INTO department(dp_name)
VALUES
('IT'),
('HR');

INSERT INTO employee(em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES
('John',50000,true,'1998-05-10',1),
('Alice',60000,true,'1997-09-15',1),
('Bob',45000,false,'2000-01-20',2);

INSERT INTO skill(sk_name)
VALUES
('Java'),
('Spring'),
('SQL');

INSERT INTO employee_skill
VALUES
(1,1),
(1,2),
(2,2),
(2,3),
(3,3);