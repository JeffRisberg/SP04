-- rubrics

INSERT INTO rubric (id, parent_id, seq_num, title, body)
values (1, null, 1, 'Rubric1', 'This is a test of rubric1');
INSERT INTO rubric (id, parent_id, seq_num, title, body)
values (2, null, 2, 'Rubric2', 'This is a test of rubric2');
INSERT INTO rubric (id, parent_id, seq_num, title, body)
values (3, null, 11, 'Rubric3', 'This is a test of rubric3');
INSERT INTO rubric (id, parent_id, seq_num, title, body)
values (4, null, 12, 'Rubric4', 'This is a test of rubric4');
INSERT INTO rubric (id, parent_id, seq_num, title, body)
values (5, null, 13, 'Rubric5', 'This is a test of rubric5');
INSERT INTO rubric (id, parent_id, seq_num, title, body)
values (6, null, 20, 'Rubric6', 'This is a test of rubric6');
INSERT INTO rubric (id, parent_id, seq_num, title, body)
values (7, null, 21, 'Rubric7', 'This is a test of rubric7');
INSERT INTO rubric (id, parent_id, seq_num, title, body)
values (8, null, 22, 'Rubric8', 'This is a test of rubric8');
INSERT INTO rubric (id, parent_id, seq_num, title, body)
values (9, null, 23, 'Rubric9', 'This is a test of rubric9');

INSERT INTO box (id, site_id, row_index, col_index, width, title, image_file_name) values (1, 1, 0,0, 12, 'Box00', null);
INSERT INTO box (id, site_id, row_index, col_index, width, title, image_file_name) values (2, 1, 1,0,  4, 'Box10', null);
INSERT INTO box (id, site_id, row_index, col_index, width, title, image_file_name) values (3, 1, 1,1,  4, 'Box11', null);
INSERT INTO box (id, site_id, row_index, col_index, width, title, image_file_name) values (4, 1, 1,2,  4, 'Box12', null);

INSERT INTO box (id, site_id, row_index, col_index, width, title, image_file_name) values (11, 2, 0,0,  4, 'Box00', null);
INSERT INTO box (id, site_id, row_index, col_index, width, title, image_file_name) values (12, 2, 0,1,  4, 'Box01', null);
INSERT INTO box (id, site_id, row_index, col_index, width, title, image_file_name) values (13, 2, 0,2,  4, 'Box02', null);
INSERT INTO box (id, site_id, row_index, col_index, width, title, image_file_name) values (14, 2, 1,0, 12, 'Box10', null);

INSERT INTO rubric_box (box_id, rubric_id) values (1, 1);
INSERT INTO rubric_box (box_id, rubric_id) values (2, 3);
INSERT INTO rubric_box (box_id, rubric_id) values (2, 4);
INSERT INTO rubric_box (box_id, rubric_id) values (3, 2);
INSERT INTO rubric_box (box_id, rubric_id) values (4, 5);

INSERT INTO rubric_box (box_id, rubric_id) values (11, 4);
INSERT INTO rubric_box (box_id, rubric_id) values (11, 2);
INSERT INTO rubric_box (box_id, rubric_id) values (12, 1);
INSERT INTO rubric_box (box_id, rubric_id) values (12, 5);
INSERT INTO rubric_box (box_id, rubric_id) values (13, 6);
INSERT INTO rubric_box (box_id, rubric_id) values (13, 7);
INSERT INTO rubric_box (box_id, rubric_id) values (14, 9);


