SELECT 
    CATEGORY, sum(SALES) "TOTAL_SALES"
from 
    BOOK_SALES S inner join BOOK B on S.BOOK_ID = B.BOOK_ID
where 
    SALES_DATE like "2022-01%"
GROUP BY
    CATEGORY
order by 
    CATEGORY ASC;

# select count(sales) from book_sales inner join book