# Write your MySQL query statement below

-- select e1.name from Employee e1
-- inner join Employee e2
-- where e1.id=e2.managerId
-- -- group by e2.managerId
-- GROUP BY e1.id, e1.name
-- having count(e2.managerId)>=5


WITH manager_count AS (
    SELECT
        managerId,
        COUNT(*) AS cnt
    FROM Employee
    WHERE managerId IS NOT NULL
    GROUP BY managerId
    HAVING COUNT(*) >= 5
)
SELECT e.name
FROM Employee e
JOIN manager_count mc
ON e.id = mc.managerId;