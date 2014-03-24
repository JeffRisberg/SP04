-- rubrics

INSERT INTO rubric (id, parent_id, seq_num, title, body)
values (1, null, 1, 'Rubric1', 'This is a test of rubric1');
INSERT INTO rubric (id, parent_id, seq_num, title, body)
values (2, null, 2, 'Rubric2', 'This is a test of rubric2');
INSERT INTO rubric (id, parent_id, seq_num, title, body)
values (3, null, 10, 'Rubric3', 'This is a test of rubric3');
INSERT INTO rubric (id, parent_id, seq_num, title, body)
values (4, null, 20, 'Rubric4', '(CSCO) This is a test of rubric4');
INSERT INTO rubric (id, parent_id, seq_num, title, body)
values (5, null, 30, 'Rubric5', '(CSCO) This is a test of rubric5');

INSERT INTO box (id, site_id, seq_num, title) values (1, 1, 1, "Box1");
INSERT INTO box (id, site_id, seq_num, title) values (2, 1, 2, "Box2");
INSERT INTO box (id, site_id, seq_num, title) values (3, 1, 3 ,"Box3");

INSERT INTO box (id, site_id, seq_num, title) values (4, 2, 1, "Box4");
INSERT INTO box (id, site_id, seq_num, title) values (5, 2, 2, "Box5");
INSERT INTO box (id, site_id, seq_num, title) values (6, 2, 3, "Box6");

INSERT INTO rubric_box (box_id, rubric_id) values (1, 1);
INSERT INTO rubric_box (box_id, rubric_id) values (1, 3);
INSERT INTO rubric_box (box_id, rubric_id) values (1, 4);
INSERT INTO rubric_box (box_id, rubric_id) values (2, 2);
INSERT INTO rubric_box (box_id, rubric_id) values (3, 5);

INSERT INTO rubric_box (box_id, rubric_id) values (4, 4);
INSERT INTO rubric_box (box_id, rubric_id) values (4, 2);
INSERT INTO rubric_box (box_id, rubric_id) values (5, 1);
INSERT INTO rubric_box (box_id, rubric_id) values (5, 3);
INSERT INTO rubric_box (box_id, rubric_id) values (6, 5);


