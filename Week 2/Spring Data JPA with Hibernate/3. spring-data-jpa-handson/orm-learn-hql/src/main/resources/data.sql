INSERT INTO department(dp_name)
VALUES
('IT'),
('HR');

INSERT INTO skill(sk_name)
VALUES
('Java'),
('Spring'),
('SQL');

INSERT INTO employee(em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES
('John',50000,true,'1998-05-10',1),
('Alice',60000,true,'1997-09-15',1),
('Bob',45000,false,'2000-01-20',2);

INSERT INTO employee_skill
VALUES
(1,1),
(1,2),
(2,2),
(2,3),
(3,3);