package entregable2.src;

import java.util.ArrayList;
import java.util.Collections;

public class Tree {

    private Integer value;
    private Tree left;
    private Tree right;
    private Tree padre;

    public Tree(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    // O(h*n) -> h = Altura del arbol. n = values.length.
    public Tree (int[] values) {
        if (values.length > 0) {
            this.value = values[0];
            for (int i = 1; i < values.length; i++)
                this.add(values[i]);
        }
        else
            this.value = null;
    }

    // O(1)
    public Integer getValue() {
        return value;
    }

    // O(h) => h = Altura del arbol.
    public void add(int newValue) {
        if (this.value == null) { // El arbol esta vacio.
            this.value = newValue;
            return;
        }
        Tree tree = new Tree(newValue);
        tree.setPadre(this);
        if (newValue < this.value) {
            if (this.left == null)
                this.left = tree;
            else
                this.left.add(newValue);
        }
        else {
            if (this.right == null)
                this.right = tree;
            else
                this.right.add(newValue);
        }
    }

    // O(1)
    public Integer getRoot () {
        return this.value;
    }

    // O(1)
    public boolean isEmpty () {
        return this.value != null;
    }

    // O(n) -> n = Cantidad de subarboles.
    public void printPosOrder() {
        if (this.left != null)
            this.left.printPosOrder();
        if (this.right != null)
            this.right.printPosOrder();
        System.out.println(this.value);
    }

    // O(n) -> n = Cantidad de subarboles.
    public void printPreOrder() {
        System.out.print(this.value + " ");
        if (this.left != null)
            this.left.printPreOrder();
        else
            System.out.print("- ");
        if (this.right != null)
            this.right.printPreOrder();
        else
            System.out.print("- " );
    }

    // O(n) -> n = Cantidad de subarboles.
    public void printInOrder () {
        if (this.left != null)
            this.left.printInOrder();
        System.out.println(this.value);
        if (this.right != null)
            this.right.printInOrder();
    }

    // O(h) -> h = Altura del arbol.
    public int getMaxElement () {
        int maxElement = this.value;
        if (this.right != null)
            maxElement = this.right.getMaxElement();
        return maxElement;
    }

    // O(h) -> h = Altura del arbol.
    // En el peor caso tengo que eliminar un elemento del ultimo nivel.
    public void delete (int value) {
        if (value < this.value && this.left != null)
            this.left.delete(value);
        else if (value > this.value && this.right != null)
            this.right.delete(value);

        else if (value == this.value) { // Me paro en el elemento que quiero borrar.
            if (this.right == null && this.left == null) { // Es hoja
                if (this.padre == null) { // Es la raiz.
                    this.value = null;
                    return;
                }
                this.changePointers(value, null);
            }
            else if (this.right != null && this.left != null) { // Tiene dos hijos.
                Tree NMISA = this.getNMISA(this); // Obtengo el subarbol mas izquierdo de mi subarbol derecho.
                this.delete(NMISA.getValue()); // Lo borro de la estructura.
                this.value = NMISA.getValue(); // Remplazo mi valor.
            }
            else { // Tiene un solo hijo.
                Tree hijo = this.left != null ? this.left : this.right;
                hijo.setPadre(this.padre);
                if (this.padre == null) { // Si el arbol a eliminar es la raiz y tiene solo un hijo.
                    this.value = hijo.getValue();
                    this.left = hijo.getLeft();
                    this.right = hijo.getRight();
                }
                else
                    this.changePointers(value, hijo);
            }
        }
    }

    // O(1)
    private void changePointers (int value, Tree node) {
        if (this.padre != null) {
            if (this.padre.getLeft() != null && this.padre.getLeft().getValue() == value)
                padre.setLeft(node);
            else if (this.padre.getRight() != null && this.padre.getRight().getValue() == value)
                padre.setRight(node);

        }
    }

    // O(h) -> h = Altura del arbol.
    private Tree getNMISA (Tree head) {
        Tree subarbolD = head.getRight();
        while (subarbolD.getLeft() != null) {
            subarbolD = subarbolD.getLeft();
        }
        return subarbolD;
    }

    // Los getter y los setter son todos O(1)

    private void setLeft (Tree tree) {
        this.left = tree;
    }

    private void setRight (Tree tree) {
        this.right = tree;
    }

    private Tree getLeft () {
        return this.left;
    }

    private Tree getRight () {
        return this.right;
    }

    private void setPadre (Tree padre) {
        this.padre = padre;
    }

    private Tree getPadre() {
        return this.padre;
    }

    // O(n) -> n = Cantidad de subarboles
    public ArrayList<Integer> getFrontera () {
        return this.privateGetFrontera(new ArrayList<Integer>());
    }

    // O(n) -> n = Cantidad de subarboles
    private ArrayList<Tree> getFronteraWithTrees () { // Este metodo lo uso para hacer el getLongestBranch. Obtengo los subarboles en vez de los valores. Es privado para no romper el encapsulamiento
        return this.privateGetFronteraWithTrees(new ArrayList<Tree>());
    }

    // O(n) -> n = Cantidad de subarboles
    // Pasa por todos los elementos
    private ArrayList<Integer> privateGetFrontera (ArrayList<Integer> hojas) {
        if (this.left == null && this.right == null)
            hojas.add(this.value);
        if (this.left != null)
            this.left.privateGetFrontera(hojas);
        if (this.right != null)
            this.right.privateGetFrontera(hojas);
        return hojas;
    }

    // O(n) -> n = Cantidad de subarboles
    // Pasa por todos los elementos
    private ArrayList<Tree> privateGetFronteraWithTrees (ArrayList<Tree> hojas) {
        if (this.left == null && this.right == null)
            hojas.add(this);
        if (this.left != null)
            this.left.privateGetFronteraWithTrees(hojas);
        if (this.right != null)
            this.right.privateGetFronteraWithTrees(hojas);
        return hojas;
    }

    // O(h) -> h = Altura del arbol.
    public boolean hasElem (Integer value) {
        if (value < this.value && this.left != null)
            return this.left.hasElem(value);
        else if (value > this.value && this.right != null)
            return this.right.hasElem(value);
        return value == this.value;
    }

    // O(n) -> n = Cantidad de subarboles.
    // En el peor caso me piden los elementos del ultimo nivel
    public ArrayList<Integer> getElemAtLevel (int level) {
        ArrayList<Integer> elements = new ArrayList<>();
        this.getElementsAtLevel(elements, level, 0);
        return elements;
    }

    // O(n) -> n = Cantidad de subarboles.
    // En el peor caso me piden los elementos del ultimos nivel
    private void getElementsAtLevel(ArrayList<Integer> elements, int level, int index) {
        // level es el nivel solicitado por el usuario
        // index es el indice por el que voy recorriendo
        if (level - 1 == index) {
            if (this.left != null)
                elements.add(this.left.getValue());
            if (this.right != null)
                elements.add(this.right.getValue());
        }
        else {
            if (this.left != null)
                left.getElementsAtLevel(elements, level, index + 1);
            if (this.right != null)
                right.getElementsAtLevel(elements, level, index + 1);
        }
    }

    // O(n) -> n = Cantidad de subarboles.
    public ArrayList<Integer> getLongestBranch () {
        int treeHeight = this.getHeight();
        ArrayList<Integer> longestBranch = new ArrayList<>(); // Rama mas larga del arbol.
        ArrayList<Tree> hojas = this.getFronteraWithTrees(); // O(n) -> n = Cantidad de subarboles Lista con las hojas del arbol. Podria ser mas eficiente si pido directamente los elementos del ultimo nivel, para que no me traiga hojas que no estan en el ultimo nivel.
        for (Tree tree : hojas) { // Por cada hoja voy hasta la raiz y guardo el recorrido en una Lista
            ArrayList<Integer> b = new ArrayList<>();
            Tree node = tree;
            while (node.padre != null) {
                b.add(node.getValue());
                node = node.getPadre();
            }
            b.add(node.getValue()); // Agrega la raiz a la lista
            if (b.size() > longestBranch.size()) // Si el nuevo recorrido es mas largo al guardado anteriormente lo remplazo.
                longestBranch = b;
            if (longestBranch.size() - 1 == treeHeight) // Si la cantidad de subarboles de la rama - 1 es igual a la altura del arbol quiere decir que ya encontre la rama mas larga y corto la busqueda.
                break;
        }
        Collections.reverse(longestBranch);
        return longestBranch;
    }

    // O(n) -> n = cantidad de subarboles.
    public int getHeight() {
        int left = 0;
        int right = 0;
        if (this.left != null)
            left = this.left.getHeight();
        if (this.right != null)
            right = this.right.getHeight();
        if (this.right == null && this.left == null)
            return Math.max(left, right);
        return 1 + Math.max(left, right);
    }
}