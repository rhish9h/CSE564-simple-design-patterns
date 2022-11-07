import java.awt.*;
import java.util.List;

public class BarPlot extends DecoratedPlot {
    BarPlot(Drawable drawable) {
        super(drawable);
    }

    @Override
    public void draw(Graphics g, List<Integer> numberList) {
        drawable.draw(g, numberList);
        g.setColor(Color.GRAY);
        for (int k = 1; k < numberList.size(); k++) {
            g.fillRect(40 * k - 3,
                    (170 - (3 * numberList.get(k) / 4)) + 3, 6,
                    (3 * numberList.get(k) / 4) - 6 + 30);
        }
    }
}
