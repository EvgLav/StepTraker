
public final class Menu {

    String menu = """
                    ------------Меню----------
                    1 - Ввести кол-во шагов 
                    2 - Вывести статистику 
                    3 - Изменить цель по кол-ву шагов за день
                    4 - Выйти из приложения
                    """;

    String staticticsMenu = """
            ----------Меню статистики------------
            1 - Шаги за месяц
            2 - Шаги по дням за месяц
            3 - Максимально пройдено шагов 
            4 - Среднее кол-во шагов
            5 - Дистанция за месяц
            6 - Потраченные калории
            7 - Лучшая серия
            8 - вернуться в главное меню
            """;

    public Menu() {
    }

    protected void printMenu() {
        System.out.println(menu);
    }

    protected void printStaticticsMenu() {
        System.out.println(staticticsMenu);
    }
}



