from Animals import Dog, Cat, Hamster, Camel, Horse, Donkey

class AnimalFactory:
    animal_classes = {
        "Dog": Dog,
        "Cat": Cat,
        "Hamster": Hamster,
        "Camel": Camel,
        "Horse": Horse,
        "Donkey": Donkey
    }

    @classmethod
    def create_animal(cls, animal_type, name, commands, date_of_birth):
        if None in [animal_type, name, commands, date_of_birth]:
            raise ValueError("All animal fields must be filled.")
        if animal_type in cls.animal_classes:
            return cls.animal_classes[animal_type](name, commands, date_of_birth)
        else:
            raise ValueError(f"Неизвестное животное: {animal_type}")
            
    @classmethod
    def create_and_count_animal(cls, counter, animal_type, name, commands, date_of_birth):
        with counter:
            animal = cls.create_animal(animal_type, name, commands, date_of_birth)
            counter.add()
        return animal
