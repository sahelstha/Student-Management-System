-- Student --
insert into student(id, name, dob, email)
values (next value for student_seq,'Sahel', current_date(), 'sahel@123gmail.com');

insert into student(id, name, dob, email)
values (next value for student_seq,'hello', current_date(), 'hello@123gmail.com');

insert into student(id, name, dob, email)
values (next value for student_seq,'ram', current_date(), 'ram@123gmail.com');

insert into student(id, name, dob, email)
values (next value for student_seq,'hehe', current_date(), 'ssad@123gmail.com');

-- Course --
insert into course(id, course_description, course_name)
values (next value for course_seq, 'Learn spring in detail', 'Spring');

insert into course(id, course_description, course_name)
values (next value for course_seq, 'Learn mySQl', 'Data base');

insert into course(id, course_description, course_name)
values (next value for course_seq, 'Learn JavaScript in detail', 'JavaScript');

insert into course(id, course_description, course_name)
values (next value for course_seq, 'Learn Python', 'Python');

-- Enrollment --
insert into enrollment(course_id, student_id)
values (1001, 10001);

insert into enrollment(course_id, student_id)
values (1001, 10002);

insert into enrollment(course_id, student_id)
values (1001, 10003);

insert into enrollment(course_id, student_id)
values (1002, 10001);

insert into enrollment(course_id, student_id)
values (1002, 10002);

insert into enrollment(course_id, student_id)
values (1002, 10003);

insert into enrollment(course_id, student_id)
values (1003, 10001);

insert into enrollment(course_id, student_id)
values (1003, 10002);

insert into enrollment(course_id, student_id)
values (1003, 10003);

insert into enrollment(course_id, student_id)
values (1004, 10001);


