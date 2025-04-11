package it.prova.test;

import it.prova.model.FiguraGeometrica;
import it.prova.model.Quadrato;
import it.prova.model.TriangoloEquilatero;
import it.prova.model.TriangoloRettangolo;

public class FiguraGeometricaTester {
    public static void main (String[] args) {
        FiguraGeometrica quadrato10 = new Quadrato(10, 10);
        FiguraGeometrica triangoloE15 = new TriangoloEquilatero(15, 17);
        FiguraGeometrica triangoloR = new TriangoloRettangolo(11, 12, 20);

        System.out.println(quadrato10.calcolaArea());
        System.out.println(quadrato10.calcolaPerimetro());

        System.out.println(triangoloE15.calcolaArea());
        System.out.println(triangoloE15.calcolaPerimetro());

        System.out.println(triangoloR.calcolaArea());
        System.out.println(triangoloR.calcolaPerimetro());
    }
}
