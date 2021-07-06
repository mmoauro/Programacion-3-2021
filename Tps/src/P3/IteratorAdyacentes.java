package P3;

import java.util.Iterator;

public class IteratorAdyacentes<T> implements Iterator<Integer> {
    private Iterator<Arco<T>> itArcos;

    public IteratorAdyacentes (Iterator<Arco<T>> itArcos) {
        this.itArcos = itArcos;
    }

    @Override
    public boolean hasNext() {
        return this.itArcos.hasNext();
    }

    @Override
    public Integer next() {
        return this.itArcos.next().getVerticeDestino();
    }
}
