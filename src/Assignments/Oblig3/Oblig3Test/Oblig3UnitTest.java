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
}

    @Test
    void nesteInorden() {
        Integer[] a = {4,7,2,9,4,10,8,7,4,6};
        ObligSBinTre<Integer> tre = new ObligSBinTre<>(Comparator.naturalOrder());
        for(int verdi : a) {
            tre.leggInn(verdi);
        }
        assertEquals("[2, 4, 4, 4, 6, 7, 7, 8, 9, 10]", tre.toString());
    }
}