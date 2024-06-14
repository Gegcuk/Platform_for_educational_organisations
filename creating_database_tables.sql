use university_managment;

create table if not exists Users (
	user_id int auto_increment primary key,
    full_name varchar(255) not null,
    email varchar(255) not null unique,
    password varbinary(255) not null,
    profile_picture varchar(255),
    role ENUM('student', 'teacher', 'admin') not null,
    birthdate date,
    location varchar(255),
    contact_info varchar(255)
);

create table if not exists Departments(
	department_id int auto_increment primary key,
    department_name varchar(255) not null
);

create table if not exists Courses(
	course_id int auto_increment primary key,
    course_title varchar(255) not null,
    course_code varchar(50) not null unique,
    semester varchar(50) not null,
    credit_hours int,
    department int,
    description text,
    prerequisites text,
    syllabus text,
    weekly_plan text,
    key_dates text,
    foreign key (department) references departments(department_id)
);

create table if not exists Students(
	student_id int auto_increment primary key,
    user_id int,
    foreign key (user_id) references users(user_id)
);

create table if not exists CurrentCourses (
	id int auto_increment primary key,
    student_id int,
    course_id int,
    foreign key (student_id) references students(student_id),
    foreign key (course_id) references courses(course_id)
);

create table if not exists CompletedCourses (
	id int auto_increment primary key,
    student_id int,
    course_id int,
    foreign key (student_id) references students(student_id),
    foreign key (course_id) references courses(course_id)
);

create table if not exists Grades(
	grade_id int auto_increment primary key,
    student_id int,
    course_id int,
    grade decimal(5,2),
    foreign key (student_id) references students(student_id),
    foreign key (course_id) references courses(course_id)
);

create table if not exists ProgressTracker(
	progress_id int auto_increment primary key,
    student_id int,
    course_id int,
    progress_percentage decimal(5,2),
    foreign key (student_id) references students(student_id),
    foreign key (course_id) references courses(course_id)
);

create table if not exists Teachers(
	teacher_id int auto_increment primary key,
    user_id int,
    department int,
    foreign key (user_id) references users(user_id),
    foreign key (department) references departments(department_id)
);

create table if not exists CoursesTaught(
	coursetaught_id int auto_increment primary key,
    teacher_id int,
    course_id int,
    foreign key (teacher_id) references teachers(teacher_id),
    foreign key (course_id) references courses(course_id)
);

create table if not exists TeachingHistory(
	coursehistory_id int auto_increment primary key,
    teacher_id int,
    course_id int,
    semester varchar(50),
    foreign key (teacher_id) references teachers(teacher_id),
    foreign key (course_id) references courses(course_id)
);

create table if not exists Projects(
	project_id int auto_increment primary key,
    teacher_id int,
    course_id int,
    title varchar(255),
    decription text,
    deadline date,
    progress_status enum('not started', 'in progress', 'completed'),
    foreign key (teacher_id) references teachers(teacher_id)
);

create table if not exists Publications(
	publication_id int auto_increment primary key,
    teacher_id int,
    title varchar(255),
    description text,
    foreign key (teacher_id) references teachers(teacher_id)
);

create table if not exists AdminStaff(
	admin_id int auto_increment primary key,
    user_id int,
    occupacion varchar(255),
    department int,
    foreign key (user_id) references users(user_id),
    foreign key (department) references departments(department_id)
);


create table if not exists ManagedCourses(
	id int auto_increment primary key,
    admin_id int,
    course_id int,
    foreign key (admin_id) references adminstaff(admin_id),
    foreign key (course_id) references courses(course_id)
);

create table if not exists CourseInstructors(
	course_id int,
    teacher_id int,
    primary key (course_id, teacher_id),
    foreign key (course_id) references courses(course_id),
    foreign key (teacher_id) references teachers(teacher_id)
);

create table if not exists enrollments (
    enrollment_id int auto_increment primary key,
    course_id int,
    student_id int,
    grade varchar(5),
    unique (course_id, student_id),
    foreign key (course_id) references courses(course_id),
    foreign key (student_id) references students(student_id)
);

create table if not exists Assignments (
    assignment_id int auto_increment primary key,
    course_id int,
    created_by int,
    title varchar(255),
    description text,
    due_date date,
    status enum('completed', 'pending'),
    foreign key (course_id) references courses(course_id),
    foreign key (created_by) references teachers(teacher_id)
);

create table if not exists Notifications (
    notification_id int auto_increment primary key,
    user_id int,
    message text,
    date date,
    type enum('alert', 'message', 'reminder'),
    foreign key (user_id) references users(user_id)
);

create table if not exists Feedback (
    feedback_id int auto_increment primary key,
    course_id int,
    student_id int,
    feedback_text text,
    rating int,
    date date,
    foreign key (course_id) references courses(course_id),
    foreign key (student_id) references students(student_id)
);

create table if not exists  Skills (
    skill_id int auto_increment primary key,
    user_id int,
    skill_name varchar(255),
    foreign key (user_id) references users(user_id)
);

create table if not exists Achievements (
    achievement_id int auto_increment primary key,
    user_id int,
    title varchar(255),
    description text,
    date date,
    foreign key (user_id) references users(user_id)
);

create table if not exists Specializations (
    specialization_id int auto_increment primary key,
    specialization_name varchar(255) not null,
    description text,
    department varchar(255) not null
);

create table if not exists LearningPaths (
    path_id int auto_increment primary key,
    specialization_id int,
    path_name varchar(255) not null,
    description text,
    start_date date,
    end_date date,
    foreign key (specialization_id) references specializations(specialization_id)
);

create table if not exists PathCourses (
    path_course_id int auto_increment primary key,
    path_id int,
    course_id int,
    is_mandatory boolean,
    foreign key (path_id) references learningpaths(path_id),
    foreign key (course_id) references courses(course_id)
);

create table if not exists StudentSpecializations (
    student_specialization_id int auto_increment primary key,
    student_id int,
    specialization_id int,
    start_date date,
    completion_date date,
    foreign key (student_id) references students(student_id),
    foreign key (specialization_id) references specializations(specialization_id)
);



















