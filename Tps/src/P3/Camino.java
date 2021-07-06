package P3;

import java.util.ArrayList;

public class Camino {
    private ArrayList<Ciudad> ciudades;
    private int distancia;

    public Camino (){
        this.ciudades = new ArrayList<>();
        this.distancia = 0;
    }

    public void addCiudad (Ciudad ciudad) {
        if (!this.ciudades.contains(ciudad))
            this.ciudades.add(ciudad);
    }

    public void incrementarDistancia (int distancia) {
        this.distancia += distancia;
    }

    public void decrementarDistancia (int distancia) {
        this.distancia -= distancia;
    }

    public void removeLastCiudad () {
        this.ciudades.remove(this.ciudades.size() - 1);
    }

    public int getDistancia () {
        return this.distancia;
    }

    public String toString () {
        String retorno = "";
        for (Ciudad ciudad : this.ciudades) {
            retorno += ciudad.getNombre() + ", ";
        }
        retorno += "Distancia de la ruta: " + this.getDistancia() + " km.";
        return this.ciudades.size() == 0 ? "No se encontro ruta" : retorno;
    }

    public ArrayList<Ciudad> getCiudades () {
        return new ArrayList<>(this.ciudades);
    }

    public void copiar (Camino c) {
        this.ciudades = new ArrayList<>();
        this.ciudades.addAll(c.getCiudades());
        this.distancia = 0;
        this.distancia += c.getDistancia();
    }
}
