package entregable4y5.src;

public class SolucionGrupos {
    private Grupo g1;
    private Grupo g2;
    private int cantidadExploraciones;

    public SolucionGrupos () {
        this.g1 = new Grupo();
        this.g2 = new Grupo();
        this.cantidadExploraciones = 0;
    }

    public Grupo getG1() {
        return g1;
    }

    public Grupo getG2() {
        return g2;
    }

    public int getCantidadTotalEmpleados () {
        return this.g1.getCantEmpleados() + this.g2.getCantEmpleados();
    }

    public void incrementExploraciones () {
        this.cantidadExploraciones++;
    }

    public int getDiferenciaFuerza () {
        return Math.abs(this.g1.getFuerzaTrabajo() - this.g2.getFuerzaTrabajo());
    }

    public void copiar (Grupo g1, Grupo g2) {
        this.g1.copiar(g1);
        this.g2.copiar(g2);
    }

    public String toString () {
        return "Fuerza de trabajo grupo 1: " + this.g1.getFuerzaTrabajo() + " - Fuerza de trabajo grupo 2: " + this.g2.getFuerzaTrabajo() + ". Cantidad de exploraciones: " + this.cantidadExploraciones;
    }
}
