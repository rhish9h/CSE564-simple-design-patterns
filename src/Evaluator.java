import java.util.List;

public class Evaluator {
    private static Evaluator _instance;

    private Evaluator() {}

    public static Evaluator getInstance() {
        if (_instance == null) {
            _instance = new Evaluator();
        }
        return _instance;
    }

    public int getAverageOf(List<Integer> numberList) {
        int sum = 0;
        int size = numberList.size();

        for (int num : numberList) {
            sum += num;
        }

        return sum / size;
    }
}
