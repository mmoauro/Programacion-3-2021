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

    private void pintarVerticesDeBlanco () {
        // Por cada vertice..
        Iterator<Integer> it = grafo.obtenerVertices();
        // Por cada uno pongo el color en blanco.
        while (it.hasNext()) {
            int verticeId = it.next();
            this.colores.put(verticeId, "Blanco");
        }
    }

    public ArrayList<Integer> dfs () {
        this.pintarVerticesDeBlanco();
        Iterator<Integer> it = grafo.obtenerVertices();
        ArrayList<Integer> retorno = new ArrayList<>();
        while (it.hasNext()) {
            int verticeId = it.next();
            if (this.colores.get(verticeId).equals("Blanco"))
                retorno.addAll(dfs_visit(verticeId)); // Es lo mismo que llamar a dfs_visit pasando retorno como parametro.
        }
        return retorno;
    }

    private ArrayList<Integer> dfs_visit (int verticeId) {
        ArrayList<Integer> retorno = new ArrayList<>();
        retorno.add(verticeId);
        this.colores.put(verticeId, "Amarillo");
        Iterator<Integer> it = this.grafo.obtenerAdyacentes(verticeId);
        while (it.hasNext()) {
            int adyId = it.next();
            if (this.colores.get(adyId).equals("Blanco"))
                retorno.addAll(dfs_visit(adyId));
        }
        this.colores.put(verticeId, "Negro");
        return retorno;
    }

    public boolean tieneCamino (int verticeOrigen, int verticeDestino) {
        this.pintarVerticesDeBlanco();
        return this.dfs_visit(verticeOrigen).contains(verticeDestino); // Es mas simple que llamar a buscarCamino pero mas costoso.
    }

    public ArrayList<Integer> obtenerCamino (int verticeOrigen, int verticeDestino) {
        this.pintarVerticesDeBlanco();
        return this.buscarCamino(verticeOrigen, verticeDestino, verticeOrigen);
    }

    private ArrayList<Integer> buscarCamino (int verticeOrigen, int verticeDestino, int verticeOrigenOriginal) {
        ArrayList<Integer> retorno = new ArrayList<>();
        if (verticeDestino == verticeOrigen) {
            retorno.add(verticeOrigen);
            return retorno;
        }
        this.colores.put(verticeOrigen, "Amarillo");
        Iterator<Integer> it = this.grafo.obtenerAdyacentes(verticeOrigen);
        while (it.hasNext()) {
            int adyId = it.next();
            if (this.colores.get(adyId).equals("Blanco") && adyId != verticeOrigenOriginal) {
                ArrayList<Integer> camino = this.buscarCamino(adyId, verticeDestino, verticeOrigenOriginal);
                if (camino.size() > 0) {
                    retorno.add(verticeOrigen);
                    retorno.addAll(camino);
                }
            }
        }
        this.colores.put(verticeOrigen, "Negro");
        return retorno;
    }

    public ArrayList<ArrayList<Integer>> obtenerTodasLasRutas (int verticeOrigen, int verticeDestino) {
        //this.pintarVerticesDeBlanco();
        ArrayList<ArrayList<Integer>> retorno = new ArrayList<>();
        Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(verticeOrigen);
        //retorno.add(this.buscarCamino(verticeOrigen, verticeDestino));
        while (adyacentes.hasNext()) {
            this.pintarVerticesDeBlanco();
            int id = adyacentes.next();
            Iterator<Integer> adyacentes1 = this.grafo.obtenerAdyacentes(id);
            while (adyacentes1.hasNext()) {
                int id1 = adyacentes1.next();
                this.pintarVerticesDeBlanco();
                ArrayList<Integer> ruta = this.buscarCamino(id1, verticeDestino, verticeOrigen);
                if (!retorno.contains(ruta)) {
                    retorno.add(ruta);
                }
            }
        }
        return retorno;
    }
}
