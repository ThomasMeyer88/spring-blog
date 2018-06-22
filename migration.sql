use blog_db;

select * FROM posts;

select * FROM users;

DESCRIBE users;
DESCRIBE posts;

insert into users(email, password, username) VALUES ('thomas@gmail.com', 'password', 'thomas');

insert into posts(body, title, user_id) VALUES ('Thomas made a post about stuff', 'OMG another post', 1);

DROP table users;
DROP table posts;