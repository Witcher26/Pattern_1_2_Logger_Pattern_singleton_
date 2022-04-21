import ru.zvezdilin.Filter;
import ru.zvezdilin.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int listSize, maxNumbers, filterValue;

    public static int getFilterNumber() {
        return filterValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getLogger();

        logger.logInfo("Start programme");
        logger.logInfo("Запрос трёх значений от пользователя");
        System.out.println("Введите через пробел три целых числа для обозначения размера списка, максимального значения и фильтра: ");

        int[] mas = new int[3];
        for (int i = 0; i < 3; i++) {
            if (scanner.hasNextInt()) {
                mas[i] = scanner.nextInt();
            }
        }

        listSize = mas[0];
        maxNumbers = mas[1];
        filterValue = mas[2];

        Filter filter = new Filter(getFilterNumber());

        List<Integer> arraylist = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            arraylist.add(new Random().nextInt(maxNumbers));
        }

        logger.logInfo("Введёные числа: ");
        System.out.println(listSize + ", " + maxNumbers + ", " + filterValue);

        logger.logInfo("Создаём и наполняем список");
        System.out.print("Рандомные значения в диапозоне 0 - " + maxNumbers + ": ");
        for (Integer integer : arraylist) {
            System.out.print(integer + ", ");
        }
        System.out.println();

        List tmp = filter.filterOut(arraylist);

        logger.logInfo("Выводим результат на экран");
        System.out.println("Фильтр по значению " + getFilterNumber());
        filter.showList(tmp);

        logger.logInfo("Завершение программы");
    }
}
