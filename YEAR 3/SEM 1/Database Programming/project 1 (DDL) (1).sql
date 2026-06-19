#Create Database
CREATE DATABASE IF NOT EXISTS attendance_system;
USE attendance_system;

#Create Tables
CREATE TABLE IF NOT EXISTS students (
	student_id INT PRIMARY KEY AUTO_INCREMENT,
    matric_no VARCHAR (12) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    programme VARCHAR (100) NOT NULL
);

CREATE TABLE IF NOT EXISTS lecturers (
	lecturer_id INT PRIMARY KEY AUTO_INCREMENT,
    staff_no VARCHAR(12) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS courses (
	course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_code VARCHAR(12) NOT NULL UNIQUE,
    course_name VARCHAR(50) NOT NULL,
    credit INT NOT NULL,
    semester INT NOT NULL
);

CREATE TABLE IF NOT EXISTS classes (
	class_id INT PRIMARY KEY AUTO_INCREMENT,
    course_id INT NOT NULL,
    lecturer_id INT NOT NULL,
    class_day VARCHAR(20),
    class_time TIME,
    FOREIGN KEY(course_id) REFERENCES courses(course_id),
    FOREIGN KEY (lecturer_id) REFERENCES lecturers(lecturer_id)
);

CREATE TABLE IF NOT EXISTS enrollments (
	enroll_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    class_id INT NOT NULL,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (class_id) REFERENCES classes(class_id)
);

CREATE TABLE IF NOT EXISTS attendance_records (
	attendance_id INT PRIMARY KEY AUTO_INCREMENT,
    enroll_id INT NOT NULL,
    attendance_date DATE NOT NULL,
    attendance_time TIME, #change it so that it can store null for absent reason
    status ENUM('Present','Absent','Late') NOT NULL,
    remark VARCHAR (255) DEFAULT NULL
);

#add email to lecturer
ALTER TABLE lecturers
	ADD COLUMN email VARCHAR(100) NOT NULL UNIQUE;
    
#change programme length
ALTER TABLE students
	MODIFY COLUMN programme VARCHAR(120);
    
#drop a temporary table (command it when no need to use)
DROP TABLE IF EXISTS temp_attendance;

#insert 10 students records
INSERT INTO students (student_id, matric_no, name, email, programme) VALUES
(1001,'A23CS0009', 'Aisyah', 'aisyah@graduate.utm.my', 'Computer Networks and Security'),
(1003,'A23CS0023', 'Balqis', 'balqis@graduate.utm.my', 'Software Engineering'),
(1008,'A23CS0018', 'Brendan Chia', 'brendan@graduate.utm.my', 'Bioinformatics'),
(1017,'A23CS0037', 'Fatin Afifah', 'fatin@graduate.utm.my', 'Computer Networks and Security'),
(1023,'A23CS0080', 'Gui Kah Sin', 'kahsin@graduate.utm.my', 'Data Engineering'),
(1056,'A23CS0098', 'Lau Yan Kai', 'yankai@graduate.utm.my', 'Software Engineering'),
(1080,'A23CS0128', 'Matthew', 'matthew@graduate.utm.my', 'Data Engineering'),
(1107,'A23CS00135', 'Muhammad Iqram', 'iqram@graduate.utm.my', 'Bioinformatics'),
(1129,'A23CS0265', 'Sabrina Heng', 'sabrina@graduate.utm.my', 'Data Engineering'),
(1212,'A23CS0239', 'Yusuf', 'yusuf@graduate.utm.my', 'Graphics and Multimedia Software');

#insert 10 lecturers records
INSERT INTO lecturers (lecturer_id, staff_no, name, department,email) VALUES
(3001, '10231','Dr. Azlan', 'Department of Computer Networks & Cybersecurity', 'azlan@utm.my'),
(3002, '12124','Dr. Siti', 'Department of Software Engineering', 'siti@utm.my'),
(3003, '9742','Dr. Lee', 'Department of Computational Biology & Bioinformatics', 'lee@utm.my'),
(3004, '12111','Dr. Sean', 'Department of Artificial Intelligence & Data Science', 'seahcs@utm.my'),
(3005, '15946','Dr. Hani', 'Department of Multimedia', 'hani@utm.my'),
(3006, '7963','Dr. Faridah', 'Department of Multimedia', 'faridah@utm.my'),
(3007, '16508','Dr. Lim', 'Department of Software Engineering', 'lim@utm.my'),
(3008, '9832','Dr. Nurin', 'Department of Multimedia', 'nurin@utm.my'),
(3009, '13126','Dr. Nies', 'Department of Computational Biology & Bioinformatics', 'nies@utm.my'),
(3010, '7864','Dr. Najmi', 'Department of Artificial Intelligence & Data Science', 'najmi@utm.my');

#insert 10 courses records
INSERT INTO courses (course_id, course_code, course_name, credit, semester) VALUES
(1, 'SECJ1013', 'Programming Language I', 3, 1),
(3, 'SECJ1023', 'Discrete Structure', 3, 1),
(102, 'SECJ2013', 'Database Programming', 3, 5),
(24, 'SECJ2023', 'System Analysis and Design (WBL)', 3, 2),
(56, 'SECJ3013', 'Network Communications', 3, 3),
(72, 'SECJ3023', 'Software Engineering (WBL)', 4, 3),
(87, 'SECJ3033', 'Operating Systems', 3, 4),
(113, 'SECJ4013', 'Artificial Intelligence', 3, 5),
(96, 'SECJ4023', 'Data Mining', 3, 4),
(43, 'SECJ4033', 'Human Computer Interaction', 3, 2);

#insert 14 classes records
INSERT INTO classes (class_id, course_id, lecturer_id, class_day, class_time) VALUES
(1, 1, 3001, 'Monday', '09:00:00'),
(2, 3, 3002, 'Tuesday', '10:00:00'),
(3, 102, 3003, 'Wednesday', '14:00:00'),
(4, 24, 3004, 'Thursday', '11:00:00'),
(5, 56, 3005, 'Friday', '15:00:00'),
(6, 72, 3006, 'Monday', '08:00:00'),
(7, 87, 3007, 'Tuesday', '09:00:00'),
(8, 113, 3008, 'Wednesday', '10:00:00'),
(9, 96, 3009, 'Thursday', '8:00:00'),
(10, 43, 3010, 'Friday', '15:00:00'),
(11, 1, 3001, 'Wednesday', '11:00:00'),
(12, 96, 3009, 'Monday', '09:00:00'),
(13, 24, 3004, 'Wednesday', '11:00:00'),
(14, 113, 3008, 'Tuesday', '08:00:00');

#insert 2 enrollments records per student
INSERT INTO enrollments (enroll_id, student_id, class_id) VALUES
(1, 1001, 1),
(2, 1001, 3),
(3, 1003, 2),
(4, 1003, 4),
(5, 1008, 3),
(6, 1008, 5),
(7, 1017, 1),
(8, 1017, 2),
(9, 1023, 5),
(10, 1023, 6),
(11, 1056, 7),
(12, 1056, 8),
(13, 1080, 6),
(14, 1080, 9),
(15, 1107, 7),
(16, 1107, 10),
(17, 1129, 4),
(18, 1129, 8),
(19, 1212, 9),
(20, 1212, 10);

#insert attendance records for 2 days for students
INSERT INTO attendance_records (attendance_id, enroll_id, attendance_date, attendance_time, status, remark) VALUES
(1, 1, '2025-11-10', '09:00:00', 'Present', NULL),
(2, 2, '2025-11-11', '09:10:00', 'Late', 'Arrived 10 mins late'),
(3, 3, '2025-11-10', '14:00:00', 'Present', 'Sick'),
(4, 4, '2025-11-11', '14:00:00', 'Present', NULL),
(5, 5, '2025-11-10', '10:00:00', 'Present', NULL),
(6, 6, '2025-11-11', '10:00:00', 'Present', NULL),
(7, 7, '2025-11-10', '11:05:00', 'Late', 'Arrived 5 mins late'),
(8, 8, '2025-11-11', '11:00:00', 'Present', NULL),
(9, 9, '2025-11-10', '14:00:00', 'Present', NULL),
(10, 10, '2025-11-11', '14:00:00', 'Present', NULL),
(11, 11, '2025-11-10', NULL, 'Absent', 'Family reason'),
(12, 12, '2025-11-11', '15:00:00', 'Present', NULL),
(13, 13, '2025-11-10', '08:00:00', 'Present', NULL),
(14, 14, '2025-11-11', '08:15:00', 'Late', 'Traffic delay'),
(15, 15, '2025-11-10', '09:00:00', 'Present', NULL),
(16, 16, '2025-11-11', '09:03:00', 'Present', NULL),
(17, 17, '2025-11-10', '10:00:00', 'Present', NULL),
(18, 18, '2025-11-11', '10:00:00', 'Present', NULL),
(19, 19, '2025-11-10', '13:10:00', 'Present', NULL),
(20, 20, '2025-11-11', '13:00:00', 'Present', NULL);

# Update attendance status if student arrived late but show present
UPDATE attendance_records
SET status = 'Late'
WHERE attendance_time IS NOT NULL AND MINUTE(attendance_time) > 0;

# Add automated remark for late students if no remark exists or the status just updated
UPDATE attendance_records
SET remark = CONCAT('Arrived ', MINUTE(attendance_time), ' mins late')
WHERE status = 'Late'
AND (remark IS NULL OR remark = '');

# The current foreign key doesn't allow deleting a student because enrollments reference them.
# To apply ON DELETE CASCADE, we first need to drop the existing foreign key,
ALTER TABLE enrollments
DROP FOREIGN KEY enrollments_ibfk_1;

# then recreate it with ON DELETE CASCADE so that deleting a student will also removes their enrollments automatically.
ALTER TABLE enrollments
ADD CONSTRAINT enrollments_ibfk_1
FOREIGN KEY (student_id) REFERENCES students(student_id)
ON DELETE CASCADE;

# Now can delete a student record that have withdrawn from the programme
DELETE FROM students
WHERE student_id = 1003;

# Delete an enrollment if a student dropped a class
DELETE FROM enrollments
where enroll_id = 15;


# Insert a new student
START TRANSACTION;

INSERT INTO students (matric_no, name, email, programme) 
VALUES ('A23CS9000', 
'Transaction Test Student', 
'test@graduate.utm.my', 
'Software Engineering');

# Enroll the student immediately into Class ID 1
INSERT INTO enrollments (student_id, class_id)
VALUES (LAST_INSERT_ID(), 1);

COMMIT;


# Rollback
START TRANSACTION;

DELETE FROM students WHERE student_id = 1212;
SELECT * FROM students; 

ROLLBACK;
SELECT * FROM students; 

# Filtering (WHERE, OR & AND)
# List late students from specific programmes
SELECT s.student_id, s.name, s.programme, a.attendance_date, a.attendance_time, a.remark
FROM attendance_records a
JOIN enrollments e ON a.enroll_id = e.enroll_id
JOIN students s ON e.student_id = s.student_id
WHERE a.status = 'Late'
  AND (s.programme = 'Data Engineering' OR s.programme = 'Software Engineering')
ORDER BY s.programme;

# Sorting (ORDER BY, LIMIT)
SELECT * FROM lecturers
WHERE department = 'Department of Multimedia'
ORDER BY name ASC
LIMIT 2;

# Aggregation (COUNT, MAX & MIN)
# 'OVER()' allows MAX() and MIN() to check across all grouped rows without collapsing them into a single row
SELECT programme,
COUNT(*) AS total_students,
    CASE 
        WHEN COUNT(*) = MAX(COUNT(*)) OVER () THEN 'MAX'
        WHEN COUNT(*) = MIN(COUNT(*)) OVER () THEN 'MIN'
        ELSE ''
    END AS student_status
FROM students
GROUP BY programme
ORDER BY total_students DESC;

# Grouping and filtering groups (GROUP BY, HAVING)
# Filter those lecturer who have more than 1 class per week
SELECT l.name AS lecturer, COUNT(cl.class_id) AS total_classes
FROM lecturers l
JOIN classes cl ON l.lecturer_id = cl.lecturer_id
GROUP BY l.name
HAVING COUNT(cl.class_id) > 1
ORDER BY total_classes DESC;

# Aggregate 
SELECT 
    SUM(credit) AS total_credits_offered, 
    ROUND(AVG(credit), 2) AS average_credit
FROM courses;

# Grouping using HAVING 
SELECT l.name AS lecturer, COUNT(cl.class_id) AS total_classes
FROM lecturers l
JOIN classes cl ON l.lecturer_id = cl.lecturer_id
GROUP BY l.name
HAVING COUNT(cl.class_id) > 1
ORDER BY total_classes DESC;



# Conditional Logic
SELECT course_id, class_time, 
CASE 
   WHEN class_time < "10:00:00" THEN "Morning Class"
   WHEN "10:00:00" <= class_time <= "02:00:00" THEN "Mid-day Class"
   ELSE "Evening Class"
END AS class_type
FROM classes;

# Single Row Subquery
SELECT course_id, class_day, class_time
FROM classes
WHERE course_id = 1
AND class_time = (
    SELECT MIN(class_time)
    FROM classes
    WHERE course_id = 1
);

# Multiple Row subquery
SELECT classes.lecturer_id, lecturers.name
FROM classes
INNER JOIN lecturers ON classes.lecturer_id = lecturers.lecturer_id
GROUP BY lecturer_id
HAVING COUNT(*) > 1;

# Multiple Row Subquery
SELECT lecturer_id, name
FROM lecturers
WHERE lecturer_id IN (
    SELECT lecturer_id
    FROM classes
    GROUP BY lecturer_id
    HAVING COUNT(*) > 1
);

# Correlated Subquery
SELECT s.student_id, s.name,
       (SELECT MAX(a.attendance_date)
        FROM enrollments e
        JOIN attendance_records a ON e.enroll_id = a.enroll_id
        WHERE e.student_id = s.student_id) AS last_attendance
FROM students s;

# Set Operations
# Union
SELECT name, programme FROM students WHERE programme = 'Data Engineering'
UNION
SELECT name, programme FROM students WHERE programme = 'Software Engineering';

# NOT EXISTS
SELECT s.student_id, s.name
FROM students s
WHERE NOT EXISTS (
    SELECT 1
    FROM enrollments e
    JOIN attendance_records a ON e.enroll_id = a.enroll_id
    WHERE e.student_id = s.student_id
      AND a.status = 'Late'
);

# JOIN
# INNER JOIN
SELECT classes.lecturer_id, lecturers.name
FROM classes
JOIN lecturers ON classes.lecturer_id = lecturers.lecturer_id
GROUP BY lecturer_id
HAVING COUNT(*) > 1;

# NATURAL JOIN
SELECT student_id, name, programme, attendance_date, attendance_time
FROM students
NATURAL JOIN attendance_records;

# SELF JOIN
SELECT 
    a1.enroll_id AS student1,
    a2.enroll_id AS student2,
    a1.attendance_date,
    a1.status AS status1,
    a2.status AS status2
FROM attendance_records a1
JOIN attendance_records a2
    ON a1.attendance_date = a2.attendance_date
   AND a1.enroll_id < a2.enroll_id
ORDER BY a1.attendance_date, a1.enroll_id;

SELECT 
    s.student_id,
    s.name,
    s.programme,
    a.attendance_date,
    a.attendance_time,
    a.status
FROM students s
LEFT JOIN attendance_records a
    ON a.attendance_date = '2025-11-10'
ORDER BY s.student_id;

#BEFORE Indexing
EXPLAIN SELECT * FROM attendance_records 
WHERE attendance_date = '2025-11-12';

EXPLAIN SELECT * FROM students 
WHERE name LIKE '%Brendan%';


# BTREE Index for attendance date
CREATE INDEX idx_attendance_date 
ON attendance_records (attendance_date) 
USING BTREE;
SHOW INDEX FROM attendance_records; 

# TEXT Index for student name search
CREATE FULLTEXT INDEX idx_student_name 
ON students (name);
SHOW INDEX FROM students; 

# AFTER Indexing
EXPLAIN SELECT * FROM attendance_records 
WHERE attendance_date = '2025-11-12';

EXPLAIN 
SELECT * FROM students 
WHERE MATCH(name) AGAINST('Brendan');

