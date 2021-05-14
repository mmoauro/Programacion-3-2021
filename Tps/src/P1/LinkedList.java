package P1;
import java.util.Iterator;

public class LinkedList implements Iterable<Integer> {
    private Node first;
    private int size;
    private Node last; // Puntero al ultimo nodo, para que el insertLast() sea O(1) y no O(N).

    public LinkedList() {
        this.size = 0;
    }

    public void insertFront (Integer info) {
        Node n = new Node(info);
        if (this.size == 0)
            this.last = n;
        n.setNext(this.first);
        this.first = n;
        this.size++;
    }

    public void insertLast (Integer info) {
        Node temp = new Node(info);
        if (this.size > 0) {
            this.last.setNext(temp);
            this.last = temp;
            this.size++;
        }
        else {
            this.insertFront(info);
        }
    }

    public Integer extractFront () {
        if (this.size > 0) {
            this.size--;
            Integer info = this.first.getInfo();
            this.first = this.first.getNext();
            return info;
        }
        return null;
    }

    public int getSize () {
        return this.size;
    }

    public Integer get (int index) {
        Node n = this.first;
        int i = 0;
        while (n.hasNext() && i < index) {
            n = n.getNext();
            i++;
        }
        return n.getInfo();
    }

    public boolean isEmpty () {
        return this.size == 0;
    }

    public int size () {
        return this.size;
    }

    public Integer indexOf (Integer info) {
        Node n = this.first;
        int index = 0;
        while (!this.isEmpty()) {
            if (n.getInfo() == info)
                return index;
            n = n.getNext();
        }
        return -1;

    }

    public Node getFirst() {
        return this.first;
    }

    @Override
    public MyIterator iterator() {
        return new MyIterator(this.first);
    }
}