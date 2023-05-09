package staticfactorymethod;

import java.util.HashMap;
import java.util.Map;

public class Day {
    // 요일을 담을 map 선언
    private static final Map<String, Day> days = new HashMap<>();

    // 미리 요일 데이터를 만들어 둠으로써 불필요한 객체 생성을 방지 할 수 있다.
    static {
        days.put("mon", new Day("Monday"));
        days.put("tue", new Day("Tuesday"));
        days.put("wed", new Day("Wednesday"));
        days.put("thu", new Day("Thursday"));
        days.put("fri", new Day("Friday"));
        days.put("sat", new Day("Saturday"));
        days.put("sun", new Day("Sunday"));
    }

    public static Day from(String day) {
        return days.get(day);
    }

    // 외부에서 들어오는 값 통제
    private final String day;

    private Day(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public static void main(String[] args) {
        // new 로 매번 객체를 생성하는 것을 방지해 줌
        Day day = Day.from("mon");
        System.out.println(day.getDay());
    }
}
