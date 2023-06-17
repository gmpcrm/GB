CREATE TABLE YoungAnimals (
    id INT PRIMARY KEY,
    AgeInMonths INT,
    FOREIGN KEY (id) REFERENCES Animal(id)
);

INSERT INTO YoungAnimals (id, AgeInMonths)
SELECT 
    id,
    TIMESTAMPDIFF(MONTH, date_of_birth, CURDATE()) as AgeInMonths
FROM Animal
WHERE TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) > 1 AND TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) < 3;
