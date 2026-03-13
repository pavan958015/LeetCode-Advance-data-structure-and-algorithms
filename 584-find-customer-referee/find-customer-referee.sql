# Write your MySQL query statement below

-- it will not give correct ans because it does not return any null values

-- 1.
-- select name from Customer 
-- where referee_id!=2;


-- 2.
-- correct

-- select name from customer 
-- where referee_id !=2 or referee_id is null;


-- 3.

select name from customer 

where 
IFNULL (referee_id , 0) <> 2;