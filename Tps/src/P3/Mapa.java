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

    public ArrayList<String> obtenerRutaMasCorta(Ciudad origen, Ciudad destino) {
        ArrayList<Integer> ruta = this.privateObtenerRutaMasCorta(origen, destino);
        ArrayList<String> retorno = new ArrayList<>();
        for (Integer r : ruta)
            retorno.add(this.ciudades.get(r).getNombre());
        return retorno.size() > 0 ? retorno : null;
    }

    private int getDistanciaRuta (ArrayList<Integer> ruta) {
        int distancia = 0;
        for (int i = 0; i < ruta.size() - 1; i++) {
            distancia += this.grafo.obtenerArco(ruta.get(i), ruta.get(i+1)).getEtiqueta();
        }
        return distancia;
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

    private ArrayList<Integer> privateObtenerRutaMasCorta(Ciudad origen, Ciudad destino) {
        this.pintarVerticesDeBlanco();
        ArrayList<Integer> ruta = new ArrayList<>();
        ruta.add(origen.getId());
        return privateObtenerRutaMasCorta(origen, destino, ruta, new ArrayList<>(), 0);
    }

    // O(n ^ n)???
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
}
