SELECT DISTINCT A.CART_ID
FROM (SELECT CART_ID
      FROM CART_PRODUCTS
      WHERE NAME = 'Milk') A, (SELECT CART_ID
                                 FROM CART_PRODUCTS
                                 WHERE NAME = 'Yogurt') B
WHERE A.CART_ID = B.CART_ID
ORDER BY A.CART_ID
