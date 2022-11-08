import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * This class holds the data required to be displayed and its related operations
 * <p>
 * Pattern Used - Observer - this is being observed by other panels
 */
public class Source extends Observable {
    private final List<Integer> numberList;

    public Source() {
        numberList = new ArrayList<>();
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    /**
     * Generates a random number, adds to the list, removes first number
     * Notifies all the observers once updated
     */
    public void updateNumberList() {
        int MIN = 1;
        int MAX = 200;
        int range = MAX - MIN + 1;
        if (numberList.size() == 11) {
            numberList.remove(0);
        }
        int rand = (int) (Math.random() * range) + MIN;
        numberList.add(rand);
        setChanged();
        notifyObservers();
    }
}
