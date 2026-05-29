-- # Write your MySQL query statement below

-- select event_day as day , emp_id , sum(out_time-in_time) as total_time
-- from Employees 
-- group by event_day , emp_id


WITH session_time AS (
    SELECT
        event_day,
        emp_id,
        (out_time - in_time) AS time_spent
    FROM Employees
)
SELECT
    event_day AS day,
    emp_id,
    SUM(time_spent) AS total_time
FROM session_time
GROUP BY event_day, emp_id;