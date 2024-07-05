SELECT TO_CHAR(O.SALES_DATE, 'YYYY') YEAR, 
        TO_NUMBER(TO_CHAR(O.SALES_DATE, 'MM')) MONTH,
        COUNT(DISTINCT O.USER_ID),
        ROUND(COUNT(DISTINCT(U.USER_ID)) / (SELECT COUNT(USER_ID)
                                          FROM USER_INFO 
                                          WHERE TO_CHAR(JOINED, 'YYYY') = '2021'), 1)
FROM USER_INFO U, ONLINE_SALE O
WHERE U.USER_ID = O.USER_ID
AND TO_CHAR(U.JOINED, 'YYYY') = 2021
GROUP BY TO_CHAR(O.SALES_DATE, 'YYYY'), TO_CHAR(O.SALES_DATE, 'MM')
ORDER BY YEAR , MONTH
