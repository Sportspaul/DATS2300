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

        int[] liste1 = {-1, -2, -7, -34, -3, -99, -64, -12, -5, -999, -43, -123, -55, -86};
        assertEquals(-1, Oblig1.maks(liste1), "Største element ligger ikke sist i arrayet");
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
    void rotasjon1() {
        // En liste fra A - J i alfabetisk rekkefølge
        char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        char[] b = {'J', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
        Oblig1.rotasjon(a);
        assertEquals(Arrays.toString(b), Arrays.toString(a));

        // En tom liste
        char[] tomTabell = {};
        Oblig1.rotasjon(tomTabell);
        assertEquals(tomTabell, tomTabell);

        // En liste med bare et element
        char[] etElement = {'A'};
        Oblig1.rotasjon(etElement);
        assertEquals(etElement, etElement);
    }

    @Test
    void rotasjon2() {
        // Tester for positiv verdi for antall rotasjoner
        char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        char[] b = {'H', 'I', 'J', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        Oblig1.rotasjon(a, 3);
        assertEquals(Arrays.toString(b), Arrays.toString(a));

        // Tester for negativ verdi for antall rotasjoner
        char[] c = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        char[] d = {'D', 'E', 'F', 'G', 'H', 'I', 'J', 'A', 'B', 'C',};
        Oblig1.rotasjon(c, -3);
        assertEquals(Arrays.toString(d), Arrays.toString(c));
    }

    @Test
    void flett() {
        int feil = 0;

        // Test nr. 1
        String a = "ABC";
        String b = "ABC";
        String expected = "AABBCC";
        String c = Oblig1.flett(a,b);
        if(!c.equals(expected)){
            System.out.println("Test 1 feilet");
            feil++;
        }

        // Test nr. 2
        a = "";
        b = "ABC";
        expected = "ABC";
        c = Oblig1.flett(a,b);
        if(!c.equals(expected)){
            System.out.println("Test 2 feilet, expected: " + expected + ", actual: " + c);
            feil++;
        }

        // Test nr. 3
        a = "ABC";
        b = "";
        expected = "ABC";
        c = Oblig1.flett(a,b);
        if(!c.equals(expected)){
            System.out.println("Test 3 feilet, expected: " + expected + ", actual: " + c);
            feil++;
        }

        // Test nr. 4
        a = "";
        b = "";
        expected = "";
        c = Oblig1.flett(a,b);
        if(!c.equals(expected)){
            System.out.println("Test 4 feilet, expected: " + expected + ", actual: " + c);
            feil++;
        }

        // Test nr. 5
        a = "AAAA";
        b = "BB";
        expected = "ABABAA";
        c = Oblig1.flett(a,b);
        if(!c.equals(expected)){
            System.out.println("Test 5 feilet, expected: " + expected + ", actual: " + c);
            feil++;
        }

        // Test nr. 6
        a = "A";
        b = "BCDEF";
        expected = "ABCDEF";
        c = Oblig1.flett(a,b);
        if(!c.equals(expected)){
            System.out.println("Test 6 feilet, expected: " + expected + ", actual: " + c);
            feil++;
        }

        // Test nr. 7
        a = "ACDEF";
        b = "B";
        expected = "ABCDEF";
        c = Oblig1.flett(a,b);
        if(!c.equals(expected)){
            System.out.println("Test 7 feilet, expected: " + expected + ", actual: " + c);
            feil++;
        }

        // Test nr. 7
        a = "ACDEFACDEFACDEFACDEF";
        b = "ACDEFACDEFACDEFACDEF";
        expected = "AACCDDEEFFAACCDDEEFFAACCDDEEFFAACCDDEEFF";
        c = Oblig1.flett(a,b);
        if(!c.equals(expected)){
            System.out.println("Test 7 feilet, expected: " + expected + ", actual: " + c);
            feil++;
        }




        assertEquals(0, feil, "Implementer flett og denne testen");
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
    void inneholdt() {
        int feil = 0;

        // Test1
        String a = "ABBA";
        String b = "ABBA";
        if (Oblig1.inneholdt(a, b) == false) {
            System.out.println("Test 1 feilet, feil når s1 og s2 er like");
            feil++;
        }

        // Test2
        String c = "ABBA";
        String d = "ABCABC";
        if(Oblig1.inneholdt(c, d) == false){
            System.out.println("Test 2 feilet, feil når s1 = '" + c + "' og s2 = '" + d + "'");
            feil++;
        }

        // Test3 - metoden skal returnere false hvis s1 er lenger enn s2
        String e = "BBBBBB";
        String f = "BBB";
        if(Oblig1.inneholdt(e, f) == true){
            System.out.println("Test 3 feilet, feil når s1 = '" + e + "' og s2 = '" + f + "'");
            feil++;
        }

        // Test4
        String g = "AABB";
        String h = "ABDF";
        if(Oblig1.inneholdt(g, h) == true){
            System.out.println("Test 4 feilet, feil når s1 = '" + c + "' og s2 = '" + d + "'");
            feil++;
        }

        // Test4
        String i = "";
        String j = "";
        if(Oblig1.inneholdt(g, h) == true){
            System.out.println("Test 5 feilet, feil når s1 = '" + c + "' og s2 = '" + d + "'");
            feil++;
        }


        assertEquals(0, feil, "Metoden har " + feil + " feil som må fikses");
    }
}