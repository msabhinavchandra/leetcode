# Write your MySQL query statement below
select
    Em.name,
    B.bonus
from
    Employee Em
    left join Bonus B on B.empId = Em.empId
where
    B.bonus < 1000
    or B.bonus is null;

-- #for the intersected things
-- # B.bonus<1000 , we need bonus of less than 1000
-- # for the people who have the bonus
-- #for the people who don't have it
-- their bonus is null so we need those people too.
