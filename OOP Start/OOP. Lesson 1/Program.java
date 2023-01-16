import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Program
{
    public static void PrintProductInfo(Product product)
    {
        System.out.println(product);
    }

    public static void main(String[] args)
    {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("Яблоки", 2.5, 10, "кг"));
        products.add(new Product("Колбаса", 10, 3, "шт"));
        products.add(new Product("Кофе", 15.99, 2, "упаковки"));

        products.add(new FoodProduct("Хлеб", 2.5, 10, "шт", LocalDate.of(2023, 10, 1)));
        products.add(new FoodProduct("Молоко", 5.5, 2, "л", LocalDate.of(2022, 12, 15)));
        products.add(new FoodProduct("Сыр", 10, 5, "кг", LocalDate.of(2022, 11, 30)));

        products.add(new Beverage("Вода", 1.5, 12, "бутылки", LocalDate.of(2023, 10, 1), 0.5));
        products.add(new Beverage("Сок", 3.5, 6, "бутылки", LocalDate.of(2022, 12, 15), 1.5));
        products.add(new Beverage("Пиво", 5, 24, "банки", LocalDate.of(2022, 11, 30), 0.33));

        products.add(new Lemonade("Лимонад", 2.5, 10, "банки", LocalDate.of(2023, 10, 1), 0.5));
        products.add(new Lemonade("Лимонад с мятой", 3.5, 6, "бутылки", LocalDate.of(2022, 12, 15), 1));
        products.add(new Lemonade("Лимонад с клубникой", 5, 24, "бутылки", LocalDate.of(2022, 11, 30), 1.5));

        products.add(new Milk("Молоко", 2.5, 10, "бутылки", LocalDate.of(2023, 10, 1), 1, 3));
        products.add(new Milk("Молоко со злаками", 3.5, 6, "бутылки", LocalDate.of(2022, 12, 15), 0.5, 1));
        products.add(new Milk("Молоко обезжиренное", 5, 24, "бутылки", LocalDate.of(2022, 11, 30), 1, 0));        

        products.add(new Bread("Хлеб", 2.5, 10, "шт", LocalDate.of(2023, 10, 1), "Пшеничная"));
        products.add(new Bread("Батон", 3.5, 6, "шт", LocalDate.of(2022, 12, 15), "Ржаная"));
        products.add(new Bread("Лепешка", 5, 24, "шт", LocalDate.of(2022, 11, 30), "Овсяная"));

        products.add(new Eggs("Куриные яйца", 2.5, 10, "шт", LocalDate.of(2023, 10, 1), 6));
        products.add(new Eggs("Яйца индюков", 3.5, 6, "шт", LocalDate.of(2022, 12, 15), 12));
        products.add(new Eggs("Яйца уток", 5, 24, "шт", LocalDate.of(2022, 11, 30), 8));

        products.add(new HygieneProduct("Зубная паста", 4.5, 2, "шт", 3));
        products.add(new HygieneProduct("Шампунь", 8, 1, "шт", 1));
        products.add(new HygieneProduct("Туалетная бумага", 3, 12, "рулон", 6));

        products.add(new Diaper("Pampers", 0.25, 100, "шт", 4, "S", 2.2, 4, "Трусики"));
        products.add(new Diaper("Huggies", 0.35, 80, "шт", 3, "M", 3.6, 6.4, "Подгузник"));
        products.add(new Diaper("Luvs", 0.30, 90, "шт", 4, "L", 6.4, 15, "Подгузник"));

        products.add(new ToiletPaper("Эконом", 3.99, 12, "рулон", 12, 1));
        products.add(new ToiletPaper("Люкс", 6.99, 8, "рулон", 8, 2));
        products.add(new ToiletPaper("С ароматом", 5.49, 20, "рулон", 20, 3));
        
        products.add(new Mask("Маска одноразовая", 0.25, 100, "шт", 50));
        products.add(new Mask("Маска N95", 2.5, 10, "шт", 5));
        products.add(new Mask("Маска с двумя слоями", 1, 50, "шт", 25));

        products.add(new KidsProduct("Игрушка", 12.5, 5, "шт", 3, false));
        products.add(new KidsProduct("Краски", 5, 12, "шт", 5, true));
        products.add(new KidsProduct("Книга", 8, 3, "шт", 2, false));

        products.add(new Pacifier("Соска NUK", 5.5, 15, "шт", 0, true));
        products.add(new Pacifier("Соска MAM", 4, 12, "шт", 3, false));
        products.add(new Pacifier("Соска Philips Avent", 6, 10, "шт", 2, true));

        for (Product product : products)
        {
            PrintProductInfo(product);
        }
    }
}