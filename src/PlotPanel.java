import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Panel where graphs will be plotted depending on the plot passed
 * <p>
 * Pattern Used - Observer - this observes the data source
 * Pattern Used - Singleton - uses the Evaluator to get average
 */
public class PlotPanel extends JPanel implements Observer {
    private final Drawable plot;
    private List<Integer> numberList;
    private int average;

    public PlotPanel(Drawable plot) {
        Source source = new Source();
        numberList = source.getNumberList();
        this.plot = plot;
        setVisible(true);
    }

    /**
     * Displays the plot that was passed during creating
     * Displays the average line once it is computed
     *
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        plot.draw(g, numberList);

        if (numberList.size() >= 2) {
            g.setColor(Color.red);
            int y = 170 - 3 * average / 4;
            g.drawLine(0, y, 400, y);
        }
    }

    /**
     * Updates the plot and average based on the new source
     * Average is received from the single Evaluator
     *
     * @param o   the observable object.
     * @param arg an argument passed to the {@code notifyObservers}
     *            method.
     */
    @Override
    public void update(Observable o, Object arg) {
        Source source = (Source) o;
        numberList = source.getNumberList();
        average = Evaluator.getInstance().getAverageOf(source.getNumberList());
        repaint();
    }
}
