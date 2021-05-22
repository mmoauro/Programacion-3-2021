package P3;

import java.util.ArrayList;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
    private ArrayList<Integer> vertices;
    private ArrayList<Arco<T>> arcos;
    // TODO: Pasar a HashMap.

    public GrafoDirigido () {
        this.vertices = new ArrayList<>();
        this.arcos = new ArrayList<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        if (!this.vertices.contains(verticeId))
            this.vertices.add(verticeId);

    }

    @Override
    public void borrarVertice(int verticeId) {
        // Primero borro todos los arcos del vertice a borrar.
        for (int i = 0; i < this.arcos.size(); i++) {
            Arco<T> arco = this.arcos.get(i);
            if (arco.getVerticeOrigen() == verticeId || arco.getVerticeDestino() == verticeId)
                this.borrarArco(verticeId, arco.getVerticeDestino());
        }
        // Una vez que borro todos los arcos de ese vertice puedo borrar el vertice.
        this.vertices.remove(verticeId);
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        Arco<T> arco = new Arco<T>(verticeId1, verticeId2, etiqueta);
        if (!this.arcos.contains(arco))
            this.arcos.add(arco);
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        if (this.existeArco(verticeId1, verticeId2)) {
            for (int i = 0; i < arcos.size(); i++) {
                Arco<T> arco = arcos.get(i);
                if (arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) {
                    this.arcos.remove(i);
                    return;
                }
            }
        }
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return this.vertices.contains(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        for (Arco<T> arco : arcos) {
            if (arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        if (this.existeArco(verticeId1, verticeId2)) {
            for (Arco<T> arco : this.arcos) {
                if (arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) {
                    return arco;
                }
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
        return this.arcos.size();
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        return this.vertices.iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        ArrayList<Integer> adyacentes = new ArrayList<>();
        for (Arco<T> arco : this.arcos) {
            if (arco.getVerticeOrigen() == verticeId)
                adyacentes.add(arco.getVerticeDestino());
        }
        return adyacentes.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        return this.arcos.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        ArrayList<Arco<T>> arcos = new ArrayList<>();
        for (Arco<T> arco : this.arcos) {
            if (arco.getVerticeOrigen() == verticeId)
                arcos.add(arco);
        }
        return arcos.iterator();
    }

}
