WITH rankEmp AS (
    SELECT 
        departmentId,
        name AS Employee,
        salary AS Salary,
        DENSE_RANK() OVER (PARTITION BY departmentId ORDER BY salary DESC) AS rnk
    FROM Employee
)
SELECT 
    d.name AS Department,
    r.Employee,
    r.Salary
FROM rankEmp r
JOIN Department d 
  ON r.departmentId = d.id
WHERE r.rnk <= 3;