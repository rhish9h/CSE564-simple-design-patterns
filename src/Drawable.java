import java.awt.*;
import java.util.List;

/**
 * Drawable interface used by the family of Drawables - all different plots
 * <p>
 * Pattern Used - Decorator - Top most interface in this pattern
 */
public interface Drawable {
    /**
     * Draw the plot using the numberList to the graphics object
     *
     * @param g          graphics object passed by parent
     * @param numberList that is used to display the graph
     */
    void draw(Graphics g, List<Integer> numberList);
}
