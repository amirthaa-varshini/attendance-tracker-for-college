CREATE DATABASE college_attendance_final;
USE college_attendance_final;

CREATE TABLE attendance_records (
    roll_no VARCHAR(10) PRIMARY KEY,
    name VARCHAR(50),
    total_classes INT DEFAULT 0,
    attended_classes INT DEFAULT 0
);

INSERT INTO attendance_records (roll_no, name, total_classes, attended_classes) VALUES
('S001', 'Amit', 30, 25),
('S002', 'Priya', 30, 20),
('S003', 'Rahul', 30, 28),
('S004', 'Kavya', 30, 15),
('S005', 'Meena', 30, 23),
('S006', 'Surya', 30, 30),
('S007', 'Kiran', 30, 18),
('S008', 'Arjun', 30, 25),
('S009', 'Neha', 30, 29),
('S010', 'Vikram', 30, 19),
('S011', 'Diya', 30, 24),
('S012', 'Ravi', 30, 27),
('S013', 'Sneha', 30, 28),
('S014', 'Karthik', 30, 15),
('S015', 'Pooja', 30, 22),
('S016', 'Varun', 30, 26),
('S017', 'Lakshmi', 30, 18),
('S018', 'Naveen', 30, 30),
('S019', 'Anjali', 30, 20),
('S020', 'Hari', 30, 24),
('S021', 'Sathish', 30, 27),
('S022', 'Jaya', 30, 29),
('S023', 'Rohit', 30, 21),
('S024', 'Deepa', 30, 17),
('S025', 'Vijay', 30, 23);

