import java.awt.*;
import java.util.List;

public class SimplePlot implements Drawable {
    SimplePlot() {

    }

    @Override
    public void draw(Graphics g, List<Integer> numberList) {
        if (numberList == null || numberList.size() <= 1) {
            return;
        }
        System.out.println(numberList);
        g.drawLine(0, (170 - (15 * numberList.get(0))), 40, (170 - (15 * numberList.get(1))));

        for (int i = 1; i < numberList.size() - 1; i++) {
            g.drawLine(40 * (i), (170 - (15 * numberList.get(i))),
                    40 * (i + 1), (170 - (15 * numberList.get(i+1))));
        }
    }
}
