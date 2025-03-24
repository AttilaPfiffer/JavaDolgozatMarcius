package hu.szamalk;

import hu.szamalk.modell.MinimumKreditException;
import hu.szamalk.modell.Szak;
import hu.szamalk.modell.Tantargy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class SzakTest {
    Szak szak;
    @BeforeEach
    void ini(){
        szak = new Szak("egy szak neve");
    }

    @Test
    void testSzakTargyNevek(){
        for (Tantargy tantargy : szak.targyak) {
            Assertions.assertTrue(tantargy.getNev().length() > 3);
        }
    }

    @Test
    void testGetTargyak(){
        List<Tantargy> targyak = szak.getTargyak();
        int eredeti = targyak.size();
        targyak.add(new Tantargy());
        Assertions.assertTrue(eredeti == szak.getTargyak().size());
    }

    @Test
    void kreditMinimum() {
        szak = new Szak();

    }

}