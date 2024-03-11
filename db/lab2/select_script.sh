psql -h pg -d studs << EOF

SELECT Н_ТИПЫ_ВЕДОМОСТЕЙ.ИД, Н_ВЕДОМОСТИ.ИД
from Н_ТИПЫ_ВЕДОМОСТЕЙ
         INNER JOIN Н_ВЕДОМОСТИ ON Н_ВЕДОМОСТИ.ВЕД_ИД = Н_ТИПЫ_ВЕДОМОСТЕЙ.ИД
WHERE Н_ТИПЫ_ВЕДОМОСТЕЙ.НАИМЕНОВАНИЕ < "Экзаменационный лист"
AND Н_ВЕДОМОСТИ.ДАТА > 2022-06-08 AND Н_ВЕДОМОСТИ.ДАТА = 2022-06-08;

EOF