package entregable1.src;

import java.util.Iterator;

public class LinkedList implements Iterable<Integer> {
    private Node first;
    private int size;
    private Node last; // Puntero al ultimo nodo, para que el insertLast() sea O(1) y no O(N).

    public LinkedList() {
        this.size = 0;
    }

    public void insertFront (Integer info) { // O(1)
        Node n = new Node(info);
        if (this.size == 0)
            this.last = n;
        n.setNext(this.first);
        this.first = n;
        this.size++;
    }

    public void insertLast (Integer info) { // O(1)
        Node temp = new Node(info);
        if (this.size > 0) {
            this.last.setNext(temp);
            this.last = temp;
        }
        else {
            // Si es el primer elemento
            this.first = temp;
            this.last = temp;
        }
        this.size++;
    }

    public Integer extractFront () { // O(1)
        if (this.size > 0) {
            this.size--;
            Integer info = this.first.getInfo();
            this.first = this.first.getNext();
            return info;
        }
        if (this.size == 0) // Se elimino el unico elemento de la lista.
            this.last = null;
        return null;
    }

    public int getSize () { // O(1)
        return this.size;
    }

    public Integer get (int index) { // O(n) -> n = cantidad de nodos.
        Node n = this.first;
        int i = 0;
        while (n.hasNext() && i < index) {
            n = n.getNext();
            i++;
        }
        return n.getInfo();
    }

    public void print (int index) { // O(n) -> n = cantidad de nodos.
        if (index < this.size) {
            Node n = this.first;
            int i = 0;
            while (n.hasNext() && i < index) {
                n = n.getNext();
                i++;
            }
            System.out.println(n.getInfo());
        }
    }


    @Override
    public MyIterator iterator() {
        return new MyIterator(this.first);
    }
}
