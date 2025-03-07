# Write your MySQL query statement below
select
    W1.id
from
    Weather W1,
    Weather W2
where
    datediff(W1.recordDate, W2.recordDate) = 1
    and W1.temperature > W2.temperature;