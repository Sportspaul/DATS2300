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
        int[] a = {6, 5, 4, 3, 2, 1};
        int[] b = {1, 2, 3, 4, 5};
        int[] c = {4, 9, 3, 6, 1, 5, 7, 8, 10, 2};
        int[] d = {2, 5, 8, 4, 3, 10, 1, 7, 6, 9};

        if (Oblig1.ombyttinger(a) != 5) {
            System.out.println("Oppgave 1: " + Oblig1.ombyttinger(a));
        }
        if (Oblig1.ombyttinger(b) != 0) {
            System.out.println("Oppgave 2: " + Oblig1.ombyttinger(b));
        }
        if (Oblig1.ombyttinger(c) != 7) {
            System.out.println("Oppgave 3: " +Oblig1.ombyttinger(c));
        }
        if (Oblig1.ombyttinger(d) != 6) {
            System.out.println("Oppgave 4: " + Oblig1.ombyttinger(d));
        }





      /*  int n = 100; int i =1;
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
        System.out.println("Gjennomsnittlig antall ombyttinger er: " + snitt); */
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
        String expected1 = "AABBCC";
        String c1 = Oblig1.flett(a,b);
        if(!c1.equals(expected1)){
            System.out.println("Test 1 feilet,  expected: " + expected1 + ", actual: " + c1);
            feil++;
        }
        System.out.println(c1 + " forventet:" + expected1);

        // Test nr. 2
        a = "";
        b = "ABC";
        String expected2 = "ABC";
        String c2 = Oblig1.flett(a,b);
        if(!c2.equals(expected2)){
            System.out.println("Test 2 feilet, expected: " + expected2 + ", actual: " + c2);
            feil++;
        }
        System.out.println(c2 + " forventet:" + expected2);

        // Test nr. 3
        a = "ABC";
        b = "";
        String expected3 = "ABC";
        String c3 = Oblig1.flett(a,b);
        if(!c3.equals(expected3)){
            System.out.println("Test 3 feilet, expected: " + expected3 + ", actual: " + c3);
            feil++;
        }
        System.out.println(c3 + " forventet:" + expected3);

        // Test nr. 4
        a = "";
        b = "";
        String expected4 = "";
        String c4 = Oblig1.flett(a,b);
        if(!c4.equals(expected4)){
            System.out.println("Test 4 feilet, expected: " + expected4 + ", actual: " + c4);
            feil++;
        }
        System.out.println(c4 + "(tom)" + " forventet:" + expected4 + " (tom)");

        // Test nr. 5
        a = "AAAA";
        b = "BB";
        String expected5 = "ABABAA";
        String c5 = Oblig1.flett(a,b);
        if(!c5.equals(expected5)){
            System.out.println("Test 5 feilet, expected: " + expected5 + ", actual: " + c5);
            feil++;
        }
        System.out.println(c5 + " forventet:" + expected5);

        // Test nr. 6
        a = "A";
        b = "BCDEF";
        String expected6 = "ABCDEF";
        String c6 = Oblig1.flett(a,b);
        if(!c6.equals(expected6)){
            System.out.println("Test 6 feilet, expected: " + expected6 + ", actual: " + c6);
            feil++;
        }
        System.out.println(c6 + " forventet:" + expected6);

        // Test nr. 7
        a = "ACDEF";
        b = "B";
        String expected7 = "ABCDEF";
        String c7 = Oblig1.flett(a,b);
        if(!c7.equals(expected7)){
            System.out.println("Test 7 feilet, expected: " + expected7 + ", actual: " + c7);
            feil++;
        }
        System.out.println(c7 + " forventet:" + expected7);

        // Test nr. 8
        String a8 = "ACDEFACDEFACDEFACDEF";
        String b8 = "ACDEFACDEFACDEFACDEF";
        String expected8 = "AACCDDEEFFAACCDDEEFFAACCDDEEFFAACCDDEEFF";
        String c8 = Oblig1.flett(a8,b8);
        if(!c8.equals(expected8)){
            System.out.println("Test 8 feilet, expected: " + expected8 + ", actual: " + c8);
            feil++;
        }
        System.out.println(c8 + " forventet:" + expected8);

    }

    @Test
    void indekssortering() {
        assertEquals(true, false, "Implementer indekssortering og denne testen");
    }

    @Test
    void tredjeMin() {
        /* Test1
        int [] verdier1 = {1,2};
        System.out.println("Tester om arrayet {1,2} kaster et unntak:");
        Oblig1.tredjeMin(verdier1); */

        //Test2
        int [] tabell ={1,2,3,10,7,5,6,4};
        int [] res = {0,1,2};
        assertArrayEquals(res, Oblig1.tredjeMin(tabell),"Indeksene er ikke sortert i stigende rekkefølge");
        int [] test2 = Oblig1.tredjeMin(tabell);
        System.out.println(" Arrayet {1,2,3,10,7,5,6,4} skal gi {0,1,2}, Oblig1.tredjeMin(tabell):\n {" + test2[0] + "," +
                test2[1] +"," + test2[2] +"}"  );


        //Test3
        int [] tabell1 ={10,7,5,6,2,4,1,3};
        int [] res1 = {6,4,7};
        assertArrayEquals(res1, Oblig1.tredjeMin(tabell1),"Indeksene er ikke sortert i stigende rekkefølge");
        int [] test3 = Oblig1.tredjeMin(tabell1);
        System.out.println(" Arrayet {10,7,5,6,2,4,1,3} skal gi {6,4,7}, Oblig1.tredjeMin(tabell1):\n {" + test3[0] + "," +
                test3[1] +"," + test3[2] +"}"  );

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
        } else {
            System.out.println("Strengen "+ a + " er inneholdt i " + b + " ,Oblig1.inneholdt(a, b): " + Oblig1.inneholdt(a, b));
        }

        // Test2
        String c = "ABBA";
        String d = "ABCABC";
        if(Oblig1.inneholdt(c, d) == false){
            System.out.println("Test 2 feilet, feil når s1 = '" + c + "' og s2 = '" + d + "'");
            feil++;
        } else {
            System.out.println("Strengen "+ c + " er inneholdt i " + d + " ,Oblig1.inneholdt(c, d): " + Oblig1.inneholdt(c, d));
        }

        // Test3 - metoden skal returnere false hvis s1 er lenger enn s2
        String e = "BBBBBB";
        String f = "BBB";
        if(Oblig1.inneholdt(e, f) == true){
            System.out.println("Test 3 feilet, feil når s1 = '" + e + "' og s2 = '" + f + "'");
            feil++;
        } else {
            System.out.println("Strengen "+ e + " er ikke inneholdt  i " + f + " ,Oblig1.inneholdt(e, f): " + Oblig1.inneholdt(e, f));
        }

        // Test4
        String g = "AABB";
        String h = "ABDF";
        if(Oblig1.inneholdt(g, h) == true){
            System.out.println("Test 4 feilet, feil når s1 = '" + g + "' og s2 = '" + h + "'");
            feil++;
        } else {
            System.out.println("Strengen "+ g + " er ikke inneholdt i " + h + " , Oblig1.inneholdt(g, h): " + Oblig1.inneholdt(g, h));
        }

        // Test5
        String i = "";
        String j = "";
        if(Oblig1.inneholdt(i, j) == false){
            System.out.println("Test 5 feilet, feil når s1 = '" + i + "' og s2 = '" + j + "'");
            feil++;
        } else {
            System.out.println("Strengen ''  er inneholdt i  '',"+ " Oblig1.inneholdt(i, j): " + Oblig1.inneholdt(i, j));
        }


        assertEquals(0, feil, "Metoden har " + feil + " feil som må fikses");
    }
}