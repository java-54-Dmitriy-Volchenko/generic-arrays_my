package telran.shapes;

public abstract class  Shape {
	protected long id;
	public abstract int square();
	public abstract int perimeter();
	public Shape(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
	
	
}