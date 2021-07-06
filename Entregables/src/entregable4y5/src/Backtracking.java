package entregable4y5.src;

import java.util.ArrayList;

public class Backtracking {

    public SolucionGrupos backtracking (ArrayList<Empleado> empleados) {
        return this.backtracking(empleados, new SolucionGrupos(), new SolucionGrupos(), 0);
    }

    private SolucionGrupos backtracking (ArrayList<Empleado> empleados, SolucionGrupos solucion, SolucionGrupos solucionActual, int desde) {
        solucion.incrementExploraciones();

        if (this.esSolucion(solucionActual, empleados.size())) {
            if (this.esFactible(solucion, solucionActual))
                solucion.copiar(solucionActual.getG1(), solucionActual.getG2());
        }
        else {
            // Por cada empleado tengo que buscar todas las soluciones posibles.

            //Todas las soluciones si lo agrego al grupo 1.
            if (!this.esMejorSolucion(solucion)) {
                solucionActual.getG1().addEmpleado(empleados.get(desde));
                solucion = this.backtracking(empleados, solucion, solucionActual, desde + 1);
                solucionActual.getG1().removeEmpleado(empleados.get(desde));
            }

            // Repito el if dos veces porque pude haber conseguido la mejor solucion en la busqueda de arriba.

            // Todas las soluciones si lo agrego al grupo 2.
            if (!this.esMejorSolucion(solucion)) {
                solucionActual.getG2().addEmpleado(empleados.get(desde));
                solucion = this.backtracking(empleados, solucion, solucionActual, desde + 1);
                solucionActual.getG2().removeEmpleado(empleados.get(desde));
            }
        }
        return solucion;
    }

    private boolean esFactible (SolucionGrupos solucion, SolucionGrupos solucionActual) {
        int diferenciaFuerzaSolucion = solucion.getDiferenciaFuerza();
        int diferenciaFuerzaActual = solucionActual.getDiferenciaFuerza();
        return (solucion.getCantidadTotalEmpleados() == 0 || diferenciaFuerzaActual < diferenciaFuerzaSolucion);
    }

    private boolean esSolucion (SolucionGrupos solucionActual, int empleadosSize) {
        return solucionActual.getCantidadTotalEmpleados() == empleadosSize;
    }

    private boolean esMejorSolucion (SolucionGrupos solucion) {
        return (solucion.getCantidadTotalEmpleados() > 0 && solucion.getDiferenciaFuerza() == 0);
    }
}
