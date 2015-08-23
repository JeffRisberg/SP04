-- images

INSERT INTO image (id, title, filename, path, width, height) VALUES (1, 'Amex background', 'amex_c_100_100', 'site', 100, 100);

--  sites

INSERT INTO site (id, name, image_id, custom_css, date_created, last_updated) VALUES (1, 'Amex', 1, 'amex.css', now(), now());
INSERT INTO site (id, name, image_id, custom_css, date_created, last_updated) VALUES (2, 'Cisco', NULL, NULL, now(), now());

