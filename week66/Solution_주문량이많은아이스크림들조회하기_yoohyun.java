SELECT FLAVOR
FROM (
        SELECT FH.FLAVOR, FH.TOTAL_ORDER + J.TOTAL TOTAL
        FROM FIRST_HALF FH, (
                            SELECT FLAVOR, SUM(TOTAL_ORDER) TOTAL
                            FROM JULY
                            GROUP BY FLAVOR
                         ) J
        WHERE FH.FLAVOR = J.FLAVOR
        ORDER BY TOTAL DESC
    )
WHERE ROWNUM <= 3
