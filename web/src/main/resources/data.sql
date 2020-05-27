insert into patron(name, email, member_since, membership_expires, patron_type,password) values('Jake Turner', 'jake.turner@ericsson.com', '2019-5-8', '2021-5-8', 'PATRON','123');
insert into patron(name, email, member_since, membership_expires, patron_type,password) values('Soumen Karmakar', 'soumen.karmakar@ericsson.com', '2020-11-3', '2025-11-3', 'PATRON','123');
insert into patron(name, email, member_since, membership_expires, patron_type,password) values('Dyutiman Bhattacharya B', 'dyutiman.b.bhattacharya@ericsson.com', '2018-2-5', '2025-2-5', 'PATRON','123');
insert into patron(name, email, member_since, membership_expires, patron_type,password) values('Rajesh Gupta G', 'rajesh.g.gupta@ericsson.com', '2010-08-17', '2023-08-17', 'PATRON','123');

insert into patron(name, email, patron_type,password) values('System Admin', 'sysAdmin@gamil.com', 'ADMIN','123');
insert into patron(name, email, patron_type,password) values('Librarian', 'librarian@gmail.com', 'LIBRARIAN','123');

insert into author(name, dob) values('Stephen King', '1947-9-21');
insert into author(name, dob) values('J. K. Rowling', '1965-7-31');
insert into author(name, dob) values('J. R. R. Tolkien', '1892-1-3');

insert into publisher(headquarters, name, year_founded) values('London', 'Bloomsbury', 1986);
insert into publisher(headquarters, name, year_founded) values('New York', 'Doubleday', 1897);
insert into publisher(headquarters, name, year_founded) values('New South Wales', 'Allen & Unwin', 1914);

insert into book(available, copies, name, pages, price, author_id, publisher_id, category) values(true, 5, 'The Lord of the Rings: The Fellowship of the Ring', 423, 6.99, 3, 3, 'Fantasy');
insert into book(available, copies, name, pages, price, author_id, publisher_id, category) values(true, 7, 'The Lord of the Rings: The Two Towers', 352, 8.99, 3, 3, 'Fantasy');
insert into book(available, copies, name, pages, price, author_id, publisher_id, category) values(true, 8, 'The Lord of the Rings: The Return of the King', 416, 9.99, 3, 3, 'Fantasy');

insert into book(available, copies, name, pages, price, author_id, publisher_id, category) values(true, 4, 'Harry Potter and the Philosophers Stone', 223, 6.99, 2, 1, 'Fantasy');
insert into book(available, copies, name, pages, price, author_id, publisher_id, category) values(true, 6, 'Harry Potter and the Chamber of Secrets', 251, 6.99, 2, 1, 'Fantasy');
insert into book(available, copies, name, pages, price, author_id, publisher_id, category) values(true, 4, 'Harry Potter and the Prisoner of Azkaban', 317, 7.99, 2, 1, 'Fantasy');

insert into book(available, copies, name, pages, price, author_id, publisher_id, category) values(true, 2, 'The Shining', 447, 9.99, 1, 2, 'Horror');
insert into book(available, copies, name, pages, price, author_id, publisher_id, category) values(true, 3, 'Carrie', 199, 8.99, 1, 2, 'Horror');


--OVERDUE BOOKS Jake
insert into book_loan(date_due, date_out, book_id, patron_id) values('2020-05-25', '2020-05-10', 5, 1);
insert into book_loan(date_due, date_out, book_id, patron_id) values('2020-05-20', '2020-05-05', 1, 1);

--OVERDUE BOOKS Soumen
insert into book_loan(date_due, date_out, book_id, patron_id) values('2020-05-20', '2020-04-10', 4, 2);

--OVERDUE BOOKS Dyutiman
insert into book_loan(date_due, date_out, book_id, patron_id) values('2020-05-25', '2020-05-10', 1, 3);
insert into book_loan(date_due, date_out, book_id, patron_id) values('2020-05-20', '2020-05-05', 2, 3);
insert into book_loan(date_due, date_out, book_id, patron_id) values('2020-05-25', '2020-05-10', 3, 3);
insert into book_loan(date_due, date_out, book_id, patron_id) values('2020-05-20', '2020-05-05', 7, 3);

--OVERDUE BOOKS Rajesh
insert into book_loan(date_due, date_out, book_id, patron_id) values('2020-05-20', '2020-04-10', 2, 4);

--NON-OVERDUE BOOKS Jake
insert into book_loan(date_due, date_out, book_id, patron_id) values('2020-07-3', '2020-05-27', 8, 1);
insert into book_loan(date_due, date_out, book_id, patron_id) values('2020-07-3', '2020-05-27', 2, 1);

--NON-OVERDUE BOOKS Soumen
insert into book_loan(date_due, date_out, book_id, patron_id) values('2020-07-3', '2020-05-27', 5, 2);

--NON-OVERDUE BOOKS Dyutiman
insert into book_loan(date_due, date_out, book_id, patron_id) values('2020-07-3', '2020-05-27', 8, 3);

--NON-OVERDUE BOOKS Rajesh
insert into book_loan(date_due, date_out, book_id, patron_id) values('2020-07-3', '2020-05-27', 1, 4);
insert into book_loan(date_due, date_out, book_id, patron_id) values('2020-07-3', '2020-05-27', 7, 4);




