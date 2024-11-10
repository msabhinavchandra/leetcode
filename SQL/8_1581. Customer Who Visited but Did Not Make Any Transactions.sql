# Write your MySQL query statement below
select
  customer_id,
  count(*) as count_no_trans 
  -- you can write * pr visit_id or customer_id anything. 
  --inside the count the answer will be the same only.
from
  Visits
  left join Transactions on Visits.visit_id = Transactions.visit_id
where
  Transactions.transaction_id is null
group by
  customer_id;