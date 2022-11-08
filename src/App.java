import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Main Frame of the application
 * Displays 3 panels of graphs - 1 basic and 2 decorated graphs
 * 4th panel has run button - clicking this will start the application loop
 * <p>
 * Pattern Used - Decorator - different PlotPanels are created using decorator pattern
 * Pattern Used - Observer - Each of the PlotPanels are observers of the data source
 */
public class App extends JFrame implements ActionListener {
    private final Source source;
    private Looper looper;

    /**
     * Initialization of the application
     * <p>
     *
     * @param title of the application
     */
    App(String title) {
        super(title);
        source = new Source();

        PlotPanel simplePanel = new PlotPanel(new SimplePlot());
        simplePanel.setBackground(Color.gray);
        PlotPanel markedSimplePanel = new PlotPanel(new MarkedPlot(new SimplePlot()));
        markedSimplePanel.setBackground(Color.lightGray);
        PlotPanel barMarkedSimplePanel = new PlotPanel(new BarPlot(new MarkedPlot(new SimplePlot())));
        source.addObserver(simplePanel);
        source.addObserver(markedSimplePanel);
        source.addObserver(barMarkedSimplePanel);
        add(barMarkedSimplePanel);
        add(markedSimplePanel);
        add(simplePanel);

        setSize(400, 800);
        setLayout(new GridLayout(4, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JButton runButton = new JButton("Run");
        runButton.addActionListener(this);
        add(runButton);

        setVisible(true);
    }

    /**
     * Main Driver method
     *
     * @param args standard main args
     */
    public static void main(String[] args) {
        new App("Simple Design Patterns");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (looper == null) {
            looper = new Looper();
            Thread t = new Thread(looper);
            t.start();
        } else {
            looper.stop();
            looper = null;
        }
    }

    /**
     * Looper class is used to run the random number generation loop
     * This will call the updateNumberList method every 200ms
     */
    class Looper implements Runnable {

        private final AtomicBoolean keepRunning;

        public Looper() {
            keepRunning = new AtomicBoolean(true);
        }

        public void stop() {
            keepRunning.set(false);
        }

        @Override
        public void run() {
            while (keepRunning.get()) {
                source.updateNumberList();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
