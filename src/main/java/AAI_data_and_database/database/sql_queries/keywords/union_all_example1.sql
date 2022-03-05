---get all discrepancies if they refer to one of the specified passage_ids
---since a passage can contain 0 or many discrepancies, use UNION ALL

SELECT * FROM  public.discrepancy WHERE passage_id= 'C5A951C92D28F6449FDB119B4D015168'
UNION ALL SELECT * FROM  public.discrepancy WHERE passage_id= '6263C5AFA735C54FB7A2453808014655'
UNION ALL SELECT * FROM  public.discrepancy WHERE passage_id= 'D19610631D8D274C8353058F6A040326'
UNION ALL SELECT * FROM  public.discrepancy WHERE passage_id= 'CD8B03B6D2C5A144BBE9A1978B022409'
UNION ALL SELECT * FROM  public.discrepancy WHERE passage_id= '47F2AB7C1ACA754FBED589B35E016780'
UNION ALL SELECT * FROM  public.discrepancy WHERE passage_id= 'EFA7C7E992ECEE4897AAAE4AB0022701'
UNION ALL SELECT * FROM  public.discrepancy WHERE passage_id= 'E451197DE9AD5D469976E1E65B009389'
UNION ALL SELECT * FROM  public.discrepancy WHERE passage_id= 'D75DBDAA8AE07B45844644E9E6009778'
UNION ALL SELECT * FROM  public.discrepancy WHERE passage_id= '3849981F1385F0479BD89564C3035061'
UNION ALL SELECT * FROM  public.discrepancy WHERE passage_id= '1BD847E99018BA4DAB208D7AAD040043'
UNION ALL SELECT * FROM  public.discrepancy WHERE passage_id= 'AB51AEDDDB2DC041B0BE89B2A2040074'
UNION ALL SELECT * FROM  public.discrepancy WHERE passage_id= '804615E50F67034B98ED138F39017152'
UNION ALL SELECT * FROM  public.discrepancy WHERE passage_id= '6F8508BA5E651141B11DFBB273010492'
UNION ALL SELECT * FROM  public.discrepancy WHERE passage_id= '6BA5CE36F32C8047A026B5820D010494'
UNION ALL SELECT * FROM  public.discrepancy WHERE passage_id= '1BB57FA926FA4A4386082583B8023081'
UNION ALL SELECT * FROM  public.discrepancy WHERE passage_id= 'BF2453C42BF062438B933D75F9057998'
UNION ALL SELECT * FROM  public.discrepancy WHERE passage_id= 'BBC931E149069D409F8B1C2866017576';