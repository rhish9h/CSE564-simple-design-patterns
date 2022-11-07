import java.awt.*;
import java.util.List;

public class MarkedPlot extends DecoratedPlot {
    MarkedPlot(Drawable drawable) {
        super(drawable);
    }

    @Override
    public void draw(Graphics g, List<Integer> numberList) {
        drawable.draw(g, numberList);
    }
}
