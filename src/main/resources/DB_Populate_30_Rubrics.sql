-- rubrics

INSERT INTO rubric (id, parent_id, title, body, seq_num)
values (1, null, 'Rubric1', 'This is a test of rubric1', 0);
INSERT INTO rubric (id, parent_id, title, body, seq_num)
values (2, null, 'Rubric2', 'This is a test of rubric2', 1);
INSERT INTO rubric (id, parent_id, title, body, seq_num)
values (3, null, 'Rubric3', 'This is a test of rubric3', 10);
INSERT INTO rubric (id, parent_id, title, body, seq_num)
values (4, null, 'Rubric4', '(CSCO) This is a test of rubric4', 20);
INSERT INTO rubric (id, parent_id, title, body, seq_num)
values (5, null, 'Rubric5', '(CSCO) This is a test of rubric5', 30);

INSERT INTO box (id, site_id, title) values (1, 1, "Box1");
INSERT INTO box (id, site_id, title) values (2, 1, "Box2");
INSERT INTO box (id, site_id, title) values (3, 2, "Box3");

INSERT INTO rubric_box (rubric_id, box_id) values (1, 1);
INSERT INTO rubric_box (rubric_id, box_id) values (2, 2);
INSERT INTO rubric_box (rubric_id, box_id) values (3, 2);
INSERT INTO rubric_box (rubric_id, box_id) values (4, 3);
INSERT INTO rubric_box (rubric_id, box_id) values (5, 3);


