public class BarPlot extends DecoratedPlot {
    BarPlot(Drawable drawable) {
        super(drawable);
        System.out.println("Bar plot drawn");
    }

    @Override
    public void draw() {
        drawable.draw();
    }
}
