import java.util.Observable;
import java.util.Observer;

public class PlotPanel implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Source source = (Source) o;
        double average = Evaluator.getInstance().getAverageOf(source.getNumberList());
//        System.out.println("In plot panel" + source.getNumberList() + " : average: " + average);
    }
}
