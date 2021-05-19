package P3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class DFS {
    private Grafo<?> grafo;
    private HashMap<Integer, String> colores;

    public DFS (Grafo<?> grafo) {
        this.grafo = grafo;
        this.colores = new HashMap<>();
    }

    // O(n) -> n = Cantidad de vertices que tiene el grafo.
    private void pintarVerticesDeBlanco () {
        // Por cada vertice..
        Iterator<Integer> it = grafo.obtenerVertices();
        // Por cada uno pongo el color en blanco.
        while (it.hasNext()) {
            int verticeId = it.next();
            this.colores.put(verticeId, "Blanco");
        }
    }

    public ArrayList<ArrayList<Integer>> obtenerRutas(int verticeOrigen, int verticeDestino) {
        this.pintarVerticesDeBlanco();
        ArrayList<Integer> ruta = new ArrayList<>();
        ruta.add(verticeOrigen);
        return obtenerTodasLasRutas(verticeOrigen, verticeDestino, ruta, new ArrayList<>());
    }

    private ArrayList<ArrayList<Integer>> obtenerTodasLasRutas(Integer verticeOrigen, Integer verticeDestino, ArrayList<Integer> ruta, ArrayList<ArrayList<Integer>> retorno)  {

        if (verticeOrigen.equals(verticeDestino))
            retorno.add(new ArrayList<>(ruta));
        this.colores.put(verticeOrigen, "Amarillo");

        for (Iterator<Integer> it = this.grafo.obtenerAdyacentes(verticeOrigen); it.hasNext(); ) {
            Integer idAdyacente = it.next();
            if (this.colores.get(idAdyacente).equals("Blanco")) {
                ruta.add(idAdyacente);
                obtenerTodasLasRutas(idAdyacente, verticeDestino, ruta, retorno);
                ruta.remove(idAdyacente);
            }
        }
        this.colores.put(verticeOrigen, "Blanco");
        return retorno;
    }
}
