import java.awt.*;
import java.util.List;

public class MarkedPlot extends DecoratedPlot {
    MarkedPlot(Drawable drawable) {
        super(drawable);
    }

    @Override
    public void draw(Graphics g, List<Integer> numberList) {
        drawable.draw(g, numberList);
        g.setColor(Color.BLUE);
        for (int j = 1; j < numberList.size(); j++) {
            g.fillRect(40 * j - 2,
                    (170 - (15 * numberList.get(j))) - 2,
                    4, 4);
        }
    }
}
