SELECT MP.MEMBER_NAME, RR.REVIEW_TEXT, TO_CHAR(RR.REVIEW_DATE, 'YYYY-MM-DD')
FROM MEMBER_PROFILE MP, REST_REVIEW RR
WHERE MP.MEMBER_ID = (SELECT MEMBER_ID
                    FROM (
                            SELECT MEMBER_ID, COUNT(*) CNT
                            FROM REST_REVIEW
                            GROUP BY MEMBER_ID
                            ORDER BY CNT DESC
                         )
                    WHERE ROWNUM <= 1)
AND RR.MEMBER_ID = MP.MEMBER_ID
ORDER BY RR.REVIEW_DATE, RR.REVIEW_TEXT
