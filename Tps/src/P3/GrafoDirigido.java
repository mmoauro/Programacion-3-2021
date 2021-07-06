package P3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
    private HashMap<Integer, ArrayList<Arco<T>>> vertices;
    private int cantidadArcos;

    public GrafoDirigido () {
        this.vertices = new HashMap<>();
        this.cantidadArcos = 0;
    }

    // O(1). No se la complejidad del metodo containsKey. La complejidad de agregarVertice(vertice) depende de ese metodo.
    @Override
    public void agregarVertice(int verticeId) {
        if (!this.vertices.containsKey(verticeId))
            this.vertices.put(verticeId, new ArrayList<>());
    }

    // O(n * a) -> n = Cantidad de vertices. a = Cantidad de arcos por cada vertice.
    @Override
    public void borrarVertice(int verticeId) {
        // Por cada vertice borro los arcos que se dirijan al vertice a borrar.
        for (int idVertice : this.vertices.keySet()) {
            this.vertices.get(idVertice).removeIf(arco -> arco.getVerticeDestino() == verticeId); // O(n)
        }
        // Una vez que borro todos los arcos de ese vertice puedo borrar el vertice.
        this.vertices.remove(verticeId);
    }

    // O(n) -> n = Cantidad de arcos que tiene el vertice.
    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        Arco<T> arco = new Arco<T>(verticeId1, verticeId2, etiqueta);
        if (!this.vertices.get(verticeId1).contains(arco)) { // O(n)
            this.vertices.get(verticeId1).add(arco);
            this.cantidadArcos++;
        }
    }

    // O(n) -> n = Cantidad de arcos que tiene el verticeId1
    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        this.vertices.get(verticeId1).removeIf(arco -> arco.getVerticeDestino() == verticeId2);
        this.cantidadArcos--;
    }

    // O(1)
    @Override
    public boolean contieneVertice(int verticeId) {
        return this.vertices.containsKey(verticeId);
    }

    // O(n) -> n = Cantidad de arcos que tiene el verticeId1
    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        for (Arco<T> arco : this.vertices.get(verticeId1)) {
            if (arco.getVerticeDestino() == verticeId2)
                return true;
        }
        return false;
    }

    // O(n) -> n = Cantidad de arcos que tiene el verticeId1
    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        for (Arco<T> arco : this.vertices.get(verticeId1)) {
            if (arco.getVerticeDestino() == verticeId2)
                return arco;
        }
        return null;
    }

    // O(1)
    @Override
    public int cantidadVertices() {
        return this.vertices.size();
    }

    // O(1)
    @Override
    public int cantidadArcos() {
        return this.cantidadArcos;
    }

    // O(1). No se la complejidad de los metodos que llamo.
    @Override
    public Iterator<Integer> obtenerVertices() {
        return this.vertices.keySet().iterator();
    }

    // O(1)
    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        return new IteratorAdyacentes<T>(this.vertices.get(verticeId).iterator());
    }

    // O(n) -> n = Cantidad de vertices.
    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        ArrayList<Arco<T>> retorno = new ArrayList<>();
        for (int verticeId : this.vertices.keySet())
            retorno.addAll(this.vertices.get(verticeId));
        return retorno.iterator();
    }

    // O(1)
    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        return this.vertices.get(verticeId).iterator();
    }

}
