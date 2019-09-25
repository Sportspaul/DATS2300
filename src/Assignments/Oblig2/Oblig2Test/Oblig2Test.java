package Assignments.Oblig2.Oblig2Test;

import Assignments.Oblig2.DobbeltLenketListe;
import Assignments.Oblig2.Liste;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Oblig2Test {


    @Test
    void instansTest() {
        Liste<String> liste = new DobbeltLenketListe<>();
    }

    // Tester konstruktør med et array som argument
    @Test
    void instansTest2() {
        int antallFeil = 0;

        int[] a = {1, 2, 3, 4, 5};

        Integer[] aInteger = new Integer[a.length];
        for(int i = 0; i < a.length; i++) {
            aInteger[i] = Integer.valueOf(a[i]);
        }

        Liste<Integer> liste = new DobbeltLenketListe<>(aInteger);

        if(liste.antall() != 5){
            System.out.println("Feil i antall variabelen, Expected: " + 5 + " Actual: " + liste.antall());
        }

        assertEquals(0, antallFeil, "Testen har: " + antallFeil + " feil");
    }

}
