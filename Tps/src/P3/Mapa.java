package P3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Mapa {
    private Grafo<Integer> grafo;
    private HashMap<Integer, Ciudad> ciudades;
    private HashMap<Integer, String> colores;

    public Mapa () {
        this.grafo = new GrafoNoDirigido<Integer>();
        this.ciudades = new HashMap<>();
        this.colores = new HashMap<>();
    }

    // O(1)
    public void addCiudad (Ciudad ciudad) {
        this.ciudades.put(ciudad.getId(), ciudad);
        this.grafo.agregarVertice(ciudad.getId());
    }

    // O(n) -> n = Cantidad de arcos que tiene el origen.
    public void agregarRuta (Ciudad origen, Ciudad destino, int distancia) {
        if (this.ciudades.containsKey(origen.getId()) && this.ciudades.containsKey(destino.getId())) {
            this.grafo.agregarArco(origen.getId(), destino.getId(), distancia);
        }
    }

    // O(n * a) -> Es lo que demora el metodo borrarVertice del grafo.
    public void borrarCiudad (Ciudad ciudad) {
        this.grafo.borrarVertice(ciudad.getId());
        this.ciudades.remove(ciudad.getId());
    }

    // O(n) -> Es lo que demora el metood borrarArco del grafo.
    public void borrarRuta (Ciudad origen, Ciudad destino) {
        this.grafo.borrarArco(origen.getId(), destino.getId());
    }

    // O(n ^ n) -> n = Cantidad de vertices del grafo.
    public ArrayList<String> obtenerRutaMasCorta(Ciudad origen, Ciudad destino) {
        ArrayList<Integer> ruta = this.privateObtenerRutaMasCorta(origen, destino);
        ArrayList<String> retorno = new ArrayList<>();
        for (Integer r : ruta) // O(n) -> n = ruta.size()
            retorno.add(this.ciudades.get(r).getNombre());
        if (retorno.size() > 0) {
            retorno.add("Distancia de la ruta: " + this.getDistanciaRuta(ruta) + " km");
            return retorno;
        }
        return null;
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

    // O(n ^ n) -> n = Cantidad de vertices del grafo.
    private ArrayList<Integer> privateObtenerRutaMasCorta(Ciudad origen, Ciudad destino) {
        this.pintarVerticesDeBlanco();
        ArrayList<Integer> ruta = new ArrayList<>();
        ruta.add(origen.getId());
        // Cuento la ciudad de origen para el conteo de balanzas y la ciudad de destino no.
        return privateObtenerRutaMasCorta(origen, destino, ruta, new ArrayList<>(), origen.isTieneBalanza() ? 1 : 0);
    }

    // O(n ^ n) -> n = Cantidad de vertices del grafo.
    private ArrayList<Integer> privateObtenerRutaMasCorta(Ciudad origen, Ciudad destino, ArrayList<Integer> ruta, ArrayList<Integer> retorno, int cuentaBalanzas)  {
        // La ciudad de destino no cuenta en el contado de balanzas.
        this.colores.put(origen.getId(), "Amarillo");
        if (origen.getId() == destino.getId()) { // Legue al destino.
            retorno.removeAll(retorno);
            retorno.addAll(ruta);
        }
        else { // Si no llegue al destino sigo buscando
            if (origen.isTieneBalanza())
                cuentaBalanzas++;

            Iterator<Integer> it = this.grafo.obtenerAdyacentes(origen.getId());
            while (it.hasNext() && cuentaBalanzas < 2 && (this.getDistanciaRuta(retorno) == 0 || (this.getDistanciaRuta(ruta) <= this.getDistanciaRuta(retorno)))) {
                Integer idAdyacente = it.next();
                if (this.colores.get(idAdyacente).equals("Blanco")) {
                    ruta.add(idAdyacente);
                    privateObtenerRutaMasCorta(this.ciudades.get(idAdyacente), destino, ruta, retorno, cuentaBalanzas);
                    ruta.remove(idAdyacente);
                }
            }
        }
        this.colores.put(origen.getId(), "Blanco");
        return retorno;
    }

    // O(n * a) -> n = Cantidad de vertices por los que pasa la ruta. a = Cantidad de arcos que tiene cada vertice de la ruta.
    private int getDistanciaRuta (ArrayList<Integer> ruta) {
        int distancia = 0;
        for (int i = 0; i < ruta.size() - 1; i++) {
            distancia += this.grafo.obtenerArco(ruta.get(i), ruta.get(i+1)).getEtiqueta(); // O(a)
        }
        return distancia;
    }
}
