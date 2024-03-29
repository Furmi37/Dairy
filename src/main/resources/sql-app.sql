CREATE TABLE student
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(20)  NOT NULL,
    last_name  VARCHAR(20)  NOT NULL,
    email      VARCHAR(100) NOT NULL UNIQUE,
    birth_day  DATE,
    class_name VARCHAR(5)
);
CREATE TABLE grade
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    grade      INT,
    add_date   DATE,
    subject    VARCHAR(20),
    student_id INT,
    FOREIGN KEY (student_id) REFERENCES student (id) ON DELETE SET NULL
);

CREATE TABLE teacher
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    first_name   VARCHAR(20),
    last_name    VARCHAR(20),
    salary       INT,
    subject      VARCHAR(20),
    academic_dgr VARCHAR(20),
    empl_date    DATE

);
ALTER TABLE teacher AUTO_INCREMENT=100;
