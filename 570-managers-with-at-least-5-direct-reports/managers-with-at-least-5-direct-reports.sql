# Write your MySQL query statement below
-- select e1.name
-- from Employee e1 inner join Employee e2
-- on e1.id=e2.managerId
-- group by e2.managerId

-- having count(e2.managerId)>=5

with recursive emp_cte as (
    select
        id,name,managerId from Employee
    union all
    select
        e.id, e.name,e.managerId from Employee e
    join emp_cte c
      on e.managerId = c.id
)

select m.name from Employee e 
join Employee m 
on e.managerId = m.id
group by m.id, m.name
having count(*) >= 5;