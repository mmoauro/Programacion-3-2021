package P3;

import java.util.ArrayList;
import java.util.HashMap;

public class Mapa {
    private Grafo<Integer> grafo;
    private HashMap<Integer, Ciudad> ciudades;

    public Mapa () {
        this.grafo = new GrafoNoDirigido<Integer>();
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


    public ArrayList<String> obtenerRutaMasCorta (Ciudad origen, Ciudad destino) {
        DFS dfs = new DFS(this.grafo);
        ArrayList<ArrayList<Integer>> todasLasRutas = dfs.obtenerRutas(origen.getId(), destino.getId());
        ArrayList<ArrayList<Integer>> rutasDisponibles = new ArrayList<>(); // Son las rutas que cumplen con las restriccion de la balanza.
        for (ArrayList<Integer> ruta : todasLasRutas) {
            int ciudadesConBalanza = 0;
            for (Integer idCiudad : ruta) {
                // Por cada ciudad de una ruta.
                if (this.ciudades.get(idCiudad).isTieneBalanza())
                    ciudadesConBalanza++;
            }
            if (ciudadesConBalanza <= 1) {
                // Si cumple con la restriccion de balanza verifico si la ruta que estoy revisando es mas corta que la actual.
                if (rutasDisponibles.size() == 0)
                    rutasDisponibles.add(ruta);
                else if (this.getDistanciaRuta(ruta) < this.getDistanciaRuta(rutasDisponibles.get(0))) {
                    rutasDisponibles.remove(0);
                    rutasDisponibles.add(ruta);
                }
            }
        }
        ArrayList<String> retorno = new ArrayList<>();
        for (ArrayList<Integer> ruta : rutasDisponibles) {
            for (Integer ciudad : ruta)
                retorno.add(this.ciudades.get(ciudad).getNombre());
        }
        return retorno.size() > 0 ? retorno : null;
    }

    private int getDistanciaRuta (ArrayList<Integer> ruta) {
        int distancia = 0;
        for (int i = 0; i < ruta.size() - 1; i++) {
            distancia += this.grafo.obtenerArco(ruta.get(i), ruta.get(i+1)).getEtiqueta();
        }
        return distancia;
    }
}
