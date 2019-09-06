package Assignments.Oblig1;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {

    /*
    Andreas Hartmann s333759
    Daniel Hansen s333748
    Felix Leypoldt s333743
    Herman Rustad s333769
    Paul Høglend s333733
     */



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

    //TODO: implementer metodene
    public static int antallUlikeSortert( int [] values ) {
        return 0;
    }

    public static int antallUlikeUsortert( int [] values ) {

        int antallUlike = 0;

        //Går gjennom alle verdiene i arrayet values
        for (int i = 0; i < values.length; i++) {

            int j;
            //Om i og j ikke har samme index (j < i) hopper den inn i if-setningen
            for (j = 0; j < i; j++) {
                //Om verdiene på index i og j har samme verdi går den ut av for-løkken
                if (values[i] == values[j]) {
                    break;
                }
            }
            //Om indexen til i og j er like øker antallet ulike tall
            if (i == j) {
                antallUlike++;
            }
        }
        return antallUlike;
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
            char temp = a[siste_idx];                       // Tar vare på verdien til siste element

            for (int i = siste_idx - 1; i >= 0; i--) {      // Looper gjennom listen fra høyre til venstre
                a[i + 1] = a[i];                            // Flytter elementene en plass til høyre
            }

            a[0] = temp;                                    // Setter første element i listen lik a[siste_idx]
        }
    }

    public static void rotasjon(char [] values, int k) {
        int n = values.length;
        char[] temp = new char[n];

        if(n == 2) { rotasjon(values); }    // Roterer 1 plass hvis n == 2

        if(n > 0 && n != 2) {
            System.arraycopy(values, 0, temp, 0, n);        // Lager en kopi av 'values'-listen
            int kAbs = Math.abs(k);                   // Finner absoluttverdien til k (eks. -5 => 5, 5 => 5)

            if (kAbs > n && k > 0) { rotasjon(values, temp, n, k % n); }
            else if (kAbs < n && k > 0) { rotasjon(values, temp, n, k); }
            else if (kAbs > n && k < 0) { rotasjon(values, temp, n, k % n); }
            else if (kAbs < n && k < 0) { rotasjon(values, temp, n, k + n); }
        }
    }

    // Helpeklasse for metoden over
    public static void rotasjon(char[] values, char[] temp, int n, int k) {
        int teller = 0;
        for (int i = 0; i < n; i++) {
            if (i + k < n) {
                values[i + k] = temp[i];
            } else if (i + k > n - 1) {
                values[teller] = temp[i];
                teller++;
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
        //TODO: Fikse copy-paste, spesielt kommentarer

    public static int [] tredjeMin(int [] values) {
        int n = values.length;     // tabellens lengde
        if (n < 3) throw      // må ha minst tre verdier
                new NoSuchElementException("values.length(" + n + ") < 2!");

        int m1 = 0;      // m er posisjonen til største verdi
        int m2 = 1;     // nm er posisjonen til nest største verdi
        int m3 = 2;
        // bytter om m og nm hvis a[1] er større enn a[0]
        if (values[1] < values[0]) {
            m1 = 1;
            m2 = 0;
        }

        int minverdi = values[m1];                // største verdi
        int nestminverdi = values[m2];      // nest største verdi
        int tredjeminverdi = values[m3];

        for (int i = 2; i < n; i++) {
            if (values[i] > nestminverdi) {
                if (values[i] > minverdi) {
                    m2 = m1;
                    nestminverdi = minverdi;     // ny nest størst

                    m1 = i;
                    minverdi = values[m1];              // ny størst
                } else {
                    m2 = i;
                    nestminverdi = values[m2];         // ny nest størst
                }
            }
        }
        return null;  //TODO: Treminste verdier-array
    }

    public static boolean inneholdt(String s1, String s2) {
        if(s1.equals(s2)) { return true; }              // Returnerer true hvis s1 og s2 er like
        if(s1.equals("")) { return true; }              // Returnerer true hvis s1 er en tom streng
        if(s2.equals("")) { return false; }             // Returnerer false hvis s2 er en tom streng
        if(s2.length() < s1.length()) { return false; } // Returnerer false hvis s2 er korterer enn s1

        // Sorterer strengene i leksikografisk rekkefølge
        char[] sortedArray1 = s1.toCharArray();
        char[] sortedArray2 = s2.toCharArray();
        Arrays.sort(sortedArray1);
        Arrays.sort(sortedArray2);
        s1 = new String(sortedArray1);
        s2 = new String(sortedArray2);

        /* Går gjennom hver bokstav i s2
        * Hvis en av bokstavene er lik en bokstav i s1 øker 'lik' variabelen med 1  */
        int lik = 0;
        for(int i = 0; i < s2.length(); i++){

            // Hindrer s1.charAt(lik) å være outOfBounds når 'lik' == s1.length()
            if(lik < s1.length()) {
                if (s2.charAt(i) == s1.charAt(lik)) {
                    lik++;
                }
            }
        }

        if(lik == s1.length()) { return true; }        // Returnerer true hvis lik == s1.length()
        else { return false; }

    }

}
