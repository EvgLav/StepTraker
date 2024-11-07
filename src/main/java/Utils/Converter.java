package Utils;

public class Converter {

    static double calories;
    static double coefficient = 0.05; //1 шаг = 50 калорий. 1 килокалория = 1000 калорий

    public double resultConverter(int steps) {
        calories = steps * coefficient;
        return calories;
    }
}
