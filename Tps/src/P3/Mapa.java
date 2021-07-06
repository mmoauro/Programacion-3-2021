package P3;

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
    public Camino obtenerRutaMasCorta(Ciudad origen, Ciudad destino) {
        this.pintarVerticesDeBlanco();
        Camino ruta = new Camino();
        ruta.addCiudad(origen);
        // Cuento la ciudad de origen para el conteo de balanzas y la ciudad de destino no.
        return privateObtenerRutaMasCorta(origen, destino, ruta, new Camino(), origen.isTieneBalanza() ? 1 : 0);
    }

    // O(n ^ n) -> n = Cantidad de vertices del grafo.
    private Camino privateObtenerRutaMasCorta(Ciudad origen, Ciudad destino, Camino rutaActual, Camino mejor, int cuentaBalanzas)  {
        // La ciudad de destino no cuenta en el contado de balanzas.
        this.colores.put(origen.getId(), "Amarillo");
        if (origen.getId() == destino.getId()) { // Legue al destino.
            mejor.copiar(rutaActual);
        }
        else { // Si no llegue al destino sigo buscando
            if (origen.isTieneBalanza())
                cuentaBalanzas++;

            Iterator<Integer> it = this.grafo.obtenerAdyacentes(origen.getId());
            while (it.hasNext() && cuentaBalanzas < 2) {
                Integer idAdyacente = it.next();
                if (this.colores.get(idAdyacente).equals("Blanco")) {
                    int distancia = this.grafo.obtenerArco(origen.getId(), idAdyacente).getEtiqueta();
                    rutaActual.addCiudad(this.ciudades.get(idAdyacente));
                    rutaActual.incrementarDistancia(distancia);
                    if (rutaActual.getDistancia() <= mejor.getDistancia() || mejor.getDistancia() == 0)
                        mejor = privateObtenerRutaMasCorta(this.ciudades.get(idAdyacente), destino, rutaActual, mejor, cuentaBalanzas);
                    rutaActual.removeLastCiudad();
                    rutaActual.decrementarDistancia(distancia);
                }
            }
        }
        this.colores.put(origen.getId(), "Blanco");
        return mejor;
    }
}
