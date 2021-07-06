package entregable4y5.src;

import org.jetbrains.annotations.NotNull;

public class Empleado implements Comparable<Empleado>{
    private String nombre;
    private String apellido;
    private int edad;
    private int fuerza;

    public Empleado (String nombre, String apellido, int edad, int fuerza) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fuerza = fuerza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    @Override
    public int compareTo(@NotNull Empleado o) {
        return this.getFuerza() - o.getFuerza();
    }
}
