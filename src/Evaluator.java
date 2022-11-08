import java.util.List;

/**
 * Singleton Evaluator class to calculate average of all points in graph
 * Contains instance that will only be created once in the entire application
 * <p>
 * Pattern Used - Singleton
 */
public class Evaluator {
    private static Evaluator _instance;

    private Evaluator() {
    }

    /**
     * Create new instance if it does not exist and return it
     *
     * @return Evaluator instance
     */
    public static Evaluator getInstance() {
        if (_instance == null) {
            _instance = new Evaluator();
        }
        return _instance;
    }

    /**
     * Calculate the average of all numbers
     *
     * @param numberList the y co-ordinates of the graph
     * @return int average
     */
    public int getAverageOf(List<Integer> numberList) {
        int sum = 0;
        int size = numberList.size();

        for (int num : numberList) {
            sum += num;
        }

        return sum / size;
    }
}
