-- 3 dep, 4 projects, 8 employees
-- 1 project -> 2 employees & 1 dep -> 2 employees
INSERT INTO project (project_id, project_name, project_start_date)
VALUES (DEFAULT, 'SoundWaves Manipulation', '2020-10-16'),
        (DEFAULT, 'GPS Navigation', '2020-02-14'),
        (DEFAULT, 'Website', '2020-01-25'),
        (DEFAULT, 'Mobile Thermostat Controller', '2020-12-4')
;


SELECT * 
FROM project
;

INSERT INTO project_employee (slot_id, employee_id, project_id)
VALUES (DEFAULT,'1', '1'),
        (DEFAULT, '2', '1'),
        (DEFAULT, '3', '2'),
        (DEFAULT, '4', '2'),
        (DEFAULT, '5', '3'),
        (DEFAULT, '6', '3'),
        (DEFAULT, '7', '4'),
        (DEFAULT, '8', '4')
;

SELECT *
FROM project_employee
;

INSERT INTO department (dep_id, dep_name)
VALUES ('0', 'NO DEP'),
       (DEFAULT, 'IT'),
       (DEFAULT, 'FINANCE'),
       (DEFAULT, 'Customer Service')
;



SELECT * 
FROM department
;

INSERT INTO department_employee (dep_slot_id, dep_id, employee_id)
VALUES (DEFAULT, '1', '1'),
        (DEFAULT, '1', '2'),
        (DEFAULT, '2', '3'),
        (DEFAULT, '2', '4'),
        (DEFAULT, '3', '5'),
        (DEFAULT, '3', '6'),
        (DEFAULT, '0', '7'),
        (DEFAULT, '0', '8')
;

SELECT *
FROM department_employee 
;

INSERT INTO employee (employee_id, title, last_name, first_name, gender, date_of_birth, date_of_hire)
VALUES  (DEFAULT, 'CEO', 'Craig', 'Shane','Male', '06-05-1999', '10-15-2020'), 
        (DEFAULT, 'CFO', 'Craig', 'Shane','Male', '06-05-1999', '10-15-2020'),
        (DEFAULT, 'CTO', 'Craig', 'Shane','Male', '06-05-1999', '10-15-2020'),
        (DEFAULT, 'General Manager', 'Craig', 'Shane','Male', '06-05-1999', '10-15-2020'),
        (DEFAULT, 'Supervisor', 'Craig', 'Shane','Male', '06-05-1999', '10-15-2020'),
        (DEFAULT, 'Senior Developer', 'Craig', 'Shane','Male', '06-05-1999', '10-15-2020'),
        (DEFAULT, 'Software Developer', 'Craig', 'Shane','Male', '06-05-1999', '10-15-2020'),
        (DEFAULT, 'Junior', 'Craig', 'Shane','Male', '06-05-1999', '10-15-2020')
;


SELECT *
FROM employee;