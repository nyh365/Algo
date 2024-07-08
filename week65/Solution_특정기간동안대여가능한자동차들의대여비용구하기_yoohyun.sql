SELECT *
FROM (
    SELECT C.CAR_ID, C.CAR_TYPE, 
          C.DAILY_FEE * 30 * (1 - P.DISCOUNT_RATE * 0.01) FEE
    FROM CAR_RENTAL_COMPANY_CAR C, CAR_RENTAL_COMPANY_DISCOUNT_PLAN P
    WHERE C.CAR_TYPE IN ('세단', 'SUV')
    AND NOT EXISTS (
                        SELECT 'Y'
                        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
                        WHERE H.CAR_ID = C.CAR_ID
                        AND TO_CHAR(H.START_DATE, 'YYYY-MM-DD') <= '2022-11-30'
                        AND TO_CHAR(H.END_DATE, 'YYYY-MM-DD') >= '2022-11-01'
                    )
    AND P.CAR_TYPE = C.CAR_TYPE
    AND P.DURATION_TYPE LIKE '30%')
WHERE FEE >= 500000
AND FEE < 2000000
ORDER BY FEE DESC, CAR_TYPE, CAR_ID DESC
