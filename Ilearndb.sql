
create database ilearn;

create table ilearn.user
(username	varchar(30) not null,
password	varchar(50) not null,
role 		int default 3 not null,
major		varchar(20),
email		varchar(30) not null,

primary key(username)
);

create table ilearn.student
(studentId	varchar(15) not null,
username	varchar(30),
fName		varchar(20),
lName		varchar(20),
credits		int,
gradYear	varchar(25),
advisorId	varchar(15),

primary key(studentId),
foreign key(username) references user(username)
on delete set null on update cascade
);

create table ilearn.advisor
(advisorId	varchar(15) not null,
username	varchar(30),
fName		varchar(20),
lName		varchar(20),
about		varchar(500),
officeHours	varchar(200),
studentId 	varchar(15),

primary key(advisorId),

foreign key(username) references user(username)
on delete set null on update cascade,
foreign key(studentId) references student(studentId)
on delete set null on update cascade
);

alter table ilearn.student add constraint fk_advisor
foreign key(advisorId) references advisor(advisorId)
on delete set null on update cascade; 

create table ilearn.collegeplan
(major		varchar(20) not null,
pos			numeric(4) not null,
areaA		varchar(100) not null,
areaB		varchar(100),
areaC		varchar(100) not null,
areaD		varchar(100) not null,
areaE		varchar(300) not null,
areaF		varchar(100) not null,
majorArea	varchar(300) not null,
majorElec	varchar(100),
areaOther	varchar(100),
electives	varchar(100),

primary key(major,pos)
);

create table ilearn.studentplan
(studentId	varchar(15),
areaA		varchar(100) not null,
areaB		varchar(100) not null,
areaC		varchar(100) not null,
areaD		varchar(100) not null,
areaE		varchar(300) not null,
areaF		varchar(100) not null,
majorArea	varchar(300) not null,
majorElec	varchar(100), 
areaOther	varchar(100),
electives	varchar(100),

foreign key(studentId) references student(studentId)
on delete set null on update cascade
);

create table ilearn.course
(courseId	varchar(25) not null,
courseName	varchar(35) not null,
credits		int			not null,
preReq		varchar(50),
courseDescription varchar(1000),

primary key(courseId)
);

insert into ilearn.course
values('SOCI 1101', 'Introduction to Sociology', 3,  null, 'This course introduces students to the methods and theories used by sociologists to explore the nature of society. Selected topics may include culture, socialization, social interaction, groups, social organization, deviance, social institutions, and social stratification.'),
('ENGL 1101', 'English Composition I', 3, null, 'This course focuses on developing academic and professional written communication through a variety of rhetorical strategies. Using primarily nonfiction texts as models, the course emphasizes critical thinking and analysis, as well as introductory academic research skills. Student must meet placement requirements prior to enrolling'),
('ENGL 1102', 'English Composition II', 3, 'ENGL 1101', 'This course develops skills in written analysis, interpretation, and evaluation of texts and emphasizes critical thinking skills, increased stylistic sophistication, and the application of advanced research methods.'),
('MATH 1113', 'Precalculus', 3, null, 'An intensive course that focuses on applications of the functions, concepts, and methods necessary for success in calculus. Topics include exponential and logarithmic functions, trigonometric and inverse trigonometric functions, trigonometric identities and equations, right and oblique triangles and complex numbers.'),
('MATH 1450', 'Calculus I', 4, 'MATH 1113', 'An introduction to differential calculus. Topics include limits, differentiation of algebraic and trigonometric functions, applications of derivatives, antidifferentiation, simple differential equations, the area under a curve, the fundamental theorem of calculus, and differentiation and integration of exponential and logarithmic functions.'),
('MATH 2510', 'Intro to Discrete Mathematics', 3, 'MATH 1113', 'An introductory course in discrete mathematics. Topics include logic, sets, relations, combinatorial methods, Boolean Algebras, Applications of Boolean Algebras and a brief survey of Graphs and Networks and recurrence relations.'), 
('MATH 2400', 'Elementary Statistics', 3, 'MATH 1113, MATH 2460', 'A noncalculus introduction to descriptive and inferential hypothesis testing, linear regression and correlation, basic probability, the normal distribution and estimation.'),
('MATH 2460', 'Calculus II', 4, 'MATH 1450', 'A continuation of Calculus I. Topics include application of definite integrals, derivatives and integrals with inverse trigonometric functions, indeterminant forms and I’Hospital’s rule, techniques of integration, polar coordinates, and infinite sequences and series.'),
('SPAN 1001', 'Elementary Spanish I', 4, null, 'Introduction to listening, speaking, reading, and writing in Spanish and to the culture of Spanish-speaking regions.'),
('SPAN 1002', 'Elementary Spanish II', 4,  'SPAN 1001', 'Continued listening, speaking, reading, and writing in Spanish and to the culture of Spanish-speaking regions.'),
('SPAN 2001', 'Intermediate Spanish I', 3, 'SPAN 1002', 'Continued development and reinforcement of the fundamentals of grammar, vocabulary acquisition, pronunciation, listening, speaking, reading and writing. Designed to increase linguistic and cultural proficiency through the situational use of the language and the study of authentic materials from Spanish-speaking regions.'),
('GRMN 1001', 'Elementary German I', 4, null, 'Introduction to listening, speaking, reading, and writing in German and to the culture of German-speaking regions.'),
('GRMN 1002', 'Elementary German II', 4, 'GRMN 1001', 'Continued listening, speaking, reading, and writing in German and to the culture of French-speaking regions.'),
('GRMN 2001', 'Intermediate German I', 3, 'GRMN 1002', 'Continued development and reinforcement of the fundamentals of grammar, vocabulary acquisition, pronunciation, speaking, reading and writing. Designed to increase linguistic and cultural proficiency through the situational use of the language and the study of authentic materials from German-speaking regions.'),
('POLS 2401', 'Global Issues', 3, null, 'An analysis of the basic forces which govern the behavior of nations in their relations with one another. This study of world power conflicts, diplomacy and international cooperation is designed to acquaint the student with the basic issues and areas of conflict among the nation-states of the contemporary world.'),
('POLS 1101', 'American Government', 3, null, 'An intensive examination of the Constitution and the three governmental divisions. The course includes a study of the national government in its relation to the states.'),
('HIST 2111', 'US History I', 3, null, 'A survey of U.S. History to the post-Civil War period.'),
('HIST 2112', 'US History II', 3, null, 'A survey of U.S. History from the post-Civil War period to the present.'),
('ANTH 1102', 'Introduction to Anthropology', 3, null, 'Anthropology is the holistic study of what it means to be human.'),
('ECON 2105', 'Principles of Macroeconomics', 3, null, 'This principles of economics course is intended to introduce students to concepts that will enable them to understand and analyze economic aggregates and evaluate economic policies.'),
('PSYC 1101', 'Introduction to Psychology', 3, null, 'An overview of the major fields within psychology with an emphasis on developing an understanding of psychology as the science of behavior.'),
('GEOG 1101', 'Intro to Human Geography', 3, null, 'A study of fundamental concepts in human geography, including spatial interaction, population dynamics, human-environment interaction, culture, interpreting landscapes, economic development, and political geography.'),  
('GEOG 1102', 'World Regional Geography', 3, null, 'An introduction to the major themes and issues of contemporary world regional geography with focus on a geographic examination of the cultures, politics and histories of the major human regions of the world, with particular emphasis on the roles that these regions play in the globalization process and how their people are responding to the forces of globalization.'),
('CSCI 1301', 'Computer Science I', 4, null, 'This course will cultivate critical thinking skills by presenting computer science as problem solving discipline with emphasis in: fundamentals of computer science, algorithm development, coding, debugging and documentation of programs.'),
('CSCI 1302', 'Computer Science II', 4, 'CSCI 1301', 'This course is a continuation of CSCI 1301. It extends the discussion of object-oriented programming to include interface, event handling, graphical user interface, exception handling, streams, recursion, searching and sorting.'),
('CSCI 3100', 'Comp Organization/Architecture', 3, 'CSCI 1302', 'The course covers both the organizational and architectural levels of computer systems. The topics of the course include instruction sets, addressing, microprogramming, memory, I/O interrupts and data paths. Microcomputers, multiprocessors, pipeline computers, supercomputers, CISC and RISC architectures will also be covered.'),
('CSCI 3200', 'Data Struct & Analysis of Algo', 3, 'CSCI 1302, MATH 2510', 'The course covers data structures and basic algorithms. Topics include sorting, searching, hashing, tree structures, and priority queues. Complexity analysis of algorithms, and data structures is introduced as a system-independent performance measure. The course provides an introduction to tractability, and algorithm design.'),
('CSCI 3300', 'Software Development', 3, 'CSCI 1302', 'This course introduces students to the software development methodology and life cycle, with an emphasis on object-oriented software systems. Topics include fundamental data structures, program correctness, object-oriented design, requirement specification and analysis, object design and formal representation, software and information security (security planning, security policy, threats, attacks and services, encryption).'),
('CSCI 3410', 'Information Management', 3, 'CSCI 1302', 'An introduction to information technology management as it relates to the information-age organization.  Includes the capture, representation, organization, and presentation of information, data modeling and abstraction, and database systems. Also covers information security, integrity, and availability in a shared environment.'),
('CSCI 3450', 'Intelligent Systems', 3, 'CSCI 1302, MATH 2510', 'Fundamentals and applications of intelligent systems, including basic search strategies, knowledge-based reasoning, software agents, machine learning, robotics and computer perception, with a focus on the theory and application of solving complex problems with a combination of these technologies.'),
('CSCI 3510', 'Networking and Communications', 3, 'CSCI 1302', 'Introduction to communication networks. Topics include: communications technologies; communication protocols; representative network types such as LANs, WANs, cellular wireless networks, wireless LANs, wireless ad hoc networks and wireless sensor networks, and mobile communication systems.'),
('CSCI 4100', 'Operating Systems/File Organization', 3, 'CSCI 3100', 'This course provides an introduction to operating system concepts and file organization. Topics include processes, process coordination and synchronization, physical and virtual memory management, CPU scheduling, concurrent processes, and comparison of some operating systems. File systems and file organization are also covered.'),
('CSCI 4200', 'Programming Languages', 3, 'CSCI 1302, MATH 2510', 'This course provides a comparative study of programming language features including data types, control structures, implementation of function calls, and run time storage management. It covers the formal definition of languages and introduces various methods of translation. Less common languages and recent trends are also discussed.'),
('CSCI 4400', 'Software Engineering', 3, 'CSCI 3300', 'This course introduces the students to the principles of software methodology and engineering. Topics include specification, design, testing, and maintenance of software systems. Documentation style, team organization, software verification and validation, and security and protection are also covered. '),
('CSCI 4950', 'Senior Project', 3, 'CSCI 3300', 'This course is designed for Computer Science majors who are within one semester of graduation. It is a capstone course integrating the analysis and skills acquired from the previous courses in computer science and the student’s area of concentration.'),
('CSCI 3710', 'Advanced Programming', 3, 'CSCI 1302', 'A programming course that studies the construction of real-world programs – programs that robustly interact with their users and with their computing environment. Using a high-level language of the instructor’s choice, this course covers concurrency, graphics, user interfaces, and network programming.'),
('CSCI 3600', 'Computer Graphics', 3, 'CSCI 1302', 'The main focus of this course is to provide an introduction to interactive computer graphics. A large component of the class will consist of writing a large-scale graphics program using a high-level language. Topics include machine- independent graphics, graphics standards, a survey of applications, use of graphics libraries, output devices, appropriate data structures, and mathematical manipulation of graphical objects.'),
('CSCI 3250', 'Computer Security', 3, 'CSCI 1301', 'This course covers several security topics pertaining to real-life systems currently deployed and commonly used in the Internet computing environment. Materials covered include program security issues, database security issues, and operating systems security issues.'),
('CSCI 3660', 'Mobile Application Development', 3, 'CSCI 1302', 'This project-oriented course examines the principles of mobile application design and development. Topics will include user interface design; input methods; data handling; network techniques; and advanced topics such as GPS and motion sensing.'),
('ART 1100', 'Art Appreciation', 3, null, 'Art Appreciation is a course focused on fostering an awareness, understanding, and appreciation for the visual arts.'),
('PHYS 2211', 'Principles of Physics I', 4, 'MATH 1450', 'An introductory course which will include material from mechanics, thermodynamics and waves. Elementary differential calculus will be used.'), 
('PHYS 2212', 'Principles of Physics II', 4, 'MATH 2460', 'This is a calculus based introduction to the fundamental laws of electricity, magnetism, optics, and modern physics.'),
('ENGL 2111', 'World Literature I', 3, 'ENGL 1102', 'This course is a study of world literature from the beginnings through the seventeenth century, which involves reading, analyzing, and interpreting significant literary works within their historical, social, and cultural contexts.'),
('ENGL 2112', 'World Literature II', 3, 'ENGL 1102', 'This course is a study of world literature from the eighteenth century to the present, which involves reading, analyzing, and interpreting significant literary works within their historical, social, and cultural contexts.'), 
('ASTR 1010', 'Astronomy of the Solar System', 4, null, 'Astronomy from early ideas of the cosmos to modern observational techniques. The solar system planets, satellites, and minor bodies.'),
('MATH 3350', 'Probability & Statistics', 3, 'MATH 1450', 'A calculus-based course in probability and statistics.'),
('MATH 3120', 'Geometry', 3, 'CSCI 2800', 'Topics include classifications of geometries (Euclidean, Non-Euclidean, and other) and geometry related concepts outside the perspective of other mathematics courses.'),
('MATH 2800', 'Intro to Mathematical Proof', 3, 'MATH 2460', 'Topics include propositions and their truth values, tautologies, quantifiers, methods of proof, sets, relations, and partitions, functions, and mathematical induction.'),
('MATH 3360', 'Stochastic Processes', 3, 'MATH 3350', 'This course is a survey of random variables with both discrete and continuous distributions; including the uniform, Bernoulli, binomial and negative binomial, geometric and hypergeometric, Poisson, normal, exponential and gamma distributions.'),
('HIST 1112', 'World Civilization', 3, null, 'A survey of World History from early modern times to the present.'),
('CSCI 2150', 'Computer Ethics and Social Issues', 3, 'CSCI 1301', 'This course introduces the student to the social impact of computers and software. Topics include professional responsibilities related to copyright, software protection, security, and privacy.')
;

insert into ilearn.collegeplan
values('Computer Science', 2014, 'ENGL 1101; ENGL 1102; MATH 1113, MATH 1450', 'SPAN 1002, SPAN 1002, GRMN 1001, GRMN 1002', 'ENGL 2111, ENGL 2112, ART 1100', 'MATH 1450, MATH 2400, PHYS 2211, PHYS 2212', 'HIST 2111, HIST 2112, POLS 1101; ANTH 1102, ECON 2105, PSYC 1101, SOCI 1101; HIST 1112, POLS 1101, POLS 2401, GEOG 1101, GEOG 1102', 'CSCI 1301; CSCI 1302; CSCI 2150; MATH 2510; MATH 1450, MATH 2400, MATH 2460', 'CSCI 3100; CSCI 3200; CSCI 3300; CSCI 3410; CSCI 3450; CSCI 3510; CSCI 4100; CSCI 4200; CSCI 4400; CSCI 4950', 'CSCI 3600, CSCI 3250, CSCI 3660', 'MATH 2460, ASTR 1010, MATH 3350', 'MATH 3360, MATH 3120, MATH 2800');