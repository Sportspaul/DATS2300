package Assignments.Oblig2.Oblig2Test;

import Assignments.Oblig2.DobbeltLenketListe;
import Assignments.Oblig2.Liste;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        //Tester om hode sin forrige-peker == null
        if(liste2.getHodeForrige() != null) {
            antallFeil++;
            System.out.println("Feil: Hode sin forrige-peker skal være null");
        }


        //Tester om hale sin neste-peker == null
        if(liste2.getHaleNeste() != null) {
            antallFeil++;
            System.out.println("Feil: Hale sin forrige-peker skal være null");
        }


        Integer[] cInteger = new Integer[] {1};
        DobbeltLenketListe<Integer> liste3 = new DobbeltLenketListe<>(cInteger);

        //Tester med 1 verdi som ikke er null
        if(liste3.getHodeNeste() != liste3.getHaleForrige()){
            antallFeil++;
            System.out.println("Feil: hodet sin neste-peker og hale sin forrige-peker er ikke like");
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

}
