DELETE FROM Camel;

DELETE FROM BeastOfBurden 
WHERE id NOT IN (SELECT id FROM Horse) AND id NOT IN (SELECT id FROM Donkey);

DELETE FROM Animal 
WHERE id NOT IN (SELECT id FROM BeastOfBurden) AND id NOT IN (SELECT id FROM DomesticAnimal);
