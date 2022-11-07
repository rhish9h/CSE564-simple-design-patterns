import java.util.Observable;
import java.util.Observer;

public class PlotPanel implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Source source = (Source) o;
        System.out.println("In plot panel" + source.getNumberList());
    }
}
