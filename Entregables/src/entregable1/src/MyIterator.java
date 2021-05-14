package entregable1.src;

import java.util.Iterator;

public class MyIterator implements Iterator<Integer> {
    private Node cursor;

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
        this.cursor = this.cursor.getNext();
        return retorno.getInfo();
    }

    public Integer getNext () { // Retorna la informacion del cursor, sin pasar al proximo nodo.
        return this.cursor.getInfo();
    }
}
