-- 코드를 입력하세요
select 
    TITLE, a.BOARD_ID, b.REPLY_ID, b.WRITER_ID, b.CONTENTS, date_format(b.created_date, '%Y-%m-%d')
from
    used_goods_board as a join used_goods_reply as b
    on a.board_id = b.board_id
where
    a.created_date like "2022-10-%"
order by
    b.created_date, a.title 