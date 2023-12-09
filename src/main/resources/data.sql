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

INSERT INTO public.question (question_id, question_text, answers, polls)
VALUES
    (DEFAULT, 'What is the best way to maintain a healthy diet?', 1, 1),
    (DEFAULT, 'How often should one exercise per week?', 3, 2),
    (DEFAULT, 'What are common symptoms of seasonal allergies?', 6, 3),
    (DEFAULT, 'Can you describe effective stress management techniques?', 2, 4),
    (DEFAULT, 'What are the benefits of regular medical checkups?', 5, 5),
    (DEFAULT, 'How does sleep affect overall health?', 9, 6),
    (DEFAULT, 'What steps can be taken to prevent common colds?', 4, 7),
    (DEFAULT, 'What is the importance of hydration for health?', 7, 8),
    (DEFAULT, 'Can you explain the role of vitamins in the body?', 8, 9),
    (DEFAULT, 'What are healthy habits to improve heart health?', 10, 10);

INSERT INTO public.answer (id, answer_text, is_chosen, question_id)
VALUES  (DEFAULT, 'Answer text for question 1', true, 1),
        (DEFAULT, 'Another answer for question 1', false, 1),
        (DEFAULT, 'Third answer for question 1', false, 1),
        (DEFAULT, 'Fourth answer for question 1', false, 1),
        (DEFAULT, 'First answer for question 2', false, 2),
        (DEFAULT, 'Second answer for question 2', false, 2),
        (DEFAULT, 'Third answer for question 2', true, 2),
        (DEFAULT, 'Fourth answer for question 2', false, 2),
        (DEFAULT, 'Answer 1 for question 3', false, 3),
        (DEFAULT, 'Answer 2 for question 3', false, 3),
        (DEFAULT, 'Answer 3 for question 3', true, 3),
        (DEFAULT, 'Answer 4 for question 3', false, 3),
        (DEFAULT, '1st answer for question 4', false, 4),
        (DEFAULT, '2nd answer for question 4', false, 4),
        (DEFAULT, '3rd answer for question 4', false, 4),
        (DEFAULT, '4th answer for question 4', true, 4),
        (DEFAULT, 'Answer one for question 5', false, 5),
        (DEFAULT, 'Answer two for question 5', false, 5),
        (DEFAULT, 'Answer three for question 5', false, 5),
        (DEFAULT, 'Answer four for question 5', true, 5);


INSERT INTO public.cabinet (id, doctor_id, user_id, disease)
values  (1, 1, 1, 'Hypertension'),
        (2, 2, 2, 'Eczema'),
        (3, 3, 3, 'Migraine'),
        (4, 4, 4, 'Asthma'),
        (5, 5, 5, 'Breast Cancer'),
        (6, 6, 6, 'Anxiety Disorder'),
        (7, 7, 7, 'Diabetes'),
        (8, 8, 8, 'Knee Injury'),
        (9, 9, 9, 'Irritable Bowel Syndrome'),
        (10, 10, 10, 'Thyroid Disorder');

INSERT INTO public.medical_record (id, patient, doctor_id, created_time, doctor_notes, disease)
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

INSERT INTO public.notification (id, message, scheduled_time, checked)
VALUES
    (DEFAULT, 'Appointment reminder: Dr. Emily Watson, Cardiology at 10:00 AM', '2023-01-01', false),
    (DEFAULT, 'Lab results are available for review', '2023-01-02', true),
    (DEFAULT, 'New message from Dr. Jacob Brown, Dermatology', '2023-01-03', false),
    (DEFAULT, 'Appointment reminder: Dr. Sophia Miller, Neurology at 2:00 PM', '2023-01-04', false),
    (DEFAULT, 'Prescription refill reminder', '2023-01-05', true),
    (DEFAULT, 'Annual health check-up due', '2023-01-06', false),
    (DEFAULT, 'Insurance update information', '2023-01-07', true),
    (DEFAULT, 'Reminder: Follow-up visit with Dr. Noah Davis, Psychiatry', '2023-01-08', false),
    (DEFAULT, 'New health tips available', '2023-01-09', true),
    (DEFAULT, 'Appointment confirmation: Dr. Amelia Wilson, General Medicine', '2023-01-10', false);

-- Insert statements for the 'poll' table
INSERT INTO public.poll (id, question_id, user_id, notification_id)
VALUES
    (DEFAULT, 1, 1, 1),
    (DEFAULT, 1, 2, 2),
    (DEFAULT, 3, 3, 3),
    (DEFAULT, 4, 4, 4),
    (DEFAULT, 5, 5, 5),
    (DEFAULT, 6, 6, 6),
    (DEFAULT, 7, 7, 7),
    (DEFAULT, 8, 8, 8),
    (DEFAULT, 9, 9, 9),
    (DEFAULT, 10, 10, 10);

INSERT INTO public.response (poll_id, user_id, answer_id, question_id)
VALUES
    (1, 1, 1, 1),
    (1, 2, 2, 2),
    (2, 3, 3, 3),
    (2, 4, 4, 4),
    (3, 5, 5, 5),
    (3, 6, 6, 6),
    (4, 7, 7, 7),
    (4, 8, 8, 8),
    (5, 9, 9, 9),
    (5, 10, 10, 10),
    (6, 11, 1, 1),
    (6, 12, 2, 2),
    (7, 13, 3, 3),
    (7, 14, 4, 4),
    (8, 15, 5, 5),
    (8, 16, 6, 6),
    (9, 17, 7, 7),
    (9, 18, 8, 8),
    (10, 19, 9, 9),
    (10, 20, 10, 10);

INSERT INTO public.response_poll (poll_id, result)
VALUES
    (1, 100),
    (2, 85),
    (3, 90),
    (4, 75),
    (5, 95),
    (6, 80),
    (7, 70),
    (8, 60),
    (9, 65),
    (10, 55);


