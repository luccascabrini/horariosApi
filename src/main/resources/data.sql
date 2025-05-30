INSERT INTO PROFESSOR (name) VALUES ('Professor João');
INSERT INTO PROFESSOR (name) VALUES ('Professora Maria');
INSERT INTO PROFESSOR (name) VALUES ('Professor Carlos');

INSERT INTO ROOM (name) VALUES ('Sala A101');
INSERT INTO ROOM (name) VALUES ('Sala B202');
INSERT INTO ROOM (name) VALUES ('Laboratório C303');
INSERT INTO ROOM (name) VALUES ('Sala D404'); -- Nova sala para exemplo de livre

INSERT INTO SUBJECT (name, taught_by) VALUES ('Algoritmos e Estruturas de Dados', (SELECT id FROM PROFESSOR WHERE name = 'Professor João'));
INSERT INTO SUBJECT (name, taught_by) VALUES ('Banco de Dados', (SELECT id FROM PROFESSOR WHERE name = 'Professora Maria'));
INSERT INTO SUBJECT (name, taught_by) VALUES ('Programação Web', (SELECT id FROM PROFESSOR WHERE name = 'Professor Carlos'));
INSERT INTO SUBJECT (name, taught_by) VALUES ('Engenharia de Software', (SELECT id FROM PROFESSOR WHERE name = 'Professor João'));

INSERT INTO CLASS (code, subject_id) VALUES ('ENG101-A', (SELECT id FROM SUBJECT WHERE name = 'Algoritmos e Estruturas de Dados'));
INSERT INTO CLASS (code, subject_id) VALUES ('BD301-D', (SELECT id FROM SUBJECT WHERE name = 'Banco de Dados'));
INSERT INTO CLASS (code, subject_id) VALUES ('WEB201-B', (SELECT id FROM SUBJECT WHERE name = 'Programação Web'));
INSERT INTO CLASS (code, subject_id) VALUES ('ES401-C', (SELECT id FROM SUBJECT WHERE name = 'Engenharia de Software'));

INSERT INTO CLASS_SCHEDULE (class_id, room_id, day_of_week, start_time, end_time) VALUES
((SELECT id FROM CLASS WHERE code = 'ENG101-A'), (SELECT id FROM ROOM WHERE name = 'Sala A101'), 'Segunda', '08:00:00', '10:00:00');
INSERT INTO CLASS_SCHEDULE (class_id, room_id, day_of_week, start_time, end_time) VALUES
((SELECT id FROM CLASS WHERE code = 'ENG101-A'), (SELECT id FROM ROOM WHERE name = 'Sala A101'), 'Quarta', '08:00:00', '10:00:00');

INSERT INTO CLASS_SCHEDULE (class_id, room_id, day_of_week, start_time, end_time) VALUES
((SELECT id FROM CLASS WHERE code = 'BD301-D'), (SELECT id FROM ROOM WHERE name = 'Sala B202'), 'Terça', '10:00:00', '12:00:00');
INSERT INTO CLASS_SCHEDULE (class_id, room_id, day_of_week, start_time, end_time) VALUES
((SELECT id FROM CLASS WHERE code = 'BD301-D'), (SELECT id FROM ROOM WHERE name = 'Sala B202'), 'Quinta', '10:00:00', '12:00:00');

INSERT INTO CLASS_SCHEDULE (class_id, room_id, day_of_week, start_time, end_time) VALUES
((SELECT id FROM CLASS WHERE code = 'WEB201-B'), (SELECT id FROM ROOM WHERE name = 'Laboratório C303'), 'Segunda', '14:00:00', '16:00:00');
INSERT INTO CLASS_SCHEDULE (class_id, room_id, day_of_week, start_time, end_time) VALUES
((SELECT id FROM CLASS WHERE code = 'WEB201-B'), (SELECT id FROM ROOM WHERE name = 'Laboratório C303'), 'Sexta', '09:00:00', '11:00:00');

INSERT INTO CLASS_SCHEDULE (class_id, room_id, day_of_week, start_time, end_time) VALUES
((SELECT id FROM CLASS WHERE code = 'ES401-C'), (SELECT id FROM ROOM WHERE name = 'Sala A101'), 'Terça', '14:00:00', '16:00:00');