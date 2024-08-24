SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD, CATEGORY, PRICE
FROM 
    (
        SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD, CATEGORY, PRICE,
        RANK() OVER (ORDER BY PRICE DESC) NO
        FROM FOOD_PRODUCT
    )
WHERE NO = 1;
