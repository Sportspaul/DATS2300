package Assignments.Oblig2.Oblig2Test;

import Assignments.Oblig2.DobbeltLenketListe;
import Assignments.Oblig2.Liste;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Oblig2Test {

    @Test
    void oppgave1Test() {
        String[] s = {"Ole", null, "Per", "Kari", null};
        Liste<String> liste = new DobbeltLenketListe<>(s);
        System.out.println(liste.antall() + " " + liste.tom());
    }

    // Tester konstruktør med et array som argument
    @Test
    void instansTest() {
        int antallFeil = 0;

        int[] a = {1, 2, 3, 4, 5};

        Integer[] aInteger = new Integer[a.length];
        for(int i = 0; i < a.length; i++) {
            aInteger[i] = Integer.valueOf(a[i]);
        }

        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>(aInteger);

        //Tester basistilfellet
        if(liste.antall() != 5){
            antallFeil++;
            System.out.println("Feil i antall variabelen, Expected: " + 5 + " Actual: " + liste.antall());
        }

        Integer[] bInteger = new Integer[] {1, null, null, 2, 3};
        DobbeltLenketListe<Integer> liste2 = new DobbeltLenketListe<>(bInteger);

        //Tester at det blir lagd riktig antall noder når listen inneholder null-verdier
        if(liste2.antall() != 3){
            antallFeil++;
            System.out.println("Feil i antall variabelen, Expected: " + 3 + " Actual: " + liste2.antall());
        }

        Integer[] dInteger = new Integer[] {};
        DobbeltLenketListe<Integer> liste4 = new DobbeltLenketListe<>(dInteger);


        assertEquals(0, antallFeil, "Testen har: " + antallFeil + " feil");
    }

    @Test
    void fjernNullVerdierTest() {

        Integer[] bInteger = new Integer[] {1, null, null, 2, 3};
        DobbeltLenketListe<Integer> liste2 = new DobbeltLenketListe<>(bInteger);

    }


    @Test
    void StringTest() {
        String[] s1 = {}, s2 = {"A"}, s3 = {null,"A",null,"B",null};
        DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>(s1);
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
        DobbeltLenketListe<String> l3 = new DobbeltLenketListe<>(s3);

        System.out.println(l1.toString() + "​ ​" + l2.toString()
                + "​ ​"+ l3.toString() +"​ ​"+ l1.omvendtString() +"​ ​"
                + l2.omvendtString() + "​ ​"+ l3.omvendtString());
    }


    @Test
    void leggInnTest() {
        Integer[] listeInteger = new Integer[] {1, 2, 3};
        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>(listeInteger);
        liste.leggInn(4);



        Integer[] liste3Integer = new Integer[] {};
        DobbeltLenketListe<Integer> liste3 = new DobbeltLenketListe<>(liste3Integer);
        liste3.leggInn(1);



        DobbeltLenketListe<Integer> liste4 = new DobbeltLenketListe<>();
        System.out.println(liste4.toString() + " " + liste4.omvendtString());
        for (int i = 1; i <= 3; i++) {
            liste4.leggInn(i);
            System.out.println(liste4.toString() + " " + liste4.omvendtString());
        }

    }

    //Oppgave 3a

    @Test
    void finnNodeTest() {
        Integer[] listeInteger = new Integer[] {1, 2, 3, 4, 5, 6};
        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>(listeInteger);
    }

    @Test
    void hentTest() {
        Integer[] listeInteger = new Integer[] {1, 2, 3, 4, 5, 6};
        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>(listeInteger);
        assertEquals(3, liste.hent(2), "hente index 2");
        assertEquals(1, liste.hent(0), "hente index 0");
        assertEquals(6, liste.hent(5), "hente index 5");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            liste.hent(-3);
        });
    }

    @Test
    void oppdaterTest() {
        Integer[] listeInteger = new Integer[] {1, 2, 3, 4, 5, 6};
        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>(listeInteger);
        assertEquals(2, liste.oppdater(1,3));
        assertEquals(1, liste.oppdater(0, 2));
        assertEquals(6, liste.oppdater(5,3));
        assertEquals("[2, 3, 3, 4, 5, 3]", liste.toString());
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            liste.oppdater(-3, 2);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            liste.oppdater(3, null);
        });
    }

    //Oppgave 3b

    @Test
    void sublisteTest() {
        Integer[] listeInteger = new Integer[] {1, 2, 3, 4, 5, 6};
        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>(listeInteger);
        assertEquals("[2, 3, 4]", liste.subliste(1,4).toString());
        assertEquals("[1]" ,liste.subliste(0, 1).toString());
        assertEquals("[]", liste.subliste(0,0).toString());
        assertEquals("[4, 5, 6]", liste.subliste(3,6).toString());
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            liste.subliste(-2,5);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            liste.subliste(3,9);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            liste.subliste(4,3);
        });
    }


    @Test
    void hastighet() {
        DobbeltLenketListe liste = new DobbeltLenketListe<>(new Integer[]{null, 1, null, 2, null});
        for (int i = 0; i < 20000; i++) liste.leggInn(i);
        long tid = System.currentTimeMillis();  // Setter starttidspunkt
        liste.toString();                       // Kjører toString-metoden
        tid = System.currentTimeMillis() - tid; // Finner diferansen mellom start- og slutt-tidspunkt

        if (tid > 20) {
            System.out.println("Dette inntreffer evt på MacOS");
            System.out.println("Oppgave 2n: Dette (" + tid + " ms) gikk altfor sakte!");
            System.out.println(" Har du kodet toString slik det ble bedt om?");
        }
        System.out.println("Tid: " + tid);
    }

    @Test
    void indeksTilTest() {
        Integer[] listeInteger = new Integer[] {1, 2, 3, 4, 5, 6};
        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>(listeInteger);
        assertEquals(2, liste.indeksTil(3));
        System.out.println("Posisjon: "+ liste.indeksTil(3));
        //Siste posisjon
        assertEquals(5, liste.indeksTil(6));
        System.out.println( "Posisjon: "+ liste.indeksTil(6));
        //Første posisjon
        assertEquals(0, liste.indeksTil(1));
        System.out.println( "Posisjon: "+ liste.indeksTil(1));

        //Lister med duplikater
        Integer[] listeInteger2 = new Integer[] {10, 3, 2, 3, 4, 5, 3, 6};
        DobbeltLenketListe<Integer> liste2 = new DobbeltLenketListe<>(listeInteger2);
        //første posisjon
        assertEquals(0, liste2.indeksTil(10));
        System.out.println("Posisjon: "+ liste2.indeksTil(10));
        //nok en unik verdi
        assertEquals(2, liste2.indeksTil(2));
        System.out.println("Posisjon: "+  liste2.indeksTil(2));
        //Duplikatverdi
        assertEquals(1, liste2.indeksTil(3));
        System.out.println("Posisjon: "+ liste2.indeksTil(3));
    }

    @Test
    void inneholderTest() {
        Integer[] listeInteger = new Integer[] {1, 2, 3, 4, 5, 6, 7};
        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>(listeInteger);

        assertEquals(true, liste.inneholder(3));
        System.out.println("inneholder: "+ liste.inneholder(3));


        assertEquals(false, liste.inneholder(10));
        System.out.println("inneholder: "+ liste.inneholder(10));

        assertEquals(false, liste.inneholder(null));
        System.out.println("inneholder: "+ liste.inneholder(null));
    }

    @Test
    void nullstillTest() {

        // Tester om nullstill metode 1 gir riktig resultat
        Integer[] listeInteger = new Integer[] {1, 2, 3, 4, 5, 6, 7};
        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>(listeInteger);
        liste.nullstill();
        assertEquals("[]", liste.toString());

        // Tester om nullstill metode 2 gir riktig resultat
        listeInteger = new Integer[] {1, 2, 3, 4, 5, 6, 7};
        liste = new DobbeltLenketListe<>(listeInteger);
        liste.nullstill();
        assertEquals("[]", liste.toString());


        // Tester hvilke av nullstill metodene som er raskest

        // Metode 1
        liste = new DobbeltLenketListe<>();
        for(int i = 0; i < 10_000_000; i++){ liste.leggInn(i); }
        long tid = System.currentTimeMillis();
        liste.nullstill();
        tid = System.currentTimeMillis() - tid;
        System.out.println("Metode nummer 1 brukte: " + tid + "(ms)" );

        // Metode 2
        for(int i = 0; i < 10_000_000; i++){ liste.leggInn(i); }
        tid = System.currentTimeMillis();
        liste.nullstill();
        tid = System.currentTimeMillis() - tid;
        System.out.println("Metode nummer 2 brukte: " + tid + "(ms)" );
    }

    @Test
    void fjernIndeksTest() {
        Integer[] listeInteger = new Integer[] {1, 2, 3, 4, 5};
        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>(listeInteger);

        assertEquals(2, liste.fjern(1));
        assertEquals(1, liste.fjern(0));
        assertEquals(5, liste.fjern(2));
        assertEquals(3, liste.fjern(0));
        assertEquals(4, liste.fjern(0));


        Integer[] liste2Integer = new Integer[] {};
        DobbeltLenketListe<Integer> liste2 = new DobbeltLenketListe<>(liste2Integer);

    }

    @Test
    void fjernVerdiTest() {
        String[] listeString = new String[] {"A", "B", "C", "D"};
        DobbeltLenketListe<String> liste = new DobbeltLenketListe<>(listeString);
        System.out.println(liste.toString());

        liste.fjern("C");
        assertEquals("[A, B, D]", liste.toString());
        System.out.println(liste.toString());

        liste.fjern("D");
        assertEquals("[A, B]", liste.toString());
        System.out.println(liste.toString());

        liste.fjern("A");
        assertEquals("[B]", liste.toString());
        System.out.println(liste.toString());

        liste.fjern("B");
        assertEquals("[]", liste.toString());
        System.out.println(liste.toString());

        String[] liste2String = new String[] {"A", "B", "C", "D"};
        DobbeltLenketListe<String> liste2 = new DobbeltLenketListe<>(liste2String);
        System.out.println(liste2.toString());

        assertEquals(false, liste2.fjern("E"));
    }

    //Oppgave 8

    @Test
    void nextTest() {
        Integer[] listeInteger = new Integer[] {1,2,3,4,5,6};
        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>(listeInteger);
        Iterator<Integer> i = liste.iterator();
        assertTrue(i.hasNext());
        i.next();
        assertEquals(2, i.next());
        Integer[] listeIntegerTom = new Integer[] {};
        DobbeltLenketListe<Integer> listeTom = new DobbeltLenketListe<>(listeIntegerTom);
        Iterator<Integer> ii = listeTom.iterator();
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            ii.next();
        });
        liste.oppdater(3,2);
        Assertions.assertThrows(ConcurrentModificationException.class, () -> {
            i.next();
        });
    }

    @Test
    void IteratorTest() {
        Integer[] listeInteger = new Integer[] {1,2,3,4,5,6};
        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>(listeInteger);
        Iterator<Integer> i = liste.iterator(2);
        assertEquals(true, i.hasNext());
        assertEquals(3, i.next());
    }



    //Oppgave 9

    @Test
    void removeTest() {
        DobbeltLenketListe<String> liste =
                new DobbeltLenketListe<>(new String[]
                        {"Lars","Anders","Bodil","Kari","Per"});
        liste.fjernHvis(navn -> navn.charAt(0) == 'B'); // fjerner navn som starter med B
        assertEquals("[Lars, Anders, Kari, Per]", liste.toString());
        assertEquals("[Per, Kari, Anders, Lars]", liste.omvendtString());

        DobbeltLenketListe<String> liste2 =
                new DobbeltLenketListe<>(new String[]
                        {"Birger","Lars","Anders","Kari","Per"});
        liste2.fjernHvis(navn -> navn.charAt(0) == 'B'); // fjerner navn som starter med B
        assertEquals("[Lars, Anders, Kari, Per]", liste2.toString());
        assertEquals("[Per, Kari, Anders, Lars]", liste2.omvendtString());

        DobbeltLenketListe<String> liste3 =
                new DobbeltLenketListe<>(new String[]
                        {"Lars","Anders","Kari","Per","Berit"});
        liste3.fjernHvis(navn -> navn.charAt(0) == 'B'); // fjerner navn som starter med B
        assertEquals("[Lars, Anders, Kari, Per]", liste3.toString());
        assertEquals("[Per, Kari, Anders, Lars]", liste3.omvendtString());

        DobbeltLenketListe<String> liste4 =
                new DobbeltLenketListe<>(new String[]
                        {"Birger","Lars","Anders","Bodil","Kari","Per","Berit"});
        liste4.fjernHvis(navn -> navn.charAt(0) == 'B'); // fjerner navn som starter med B
        assertEquals("[Lars, Anders, Kari, Per]", liste4.toString());
        assertEquals("[Per, Kari, Anders, Lars]", liste4.omvendtString());

        Integer[] listeInteger = new Integer[] {};
        DobbeltLenketListe<Integer> listeInt = new DobbeltLenketListe<>(listeInteger);
        Iterator<Integer> i = listeInt.iterator();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            i.remove();
        });

    }

    //Oppgave 10

    @Test
    void sorterTest() {
        String [] navn = {"Lars","Anders","Bodil","Kari","Per","Berit"};
        Liste<String> liste1 = new DobbeltLenketListe<>(navn);
        DobbeltLenketListe.sorter(liste1, Comparator.naturalOrder());
        System.out.println("----------------------------");
        Integer [] tall = {2,6,4,7,9,16,16};
        Liste<Integer> liste2 = new DobbeltLenketListe<>(tall);
        DobbeltLenketListe.sorter(liste2, Comparator.naturalOrder());
    }

}
