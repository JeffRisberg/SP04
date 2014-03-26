-- rubrics

INSERT INTO rubric (id, parent_id, seq_num, title, body)
values (1, null, 1, 'Donations',
 '<p><span style="color: rgb(51, 51, 51); font-family: ''Century Gothic'', Quicksand, sans-serif; font-size: 14px; line-height: 20px;">
   We make it easy to support your favorite causes and donate when, how, and as often as you want to more than 1.8 million charities working throughout the world. Several convenient search tools help you quickly find and learn more about any charity.
   </span></p>');
INSERT INTO rubric (id, parent_id, seq_num, title, body)
values (2, null, 2, 'One-time Donations', '<p>Make a one-time donation to one or more charities.</p>');
INSERT INTO rubric (id, parent_id, seq_num, title, body)
values (3, null, 11, null, 'For any cause you care about, it''s simple to find a charity: large or small, working in your local community or across the world - and donate to support their work.');
INSERT INTO rubric (id, parent_id, seq_num, title, body)
values (4, null, 12, 'Monthly Giving', '<p>Automatically donate to selected charities on a regular basis.</p>');
INSERT INTO rubric (id, parent_id, seq_num, title, body)
values (5, null, 13, 'Gift Donations', 'For every purpose and occasion, charity is the perfect gift.');
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
INSERT INTO rubric_box (box_id, rubric_id) values (2, 2);
INSERT INTO rubric_box (box_id, rubric_id) values (2, 3);
INSERT INTO rubric_box (box_id, rubric_id) values (3, 4);
INSERT INTO rubric_box (box_id, rubric_id) values (4, 5);

INSERT INTO rubric_box (box_id, rubric_id) values (11, 4);
INSERT INTO rubric_box (box_id, rubric_id) values (11, 2);
INSERT INTO rubric_box (box_id, rubric_id) values (12, 8);
INSERT INTO rubric_box (box_id, rubric_id) values (12, 5);
INSERT INTO rubric_box (box_id, rubric_id) values (13, 6);
INSERT INTO rubric_box (box_id, rubric_id) values (13, 7);
INSERT INTO rubric_box (box_id, rubric_id) values (14, 9);


