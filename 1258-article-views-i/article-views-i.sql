-- distinct for no dublicates
-- we have to return as id column so use keyword as for rename column
select distinct author_id as id
from Views
where author_id=viewer_id
-- for asending order we will use order by 
order by id;