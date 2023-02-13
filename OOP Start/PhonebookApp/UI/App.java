package PhonebookApp.UI;

import java.util.Scanner;

import PhonebookApp.Config;
import PhonebookApp.Core.MVP.Presenter;
import PhonebookApp.Core.MVP.View;

public class App {
    public static void Run() {
        System.out.print("\033[H\033[J");// ru.stackoverflow.com/questions/1315049/Как-очистить-консоль-в-java-во-время-действия-программы
        View view = new ConsoleView();
        Presenter presenter = new Presenter(view, Config.pathDb);
        presenter.loadFromFile();

        try (Scanner in = new Scanner(System.in)) {

            while (true) {
                System.out.println("0 add, 1 prev, 2 next, 3 save, 4 load, 5 remove, 6 export, 7 import, 8 search, 9 exit");
                String key = in.next();
                System.out.print("\033[H\033[J");
                switch (key) {
                    case "0":
                        presenter.add();
                        break;
                    case "1":
                        presenter.prev();
                        break;
                    case "2":
                        presenter.next();
                        break;
                    case "3":
                        presenter.saveToFile();
                        break;
                    case "4":
                        presenter.loadFromFile();
                        break;
                    case "5":
                        presenter.remove();
                        break;
                    case "6":
                        presenter.exportData();
                        break;
                    case "7":
                        presenter.importData();
                        break;
                    case "9":
                        return;
                    default:
                        System.out.println("No such command");
                        break;
                }
            }
        }

    }
}
