ALTER TABLE employees ADD balance NUMERIC(8,2) default 100
UPDATE employees set balance = 100 WHERE employee_id = 100
INSERT INTO employees (last_name, email, hire_date, job_id, balance)  VALUES ('Van', 'Du', current_date, 'SA_REP', 100);
SELECT SUM(balance) FROM employees WHERE job_id = 'SA_REP';
CREATE VIEW	empvu80
AS SELECT	employee_id, last_name, salary  
	FROM	employees
WHERE	department_id = 80;
select * from empvu80;
DROP FUNCTION get_emloyees();
create or replace function get_emloyees()
returns table (employee_id integer,
first_name varchar,
last_name varchar,
email varchar,
phone_number varchar,
hire_date timestamp,
job_id varchar,
salary numeric,
commission_pct  numeric,
manager_id  integer,
department_id  integer,
balance numeric)
language plpgsql  
as $$
	BEGIN
	return query 
		select * from employees;
	END;
$$;
select * from get_emloyees();