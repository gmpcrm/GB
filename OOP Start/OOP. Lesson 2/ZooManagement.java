class ZooManagement {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        while(true) {
            System.out.println("1. Добавить животное в зоопарк");
            System.out.println("2. Удалить животное из зоопарка");
            System.out.println("3. Просмотреть информацию о конкретном животном");
            System.out.println("4. Заставить конкретное животное издать звук");
            System.out.println("5. Просмотреть информацию о всех животных в зоопарке");
            System.out.println("6. Заставить всех животных в зоопарке издать звук");
            System.out.println("7. Создать новый зоопарк");
            System.out.println("8. Выйти");

            int choice = InputScanner.getInt(null);
            switch(choice) {
                case 1:
                    while(true){
                        System.out.print("Доступные животные: ");
                        System.out.println(AnimalFactory.getAvailableAnimals());
                        String kind = InputScanner.getString("Введите вид животного: ");
                        Animal animal = AnimalFactory.createAnimal(kind);
                        if (animal == null) {
                            System.out.println("Животное вида " + kind + " не найдено.");
                        }
                        else {
                            zoo.insertAnimal(0, animal);
                            break;
                        }
    
                    }
                    break;
                case 2:
                    zoo.removeAnimal(InputScanner.getInt("Введите номер животного в зоопарке: "));
                    break;
                case 3:
                    zoo.printAnimal(InputScanner.getInt("Введите номер животного в зоопарке: "));
                    break;
                case 4:
                    zoo.makeAnimalSound(InputScanner.getInt("Введите номер животного в зоопарке: "));
                    break;
                case 5:
                    zoo.printAnimals();
                    break;
                case 6:
                    zoo.makeAnimalsSound();
                    break;
                case 7:
                    zoo.makeNewZoo();
                    zoo.printAnimals();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Некорректный ввод, попробуйте снова");
                    break;
            }
        }
    }
}
