package P3;

public class Main {

    public static void main(String[] args) {

        Mapa mapa = new Mapa();
        Ciudad tandil = new Ciudad(1,"Tandil", 6, true, true, 5);
        Ciudad mardel = new Ciudad(2,"Mar del plata", 15, true, false, 12);
        Ciudad rauch = new Ciudad(3,"Rauch", 1, false, true, 0);
        Ciudad bolivar = new Ciudad(4,"Bolivar", 7, false, false, 4);
        Ciudad olavarria = new Ciudad(5,"Olavarria", 9, true, false, 17);
        Ciudad ayacucho = new Ciudad(6,"Ayacucho", 1, false, false, 5);
        Ciudad pehuajo = new Ciudad(7,"Pehuajo", 3, true, true, 5);
        Ciudad azul = new Ciudad(8,"Azul", 4, false, true, 4);



        mapa.addCiudad(tandil);
        mapa.addCiudad(mardel);
        mapa.addCiudad(azul);
        mapa.addCiudad(rauch);
        mapa.addCiudad(bolivar);
        mapa.addCiudad(olavarria);
        mapa.addCiudad(ayacucho);
        mapa.addCiudad(pehuajo);

        mapa.agregarRuta(azul, bolivar, 100);
        mapa.agregarRuta(bolivar, pehuajo, 70);
        mapa.agregarRuta(bolivar, olavarria, 140);
        mapa.agregarRuta(olavarria, rauch, 210);
        mapa.agregarRuta(olavarria, tandil, 130);
        mapa.agregarRuta(rauch, ayacucho, 50);
        mapa.agregarRuta(tandil, mardel, 200);
        mapa.agregarRuta(tandil, ayacucho, 70);
        mapa.agregarRuta(tandil, rauch, 60);
        mapa.agregarRuta(ayacucho, pehuajo, 540);

        /*
        origen: Azul - destino: Ayacucho
        origen: Rauch - destino: Mar del plata
        origen: Mar del plata - destino: Pehuajo
        eliminar la ciudad Ayacucho.
        eliminar la ruta Tandil - Rauch
        origen: Mar del plata - destino Pehuajo
         */
        System.out.println(mapa.obtenerRutaMasCorta(azul, ayacucho));
        System.out.println(mapa.obtenerRutaMasCorta(rauch, mardel));
        System.out.println(mapa.obtenerRutaMasCorta(mardel, pehuajo));
        mapa.borrarCiudad(ayacucho);
        mapa.borrarRuta(tandil, rauch);
        System.out.println(mapa.obtenerRutaMasCorta(mardel, pehuajo));

    }

}