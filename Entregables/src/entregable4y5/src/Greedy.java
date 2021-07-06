package entregable4y5.src;

import java.util.ArrayList;
import java.util.Collections;

public class Greedy {


    public SolucionGrupos greedy(ArrayList<Empleado> empleados) {
        //Collections.sort(empleados);
        // Se pueden ordenar por fuerza los empleados. Pero ejecute las pruebas y me da peores resultados.
        SolucionGrupos grupos = new SolucionGrupos();
        for (Empleado empleado : empleados) {
            this.seleccionar(grupos.getG1(), grupos.getG2()).addEmpleado(empleado);
            grupos.incrementExploraciones();
        }
        return grupos;
    }

    private Grupo seleccionar (Grupo g1, Grupo g2) {
        return g1.getFuerzaTrabajo() < g2.getFuerzaTrabajo() ? g1 : g2;
    }
}
