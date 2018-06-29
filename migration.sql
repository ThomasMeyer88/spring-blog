
create DATABASE iron_db;

use blog_db;



create table users (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(250) NOT NULL,
  username VARCHAR(250) NOT NULL UNIQUE,
  email VARCHAR(250) NOT NULL UNIQUE,
  password VARCHAR(250) NOT NULL,
  DOB VARCHAR(250) NOT NULL,
  height INT,
  weight INT,
  sex VARCHAR(50),
  userRole VARCHAR(250) NOT NULL DEFAULT 'client',
  imgurl VARCHAR(250),
  bio VARCHAR (1000),
  coach_id INT,
  PRIMARY KEY (id)
  );

create table exercises (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(250) NOT NULL,
  muscle VARCHAR(250) NOT NULL,
  PRIMARY KEY (id)
);

insert into exercises (name, muscle) VALUES  ('Squat', 'Legs'),
('Deadlift', 'Legs'), ('Bench Press', 'Chest'), ('Overhead Press', 'Shoulders'),
('Pendlay Row', 'Back'), ('Sumo Deadlift', 'Legs'), ('Barbell Curl', 'Arms'),
('Dumbbell Curl', 'Arms'), ('Lat Pulldown', 'Back'), ('Inverted Row', 'Back'),
('Pullups', 'Back'), ('Pushups', 'Chest'), ('Situps', 'Core'), ('Crunches', 'Core'),
('Dumbbell Bench Press', 'Chest');


create table workSet (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  sets INT NOT NULL,
  reps INT NOT NULL,
  weight INT,
  exId INT UNSIGNED NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (exId) REFERENCES exercises (id)
);

create table template (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  day INT UNSIGNED NOT NULL,
  setId INT UNSIGNED NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (setId) REFERENCES workSet(id)
);



create table program (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR (245) NOT NULL,
  creator INT UNSIGNED NOT NULL,
  access VARCHAR(250) NOT NULL DEFAULT 'private',
  primary key (id),
  FOREIGN KEY (creator) REFERENCES users(id)
);

create table progDays(
  progId INT UNSIGNED NOT NULL,
  dayID INT UNSIGNED NOT NULL,
  FOREIGN KEY (progId) REFERENCES program (id),
  FOREIGN KEY (dayId) REFERENCES template (id)
);

