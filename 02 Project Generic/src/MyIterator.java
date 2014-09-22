import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyIterator implements Iterator<Object> {
	private int index;
	private List<Object> cl;
	
	public MyIterator(List<Object> cl) {
        this.cl = cl;
        index = 0;
    }

	@Override
	public boolean hasNext() {
		return !(cl.listSize() == index);
		
	}

	@Override
	public Object next() {
		if(hasNext()) {
			index++;
            return cl; //return cl.get(index++);
            		
        } else {
            throw new NoSuchElementException("There are no elements size = ");
        }
    }

	@Override
	public void remove() {
		if(index <= 0) {
            throw new IllegalStateException("You can't delete element before first next() method call");
        }
       // cl.delete(--index);
	}
}
