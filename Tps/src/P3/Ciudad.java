package P3;

public class Ciudad {
    private final int id;
    private String nombre;
    private int estacionesDeServicio;
    private boolean tieneBalanza;
    private boolean tieneRadares;
    private int talleresMecanicos;

    public Ciudad(int id, String nombre, int estacionesDeServicio, boolean tieneBalanza, boolean tieneRadares, int talleresMecanicos) {
        this.nombre = nombre;
        this.estacionesDeServicio = estacionesDeServicio;
        this.tieneBalanza = tieneBalanza;
        this.tieneRadares = tieneRadares;
        this.talleresMecanicos = talleresMecanicos;
        this.id = id;
    }

    // Todos O(1)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstacionesDeServicio() {
        return estacionesDeServicio;
    }

    public void setEstacionesDeServicio(int estacionesDeServicio) {
        this.estacionesDeServicio = estacionesDeServicio;
    }

    public boolean isTieneBalanza() {
        return tieneBalanza;
    }

    public void setTieneBalanza(boolean tieneBalanza) {
        this.tieneBalanza = tieneBalanza;
    }

    public boolean isTieneRadares() {
        return tieneRadares;
    }

    public void setTieneRadares(boolean tieneRadares) {
        this.tieneRadares = tieneRadares;
    }

    public int getTalleresMecanicos() {
        return talleresMecanicos;
    }

    public void setTalleresMecanicos(int talleresMecanicos) {
        this.talleresMecanicos = talleresMecanicos;
    }

    public int getId() {
        return id;
    }
}
