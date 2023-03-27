public class Main {
    public static void main(String[] args) {
        ToyStorage toyStorage = new ToyStorage();
    
        // Массив игрушек
        Toy[] toysArray = {
            new Toy(1, "Toy Car", 10, 20.0),
            new Toy(2, "Toy Robot", 5, 30.0),
            new Toy(3, "Doll", 15, 50.0),
            new Toy(4, "Stuffed Animal", 20, 15.0),
            new Toy(5, "Puzzle", 12, 25.0),
            new Toy(6, "Action Figure", 8, 35.0),
            new Toy(7, "Board Game", 5, 40.0),
            new Toy(8, "Building Blocks", 18, 22.0),
            new Toy(9, "Play Kitchen", 3, 60.0),
            new Toy(10, "Trampoline", 2, 100.0),
            new Toy(11, "Bicycle", 4, 80.0),
            new Toy(12, "Scooter", 6, 45.0),
            new Toy(13, "Roller Skates", 7, 35.0),
            new Toy(14, "Musical Instrument", 9, 28.0),
            new Toy(15, "Remote Control Car", 11, 30.0),
            new Toy(16, "Art Supplies", 14, 20.0),
            new Toy(17, "Fidget Spinner", 16, 10.0),
            new Toy(18, "Yo-Yo", 13, 12.0),
            new Toy(19, "Bouncy Ball", 17, 5.0),
            new Toy(20, "Water Gun", 7, 15.0)
        };
    
        // Добавляем игрушки в хранилище
        for (Toy toy : toysArray) {
            toyStorage.addToy(toy);
        }
    
        // Создаем объект ToyRaffle, передавая список игрушек из хранилища
        ToyRaffle toyRaffle = new ToyRaffle(toyStorage.getToys());
    
        // Выбираем случайную игрушку и записываем ее в файл
        for (int i = 0; i < 10; i++) {
            Toy randomToy = toyRaffle.getRandomToy();
            if (randomToy != null && randomToy.getQuantity() > 0) {
                System.out.println("Выиграна игрушка: " + randomToy.getName());
                randomToy.setQuantity(randomToy.getQuantity() - 1);
                // если количество игрушек равно 0, удаляем игрушку из хранилища
                if (randomToy.getQuantity() == 0) {
                    toyStorage.removeToy(randomToy);
                }
                // записываем имя игрушки в файл
                FileHandler.writeToFile("winning_toys.txt", randomToy.getName());
            } else {
                System.out.println("Игрушка не найдена или закончилась");
            }
        }
    }        
}
