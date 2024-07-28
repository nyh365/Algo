SELECT C.CAR_ID
FROM CAR_RENTAL_COMPANY_CAR C 
WHERE C.CAR_TYPE = '세단'
AND EXISTS (
             SELECT 'Y'
             FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
             WHERE C.CAR_ID = H.CAR_ID
             AND TO_CHAR(H.START_DATE, 'MM') = 10
            )
ORDER BY C.CAR_ID DESC
