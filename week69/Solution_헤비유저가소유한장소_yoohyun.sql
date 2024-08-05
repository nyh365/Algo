SELECT P1.ID, P1.NAME, P1.HOST_ID
FROM PLACES P1
WHERE EXISTS (
                SELECT 'Y'
                FROM PLACES P2
                WHERE P1.HOST_ID = P2.HOST_ID
                GROUP BY HOST_ID
                HAVING COUNT(*) >= 2
             )
