public class MarkedPlot extends DecoratedPlot {
    MarkedPlot(Drawable drawable) {
        super(drawable);
    }

    @Override
    public void draw() {
        drawable.draw();
    }
}
