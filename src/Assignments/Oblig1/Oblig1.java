package Assignments.Oblig1;

import java.util.NoSuchElementException;

public class Oblig1 {


    //TODO: implementer metodene
    public static int maks(int [] values ) {
        if(values.length <= 0){
            throw new NoSuchElementException("Tabellen er tom");
        }
        for(int i = 0; i < values.length - 1; i++){
            for(int j = i + 1; j < values.length; j++){
                int bytt = values[i];
                if(values[i] > values[j]){
                    values[i] = values[j];
                    values[j] = bytt;
                }
            }
        }
       return values[values.length -1];
    }

    public static int ombyttinger(int [] values ) {
        if(values.length <= 0){
            throw new NoSuchElementException("Tabellen er tom");
        }
        int antall = 0;
        for(int i = 0; i < values.length - 1; i++){
            for(int j = i + 1; j < values.length; j++){
                int bytt = values[i];
                if(values[i] > values[j]){
                    values[i] = values[j];
                    values[j] = bytt;
                    antall++;
                }
            }
        }
        return antall;
    }


    public static int antallUlikeSortert( int [] values ) {
        return 0;
    }

    public static int antallUlikeUsortert( int [] values ) {
        return 0;
    }

    public static void delsortering(int [] values) { }


    /* Metode som tar inn en liste med 'char'-elementer og roterer alle elementene 1 plass mot høyre
    * eks. char[] a = {'A', 'B', 'C', 'D'}
    * rotasjon(a)
    * a == {'D', 'A', 'B', 'C'} */
    public static void rotasjon(char[] a) {

        // Tester om listen har mer enn 1 element
        if(a.length > 1) {
            int siste_idx = a.length - 1;
            char temp = a[siste_idx];                       //Tar vare på verdien til siste element

            for (int i = siste_idx - 1; i >= 0; i--) {      //Looper gjennom listen fra høyre til venstre
                a[i + 1] = a[i];                            //Flytter elementene en plass til høyre
            }

            a[0] = temp;                                    //Setter første element i listen lik a[siste_idx]
        }
    }

    //TODO: Gjøre metoden mer effektiv
    public static void rotasjon(char [] values, int k) {
        int i = 0;
        if(k > 0) {     // Tester om k er positiv

            while (i < k) {
                rotasjon(values);
                i++;
            }
        }else if(k < 0) {   // Tester om k er negativ

            while (i > k) {
                int siste_idx = values.length - 1;
                char temp = values[0];

                for (int j = 1; j <= siste_idx; j++) {
                    values[j - 1] = values[j];
                }

                values[siste_idx] = temp;
                i--;
            }
        }

    }

    public static String flett(String s1, String s2) {
        return "";
    }

    public static String flett(String... s) {return "";}

    public static int [] indekssortering(int [] values) {
        return null;
    }

    public static int [] tredjeMin(int [] values)  {
        return null;
    }

    public static boolean inneholdt(String s1, String s2) {
        String str1 = s1.toUpperCase();
        String str2 = s2.toUpperCase();
        String [] strArray1 = str1.split("\\s");
        String [] strArray2 = str2.split("\\s");
        //test
        //TODO: Ikke ferdig

        for(int i = 0; i < strArray1.length; i++ ) {

        }
        if(s2.length() > s1.length()) {
            //TODO:Lage exception
        }
        return false;
    }


}
