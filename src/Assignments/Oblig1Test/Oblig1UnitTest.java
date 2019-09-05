package Assignments.Oblig1Test;

import Assignments.Oblig1.Oblig1;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Denne klassen kan du bruke til hjelp under utvikling av din oblig.
 * Lag små og enkle test-eksempler for å teste at metoden din fungerer som ønsket.
 */
class Oblig1UnitTest {

    @Test
    void maks() {
        int[] liste = {1, 2, 7, 34, 3, 99, 64, 12, 5, 999, 43, 123, 55, 86};
        assertEquals(999, Oblig1.maks(liste), "Største element ligger ikke sist i arrayet");
        System.out.println(Oblig1.maks(liste));
        System.out.println("Testen er bestått");

        int[] liste1 = {-1, -2, -7, -34, -3, -99, -64, -12, -5, -999, -43, -123, -55, -86};
        assertEquals(-1, Oblig1.maks(liste1), "Største element ligger ikke sist i arrayet");
        System.out.println("Testen er bestått");
        System.out.println(Oblig1.maks(liste1));
    }

    @Test
    void ombyttinger() {

        int n = 100; int i =1;
        int sum = 0;

        while(i < n){
            int[] heltall = Oblig1Test.randPerm(15);
            int ant = Oblig1.ombyttinger(heltall);
            System.out.println("Antall ombyttinger: " + ant);
            sum += ant;
            //sum = sum + ant;
            System.out.println(sum);
            i++;
        }
        double snitt = sum/n;
        System.out.println("Gjennomsnittlig antall ombyttinger er: " + snitt);
    }

    @Test
    void antallUlikeSortert() {
        assertEquals(true, false, "Implementer antallUlikeSortert og denne testen");
        System.out.println("Testen er bestått");
    }

    @Test
    void antallUlikeUsortert() {
        assertEquals(true, false, "Implementer antallUlikeUsortert og denne testen");
        System.out.println("Testen er bestått");
    }

    @Test
    void delsortering() {
        assertEquals(true, false, "Implementer delsortering og denne testen");
        System.out.println("Testen er bestått");
    }

    @Test
    void rotasjon1() {
        // En liste fra A - J i alfabetisk rekkefølge
        char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        char[] b = {'J', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
        Oblig1.rotasjon(a);
        assertEquals(Arrays.toString(b), Arrays.toString(a));
        System.out.println("Testen er bestått");

        // En tom liste
        char[] tomTabell = {};
        Oblig1.rotasjon(tomTabell);
        assertEquals(tomTabell, tomTabell);
        System.out.println("Testen er bestått");

        // En liste med bare et element
        char[] etElement = {'A'};
        Oblig1.rotasjon(etElement);
        assertEquals(etElement, etElement);
        System.out.println("Testen er bestått");
    }

    @Test
    void rotasjon2() {
        // Tester for positiv verdi for antall rotasjoner
        char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        char[] b = {'H', 'I', 'J', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        Oblig1.rotasjon(a, 3);
        assertEquals(Arrays.toString(b), Arrays.toString(a));
        System.out.println("Testen er bestått");

        // Tester for negativ verdi for antall rotasjoner
        char[] c = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        char[] d = {'D', 'E', 'F', 'G', 'H', 'I', 'J', 'A', 'B', 'C',};
        Oblig1.rotasjon(c, -3);
        assertEquals(Arrays.toString(d), Arrays.toString(c));
        System.out.println("Testen er bestått");
    }

    @Test
    void flett() {
        assertEquals(true, false, "Implementer flett og denne testen");
        System.out.println("Testen er bestått");
    }

    @Test
    void indekssortering() {
        assertEquals(true, false, "Implementer indekssortering og denne testen");
        System.out.println("Testen er bestått");
    }

    @Test
    void tredjeMin() {
        assertEquals(true, false, "Implementer tredjeMin og denne testen");
        System.out.println("Testen er bestått");
    }

    @Test
    void inneholdt() {
        String t = "";
        String test = "AVCDFEFE";
        char [] letters = test.toCharArray();
        assertEquals(true, Oblig1.inneholdt(t,test));
        System.out.println("Testen er bestått");
    }
}