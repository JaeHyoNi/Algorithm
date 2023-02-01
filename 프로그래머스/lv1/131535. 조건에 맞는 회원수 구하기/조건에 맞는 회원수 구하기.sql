-- 코드를 입력하세요
SELECT count(user_id) USERS
from USER_INFO
where AGE between 20 and 29 and YEAR(JOINED) = 2021;