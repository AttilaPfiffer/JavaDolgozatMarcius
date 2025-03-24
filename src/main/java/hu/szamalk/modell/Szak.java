package hu.szamalk.modell;

import java.io.*;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class Szak implements Serializable {

    public Tantargy[] targyak;
    public List<String> tantargy;
    private static final String fajl_neve = "targyak.dat";
    private static final String fajl_neve2 = "statisztika.txt";
    private String nev;
    private UUID id;
    private static ArrayList<String> tantargyak;
    private int kredit;


    public Szak(String nev) {
        this.nev = nev;
    }

    public Szak(String nev, ArrayList<String> tantargyak, int kredit) {
        this.nev = nev;
        this.tantargyak = tantargyak;
        this.kredit = kredit;
        ujIdGeneralas();
        szakKiirasa();


    }

    public Szak(Tantargy[] targyak, List<String> tantargy, String nev, UUID id, int kredit) {
        this.targyak = targyak;
        this.tantargy = tantargy;
        this.nev = nev;
        this.kredit = kredit;
        ujIdGeneralas();
    }

    public String getNev() {
        return nev;
    }

    public static ArrayList<String> getTantargyak() {
        return tantargyak;
    }

    public int getKredit() {
        return kredit;
    }

    public List<Tantargy> getTargyak() {
        return List.of(targyak);
    }

    private void ujIdGeneralas() {
        id = UUID.randomUUID();
    }

    public static void szakKiirasa() {
        Szak szak;
        tantargyak = new ArrayList<>();
        tantargyak.add("matematika");
        tantargyak.add("informatika");
        tantargyak.add("történelem");
        tantargyak.add("irodalom");

        try(ObjectOutputStream objKi = new ObjectOutputStream(new FileOutputStream(fajl_neve))) {
            objKi.writeObject(tantargyak);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void szakBeolvasasa() throws IOException {
        try(ObjectInputStream objBe = new ObjectInputStream(new FileInputStream(fajl_neve2))) {
            Szak szak;
            szak = (Szak) objBe.readObject();
            ujIdGeneralas();
            System.out.println("első sor: ");
            System.out.println(szak);
            szak = (Szak) objBe.readObject();
            System.out.println("második sor: ");
            System.out.println(szak);
            szak = (Szak) objBe.readObject();
            System.out.println("harmadik sor: ");
            System.out.println(szak);
            szak = (Szak) objBe.readObject();
            System.out.println("negyedik sor: ");
            System.out.println(szak);
        } catch(FileNotFoundException f){
            throw new RuntimeException();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static NevComparator getTargyakNevSzerint() {
        return new NevComparator();
    }

    private static class NevComparator implements Comparator<Szak> {

        @Override
        public int compare(Szak sz1, Szak sz2) {
            Collator coll = Collator.getInstance();
            return coll.compare(sz1.tantargyak, sz2.tantargyak);
        }
    }

    public static KreditComparator getTargyakKreditSzerint() {
        return new KreditComparator();
    }

    private static class KreditComparator implements Comparator<Szak> {

        @Override
        public int compare(Szak k1, Szak k2) {
            return k1.kredit - k2.kredit;
        }
    }






    @Override
    public String toString() {
        return "Szak{" +
                "nev='" + nev + '\'' +
                ", id=" + id +
                ", tantargyak=" + tantargyak +
                '}';
    }
}
