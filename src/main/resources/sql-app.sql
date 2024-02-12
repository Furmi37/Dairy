CREATE TABLE student (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         first_name VARCHAR (20) NOT NULL,
                         last_name VARCHAR(20) NOT NULL,
                         email VARCHAR(100)NOT NULL UNIQUE,
                         birth_day DATE,
                         class_name VARCHAR (5)
);
CREATE TABLE grades (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        grade INT,
                        add_date DATE,
                        subject VARCHAR(20),
                        student_id INT,
                        FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE SET NULL
);