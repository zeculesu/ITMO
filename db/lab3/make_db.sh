CREATE TABLE OBJECT (
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

CREATE TABLE OBSERVATION (
  id SERIAL PRIMARY KEY,
  id_object INTEGER references OBJECT,
  note TEXT NOT NULL,
  weather TEXT default NULL,
  date DATE
);

CREATE TABLE OBSERVATION_EQUIPMENT (
  id_observation INTEGER references OBSERVATION,
  id_equipment INTEGER references EQUIPMENT,
  PRIMARY KEY (id_observation, id_equipment)
);

ALTER TABLE OBJECT
ADD COLUMN observation_count INTEGER DEFAULT 0;

CREATE OR REPLACE FUNCTION update_observation_count()
RETURNS TRIGGER AS $$
BEGIN
    UPDATE OBJECT
    SET observation_count = observation_count + 1
    WHERE id = NEW.id_object;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER observation_insert_trigger
AFTER INSERT ON OBSERVATION
FOR EACH ROW
EXECUTE PROCEDURE update_observation_count();

INSERT INTO OBJECT (name, shape, brightness) VALUES ('полумесяц', 'безупречная', 100);
INSERT INTO OBJECT (name, shape, brightness) VALUES ('звезды', 'шарообразные', 100);
INSERT INTO TYPE_EQUIPMENT (type, purpose) VALUES ('контрольный экран', 'для управления и мониторинга');
INSERT INTO EQUIPMENT (name, type, state) VALUES ('экран', 1, 'Включен');
INSERT INTO OBSERVATION (id_object, note, date) VALUES (2, 'почти не наблюдаются', '02.04.2005');
INSERT INTO OBSERVATION_EQUIPMENT VALUES (1, 1);
INSERT INTO OBSERVATION (id_object, note, weather, date) VALUES (1, 'похоже на Венеру. Географических контуров не наблюдается', 'Облачно', '02.04.2005');
INSERT INTO OBSERVATION_EQUIPMENT VALUES (2, 1);

CREATE or REPLACE VIEW FULL_OBSERVATION AS
  SELECT OBSERVATION.id, OBJECT.name AS name_object, note, weather, date
  FROM OBSERVATION
  INNER JOIN OBJECT
  ON OBSERVATION.id_object = OBJECT.id;

SELECT * FROM OBJECT;
SELECT * FROM TYPE_EQUIPMENT;
SELECT * FROM EQUIPMENT;
SELECT * FROM OBSERVATION_EQUIPMENT;
SELECT * FROM OBSERVATION;
SELECT * FROM FULL_OBSERVATION;