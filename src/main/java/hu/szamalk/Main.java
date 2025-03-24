package hu.szamalk;

import hu.szamalk.modell.Szak;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Szak> szakokLista = new ArrayList<>();

    public static void main(String[] args) {


        Szak.szakKiirasa();

        System.out.println("Rendezesek: ");
        szakokLista.sort(Szak.getTargyakNevSzerint());
        System.out.println("---- \nnév szerint: ");


        szakokLista.sort(Szak.getTargyakKreditSzerint());
        System.out.println("---- \nkredit szerint: ");
    }
}