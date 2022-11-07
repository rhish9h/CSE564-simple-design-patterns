import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicBoolean;

public class App extends JFrame implements ActionListener {
    private Source source;
    private Looper looper;

    App(String title) {
        super(title);
        source = new Source();

        PlotPanel simplePanel = new PlotPanel(PlotType.SIMPLE);
        PlotPanel markedSimplePanel = new PlotPanel(PlotType.MARKED_SIMPLE);
        PlotPanel barMarkedSimplePanel = new PlotPanel(PlotType.BAR_MARKED_SIMPLE);
        source.addObserver(simplePanel);
        source.addObserver(markedSimplePanel);
        source.addObserver(barMarkedSimplePanel);
        add(barMarkedSimplePanel);
        add(markedSimplePanel);
        add(simplePanel);

        setSize(400, 800);
        setLayout(new GridLayout(4,1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JButton runButton = new JButton("Run");
        runButton.addActionListener(this);
        add(runButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        App app = new App("Simple Design Patterns");
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

    class Looper implements Runnable {

        private AtomicBoolean keepRunning;

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
