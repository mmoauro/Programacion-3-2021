package P3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
    private HashMap<Integer, ArrayList<Arco<T>>> vertices;

    public GrafoDirigido () {
        this.vertices = new HashMap<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        if (!this.vertices.containsKey(verticeId))
            this.vertices.put(verticeId, new ArrayList<>());
    }

    @Override
    public void borrarVertice(int verticeId) {
        // Por cada vertice borro los arcos que se dirijan al vertice a borrar.
        for (int idVertice : this.vertices.keySet()) {
            this.vertices.get(idVertice).removeIf(arco -> arco.getVerticeDestino() == verticeId);
        }
        // Una vez que borro todos los arcos de ese vertice puedo borrar el vertice.
        this.vertices.remove(verticeId);
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        Arco<T> arco = new Arco<T>(verticeId1, verticeId2, etiqueta);
        if (!this.vertices.get(verticeId1).contains(arco))
            this.vertices.get(verticeId1).add(arco);
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        this.vertices.get(verticeId1).removeIf(arco -> arco.getVerticeDestino() == verticeId2);
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return this.vertices.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        for (Arco<T> arco : this.vertices.get(verticeId1)) {
            if (arco.getVerticeDestino() == verticeId2) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        for (Arco<T> arco : this.vertices.get(verticeId1)) {
            if (arco.getVerticeDestino() == verticeId2) {
                return arco;
            }
        }
        return null;
    }

    @Override
    public int cantidadVertices() {
        return this.vertices.size();
    }

    @Override
    public int cantidadArcos() {
        int total = 0;
        for (int verticeId : this.vertices.keySet())
            total += this.vertices.get(verticeId).size();
        return total;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        return this.vertices.keySet().iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        ArrayList<Integer> adyacentes = new ArrayList<>();
        for (Arco<T> arco : this.vertices.get(verticeId)) {
            adyacentes.add(arco.getVerticeDestino());
        }
        return adyacentes.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        ArrayList<Arco<T>> retorno = new ArrayList<>();
        for (int verticeId : this.vertices.keySet())
            retorno.addAll(this.vertices.get(verticeId));
        return retorno.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        return this.vertices.get(verticeId).iterator();
    }

}
