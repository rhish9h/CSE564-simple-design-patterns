import java.util.Observable;
import java.util.Observer;

public class PlotPanel implements Observer {
    PlotType plotType;
    Drawable plot;

    public PlotPanel(PlotType plotType) {
        this.plotType = plotType;
        switch (plotType) {
            case SIMPLE -> {
                plot = new SimplePlot();
            }
            case MARKED_SIMPLE -> {
                plot = new MarkedPlot(new SimplePlot());
            }
            case BAR_MARKED_SIMPLE -> {
                plot = new BarPlot(new MarkedPlot(new SimplePlot()));
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        Source source = (Source) o;
        double average = Evaluator.getInstance().getAverageOf(source.getNumberList());
    }
}
