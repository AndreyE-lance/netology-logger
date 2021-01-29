import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int maxValue = 0;
        int listSize = 0;
        int filterInt = 0;
        Random rnd = new Random();
        List<Integer> list = new ArrayList<>();
        Logger logger = Logger.getInstance();
        logger.log("Программа запущена.");
        logger.log("Запрос данных у пользователя.");
        System.out.println("Введите размер списка:");
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            listSize = Integer.parseInt(bReader.readLine());
            System.out.println("Введите верхнюю границу для значений:");
            maxValue = Integer.parseInt(bReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.log("Создаем и заполняем список.");
        for (int i = 0; i < listSize; i++) {
            list.add(rnd.nextInt(maxValue));
        }
        logger.log("Вот случайный список " + list.toString());
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.println("Введите порог для фильтра:");
        try {
            filterInt = Integer.parseInt(bReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Запуск фильтрации");
        Filter filter = new Filter(filterInt);
        list = filter.filterOut(list);
        logger.log("Вот итоговый список " + list.toString());
        logger.log("Завершение работы программы.");
    }
}
