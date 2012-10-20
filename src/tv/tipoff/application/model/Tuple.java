package tv.tipoff.application.model;

public class Tuple<X, Y> {
	public final X x;
	public  Y y;

	public Tuple(X x, Y y) {
		this.x = x;
		this.y = y;
	}
}