package ru.zvezdilin;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    private int f;

    public Filter(int f) {
        this.f = f;
    }

    public List<Integer> filterOut(List<Integer> list) {
        Logger logger = Logger.getLogger();
        List<Integer> listFilter = new ArrayList<>();
        logger.logInfo("Запускаем фильтрацию");
        for (Integer integer : list) {
            if (integer < f) {
                logger.logInfo("Элемент " + integer + " проходит");
                listFilter.add(integer);
            } else {
                logger.logInfo("Элемент " + integer + " не проходит");
            }
        }
        return listFilter;
    }

    public void showList(List<Integer> list) {
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}

