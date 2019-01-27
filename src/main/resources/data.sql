INSERT INTO offer (id, job_title, start_date) VALUES (1, 'job1', '2019-02-03');
INSERT INTO offer (id, job_title, start_date) VALUES (2, 'job2', '2019-02-05');
INSERT INTO offer (id, job_title, start_date) VALUES (3, 'job3', '2019-02-06');

INSERT INTO Application (id, APPLICATION_STATUS, CANDIDATE_EMAIL, RESUME_TEXT, FK_OFFER)
VALUES (1, 0, 'test1@gmail.com', 'text1', 1);
INSERT INTO Application (id, APPLICATION_STATUS, CANDIDATE_EMAIL, RESUME_TEXT, FK_OFFER)
VALUES (2, 0, 'test2@gmail.com', 'text2', 1);