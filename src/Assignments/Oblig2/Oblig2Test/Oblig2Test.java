package Assignments.Oblig2.Oblig2Test;

import Assignments.Oblig2.DobbeltLenketListe;
import Assignments.Oblig2.Liste;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>(aInteger);

        if(liste.antall() != 5){
            antallFeil++;
            System.out.println("Feil i antall variabelen, Expected: " + 5 + " Actual: " + liste.antall());
        }

        Integer[] bInteger = new Integer[] {1, null, null, 2, 3};
        DobbeltLenketListe<Integer> liste2 = new DobbeltLenketListe<>(bInteger);

        if(liste2.antall() != 3){
            antallFeil++;
            System.out.println("Feil i antall variabelen, Expected: " + 3 + " Actual: " + liste2.antall());
        }

        assertEquals(0, antallFeil, "Testen har: " + antallFeil + " feil");
    }

    @Test
    void fjernNullVerdierTest() {

        Integer[] bInteger = new Integer[] {1, null, null, 2, 3};
        DobbeltLenketListe<Integer> liste2 = new DobbeltLenketListe<>(bInteger);

        System.out.println(Arrays.toString(liste2.fjernNullVerdier(bInteger)));
    }

}
