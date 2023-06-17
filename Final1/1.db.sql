USE Друзья_человека;

CREATE TABLE Animal (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    commands VARCHAR(255),
    date_of_birth DATE
);

CREATE TABLE DomesticAnimal (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Animal(id)
);

CREATE TABLE BeastOfBurden (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Animal(id)
);

CREATE TABLE Horse (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES BeastOfBurden(id)
);

CREATE TABLE Donkey (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES BeastOfBurden(id)
);

CREATE TABLE Camel (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES BeastOfBurden(id)
);

CREATE TABLE Dog (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES DomesticAnimal(id)
);

CREATE TABLE Cat (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES DomesticAnimal(id)
);

CREATE TABLE Hamster (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES DomesticAnimal(id)
);
