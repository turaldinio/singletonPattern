import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scan = new Scanner(System.in);

        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");

        System.out.println("Введите размер списка:");
        int listSize = scan.nextInt();

        System.out.println("Введите верхнюю границу для значений:");
        int maxValue = scan.nextInt();

        logger.log("Создаём и наполняем список");
        List<Integer> list = new Random()
                .ints(listSize, 0, maxValue)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(("Вот случайный список " + list.toString()
                .replaceAll("[^0-9 ,]", "")));

        logger.log("Просим пользователя ввести входные данные для фильтрации");

        System.out.println("Введите порог для фильтра:");
        int threshold = scan.nextInt();

        logger.log("Запускаем фильтрацию");

        Filter filter = new Filter(threshold);
        List<Integer> result = filter.filterOut(list);

        logger.log(String.format(" Прошло фильтр %d элемента из %d", result.size(), listSize));
        logger.log("Выводим результат на экран");

        System.out.println("Отфильтрованный список: " + result.toString()
                .replaceAll("[^0-9 ,]", ""));

        logger.log("Завершаем программу");

    }
}
