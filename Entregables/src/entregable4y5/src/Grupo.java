package entregable4y5.src;

import java.util.ArrayList;

public class Grupo {
    private ArrayList<Empleado> empleados;
    private int fuerzaTrabajo;

    public Grupo () {
        this.empleados = new ArrayList<>();
        this.fuerzaTrabajo = 0;
    }

    public void addEmpleado (Empleado e) {
        if (!this.empleados.contains(e)) {
            this.empleados.add(e);
            this.fuerzaTrabajo += e.getFuerza();
        }
    }

    public int getCantEmpleados () {
        return this.empleados.size();
    }

    public void removeEmpleado (Empleado e) {
        this.empleados.remove(e);
        this.fuerzaTrabajo -= e.getFuerza();
    }

    public int getFuerzaTrabajo () {
        return this.fuerzaTrabajo;
    }

    public ArrayList<Empleado> getEmpleados () {
        return new ArrayList<>(this.empleados);
    }

    public void copiar (Grupo g) {
        this.empleados = new ArrayList<>();
        this.empleados.addAll(g.getEmpleados());
        this.fuerzaTrabajo = g.getFuerzaTrabajo();
    }

    public String toString () {
        return this.fuerzaTrabajo + "";
    }
}
