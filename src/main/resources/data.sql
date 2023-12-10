INSERT INTO public.users (id, email, name, password, phone_number, surname)
VALUES (DEFAULT, 'volodymyrkolomiy@mail.com', 'Volodymyr', '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6',
        '380501234567', 'Kolomiy'),
       (DEFAULT, 'dariiamartyniuk@inbox.com', 'Dariia', '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6',
        '380501234568', 'Martyniuk'),
       (DEFAULT, 'artemhuk@mail.com', 'Artem', '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6',
        '380501234569', 'Huk'),
       (DEFAULT, 'zaharboiko@inbox.com', 'Zahar', '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6',
        '380501234570', 'Boiko'),
       (DEFAULT, 'ivanpetrov@mail.com', 'Ivan', '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6',
        '380501234571', 'Petrov'),
       (DEFAULT, 'annasmirnova@inbox.com', 'Anna', '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6',
        '380501234572', 'Smirnova'),
       (DEFAULT, 'oleksiykovalenko@mail.com', 'Oleksiy', '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6',
        '380501234573', 'Kovalenko'),
       (DEFAULT, 'mariyasydorenko@inbox.com', 'Mariya', '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6',
        '380501234574', 'Sydorenko'),
       (DEFAULT, 'serhiybondarenko@mail.com', 'Serhiy', '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6',
        '380501234575', 'Bondarenko'),
       (DEFAULT, 'yuliyavasylchenko@inbox.com', 'Yuliya',
        '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6', '380501234576', 'Vasylchenko');


INSERT INTO public.doctor (id, email, name, phone_number, specialization, surname, password)
VALUES (DEFAULT, 'emily.watson@healthmail.com', 'Emily', '380601234567', 'Cardiology', 'Watson',
        '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6'),
       (DEFAULT, 'jacob.brown@healthmail.com', 'Jacob', '380601234568', 'Dermatology', 'Brown',
        '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6'),
       (DEFAULT, 'sophia.miller@healthmail.com', 'Sophia', '380601234569', 'Neurology', 'Miller',
        '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6'),
       (DEFAULT, 'oliver.smith@healthmail.com', 'Oliver', '380601234570', 'Pediatrics', 'Smith',
        '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6'),
       (DEFAULT, 'charlotte.jones@healthmail.com', 'Charlotte', '380601234571', 'Oncology', 'Jones',
        '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6'),
       (DEFAULT, 'noah.davis@healthmail.com', 'Noah', '380601234572', 'Psychiatry', 'Davis',
        '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6'),
       (DEFAULT, 'amelia.wilson@healthmail.com', 'Amelia', '380601234573', 'General Medicine', 'Wilson',
        '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6'),
       (DEFAULT, 'liam.taylor@healthmail.com', 'Liam', '380601234574', 'Orthopedics', 'Taylor',
        '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6'),
       (DEFAULT, 'ava.moore@healthmail.com', 'Ava', '380601234575', 'Gastroenterology', 'Moore',
        '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6'),
       (DEFAULT, 'william.johnson@healthmail.com', 'William', '380601234576', 'Endocrinology', 'Johnson',
        '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6');

INSERT INTO public.answer (id, answer_text)
VALUES  (1, 'Так'),
        (2, 'Ні'),
        (3, 'Близько трьох разів на тиждень'),
        (4, 'Не маю активностей'),
        (5, 'Більше пяти разів на тижлень'),
        (6, 'Менше пяти разів на тиждень'),
        (7, 'Біль при сечовипусканні'),
        (8, 'Запаморочення'),
        (9, 'Температура'),
        (10, 'Різка біль'),
        (11, 'Головний біль'),
        (12, 'Так'),
        (13, 'Ні'),
        (14, 'Так'),
        (15, 'Ні'),
        (16, 'Так'),
        (17, 'Ні'),
        (18, 'Так'),
        (19, 'Ні'),
        (20, 'Так'),
        (21, 'Ні'),
        (22, 'Так'),
        (23, 'Ні'),
        (24, 'Так'),
        (25, 'Ні'),
        (26, 'Так'),
        (27, 'Ні'),
        (28, 'Так'),
        (29, 'Ні'),
        (30, 'Так'),
        (31, 'Ні'),
        (32, 'Високий'),
        (33, 'Середній'),
        (34, 'Низький'),
        (35, 'Відсутній'),
        (36, 'Так'),
        (37, 'Ні');

INSERT INTO public.question_block (id, block_name)
VALUES
(1,'Запитання про самопочуття'),
(2,'Запитання про аналізи'),
(3,'Запитання про спосіб життя'),
(4,'Запитання про симптоми'),
(5,'Запитання про хвороби в сімї'),
(6,'Запитання про хронічні захворювання');

INSERT INTO public.question (id, question_text, answer_id, question_block)
VALUES
    (1, 'Чи часто у Вас болить голова?', 2, 1),
    (2, 'Чи відчуваєте ви нудоту?', 13, 1),
    (3, 'Чи часто у вас паморочиться голова?', 15, 1),
    (4, 'Ви здавали аналіз крові протягом останніх трьох днів?', 17, 2),
    (5, 'Чи часто ви відчуваєте втому?', 19, 1),
    (6, 'Скільки разів на тиждень маєте активностей?', 3, 3),
    (7, 'Які з наведених симптомів відчуваєте найбільше?', 8, 4),
    (8, 'Чи відчуваєте ви тривожність?', 21, 1),
    (9, 'Чи маєте ви шкідливі звички?', 23, 3),
    (10, 'Чи хворів хтось в сімї на рак?', 24, 5),
    (11, 'Чи маєте хронічні захворювання?', 27, 6),
    (12, 'Чи збалансоване у Вас харчування (80% поживної їжі, 20% шкідливої)?', 28, 3),
    (13, 'Чи робили ви УЗД щитовидної залози впродовж останніх 6 місяців?', 30, 2),
    (14, 'Який у Вас рівень стресу?', 35, 3),
    (15, 'Чи приймаєте якісь ліки на постійній основі?', 37, 3);

UPDATE public.answer SET question_id  = 1 WHERE id = 1;

UPDATE public.answer SET question_id  = 1 WHERE id = 2;

UPDATE public.answer SET question_id  = 6 WHERE id = 3;

UPDATE public.answer SET question_id  = 6 WHERE id = 4;

UPDATE public.answer SET question_id  = 6 WHERE id = 5;

UPDATE public.answer SET question_id  = 6 WHERE id = 6;

UPDATE public.answer SET question_id  = 7 WHERE id = 7;

UPDATE public.answer SET question_id  = 7 WHERE id = 8;

UPDATE public.answer SET question_id  = 7 WHERE id = 9;

UPDATE public.answer SET question_id  = 7 WHERE id = 10;

UPDATE public.answer SET question_id  = 2 WHERE id = 12;

UPDATE public.answer SET question_id  = 2 WHERE id = 13;

UPDATE public.answer SET question_id  = 3 WHERE id = 14;

UPDATE public.answer SET question_id  = 3 WHERE id = 15;

UPDATE public.answer SET question_id  = 4 WHERE id = 16;

UPDATE public.answer SET question_id  = 4 WHERE id = 17;

UPDATE public.answer SET question_id  = 5 WHERE id = 18;

UPDATE public.answer SET question_id  = 5 WHERE id = 19;

UPDATE public.answer SET question_id  = 8 WHERE id = 20;

UPDATE public.answer SET question_id  = 8 WHERE id = 21;

UPDATE public.answer SET question_id  = 9 WHERE id = 22;

UPDATE public.answer SET question_id  = 9 WHERE id = 23;

UPDATE public.answer SET question_id  = 10 WHERE id = 24;

UPDATE public.answer SET question_id  = 10 WHERE id = 25;

UPDATE public.answer SET question_id  = 11 WHERE id = 26;

UPDATE public.answer SET question_id  = 11 WHERE id = 27;

UPDATE public.answer SET question_id  = 12 WHERE id = 28;

UPDATE public.answer SET question_id  = 12 WHERE id = 29;

UPDATE public.answer SET question_id  = 13 WHERE id = 30;

UPDATE public.answer SET question_id  = 13 WHERE id = 31;

UPDATE public.answer SET question_id  = 14 WHERE id = 32;

UPDATE public.answer SET question_id  = 14 WHERE id = 33;

UPDATE public.answer SET question_id  = 14 WHERE id = 34;

UPDATE public.answer SET question_id  = 14 WHERE id = 35;

UPDATE public.answer SET question_id  = 15 WHERE id = 36;

UPDATE public.answer SET question_id  = 15 WHERE id = 37;



INSERT INTO public.cabinet (id, disease, doctor_id, user_id)
values  (DEFAULT, 'Астма', 1, 1),
        (DEFAULT, 'Мігрень', 2, 1),
        (DEFAULT, 'Діабет', 3, 3),
        (DEFAULT, 'Застуда', 4, 4),
        (DEFAULT, 'COVID-19', 5, 5),
        (DEFAULT, 'Цистит', 6, 6),
        (DEFAULT, 'Отруєння', 7, 7),
        (DEFAULT, 'Переохолодження', 8, 8),
        (DEFAULT, 'Рак', 9, 9),
        (DEFAULT, 'Дизбактеріоз', 10, 10);

INSERT INTO public.medical_record (id, patient_id, doctor_id, created_time, doctor_notes, disease)
VALUES
    (DEFAULT, 1, 1, '2023-01-01T08:00:00', 'Patient in good health, no immediate concerns.', 'Астма'),
    (DEFAULT, 1, 2, '2023-01-02T09:00:00', 'Patient reports mild eczema, prescribed topical cream.', 'Мігрень'),
    (DEFAULT, 3, 3, '2023-01-03T10:30:00', 'Regular migraine, advised lifestyle changes and medication.', 'Діабет'),
    (DEFAULT, 4, 4, '2023-01-04T11:15:00', 'Asthma check-up, no change in medication needed.', 'Застуда'),
    (DEFAULT, 5, 5, '2023-01-05T14:00:00', 'Routine cancer follow-up, stable condition.', 'COVID-19'),
    (DEFAULT, 6, 6, '2023-01-06T16:00:00', 'Discussed anxiety management strategies.', 'Цистит'),
    (DEFAULT, 7, 7, '2023-01-07T10:00:00', 'Diabetes management, blood sugar levels stable.', 'Отруєння'),
    (DEFAULT, 8, 8, '2023-01-08T13:00:00', 'Assessed knee injury, recommended physiotherapy.', 'Переохолодження'),
    (DEFAULT, 9, 9, '2023-01-09T15:30:00', 'IBS symptoms present, dietary adjustments suggested.', 'Рак'),
    (DEFAULT, 10, 10, '2023-01-10T17:00:00', 'Thyroid function normal, continue current medication.', 'Дизбактеріоз');

INSERT INTO public.poll (id, poll_title)
VALUES
    (1, 'Початкове опитування про пацієнта'),
    (2, 'Проміжне опитування по хворобі'),
    (3, 'Початкове опитування по хворобі'),
    (4, 'Опитування на цистит'),
    (5, 'Опитування на аналізи'),
    (6, 'Фінальне опитування симптомів');

INSERT INTO public.response (id, response_date, answer_id, poll_id, question_id, user_id)
values
    (DEFAULT,'2023-12-01',19,1, 5,1),
    (DEFAULT,'2023-12-01',3,1, 6,1),
    (DEFAULT,'2023-12-01',21,1, 8,1),
    (DEFAULT,'2023-12-01',22,1, 9,1),
    (DEFAULT,'2023-12-01',24,1, 10,1),

    (DEFAULT,'2023-12-02',1,2, 11,1),
    (DEFAULT,'2023-12-02',1,2, 1,1),
    (DEFAULT,'2023-12-02',1,2, 2,1),
    (DEFAULT,'2023-12-02',2,2, 3,1),
    (DEFAULT,'2023-12-02',1,2, 5,1),
    (DEFAULT,'2023-12-02',7,2, 7,1),
    (DEFAULT,'2023-12-02',2,2, 8,1),

    (DEFAULT,'2023-12-03',16,3, 4,3),
    (DEFAULT,'2023-12-03',23,3, 9,3),
    (DEFAULT,'2023-12-03',26,3, 11,3),
    (DEFAULT,'2023-12-03',29,3, 12,3),
    (DEFAULT,'2023-12-03',31,3, 13,3),
    (DEFAULT,'2023-12-03',35,3, 14,3),
    (DEFAULT,'2023-12-03',37,3, 15,3),
    (DEFAULT,'2023-12-03',21,3, 8,3);


INSERT INTO public.statistic (id, poll_id, result, user_id)
VALUES
    (DEFAULT,1, 55, 1),
    (DEFAULT,2, 40, 1),
    (DEFAULT,3, 90, 3),
    (DEFAULT,4, 75, 4),
    (DEFAULT,5, 95, 5),
    (DEFAULT,6, 80, 6);

INSERT INTO public.poll_assignment (id, doctor_id, user_id, poll_id, deadline, created_date, is_completed)
values
(DEFAULT, 1, 1, 1, '2023-12-31', '2023-12-01', false),
(DEFAULT, 2, 2, 1, '2023-12-30', '2023-12-02', false),
(DEFAULT, 3, 3, 3, '2023-12-29', '2023-12-03', true),
(DEFAULT, 4, 4, 4, '2023-12-28', '2023-12-04', false),
(DEFAULT, 5, 5, 5, '2023-12-27', '2023-12-05', true),
(DEFAULT, 6, 6, 6, '2023-12-26', '2023-12-06', false);

INSERT INTO public.poll_questions
(poll_id, questions_id)
values  (1, 5),
		(1, 6),
		(1, 8),
		(1, 9),
		(1, 10),
		(1, 11),
		(2, 1),
		(2, 2),
		(2, 3),
		(2, 5),
		(2, 7),
		(2, 8);
