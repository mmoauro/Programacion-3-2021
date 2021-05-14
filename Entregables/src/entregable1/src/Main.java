package entregable1.src;

public class Main {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        LinkedList l3 = new LinkedList();
        LinkedList l4 = new LinkedList();

        l2.insertLast(1);
        l2.insertLast(2);
        l2.insertLast(3);

        l3.insertLast(3);
        l3.insertLast(5);
        l3.insertLast(2);
        l3.insertLast(7);
        l3.insertLast(19);
        l3.insertLast(14);
        l3.insertLast(28);

        l4.insertLast(3);
        l4.insertLast(5);
        l4.insertLast(4);
        l4.insertLast(2);
        l4.insertLast(7);
        l4.insertLast(15);
        l4.insertLast(14);
        l4.insertLast(28);
        
        System.out.println("------- Ejemplo 1 -------");
        for (Integer integer : getSecuencias(l1, 10))
            System.out.println(integer);
        System.out.println("------- Ejemplo 2 -------");
        for (Integer integer : getSecuencias(l2, 10))
            System.out.println(integer);
        System.out.println("------- Ejemplo 3 -------");
        for (Integer integer : getSecuencias(l2, 2))
            System.out.println(integer);
        System.out.println("------- Ejemplo 4 -------");
        for (Integer integer : getSecuencias(l3, 10))
            System.out.println(integer);
        System.out.println("------- Ejemplo 5 -------");
        for (Integer integer : getSecuencias(l4, 15))
            System.out.println(integer);
    }

    public static LinkedList getSecuencias (LinkedList list, int umbral) {  // O(n) -> n = cantidad de elementos de la lista
        LinkedList retorno = new LinkedList();
        MyIterator lista = list.iterator();
        Integer suma = 0;
        while (lista.hasNext()) { //O(n) -> n = cantidad de elementos de la lista
            Integer info = lista.getNext(); // O(1)
            if (info + suma <= umbral) {
                suma += info;
                lista.next();
            }
            else {
                if (suma > 0 && info + suma >= umbral)
                    retorno.insertLast(suma); //O(1)
                else
                    lista.next();
                suma = 0;
            }
            if (!lista.hasNext() && suma > 0 && suma <= umbral)
                retorno.insertLast(suma); // O(1)
        }
        return retorno;
    }
}
