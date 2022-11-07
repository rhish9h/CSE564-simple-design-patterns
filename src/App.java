import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener {
    private Source source;

    App(String title) {
        super(title);
        source = new Source();
        PlotPanel panel = new PlotPanel();
        source.addObserver(panel);
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
        source.updateNumberList();
    }
}
