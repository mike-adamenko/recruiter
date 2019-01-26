insert into offer(id, job_title, start_date) values (1,'job1', '2019-02-03');
insert into offer(id, job_title, start_date) values (2,'job2', '2019-02-05');
insert into offer(id, job_title, start_date) values (3,'job3', '2019-02-06');

insert into Application(id,APPLICATION_STATUS, CANDIDATE_EMAIL, RESUME_TEXT, FK_OFFER) values (1,1, 'test1@gmail.com', 'text1', 1);
insert into Application(id,APPLICATION_STATUS, CANDIDATE_EMAIL, RESUME_TEXT, FK_OFFER) values (2,1, 'test2@gmail.com', 'text1', 1);