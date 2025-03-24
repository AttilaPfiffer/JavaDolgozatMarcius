package hu.szamalk.modell;

import java.util.ArrayList;

public class Tantargy {
    private String nev;
    private int kredit;
    private ArrayList<String> tanarok;
    private int felev;
    private boolean vizsga;




    public Tantargy(String nev) {
        this.nev = nev;
    }

    public Tantargy(String nev, int kredit, ArrayList<String> tanarok, int felev, boolean vizsga) {
        this.nev = nev;
        this.kredit = kredit;
        this.tanarok = tanarok;
        this.felev = felev;
        this.vizsga = vizsga;
    }

    public Tantargy() {
        this.kredit = 0;
    }


    public String getNev() {
        return nev;
    }



    public int getKredit() {
        return kredit;
    }



    @Override
    public String toString() {
        return "Tantargy{" +
                "nev='" + nev + '\'' +
                ", kredit=" + kredit +
                ", tanarok=" + tanarok +
                ", felev=" + felev +
                ", vizsga=" + vizsga +
                '}';
    }
}
