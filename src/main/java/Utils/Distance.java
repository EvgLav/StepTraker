package Utils;

public class Distance {

    static double distance;
    static double coefficient = 0.00075;//1 шаг = 75см

    public  double resultDistance(int steps) {
        distance = steps * coefficient;
        return distance;
    }
}


