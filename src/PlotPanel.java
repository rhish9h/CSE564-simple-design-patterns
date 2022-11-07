import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class PlotPanel extends JPanel implements Observer {
    private Drawable plot;
    private List<Integer> numberList;
    private int average;

    public PlotPanel(PlotType plotType) {
        Source source = new Source();
        numberList = source.getNumberList();

        switch (plotType) {
            case SIMPLE -> {
                setBackground(Color.gray);
                plot = new SimplePlot();
            }
            case MARKED_SIMPLE -> {
                setBackground(Color.lightGray);
                plot = new MarkedPlot(new SimplePlot());
            }
            case BAR_MARKED_SIMPLE -> plot = new BarPlot(new MarkedPlot(new SimplePlot()));
        }

        setVisible(true);
    }

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

    @Override
    public void update(Observable o, Object arg) {
        Source source = (Source) o;
        numberList = source.getNumberList();
        average = Evaluator.getInstance().getAverageOf(source.getNumberList());
        repaint();
    }
}
