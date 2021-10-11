use newservlet2020;
CREATE TABLE roles(
id bigint NOT NULL PRIMARY KEY auto_increment,
name VARCHAR(255) NOT NULL,
code VARCHAR(255) NOT NULL,
created_date timestamp NULL,
modified_date timestamp NULL,
created_by VARCHAR(255) NULL,
modified_by VARCHAR(255) NULL
);

CREATE TABLE users(
id bigint NOT NULL PRIMARY KEY auto_increment,
name VARCHAR(255) NOT NULL,
password VARCHAR(200) NOT NULL,
full_name VARCHAR(200) NULL,
status int NOT NULL,
role_id bigint NOT NULL,
created_date timestamp NULL,
modified_date timestamp NULL,
created_by VARCHAR(255) NULL,
modified_by VARCHAR(255) NULL
);
ALTER TABLE users ADD CONSTRAINT fk_users_roles FOREIGN KEY (role_id) REFERENCES roles(id);
CREATE TABLE news(
id bigint NOT NULL PRIMARY KEY auto_increment,
title VARCHAR(255) NULL,
thumbnail VARCHAR(255) NULL,
short_description TEXT NULL,
content TEXT NULL,
category_id bigint NOT NULL,
created_date timestamp NULL,
modified_date timestamp NULL,
created_by VARCHAR(255) NULL,
modified_by VARCHAR(255) NULL
);

CREATE TABLE categorys(
id bigint NOT NULL PRIMARY KEY auto_increment,
name VARCHAR(255) NOT NULL,
code VARCHAR(255) NOT NULL,
created_date timestamp NULL,
modified_date timestamp NULL,
created_by VARCHAR(255) NULL,
modified_by VARCHAR(255) NULL
);
ALTER TABLE news ADD CONSTRAINT fk_news_categorys FOREIGN KEY (category_id) REFERENCES categorys(id);

CREATE TABLE comments(
id bigint NOT NULL PRIMARY KEY auto_increment,
content TEXT NOT NULL,
new_id bigint NOT NULL,
user_id bigint NOT NULL,
created_date timestamp NULL,
modified_date timestamp NULL,
created_by VARCHAR(255) NULL,
modified_by VARCHAR(255) NULL
);
ALTER TABLE comments ADD CONSTRAINT fk_comments_news FOREIGN KEY (new_id) REFERENCES news(id);
ALTER TABLE comments ADD CONSTRAINT fk_comments_users FOREIGN KEY (user_id) REFERENCES users(id);


INSERT into categorys(code, name) values('the-thao', 'Thể Thao');
INSERT into categorys(code, name) values('phap-luat', 'Pháp Luật');
INSERT into categorys(code, name) values('cong-nghe', 'Công Nghệ');
INSERT into categorys(code, name) values('doi-song', 'Đời Sống');


INSERT into news(title, category_id) values('Bài viết về thể thao 1', 1);
INSERT into news(title, category_id) values('Bài viết về thể thao 2', 1);

