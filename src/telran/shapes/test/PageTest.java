package telran.shapes.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.shapes.*;
import telran.shapes.exceptions.NoCanvasException;
import telran.shapes.exceptions.ShapeAlreadyExistsException;
import telran.shapes.exceptions.ShapeNotFoundException;

class PageTest {
Shape shape1 = new Rectangle(1, 3, 4);
Shape shape2 = new Rectangle(2, 3, 4);
Shape shape3 = new Rectangle(3, 3, 4);
Shape shape4 = new Rectangle(4, 3, 4);
Shape shape5 = new Rectangle(5, 3, 4);
Shape shape6 = new Rectangle(6, 3, 4);
Shape shape7 = new Rectangle(7, 3, 4);
Canvas canvas1;
Canvas canvas2;
Canvas canvas3;
Canvas canvas4;
Canvas canvas5;
Long[] pathToCanvas1 = {55l, 44l, 33l, 22l, 11l};
Long[] pathToRectangle = {55l, 44l, 6l};
Long[] pathToNotFound = {55l, 44l, 33l, 22l, 11l, 100l};
Page page;
@BeforeEach
void setUp() {
	page = new Page();
	page.addShape(shape1);
	page.addShape(shape2);
	canvas1 = new Canvas(11);
	canvas1.addShape(shape3);
	canvas2 = new Canvas(22);
	canvas2.addShape(canvas1);
	canvas2.addShape(shape4);
	canvas3 = new Canvas(33);
	canvas3.addShape(canvas2);
	canvas3.addShape(shape5);
	canvas4 = new Canvas(44);
	canvas4.addShape(canvas3);
	canvas4.addShape(shape6);
	canvas5 = new Canvas(55);
	canvas5.addShape(shape1);
	canvas5.addShape(canvas4);
	page.addShape(canvas5);
}
	@Test
	void testAddShapeShape() {
		page.addShape(shape7);
		assertThrowsExactly(ShapeAlreadyExistsException.class,
				() ->page.addShape(shape7));
	}

	@Test
	void testAddShapeLongArrayShape() {
		page.addShape(pathToCanvas1, shape7);
		assertThrowsExactly(ShapeAlreadyExistsException.class,
				() -> page.addShape(pathToCanvas1, shape7));
		assertThrowsExactly(NoCanvasException.class,
				()-> page.addShape(pathToRectangle, shape7));
		assertThrowsExactly(ShapeNotFoundException.class,
				()-> page.addShape(pathToNotFound, shape7) );
	}

	@Test
	void testRemoveShapeLong() {
		page.removeShape(1);
		assertThrowsExactly(ShapeNotFoundException.class,
				()-> page.removeShape(1) );
		
	}

	@Test
	void testRemoveShapeLongArrayLong() {
		page.removeShape(pathToCanvas1, 3);
		assertThrowsExactly(ShapeNotFoundException.class,
				() -> page.removeShape(pathToCanvas1, 3));
		assertThrowsExactly(NoCanvasException.class,
				()-> page.removeShape(pathToRectangle, 7));
		
	}

	@Test
	void testIterator() {
		Shape[] shapesExpected = {shape1, shape2, canvas5};
		int index = 0;
		Iterator<Shape> it = page.iterator();
		while(it.hasNext()) {
			assertEquals(shapesExpected[index++], it.next());
		}
		assertEquals(index, shapesExpected.length);
		assertThrowsExactly(NoSuchElementException.class, it::next);
	}

}