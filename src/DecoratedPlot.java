public abstract class DecoratedPlot implements Drawable {
    public Drawable drawable;

    DecoratedPlot(Drawable drawable) {
        this.drawable = drawable;
    }
}
