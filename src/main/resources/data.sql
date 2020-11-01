INSERT INTO PERSON (FIRST_NAME, MIDDLE_NAME, LAST_NAME, AGE) VALUES
    ('Joe', 'prdola', 'Briggs',23),
    ('John', 'kuk', 'Smith',44),
    ('Steve', 'Trmos', 'Jones',16),
    ('Tom', 'Junior', 'Richards',67);

INSERT INTO PersonInfo (id, person_InfoS,suma,nationallity, person_id) VALUES
        (1, 'je to prdolik',5,'cz',1),
        (2, 'Rad si kuka',2,'es',2),
        (3, 'teprve 16',2,'cz',3),
        (4, 'strsi junior',6,'uk',4);

insert into post (id,title) values
   (1, 'First post'),
   (2,'second post');

insert into postcomment (id, review, post_id) values
    (1,'My first review',1),
    (2,'My first second review',1),
    (3,'My first third review',1),
    (4,'My second first review',2),
    (5,'My second third review',2),
    (6, 'My second second review',2);

insert into post_many (id, title) values
        (1,'Titulek prvni'),
        (2,'Titulek 2');

insert into tag (id, name) values
                (1,'Tag 1 jmeno'),
                (2,'Tag 2 jmeno');

insert into post_tag (post_id, tag_id) values
                (1,1),
                (2,2);
