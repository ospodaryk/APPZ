INSERT INTO public.users (id, email, name, password, phone_number, surname)
VALUES (DEFAULT, 'volodymyrkolomiy@mail.com', 'Володимир', '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6',
        '380501234567', 'Коломий'),
       (DEFAULT, 'olexlozonevskiy@inbox.com', 'Олександр', '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6',
        '380501234568', 'Лозоневський'),
       (DEFAULT, 'andriyzolochiv@mail.com', 'Андрій', '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6',
        '380501234569', 'Золочів'),
       (DEFAULT, 'olenashpakova@inbox.com', 'Олена', '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6',
        '380501234570', 'Шпакова'),
       (DEFAULT, 'ivanvovk@mail.com', 'Іван', '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6',
        '380501234571', 'Вовк'),
       (DEFAULT, 'annasmirnova@inbox.com', 'Анна', '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6',
        '380501234572', 'Смирнова'),
       (DEFAULT, 'oleksiykovalenko@mail.com', 'Олексій', '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6',
        '380501234573', 'Коваленко'),
       (DEFAULT, 'mariyasydorenko@inbox.com', 'Марія', '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6',
        '380501234574', 'Сидоренко'),
       (DEFAULT, 'serhiybondarenko@mail.com', 'Сергій', '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6',
        '380501234575', 'Бондаренко'),
       (DEFAULT, 'yuliyavasylchenko@inbox.com', 'Юлія',
        '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6', '380501234576', 'Василенко');


INSERT INTO public.doctor (id, email, name, phone_number, specialization, surname, password)
VALUES (DEFAULT, 'olexandr.reva@healthmail.com', 'Олександр', '380601234567', 'Cardiology', 'Рева',
        '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6'),
       (DEFAULT, 'abton.slobodianyk@healthmail.com', 'Антон', '380601234568', 'Dermatology', 'Слободянюк',
        '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6'),
       (DEFAULT, 'sophia.miller@healthmail.com', 'Софія', '380601234569', 'Neurology', 'Дорошенко',
        '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6'),
       (DEFAULT, 'mariia.kovalchyk@healthmail.com', 'Марія', '380601234570', 'Pediatrics', 'Ковальчук',
        '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6'),
       (DEFAULT, 'pavlo.laskyryk@healthmail.com', 'Павло', '380601234571', 'Oncology', 'Ласкурик',
        '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6'),
       (DEFAULT, 'serghii.karyavka@healthmail.com', 'Сергій', '380601234572', 'Psychiatry', 'Карявка',
        '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6'),
       (DEFAULT, 'volodymyr.zadorozhniy@healthmail.com', 'Володимир', '380601234573', 'General Medicine', 'Задорожній',
        '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6'),
       (DEFAULT, 'olexandr.chorniy@healthmail.com', 'Олександр', '380601234574', 'Orthopedics', 'Чорний',
        '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6'),
       (DEFAULT, 'yeva.chirnova@healthmail.com', 'Єва', '380601234575', 'Gastroenterology', 'Жирнова',
        '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6'),
       (DEFAULT, 'nataliia.tolmach@healthmail.com', 'Наталія', '380601234576', 'Endocrinology', 'Толмач',
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
    (DEFAULT, 1, 1, '2023-01-01T08:00:00', 'Пацієнт у хорошому стані здоров’я, негайних проблем немає.', 'Астма'),
    (DEFAULT, 1, 2, '2023-01-02T09:00:00', 'Пацієнт скаржиться на легку екзему, призначено місцевий крем.', 'Мігрень'),
    (DEFAULT, 3, 3, '2023-01-03T10:30:00', 'Регулярний мігрень, пораджено зміни в способі життя та медикацію.', 'Діабет'),
    (DEFAULT, 4, 4, '2023-01-04T11:15:00', 'Перевірка астми, зміни в медикації не потрібні.', 'Застуда'),
    (DEFAULT, 5, 5, '2023-01-05T14:00:00', 'Рутинний контроль за раком, стабільний стан.', 'COVID-19'),
    (DEFAULT, 6, 6, '2023-01-06T16:00:00', 'Обговорено стратегії керування тривогою.', 'Цистит'),
    (DEFAULT, 7, 7, '2023-01-07T10:00:00', 'Керування діабетом, рівень цукру в крові стабільний.', 'Отруєння'),
    (DEFAULT, 8, 8, '2023-01-08T13:00:00', 'Оцінено травму коліна, рекомендовано фізіотерапію.', 'Переохолодження'),
    (DEFAULT, 9, 9, '2023-01-09T15:30:00', 'Присутні симптоми СРК, запропоновано корекцію дієти.', 'Рак'),
    (DEFAULT, 10, 10, '2023-01-10T17:00:00', 'Функція щитовидної залози нормальна, продовжуйте поточну медикацію.', 'Дизбактеріоз');


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
    (DEFAULT,2, 40, 1);

INSERT INTO public.poll_assignment (id, doctor_id, user_id, poll_id, deadline, created_date, is_completed)
values
(DEFAULT, 1, 1, 1, '2023-12-02', '2023-12-01', false),
(DEFAULT, 2, 1, 1, '2023-12-03', '2023-12-02', false),
(DEFAULT, 3, 3, 3, '2023-12-12', '2023-12-03', false),
(DEFAULT, 4, 4, 4, '2023-12-05', '2023-12-04', false),
(DEFAULT, 5, 5, 5, '2023-12-06', '2023-12-05', true),
(DEFAULT, 6, 6, 6, '2023-12-07', '2023-12-06', false);

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
		(2, 8),
		(2, 1),
        (3, 4),
        (3, 9),
        (3, 11),
        (3, 12),
        (3, 13),
        (3, 14),
        (3, 15),
        (3, 8);
