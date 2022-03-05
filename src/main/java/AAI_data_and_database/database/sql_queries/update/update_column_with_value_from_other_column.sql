update inspection_case set activated_at = modified_at

where created_at < '2021-11-14 09:13:28.791549'

  and activated_at is null ;