insert into patron(name, email, member_since, membership_expires, patron_type,password) values('Jake Turner', 'jaketurner810@gmail.com', '2019-5-8', '2021-5-8', 'PATRON','12345');
insert into patron(name, email, member_since, membership_expires, patron_type,password) values('Hannah Tilbury', 'hannaht96@talktalk.net', '2020-11-3', '2025-11-3', 'PATRON','12345');
insert into patron(name, email, patron_type,password) values('System Admin', 'sysAdmin@gamil.com', 'ADMIN','123');
insert into patron(name, email, patron_type,password) values('Jacob Black', 'jacobB123@hotmail.co.uk', 'LIBRARIAN','123');



insert into author(name, dob) values('Stephen King', '1947-9-21');
insert into author(name, dob) values('J.K.Rowling', '1965-7-31');

insert into publisher(headquarters, name, year_founded) values('London', 'Bloomsbury', 1986);
insert into publisher(headquarters, name, year_founded) values('New York', 'Doubleday', 1897);

insert into book(available, copies, name, pages, price, author_id, publisher_id) values(true, 4, 'Harry Potter and the Philosophers Stone', 223, 6.99, 2, 1);
insert into book(available, copies, name, pages, price, author_id, publisher_id) values(true, 6, 'Harry Potter and the Chamber of Secrets', 251, 6.99, 2, 1);
insert into book(available, copies, name, pages, price, author_id, publisher_id) values(true, 4, 'Harry Potter and the Prisoner of Azkaban', 317, 7.99, 2, 1);

insert into book(available, copies, name, pages, price, author_id, publisher_id) values(true, 2, 'The Shining', 447, 9.99, 1, 2);
insert into book(available, copies, name, pages, price, author_id, publisher_id) values(true, 3, 'Carrie', 199, 8.99, 1, 2);