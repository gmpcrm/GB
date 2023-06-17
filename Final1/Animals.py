from datetime import datetime

class Animal:
    def __init__(self, name, commands, date_of_birth):
        self.__name = name
        self.__commands = commands
        self.__date_of_birth = date_of_birth
        self.__type = "Animal"

    @property
    def name(self):
        return self.__name

    @name.setter
    def name(self, name):
        self.__name = name

    @property
    def commands(self):
        return self.__commands

    @commands.setter
    def commands(self, commands):
        self.__commands = commands

    @property
    def date_of_birth(self):
        return self.__date_of_birth

    @date_of_birth.setter
    def date_of_birth(self, date_of_birth):
        self.__date_of_birth = date_of_birth

    @property
    def type(self):
        return self.__type

    @property
    def age(self):
        return datetime.now().year - self.__date_of_birth.year


class DomesticAnimal(Animal):
    @property
    def type(self):
        return "DomesticAnimal"


class BeastOfBurden(Animal):
    @property
    def type(self):
        return "BeastOfBurden"


class Horse(BeastOfBurden):
    @property
    def type(self):
        return "Horse"


class Donkey(BeastOfBurden):
    @property
    def type(self):
        return "Donkey"


class Camel(BeastOfBurden):
    @property
    def type(self):
        return "Camel"


class Dog(DomesticAnimal):
    @property
    def type(self):
        return "Dog"


class Cat(DomesticAnimal):
    @property
    def type(self):
        return "Cat"


class Hamster(DomesticAnimal):
    @property
    def type(self):
        return "Hamster"
