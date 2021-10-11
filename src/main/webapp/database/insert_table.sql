use newservlet2020;
insert into role(code, name) values('ADMIN', 'Quản trị');

INSERT INTO users(name, password, full_name, status, role_id) VALUES ('admin', '123456', 'admin', 1, 5);
INSERT INTO users(name, password, full_name, status, role_id) VALUES ('lequangnhu', '123456', 'Lê Quang Như', 1, 6);
INSERT INTO users(name, password, full_name, status, role_id) VALUES ('nguyenvanb', '123456', 'Nguyễn Văn B', 1, 6);