import Utils.Converter;
import Utils.Distance;
import Utils.Target;

import java.util.*;



public class StapTraker {

    public Map<String, int[]> stepsMap;//хранит шаги по месяцам

    public DaysInMonth daysInMonth;

    Distance distance = new Distance();

    Converter converter = new Converter();

    Target target = new Target();


    public StapTraker() {
        stepsMap = new HashMap<>();
        daysInMonth = new DaysInMonth();

        for (Object month : daysInMonth.daysInMonths.keySet()) {
            stepsMap.put(String.valueOf(month), new int[daysInMonth.getDaysInMonth(String.valueOf(month))]);
        }
    }

    //Добавление шагов
    public void addSteps(String month, int day, Integer steps) {
        month = month.toLowerCase();
        if (daysInMonth.daysInMonths.containsKey(month)) {
            int maxDay = daysInMonth.getDaysInMonth(month);
            if (day >= 1 && day <= maxDay) {
                stepsMap.get(month)[day - 1] = steps;
                System.out.println("шаги добавлены: " + steps + " шагов за "
                        + day + " число в месяце " + month);
            } else {
                System.out.println("Нет такой даты, в месяце " + month + " только "
                        + maxDay + " дней");
            }
        } else {
            System.out.println("Неверное название месяца\n");
        }
    }

    //Выводит шаги за месяц по дням
    public void printStepsForMonth(String month) {
        month = month.toLowerCase();

        if (daysInMonth.daysInMonths.containsKey(month)) {
            int[] stepsForMounth = stepsMap.get(month);
            System.out.println("Шаги за месяц " + month + ": ");
            for (int i = 0; i < stepsForMounth.length; i++) {
                System.out.println("День " + (i + 1) + ": " + stepsForMounth[i]
                        + " шагов");
            }
        } else {
            System.out.println("некорректное название месяца\n");
        }
    }

    //Сумма шагов за месяц
    public void summSteps(String month) {
        month = month.toLowerCase();
        if (daysInMonth.daysInMonths.containsKey(month)) {
            int sum = Arrays.stream(stepsMap.get(month)).sum();

            System.out.println("Сумма шагов за месяц " + month + " сост. " + sum + " шагов\n");
        } else {
            System.out.println("некорректное название месяца\n");
        }
    }

    //Максимальное пройденное кол-во шагов за месяц
    public void maxSteps(String month) {
        month = month.toLowerCase();
        if (daysInMonth.daysInMonths.containsKey(month)) {
            int maxDay = Arrays.stream(stepsMap.get(month)).max().getAsInt();
            System.out.println(maxDay);
        } else {
            System.out.println("некорректное название месяца\n");
        }
    }

    //Среднее кол-во за месяц
    public void averageSteps(String month) {
        month = month.toLowerCase();
        if (daysInMonth.daysInMonths.containsKey(month)) {
            int sum = Arrays.stream(stepsMap.get(month)).sum();//получаем сумму шагов за месяц
            int[] day = stepsMap.get(month); // получаем массив по ключу
            // Так как массив имеет тип Integer, то используем стрим. Выбираем эл-ты не содержащие "0"
            // и считаем их
            int count = (int) Arrays.stream(day).filter(x -> x != 0).count();
            if (count == 0) {
                System.out.println("В " + month + " не занесено информации о шагах\n");
            } else {
                int average = sum / count;
                System.out.println("Среднее значение: " + average + " шагов за " + month + "\n");
            }
        } else {
            System.out.println("некорректное название месяца\n");
        }
    }

    //Расчет дистанции за месяц
    public void getDistanse(String month) {
        //Distance distance = new Distance();
        int sum = Arrays.stream(stepsMap.get(month)).sum();
        double result = distance.resultDistance(sum);
        System.out.println("Пройденная дистанция за " + month + " сост. " + result + "км\n");
    }

    //Расчет калорий за месяц
    public void getCalories(String month) {
        //Converter converter = new Converter();
        int sum = Arrays.stream(stepsMap.get(month)).sum();
        double result = converter.resultConverter(sum);
        System.out.println("Потрачено калорий за " + month + " " + result + "ккал\n");
    }

    //Лучшая серия по шагам
    //Максимальное количество дней подряд, когда шагов было больше целевого значения
    public void seriesSteps(String month) {
        if (daysInMonth.daysInMonths.containsKey(month)) {
            int[] steps = stepsMap.get(month);
            int count = target.getTargetSteps();
            int values = 0;
            for (int i = 0; i < steps.length; i++) {
                if (steps[i] > count) {
                    values += 1;
                } else {
                    continue;
                }
            }
            System.out.println("Наибольшее кол-во дней подряд, выше целевого: " + values + "\n"
                    + "Цель: " + count + " шагов\n");
        }
    }

    //Изменение цели по шагам
    public void setNewTarget (int meaning) {
        target.changeTarget(meaning);
        System.out.println("Дневная цель изменена на " + meaning + " шагов\n");
    }
}










