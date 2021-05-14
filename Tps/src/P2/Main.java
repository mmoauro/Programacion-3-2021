package P2;

import P1.LinkedList;
import P1.Node;

public class Main {
    public static void main(String[] args) {
        int[] valoresIniciales = new int[] {5};
        Tree miArbol = new Tree(valoresIniciales);

        miArbol.printPreOrder();
        System.out.println();
        miArbol.delete(5);
        miArbol.printPreOrder();
        System.out.println();

        /*


        System.out.println( miArbol.getMaxElement() );
        System.out.println( miArbol.getHeight() );
        System.out.println( miArbol.getLongestBranch() );
        System.out.println( miArbol.getElemAtLevel(2) );
        System.out.println( miArbol.getFrontera() );

        miArbol.add(23);
        miArbol.add(3);
        miArbol.delete(6);
        miArbol.delete(30);

        miArbol.printPreOrder();
        System.out.println();
        System.out.println( miArbol.getMaxElement() );
        System.out.println( miArbol.getHeight() );
        System.out.println( miArbol.getLongestBranch() );
        System.out.println( miArbol.getElemAtLevel(2) );
        System.out.println( miArbol.getFrontera() );

        miArbol.add(65);
        miArbol.delete(5);
        miArbol.delete(15);
        miArbol.add(55);

        miArbol.printPreOrder();
        System.out.println();
        System.out.println( miArbol.getMaxElement() );
        System.out.println( miArbol.getHeight() );
        System.out.println( miArbol.getLongestBranch() );
        System.out.println( miArbol.getElemAtLevel(2) );
        System.out.println( miArbol.getFrontera() );

         */

    }

    public static boolean estaOrdenado (int[] arr, int n) {
        if (n == arr.length - 1)
            return true;
        else if (arr[n] > arr[n + 1])
            return false;
        return estaOrdenado(arr, n + 1);
    }

    static int busquedaBinaria (int[] arr, int numero, int inicioBusqueda, int finBusqueda) {
        if (inicioBusqueda > finBusqueda)
            return -1;
        int medio = (inicioBusqueda + finBusqueda) / 2;
        if (numero > arr[medio]) {
            return busquedaBinaria(arr, numero, medio + 1, finBusqueda);
        }
        else if (numero < arr[medio]) {
            return busquedaBinaria(arr, numero, inicioBusqueda, medio - 1);
        }
        else return arr[medio];
    }

    static Integer listaContiene (LinkedList lista, Integer busco, Node desde) {
        if (!desde.hasNext())
            return null;
        else if (busco.equals(desde.getInfo()))
            return busco;
        else
            return listaContiene(lista, busco, desde.getNext());
    }

    static void bubbleSort (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void selectionSort(int [] arr) {
        for(int i=0; i<arr.length; i++) {
            int menor = i;
            for(int j = i+1; j<arr.length; j++) {
                if(arr[j]<arr[menor])
                    menor = j;
            }
            int aux = arr[i];
            arr[i] = arr[menor];
            arr[menor] = aux;
        }
    }
}
