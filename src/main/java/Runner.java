import Utils.Distance;
import Utils.Target;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        Menu menu = new Menu();
        StapTraker traker = new StapTraker();
        Target target = new Target();
        Scanner scanner = new Scanner(System.in);
        int choose;

        do {

            menu.printMenu();
            System.out.println(target);
            choose = Integer.parseInt(scanner.nextLine());


            if (choose == 1) {
                ////КОД ДЛЯ 1
                System.out.println("Введите название месяца");
                String mount = scanner.nextLine();
                System.out.println("Введите день месяца");
                int day = scanner.nextInt();
                System.out.println("Введите кол-во шагов: ");
                int steps = scanner.nextInt();
                scanner.nextLine();
                traker.addSteps(mount, day, steps);
            }

            if (choose == 2) {
                //КОД ДЛЯ 2
                menu.printStaticticsMenu();
                int choose2 = Integer.parseInt(scanner.nextLine());

                if (choose2 == 1) {
                    System.out.println("Введите месяц");
                    String monthForSum = scanner.nextLine();
                    traker.summSteps(monthForSum);
                }
                if (choose2 == 2) {
                    System.out.println("Введите месяц");
                    String monthForSumSteps = scanner.nextLine();
                    traker.printStepsForMonth(monthForSumSteps);
                }
                if (choose2 == 3) {
                    System.out.println("Введите месяц");
                    String monthForMaxSteps = scanner.nextLine();
                    traker.maxSteps(monthForMaxSteps);
                }
                if (choose2 == 4) {
                    System.out.println("Введите месяц");
                    String monthAverageSteps = scanner.nextLine();
                    traker.averageSteps(monthAverageSteps);
                }
                if (choose2 == 5) {
                    System.out.println("Введите месяц");
                    String monthDistance = scanner.nextLine();
                    traker.getDistanse(monthDistance);
                }

                if (choose2 == 6) {
                    System.out.println("Введите месяц");
                    String monthCalories = scanner.nextLine();
                    traker.getCalories(monthCalories);
                }

                if (choose2 == 7) {
                    System.out.println("Введите месяц");
                    String monthSeries = scanner.nextLine();
                    traker.seriesSteps(monthSeries);
                }
            }
            if (choose == 3) {
                //////КОД ДЛЯ 3
                System.out.println("Введите новую цель за день");
                int newTarget = Integer.parseInt(scanner.nextLine());
                traker.setNewTarget(newTarget);
            }
        }

        while (choose != 4);
        scanner.close();
        System.out.println("Выход выполнен");
    }
}







