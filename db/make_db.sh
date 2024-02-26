 psql -h pg -d studs << EOF

CREATE TABLE OBJECT_OBVERSATION (
  id SERIAL PRIMARY KEY,
  name varchar(32) NOT NULL,
  shape TEXT NOT NULL,
  brightness INTEGER default 0
);
CREATE TYPE State_EQUIPMENT AS ENUM ('Включен', 'Выключен', 'Сломан');
CREATE TABLE TYPE_EQUIPMENT (
  id SERIAL PRIMARY KEY,
  type TEXT NOT NULL,
  purpose TEXT NOT NULL
);
CREATE TABLE EQUIPMENT (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL,
  type INTEGER references TYPE_EQUIPMENT,
  state State_EQUIPMENT
);
CREATE TABLE OBVERSATION (
  id SERIAL PRIMARY KEY,
  id_equipment INTEGER references EQUIPMENT,
  id_object INTEGER references OBJECT_OBVERSATION,
  note TEXT NOT NULL,
  weather TEXT default NULL,
  date DATE
);

INSERT INTO OBJECT_OBVERSATION (name, shape, brightness) VALUES ('полумесяц', 'безупречная', 100);
INSERT INTO OBJECT_OBVERSATION (name, shape, brightness) VALUES ('звезды', 'шарообразные', 100);
INSERT INTO TYPE_EQUIPMENT (type, purpose) VALUES ('контрольный экран', 'для управления и мониторинга');
INSERT INTO EQUIPMENT (name, type, state) VALUES ('экран', 1, 'Включен');
INSERT INTO OBVERSATION (id_object, id_equipment, note, date) VALUES (2, 1, 'почти не наблюдаются', '02.04.2005');
INSERT INTO OBVERSATION (id_object, id_equipment, note, weather, date) VALUES (1, 1, 'похоже на Венеру. Географических контуров не наблюдается', 'Облачно', '02.04.2005');

CREATE or REPLACE VIEW FULL_OBVERSATION AS
  SELECT OBVERSATION.id, EQUIPMENT.name as name_equiment, OBJECT_OBVERSATION.name AS name_object, note, weather, date
  FROM OBVERSATION
  INNER JOIN OBJECT_OBVERSATION
  ON OBVERSATION.id_object = OBJECT_OBVERSATION.id
  INNER JOIN EQUIPMENT
  ON OBVERSATION.id_equipment = EQUIPMENT.id;

SELECT * FROM OBJECT_OBVERSATION;
SELECT * FROM TYPE_EQUIPMENT;
SELECT * FROM EQUIPMENT;
SELECT * FROM OBVERSATION;
SELECT * FROM FULL_OBVERSATION;
EOF