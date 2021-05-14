package P1;

public class Pila {
    private LinkedList list;

    public Pila () {
        this.list = new LinkedList();
    }

    public void push (Integer info) {
        this.list.insertFront(info);
    }

    public Integer pop () {
        return list.extractFront();
    }

    public Integer top () {
        return this.list.getFirst() != null ? this.list.getFirst().getInfo() : null;
    }

    public void reverse () {
        LinkedList aux = new LinkedList();
        while (!this.list.isEmpty())
            aux.insertFront(this.pop());
        this.list = aux;
    }
}
