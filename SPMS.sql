-- AUTHORS

create table authors (
id serial primary key,
username varchar(25),
password varchar(25),
f_name varchar(25),
l_name varchar(25),
points int
);

-- EDITORS

create table editors (
id serial primary key,
username varchar(25),
password varchar(25),
f_name varchar(25),
l_name varchar(25),
genre_committee varchar(25),
role varchar(25)
);

-- REFERENCE

create table reference (
id serial primary key,
genre varchar(25),
story_type varchar(25) references points_ref(story_type)
);

-- POINTS

create table points_ref (
story_type varchar(25) unique,
p_amount int unique
);

-- STORIES

create table stories (
id serial primary key,
author_id int references authors(id),
p_amount int references points_ref(p_amount),
title varchar(50),
completion_date int, --DDMMYYYY
story_type varchar(25),
genre varchar(25),
tag_line varchar(25),
description varchar(1000),
draft varchar(1000),
priority int,
pitch_approved boolean,
story_approved boolean,
status varchar(25)
);

-- PITCH_REVIEW

/*create table pitch_review (
id serial primary key,
story_id int references stories(id),
assist_editor int references editors(id),
assist_decision varchar(25),
general_editor int references editors(id),
general_decision varchar(25),
senior_editor int references editors(id),
senior_decision varchar(25)
);*/

alter table pitch_review 
add constraint pitch_review_stories_fk 
FOREIGN KEY (story_id) 
REFERENCES stories (id);

-- REVIEWS

create table reviews (
id serial primary key,
story_id int references stories(id),
editor_id int references editors(id),
review_type varchar(25),
decision varchar(25),
additional_info varchar(1000)
);

drop table pitch_review;
alter table story_review rename to reviews;
alter table stories add column status varchar(25);
ALTER TABLE "SPMS".story_review ADD CONSTRAINT story_review_editors_fk FOREIGN KEY (editor_id) REFERENCES "SPMS".editors(id);

insert into points_ref values 
('Novel', 50),
('Novella', 25),
('Short', 20),
('Article', 10);

insert into reference values
(default, 'Romance', 'Novel'),
(default, 'Fantasy', 'Novel'),
(default, 'Sci-Fi', 'Novel'),
(default, 'Mystery', 'Novel'),
(default, 'Horror', 'Novel'),
(default, 'LGBT', 'Novel'),
(default, 'Children', 'Novel'),
(default, 'Biography', 'Novel'),
(default, 'Technology', 'Novel'),
(default, 'Travel', 'Novel'),
(default, 'Romance', 'Novella'),
(default, 'Fantasy', 'Novella'),
(default, 'Sci-Fi', 'Novella'),
(default, 'Mystery', 'Novella'),
(default, 'Horror', 'Novella'),
(default, 'LGBT', 'Novella'),
(default, 'Children', 'Novella'),
(default, 'Biography', 'Novella'),
(default, 'Technology', 'Novella'),
(default, 'Travel', 'Novella'),
(default, 'Romance', 'Short'),
(default, 'Fantasy', 'Short'),
(default, 'Sci-Fi', 'Short'),
(default, 'Mystery', 'Short'),
(default, 'Horror', 'Short'),
(default, 'LGBT', 'Short'),
(default, 'Children', 'Short'),
(default, 'Biography', 'Short'),
(default, 'Technology', 'Short'),
(default, 'Travel', 'Short'),
(default, 'Romance', 'Article'),
(default, 'Fantasy', 'Article'),
(default, 'Sci-Fi', 'Article'),
(default, 'Mystery', 'Article'),
(default, 'Horror', 'Article'),
(default, 'LGBT', 'Article'),
(default, 'Children', 'Article'),
(default, 'Biography', 'Article'),
(default, 'Technology', 'Article'),
(default, 'Travel', 'Article');

insert into authors values (default, 'author4', 'author4', 'Brian', 'Kim', 100);
insert into editors values (default, 'editor4', 'editor4', 'Kelly', 'Sanders', '', 'General');






