package P1;
import P1.Node;

import java.util.Iterator;

public class MyIterator implements Iterator<Integer> {
	private Node cursor;
	private Node prev;

	public MyIterator (Node cursor) {
		this.cursor = cursor;
	}

	@Override
	public boolean hasNext() {
		return this.cursor != null;
	}

	@Override
	public Integer next() {
		Node retorno = this.cursor;
		this.prev = this.cursor;
		this.cursor = this.cursor.getNext();
		return retorno.getInfo();
	}

	public void setPrevAsCursor () {
		this.cursor = prev;
	}
}
