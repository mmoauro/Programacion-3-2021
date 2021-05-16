package P3;

public class Main {

    public static void main(String[] args) {
        /*

        // Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
        GrafoDirigido<Float> grafito = new GrafoDirigido<>();

        // Agrego los vertices 1 y 2
        grafito.agregarVertice(1);
        grafito.agregarVertice(2);
        grafito.agregarVertice(6);
        grafito.agregarVertice(120);

        // Genero un arco desde 1 hasta 2 con el valor de etiqueta 3
        grafito.agregarArco(1, 2, 3F);
        grafito.agregarArco(2, 1, 2F);
        grafito.agregarArco(2, 120, 2F);

        // Obtengo el arco entre 1 y 2, y le pido la etiqueta
        Float etiqueta = grafito.obtenerArco(1, 2).getEtiqueta();

        System.out.println(etiqueta); // Debería imprimir 3
        DFS dfs = new DFS(grafito);
        System.out.println(dfs.dfs());
         */
        Mapa mapa = new Mapa();
        Ciudad tandil = new Ciudad("Tandil", 10, true, true, 15);
        Ciudad mardel = new Ciudad("Mar del plata", 10, true, true, 15);
        Ciudad rauch = new Ciudad("Rauch", 10, true, true, 15);
        Ciudad bolivar = new Ciudad("Bolivar", 10, true, true, 15);
        Ciudad olavarria = new Ciudad("Olavarria", 10, true, true, 15);
        Ciudad ayacucho = new Ciudad("Ayacucho", 10, true, true, 15);
        Ciudad pehuajo = new Ciudad("Pehuajo", 10, true, true, 15);
        Ciudad azul = new Ciudad("Azul", 10, true, true, 15);



        mapa.addCiudad(tandil);
        mapa.addCiudad(mardel);
        mapa.addCiudad(azul);
        mapa.addCiudad(rauch);
        mapa.addCiudad(bolivar);
        mapa.addCiudad(olavarria);
        mapa.addCiudad(ayacucho);
        mapa.addCiudad(pehuajo);

        mapa.agregarRuta(azul, bolivar, 100);
        mapa.agregarRuta(bolivar, pehuajo, 100);
        mapa.agregarRuta(bolivar, olavarria, 100);
        mapa.agregarRuta(olavarria, rauch, 100);
        mapa.agregarRuta(olavarria, tandil, 100);
        mapa.agregarRuta(rauch, ayacucho, 100);
        mapa.agregarRuta(tandil, mardel, 100);
        mapa.agregarRuta(tandil, ayacucho, 100);
        mapa.agregarRuta(tandil, rauch, 100);
        mapa.agregarRuta(ayacucho, pehuajo, 100);

        System.out.println(mapa.obtenerRutas(pehuajo, azul));

    }

}