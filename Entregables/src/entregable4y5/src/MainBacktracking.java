package entregable4y5.src;

import java.util.ArrayList;

public class MainBacktracking {
    public static void main(String[] args) {
        Empleado e1 = new Empleado("Juan", "Perez", 32, 48);
        Empleado e2 = new Empleado("Roberto", "Hernandez", 45, 57);
        Empleado e3 = new Empleado("Camila", "Gutierrez", 19, 51);
        Empleado e4 = new Empleado("Francisco", "Martinez", 19, 73);
        Empleado e5 = new Empleado("Benjamin", "Nunez", 19, 15);
        Empleado e6 = new Empleado("Mateo", "Morales", 19, 33);
        Empleado e7 = new Empleado("Delfina", "Lopez", 19, 92);
        Empleado e8 = new Empleado("Catalina", "Cruz", 19, 71);
        Empleado e9 = new Empleado("Benicio", "Montero", 19, 19);
        Empleado e10 = new Empleado("Valentino", "Gonzalez", 19, 22);
        Empleado e11 = new Empleado("Olivia", "Gomez", 19, 41);
        Empleado e12 = new Empleado("Martina", "Diaz", 19, 49);
        Empleado e13 = new Empleado("Joaquin", "Cabrera", 19, 14);
        Empleado e14 = new Empleado("Bautista", "Dominguez", 19, 33);
        Empleado e15 = new Empleado("Emilia", "Paz", 19, 16);
        Empleado e16 = new Empleado("Francesca", "Figueroa", 19, 21);
        Empleado e17 = new Empleado("Santino", "Blanco", 19, 79);
        Empleado e18 = new Empleado("Ignacio", "Ibarra", 19, 32);
        Empleado e19 = new Empleado("Andrea", "Chavez", 19, 78);
        Empleado e20 = new Empleado("Elena", "Mengochea", 19, 67);


        ArrayList<Empleado> entrada1 = new ArrayList<>();
        entrada1.add(e1);
        entrada1.add(e2);
        entrada1.add(e3);
        entrada1.add(e4);
        entrada1.add(e5);
        entrada1.add(e6);

        ArrayList<Empleado> entrada2 = new ArrayList<>();
        entrada2.add(e7);
        entrada2.add(e4);
        entrada2.add(e8);
        entrada2.add(e15);

        ArrayList<Empleado> entrada3 = new ArrayList<>();
        entrada3.add(e19);
        entrada3.add(e12);
        entrada3.add(e11);
        entrada3.add(e13);

        ArrayList<Empleado> entrada4 = new ArrayList<>();
        entrada4.add(e19);
        entrada4.add(e18);
        entrada4.add(e14);
        entrada4.add(e16);

        ArrayList<Empleado> entrada5 = new ArrayList<>();
        entrada5.add(e7);
        entrada5.add(e8);
        entrada5.add(e20);
        entrada5.add(e3);
        entrada5.add(e16);

        ArrayList<Empleado> entrada6 = new ArrayList<>();
        entrada6.add(e6);
        entrada6.add(e15);
        entrada6.add(e17);
        entrada6.add(e13);
        entrada6.add(e16);
        entrada6.add(e10);

        ArrayList<Empleado> entrada7 = new ArrayList<>();
        entrada7.add(e17);
        entrada7.add(e2);
        entrada7.add(e19);
        entrada7.add(e20);
        entrada7.add(e4);
        entrada7.add(e12);
        entrada7.add(e15);

        ArrayList<Empleado> entrada8 = new ArrayList<>();
        entrada8.add(e12);
        entrada8.add(e14);
        entrada8.add(e18);
        entrada8.add(e6);
        entrada8.add(e2);
        entrada8.add(e9);
        entrada8.add(e10);
        entrada8.add(e16);

        ArrayList<Empleado> entrada9 = new ArrayList<>();
        entrada9.add(e1);
        entrada9.add(e2);
        entrada9.add(e3);
        entrada9.add(e4);
        entrada9.add(e5);
        entrada9.add(e6);
        entrada9.add(e7);
        entrada9.add(e8);
        entrada9.add(e9);
        entrada9.add(e10);
        entrada9.add(e11);
        entrada9.add(e12);
        entrada9.add(e13);
        entrada9.add(e14);
        entrada9.add(e15);
        entrada9.add(e16);
        entrada9.add(e17);
        entrada9.add(e18);
        entrada9.add(e19);
        entrada9.add(e20);

        Backtracking b = new Backtracking();

        System.out.println(b.backtracking(entrada1));
        System.out.println(b.backtracking(entrada2));
        System.out.println(b.backtracking(entrada3));
        System.out.println(b.backtracking(entrada4));
        System.out.println(b.backtracking(entrada5));
        System.out.println(b.backtracking(entrada6));
        System.out.println(b.backtracking(entrada7));
        System.out.println(b.backtracking(entrada8));
        System.out.println(b.backtracking(entrada9));
    }
}
