import datetime
import os

from sqlalchemy import func
from AnimalFactory import AnimalFactory
from Counter import Counter
from ZooDatabase import ZooDatabase

class ZooManagement:
    def __init__(self, db):
        self.registry = []
        self.db = db
        self.Animal = self.db.get_table("animal")

    def register_animal(self, animal):
        self.registry.append(animal)
        self.save_to_db(animal)

    def save_to_db(self, animal):
        session = self.db.create_session()
        db_animal = session.query(self.Animal).filter_by(name=animal.name).first()
        
        if db_animal is None:
            max_id = session.query(func.max(self.Animal.id)).scalar() or 0
            max_id += 1            
            db_animal = self.Animal(id=max_id, name=animal.name, commands=','.join(animal.commands), date_of_birth=animal.date_of_birth, type=animal.type)
            session.add(db_animal)
        else:
            db_animal.commands = ','.join(animal.commands)

        session.commit()

    def load_from_db(self):
        session = self.db.create_session()
        db_animals = session.query(self.Animal).all()
        for db_animal in db_animals:
            animal = AnimalFactory.create_animal(db_animal.type, db_animal.name, db_animal.commands.split(','), db_animal.date_of_birth)
            self.registry.append(animal)        

    def get_animals_by_type(self, animal_type):
        return [animal for animal in self.registry if animal.type == animal_type]

    def get_animal_commands(self, animal_name):
        for animal in self.registry:
            if animal.name == animal_name:
                return animal.commands
        return None

    def print_all_animals(self):
        for animal in self.registry:
            print(f"Имя: {animal.name}, тип: {animal.type}, команды: {', '.join(animal.commands)}, дата рождения: {animal.date_of_birth}")

    def teach_animal_command(self, animal_name, command):
        for animal in self.registry:
            if animal.name == animal_name:
                animal.commands.append(command)
                self.save_to_db(animal)

    def print_menu(self):
        print("1. Завести новое животное")
        print("2. Выдать список всех животных")
        print("3. Увидеть список команд, которое выполняет животное")
        print("4. Обучить животное новым командам")
        print("0. Выход")

    def main_loop(self):
        counter = Counter()

        while True:
            self.print_menu()
            choice = input("Выберите действие: ")
            if choice == "1":
                name = input("Введите имя животного: ")
                commands = input("Введите команды животного, разделенные запятой: ").split(',')
                date_of_birth = datetime.datetime.strptime(input("Введите дату рождения животного в формате YYYY-MM-DD: "), '%Y-%m-%d')
                animal_type = input("Введите тип животного: ")
                try:
                    animal = AnimalFactory.create_and_count_animal(counter, animal_type, name, commands, date_of_birth)
                    self.register_animal(animal)
                except ValueError as e:
                    print(e)
            elif choice == "2":
                self.print_all_animals()
            elif choice == "3":
                animal_name = input("Введите имя животного: ")
                commands = self.get_animal_commands(animal_name)
                if commands is not None:
                    print(commands)
                else:
                    print("Животное не найдено")
            elif choice == "4":
                animal_name = input("Введите имя животного: ")
                command = input("Введите команду: ")
                self.teach_animal_command(animal_name, command)
            elif choice == "0":
                break
        

if __name__ == "__main__":
    db = ZooDatabase(user=os.getenv("MYSQL_USER"), password=os.getenv("MYSQL_PASSWORD"), host="localhost", database="друзья_человека")
    db.prepare()
    registry = ZooManagement(db)
    registry.load_from_db()
    registry.main_loop()