-- 4222fd07-7311-4dae-b5b7-24a8b1315d72
-- d2bfa73a-27dd-4dae-b254-b2811dd24a46
-- 5a3d2d28-1e7a-47fd-877e-5f4e0ebbcd44

--  Join um alle Verbindungen zu sehen 
SELECT jo.id, jo.predecessor_id, jc.id, jc.predecessor_id
FROM journey_declaration jo
         JOIN journey_declaration jc ON jo.id = jc.predecessor_id;


WITH RECURSIVE get_child (journey_id, pre_id) as
                   (
                       SELECT id, predecessor_id
                       FROM journey_declaration
                       WHERE id = '4222fd07-7311-4dae-b5b7-24a8b1315d72'
                       UNION ALL
                       SELECT jc.id, jc.predecessor_id
                       FROM get_child,
                            journey_declaration jo
                                JOIN journey_declaration jc ON jo.id = jc.predecessor_id
                       WHERE jc.predecessor_id = journey_id
                   )
SELECT *
FROM get_child;

WITH RECURSIVE get_parent (journey_id, pre_id) as
                   (
                       SELECT id, predecessor_id
                       FROM journey_declaration
                       WHERE predecessor_id = 'd2bfa73a-27dd-4dae-b254-b2811dd24a46'
                       UNION ALL
                       SELECT jc.id, jc.predecessor_id
                       FROM get_parent,
                            journey_declaration jo
                                FULL JOIN journey_declaration jc ON jo.id = jc.predecessor_id
                       WHERE jc.id = pre_id
                   )
SELECT *
FROM get_parent;
