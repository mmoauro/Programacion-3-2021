package P3;

import java.util.HashMap;
import java.util.Iterator;

public class DFS {
    private Grafo<?> grafo;
    private HashMap<Integer, String> colores;
    private int tiempo;
    private HashMap<Integer, Integer> descubrimiento;
    private HashMap<Integer, Integer> finalizacion;

    public DFS (Grafo<?> grafo) {
        this.grafo = grafo;
        this.colores = new HashMap<>();
        this.descubrimiento = new HashMap<>();
        this.finalizacion = new HashMap<>();
        this.tiempo = 0;
    }

    public void dfs () {
        // Por cada vertice..
        Iterator<Integer> it = grafo.obtenerVertices();
        // Por cada uno pongo el color en blanco.
        while (it.hasNext()) {
            int verticeId = it.next();
            this.colores.put(verticeId, "Blanco");
        }

        it = grafo.obtenerVertices();
        while (it.hasNext()) {
            int verticeId = it.next();
            if (this.colores.get(verticeId).equals("Blanco"))
                dfs_visit(verticeId);
        }
    }

    public void dfs_visit (int verticeId) {
        System.out.println(verticeId);
        this.colores.put(verticeId, "Amarillo");
        this.tiempo++;
        this.descubrimiento.put(verticeId, tiempo);
        Iterator<Integer> it = this.grafo.obtenerAdyacentes(verticeId);
        while (it.hasNext()) {
            int adyId = it.next();
            if (this.colores.get(adyId).equals("Blanco"))
                dfs_visit(adyId);
        }
        this.colores.put(verticeId, "Negro");
        this.tiempo++;
        this.finalizacion.put(verticeId, tiempo);
    }

    public boolean tieneCiclo () {
        // Por cada vertice..
        Iterator<Integer> it = grafo.obtenerVertices();
        // Por cada uno pongo el color en blanco.
        while (it.hasNext()) {
            int verticeId = it.next();
            this.colores.put(verticeId, "Blanco");
        }

        it = grafo.obtenerVertices();
        while (it.hasNext()) {
            int verticeId = it.next();
            if (this.colores.get(verticeId).equals("Blanco"))
                return tieneCiclo(verticeId);
        }
        return false;
    }

    public boolean tieneCiclo (int verticeId) {
        Iterator<Integer> it = this.grafo.obtenerAdyacentes(verticeId);
        boolean encontro = false;
        while (it.hasNext() && !encontro) {
            int adyId = it.next();
            if (this.colores.get(adyId).equals("Amarillo"))
                encontro = true;
            else if (this.colores.get(adyId).equals("Blanco"))
                encontro = this.tieneCiclo(adyId);
        }
        return encontro;
    }
}
