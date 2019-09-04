package Assignments.Oblig1Test;

import Assignments.Oblig1.Oblig1;
import org.junit.jupiter.api.Test;

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
    }

    @Test
    void antallUlikeUsortert() {
        assertEquals(true, false, "Implementer antallUlikeUsortert og denne testen");
    }

    @Test
    void delsortering() {
        assertEquals(true, false, "Implementer delsortering og denne testen");
    }

    @Test
    void rotasjon() {
        assertEquals(true, false, "Implementer rotasjon og denne testen");
    }

    @Test
    void flett() {
        assertEquals(true, false, "Implementer flett og denne testen");
    }

    @Test
    void indekssortering() {
        assertEquals(true, false, "Implementer indekssortering og denne testen");
    }

    @Test
    void tredjeMin() {
        assertEquals(true, false, "Implementer tredjeMin og denne testen");
    }

    @Test
    void bokstavNr() {
        assertEquals(true, false, "Implementer bokstavNr og denne testen");
    }

    @Test
    void inneholdt() {
        assertEquals(true, false, "Implementer inneholdt og denne testen");
    }
}