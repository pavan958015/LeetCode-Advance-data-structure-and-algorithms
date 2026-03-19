# Write your MySQL query statement below

select 
 s.student_id , 
 s.student_name , 
 sub.subject_name ,
 count(e.subject_name) as attended_exams
from Students s cross join Subjects sub
Left join Examinations e
on 
e.subject_name=sub.subject_name 
and s.student_id=e.student_id

group by s.student_id , s.student_name , sub.subject_name
order by s.student_id ,sub.subject_name;