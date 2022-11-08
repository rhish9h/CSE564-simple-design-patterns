/**
 * Abstract class used to decorate Drawable
 * <p>
 * Pattern Used - Decorator - Decorator class of which objects will be made
 * to decorate basic Drawables
 */
public abstract class DecoratedPlot implements Drawable {
    protected Drawable drawable;

    DecoratedPlot(Drawable drawable) {
        this.drawable = drawable;
    }
}
