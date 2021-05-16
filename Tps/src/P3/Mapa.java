package P3;

import java.util.ArrayList;
import java.util.HashMap;

public class Mapa {
    private Grafo<Integer> grafo;
    private HashMap<Integer, Ciudad> ciudades;

    public Mapa () {
        this.grafo = new GrafoNoDirigido<>();
        this.ciudades = new HashMap<>();
    }

    public void addCiudad (Ciudad ciudad) {
        this.ciudades.put(ciudad.getId(), ciudad);
        this.grafo.agregarVertice(ciudad.getId());
    }

    public void agregarRuta (Ciudad origen, Ciudad destino, int distancia) {
        if (this.ciudades.containsKey(origen.getId()) && this.ciudades.containsKey(destino.getId())) {
            this.grafo.agregarArco(origen.getId(), destino.getId(), distancia);
        }
    }

    public void borrarCiudad (Ciudad ciudad) {
        this.grafo.borrarVertice(ciudad.getId());
        this.ciudades.remove(ciudad.getId());
    }

    public void borrarRuta (Ciudad origen, Ciudad destino) {
        this.grafo.borrarArco(origen.getId(), destino.getId());
    }

    public DFS dfs () {
        return new DFS(this.grafo);
    }

    public ArrayList<String> getRuta (Ciudad origen, Ciudad destino) {
        DFS dfs = new DFS(this.grafo);
        ArrayList<Integer> ruta = dfs.obtenerCamino(origen.getId(), destino.getId());
        ArrayList<String> retorno = new ArrayList<>();
        for (Integer r : ruta)
            retorno.add(this.ciudades.get(r).getNombre());
        return retorno.size() > 0 ? retorno : null;
    }

    public ArrayList<ArrayList<String>> obtenerRutas (Ciudad origen, Ciudad destino) {
        DFS dfs = new DFS(this.grafo);
        ArrayList<ArrayList<Integer>> rutas = dfs.obtenerTodasLasRutas(origen.getId(), destino.getId());
        ArrayList<ArrayList<String>> retorno = new ArrayList<>();
        for (ArrayList<Integer> ruta : rutas) {
            ArrayList<String> nombreCiudades = new ArrayList<>();
            for (Integer ciudad : ruta)
                nombreCiudades.add(this.ciudades.get(ciudad).getNombre());
            retorno.add(nombreCiudades);
        }
        return retorno.size() > 0 ? retorno : null;
    }


}
