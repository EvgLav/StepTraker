import java.util.HashMap;
import java.util.Map;

public class DaysInMonth {
    protected static final Map<String, Integer> daysInMonths = new HashMap<>();

    static {
        daysInMonths.put("январь", 31);
        daysInMonths.put("февраль", 28);
        daysInMonths.put("март", 31);
        daysInMonths.put("апрель", 30);
        daysInMonths.put("май", 31);
        daysInMonths.put("июнь", 30);
        daysInMonths.put("июль", 31);
        daysInMonths.put("август", 31);
        daysInMonths.put("сентябрь", 30);
        daysInMonths.put("октябрь", 31);
        daysInMonths.put("ноябрь", 30);
        daysInMonths.put("декабрь", 31);
    }
    public boolean isValidMounth (String month) { //метод для проверки, есть ли такой месяц
        month.toLowerCase();
        return daysInMonths.containsKey(month);
    }

    public int getDaysInMonth (String month) {
        month = month.toLowerCase();
        return daysInMonths.getOrDefault(month, 0);
    }



}
