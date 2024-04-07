create database bookrent;
show databases;
grant all privileges on bookrent.* to 'ohgiraffers';
show grants for 'ohgiraffers'@'%';

use bookrent;
drop table if exists book cascade;
create table if not exists book(
	book_no int auto_increment comment '책번호',
	book_title varchar(255) not null comment '책제목',
    book_author varchar(255) not null comment '저자',
    book_publisher varchar(255) not null comment '출판사',
    primary key (book_no)
)engine=innodb comment '책';

drop table if exists user cascade;
create table if not exists user(
	user_no int auto_increment comment '회원번호',
    user_id varchar(255) unique not null comment '아이디',
    user_password varchar(255) not null comment '비밀번호',
    user_name varchar(255) not null comment '이름',
    primary key (user_no)
) engine=innodb comment '회원';

drop table if exists rent cascade;
create table if not exists rent(
	rent_no int auto_increment comment '대여번호',
    rent_date DATETIME not null comment '대여일시',
    book_no int not null comment '책번호',
    user_no int not null comment '회원번호',
    return_status varchar(2) not null comment '반납 여부',
    primary key (rent_no),
    foreign key (book_no) references book (book_no),
    foreign key (user_no) references user (user_no)
)engine=innodb comment '대여';

show tables ;

insert into book (book_title, book_author, book_publisher)
values ('오설록 홈즈 ~분홍색 연구~', '아서라 고난도 일', '녹차의난');
insert into book (book_title, book_author, book_publisher)
values ('오설록 홈즈 ~내 사람의 서명~', '아서라 고난도 일', '녹차의난');
insert into book (book_title, book_author, book_publisher)
values ('오설록 홈즈 ~버스가 길가에 섰당께~', '아서라 고난도 일', '녹차의난');

insert into book (book_title, book_author, book_publisher)
values ('거위엔트 특급살인', '얘가 싸 크리스티', '이편지는영국에서시작되어');
insert into book (book_title, book_author, book_publisher)
values ('나일 강의 환생', '얘가 싸 크리스티', '이편지는영국에서시작되어');
insert into book (book_title, book_author, book_publisher)
values ('그리고 아무나 있었다', '얘가 싸 크리스티', '이편지는영국에서시작되어');

select * from book;

insert into user (user_id, user_password, user_name)
values ('user01', '1234', '유저1');