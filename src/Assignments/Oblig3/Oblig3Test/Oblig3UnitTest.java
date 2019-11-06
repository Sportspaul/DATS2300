package Assignments.Oblig3.Oblig3Test;

import Assignments.Oblig3.ObligSBinTre;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class Oblig3UnitTest {

    @Test
    void LeggInnTest() {
        Integer[] a = {4,7,2,9,5,10,8,1,3,6};
        ObligSBinTre<Integer> tre = new ObligSBinTre<>(Comparator.naturalOrder());
        for(int verdi : a) {
            tre.leggInn(verdi);
        }
        System.out.println(tre.antall()); // Utskrift: 10
    }

    @Test
    void AntallTest() {
        Integer[] a = {4,7,2,9,4,10,8,7,4,6};
        ObligSBinTre<Integer> tre = new ObligSBinTre<>(Comparator.naturalOrder());
        for(int verdi : a) tre.leggInn(verdi);

        System.out.println(tre.antall()); // Utskrift: 10
        System.out.println(tre.antall(5)); // Utskrift: 0
        System.out.println(tre.antall(4)); // Utskrift: 3
        System.out.println(tre.antall(7)); // Utskrift: 2
        System.out.println(tre.antall(10)); // Utskrift: 1
    }

    @Test
    void Oppgave5Test() {
        int [] a = {4,7,2,9,4,10,8,7,4,6,1};ObligSBinTre<Integer> tre = new ObligSBinTre<>(Comparator.naturalOrder());
        for(int verdi: a) tre.leggInn(verdi);
        System.out.println(tre.fjernAlle(4)); // 3
        tre.fjernAlle(7); tre.fjern(8);
        System.out.println(tre.antall()); // 5
        System.out.println(tre + " " + tre.toString());
        //System.out.println(tre + "​ ​"+ tre.omvendtString());
            // [1, 2, 6, 9, 10] [10, 9, 6, 2, 1]
           // OBS: Hvis du ikke har gjort oppgave 4 kan du her bruke toString()
    }

    @Test
    void høyreGrenTest() {
        ObligSBinTre<Character> tre = new ObligSBinTre<>(Comparator.naturalOrder());
        char[] verdier = "IATBHJCRSOFELKGDMPQN".toCharArray();
        for(char c: verdier) tre.leggInn(c);

        assertEquals("[I, T, J, R, S]", tre.høyreGren());

    }

    @Test
    void lengsteGrenTest() {
        ObligSBinTre<Character> tre = new ObligSBinTre<>(Comparator.naturalOrder());
        char[] verdier = "IATBHJCRSOFELKGDMPQN".toCharArray();
        for(char c: verdier) tre.leggInn(c);

        tre.lengstGren();
        assertEquals("[I, A, B, H, C, F, E, D]", tre.lengstGren());
    }

    @Test
    void nesteInorden() {
        Integer[] a = {4,7,2,9,4,10,8,7,4,6,1};
        ObligSBinTre<Integer> tre = new ObligSBinTre<>(Comparator.naturalOrder());
        for(int verdi : a) {
            tre.leggInn(verdi);
        }
        assertEquals("[1, 2, 4, 4, 4, 6, 7, 7, 8, 9, 10]", tre.toString());
    }

    @Test
    void omvendtString() {
        Integer[] a = {4,7,2,9,4,10,8,7,4,6};
        ObligSBinTre<Integer> tre = new ObligSBinTre<>(Comparator.naturalOrder());
        for(int verdi : a) {
            tre.leggInn(verdi);
        }
        assertEquals("[10, 9, 8, 7, 7, 6, 4, 4, 4, 2]", tre.omvendtString());

        Integer[] b = {};
        ObligSBinTre<Integer> tre2 = new ObligSBinTre<>(Comparator.naturalOrder());
        for(int verdi : b) {
            tre2.leggInn(verdi);
        }
        assertEquals("[]", tre2.omvendtString());
    }

    @Test
    void fjernTest() {
        int[] a = {4, 7, 2, 9, 4, 10, 8, 7, 4, 6, 1};
        ObligSBinTre<Integer> tre = new ObligSBinTre<>(Comparator.naturalOrder());
        for (int verdi : a) tre.leggInn(verdi);
        System.out.println(tre.toString());
        tre.fjernAlle(4);
        System.out.println(tre.toString());
        tre.fjernAlle(7);
        System.out.println(tre.toString());
        tre.fjernAlle(8);
        System.out.println(tre.toString());
        System.out.println(tre.antall());

    }

    @Test
    void nullstrillTest() {
        int[] a = {4, 7, 2, 9, 4, 10, 8, 7, 4, 6, 1};
        ObligSBinTre<Integer> tre = new ObligSBinTre<>(Comparator.naturalOrder());
        for (int verdi : a) tre.leggInn(verdi);

        tre.nullstill();
    }

    @Test
    void postStringTest() {
        ObligSBinTre<Character> tre = new ObligSBinTre<>(Comparator.naturalOrder());
        char[] verdier = "IATBHJCRSOFELKGDMPQN".toCharArray();
        for(char c: verdier) tre.leggInn(c);


    }

    @Test
    void bladNode() {
        int[] a = {5, 2, 1, 3, 7, 9, 6};
        ObligSBinTre<Integer> tre = new ObligSBinTre<>(Comparator.naturalOrder());
        for (int verdi : a) tre.leggInn(verdi);

        tre.bladnodeverdier();
        assertEquals("[1, 3, 6, 9]", tre.bladnodeverdier());
    }
}