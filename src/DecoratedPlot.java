public abstract class DecoratedPlot implements Drawable {
    Drawable drawable;

    DecoratedPlot(Drawable drawable) {
        this.drawable = drawable;
    }
}
