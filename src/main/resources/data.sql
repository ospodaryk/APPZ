INSERT INTO public.users (id, email, name, password, phone_number, surname)
VALUES (DEFAULT, 'oksanaspodaryk@mail.com', 'Oksana', '$2a$10$qiG6YVCCLwVIaLKOGChmru7cf7v1P5Ohrxp3bpyQf56GdvpmKr3U6',
        '380501234567', 'Spodaryk'),
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
VALUES  (DEFAULT, 'Answer text for question 1'),
        (DEFAULT, 'Another answer for question 1'),
        (DEFAULT, 'Third answer for question 1'),
        (DEFAULT, 'Fourth answer for question 1'),
        (DEFAULT, 'First answer for question 2'),
        (DEFAULT, 'Second answer for question 2'),
        (DEFAULT, 'Third answer for question 2'),
        (DEFAULT, 'Fourth answer for question 2'),
        (DEFAULT, 'Answer 1 for question 3'),
        (DEFAULT, 'Answer 2 for question 3'),
        (DEFAULT, 'Answer 3 for question 3'),
        (DEFAULT, 'Answer 4 for question 3'),
        (DEFAULT, '1st answer for question 4'),
        (DEFAULT, '2nd answer for question 4'),
        (DEFAULT, '3rd answer for question 4'),
        (DEFAULT, '4th answer for question 4'),
        (DEFAULT, 'Answer one for question 5'),
        (DEFAULT, 'Answer two for question 5'),
        (DEFAULT, 'Answer three for question 5'),
        (DEFAULT, 'Answer four for question 5');

INSERT INTO public.question_block (id, block_name)
VALUES
(DEFAULT,'Questions about Body Health'),
(DEFAULT,'General Health and Wellness Questions'),
(DEFAULT,'Questions about Diet and Nutrition'),
(DEFAULT,'Mental Health and Stress Management Questions'),
(DEFAULT,'Chronic Conditions and Disease Management'),
(DEFAULT,'Medication and Treatment Questions'),
(DEFAULT,'Family Health History Questions'),
(DEFAULT,'Lifestyle and Exercise Questions'),
(DEFAULT,'Symptom Assessment and Reporting'),
(DEFAULT,'Preventive Health and Checkups');

INSERT INTO public.question (id, question_text, answer_id, block_id)
VALUES
    (DEFAULT, 'What is the best way to maintain a healthy diet?', 1, 1),
    (DEFAULT, 'How often should one exercise per week?', 3, 2),
    (DEFAULT, 'What are common symptoms of seasonal allergies?', 6, 2),
    (DEFAULT, 'Can you describe effective stress management techniques?', 2, 3),
    (DEFAULT, 'What are the benefits of regular medical checkups?', 5, 4),
    (DEFAULT, 'How does sleep affect overall health?', 9, 5),
    (DEFAULT, 'What steps can be taken to prevent common colds?', 4, 6),
    (DEFAULT, 'What is the importance of hydration for health?', 7, 7),
    (DEFAULT, 'Can you explain the role of vitamins in the body?', 8, 8),
    (DEFAULT, 'What are healthy habits to improve heart health?', 10, 9);

INSERT INTO public.cabinet (id, doctor_id, user_id, disease)
values  (DEFAULT, 1, 1, 'Hypertension'),
        (DEFAULT, 2, 2, 'Eczema'),
        (DEFAULT, 3, 3, 'Migraine'),
        (DEFAULT, 4, 4, 'Asthma'),
        (DEFAULT, 5, 5, 'Breast Cancer'),
        (DEFAULT, 6, 6, 'Anxiety Disorder'),
        (DEFAULT, 7, 7, 'Diabetes'),
        (DEFAULT, 8, 8, 'Knee Injury'),
        (DEFAULT, 9, 9, 'Irritable Bowel Syndrome'),
        (DEFAULT, 10, 10, 'Thyroid Disorder');

INSERT INTO public.medical_record (id, patient_id, doctor_id, created_time, doctor_notes, disease)
VALUES
    (DEFAULT, 1, 1, '2023-01-01T08:00:00', 'Patient in good health, no immediate concerns.', 'Hypertension'),
    (DEFAULT, 2, 2, '2023-01-02T09:00:00', 'Patient reports mild eczema, prescribed topical cream.', 'Eczema'),
    (DEFAULT, 3, 3, '2023-01-03T10:30:00', 'Regular migraine, advised lifestyle changes and medication.', 'Migraine'),
    (DEFAULT, 4, 4, '2023-01-04T11:15:00', 'Asthma check-up, no change in medication needed.', 'Asthma'),
    (DEFAULT, 5, 5, '2023-01-05T14:00:00', 'Routine cancer follow-up, stable condition.', 'Breast Cancer'),
    (DEFAULT, 6, 6, '2023-01-06T16:00:00', 'Discussed anxiety management strategies.', 'Anxiety Disorder'),
    (DEFAULT, 7, 7, '2023-01-07T10:00:00', 'Diabetes management, blood sugar levels stable.', 'Diabetes'),
    (DEFAULT, 8, 8, '2023-01-08T13:00:00', 'Assessed knee injury, recommended physiotherapy.', 'Knee Injury'),
    (DEFAULT, 9, 9, '2023-01-09T15:30:00', 'IBS symptoms present, dietary adjustments suggested.', 'Irritable Bowel Syndrome'),
    (DEFAULT, 10, 10, '2023-01-10T17:00:00', 'Thyroid function normal, continue current medication.', 'Thyroid Disorder');


INSERT INTO public.poll (id, poll_title)
VALUES
    (DEFAULT, 'Title_1'),
    (DEFAULT, 'Title_2'),
    (DEFAULT, 'Title_3'),
    (DEFAULT, 'Title_4'),
    (DEFAULT, 'Title_5'),
    (DEFAULT, 'Title_6'),
    (DEFAULT, 'Title_7'),
    (DEFAULT, 'Title_8'),
    (DEFAULT, 'Title_9'),
    (DEFAULT, 'Title_10');

INSERT INTO public.response (id, poll_id, user_id, answer_id, question_id, response_date)
VALUES
    (DEFAULT, 1, 1, 1, 11, '2023-12-01'),
    (DEFAULT, 1, 2, 2, 12, '2023-12-01'),
    (DEFAULT, 2, 3, 3, 13, '2023-12-01'),
    (DEFAULT, 2, 4, 4, 14, '2023-12-01'),
    (DEFAULT, 3, 5, 5, 15, '2023-12-01'),
    (DEFAULT, 3, 6, 6, 16, '2023-12-01'),
    (DEFAULT, 4, 7, 7, 17, '2023-12-01'),
    (DEFAULT, 4, 8, 8, 18, '2023-12-01'),
    (DEFAULT, 5, 9, 9, 19, '2023-12-01'),
    (DEFAULT, 5, 10, 10, 20, '2023-12-01');

INSERT INTO public.statistic (id, poll_id, result, user_id)
VALUES
    (DEFAULT,1, 100, 2),
    (DEFAULT,2, 85, 3),
    (DEFAULT,3, 90, 4),
    (DEFAULT,4, 75, 1),
    (DEFAULT,5, 95, 5),
    (DEFAULT,6, 80, 6),
    (DEFAULT,7, 70, 7),
    (DEFAULT,8, 60, 9),
    (DEFAULT,9, 65, 8),
    (DEFAULT,10, 55, 10);

INSERT INTO public.assigned_poll (id, doctor_id, user_id, poll_id, deadline, created_date, is_completed)
values
(DEFAULT, 1, 1, 1, '2023-12-31', '2023-12-01', false),
(DEFAULT, 2, 2, 2, '2023-12-30', '2023-12-02', false),
(DEFAULT, 3, 3, 3, '2023-12-29', '2023-12-03', true),
(DEFAULT, 4, 4, 4, '2023-12-28', '2023-12-04', false),
(DEFAULT, 5, 5, 5, '2023-12-27', '2023-12-05', true),
(DEFAULT, 6, 6, 6, '2023-12-26', '2023-12-06', false),
(DEFAULT, 7, 7, 7, '2023-12-25', '2023-12-07', true),
(DEFAULT, 8, 8, 8, '2023-12-24', '2023-12-08', false),
(DEFAULT, 9, 9, 9, '2023-12-23', '2023-12-09', true),
(DEFAULT, 10, 10, 10, '2023-12-22', '2023-12-10', false);

INSERT INTO public.poll_questions (poll_id, question_id)
VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(2, 5),
(2, 6),
(2, 1),
(2, 2),
(2, 8),
(2, 10);
