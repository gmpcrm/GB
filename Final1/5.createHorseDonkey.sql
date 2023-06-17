CREATE TABLE HorseDonkey (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES BeastOfBurden(id)
);

INSERT INTO HorseDonkey (id)
SELECT id FROM Horse
UNION ALL
SELECT id FROM Donkey;
