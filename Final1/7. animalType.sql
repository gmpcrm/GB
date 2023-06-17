ALTER TABLE Animal 
ADD COLUMN type VARCHAR(255);

UPDATE Animal
SET type = 'Dog'
WHERE id IN (SELECT id FROM Dog);

UPDATE Animal
SET type = 'Cat'
WHERE id IN (SELECT id FROM Cat);

UPDATE Animal
SET type = 'Hamster'
WHERE id IN (SELECT id FROM Hamster);

UPDATE Animal
SET type = 'Horse'
WHERE id IN (SELECT id FROM Horse);

UPDATE Animal
SET type = 'Donkey'
WHERE id IN (SELECT id FROM Donkey);
