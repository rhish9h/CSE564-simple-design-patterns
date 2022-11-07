import java.awt.*;
import java.util.List;

public class BarPlot extends DecoratedPlot {
    BarPlot(Drawable drawable) {
        super(drawable);
        System.out.println("Bar plot drawn");
    }

    @Override
    public void draw(Graphics g, List<Integer> numberList) {
        drawable.draw(g, numberList);
    }
}
