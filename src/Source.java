import java.util.ArrayList;
import java.util.List;

public class Source {
    private final int MIN = 1;
    private final int MAX = 10;
    private List<Integer> numberList;

    public Source() {
        numberList = new ArrayList<>();
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public void updateNumberList() {
        int range = MAX - MIN + 1;
        if (numberList.size() == 10) {
            numberList.remove(0);
        }
        int rand = (int)(Math.random() * range) + MIN;
        numberList.add(rand);
    }
}
