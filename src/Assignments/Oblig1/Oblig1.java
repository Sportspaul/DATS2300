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


    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int [] verdier ) {
        if(verdier.length <= 0){
            throw new NoSuchElementException("Tabellen er tom");
        }
        for(int i = 0; i < verdier.length-1; i++){
                if(verdier[i] > verdier[i+1]){
                    int bytt = verdier[i];
                    verdier[i] = verdier[i+1];
                    verdier[i+1] = bytt;

            }
        }
       return verdier[verdier.length-1];
    }

    public static int ombyttinger(int [] verdier ) {
        if(verdier.length <= 0){
            throw new NoSuchElementException("Tabellen er tom");
        }
        int antall = 0;
        for(int i = 0; i < verdier.length-1; i++){
            if(verdier[i] > verdier[i+1]){
                int bytt = verdier[i];
                verdier[i] = verdier[i+1];
                verdier[i+1] = bytt;
                antall++;

            }
        }
        return antall;
    }

    //TODO: implementer metodene
    public static int antallUlikeSortert( int [] verdier ) {
        return 0;
    }

    /**Itererer gjennom en tabell, og finner ut av hvor mange unike tall det er i den*/

    public static int antallUlikeUsortert(int [] verdier ) {

        int antallUlike = 0;

        for (int i = 0; i < verdier.length; i++) {                 //Går gjennom alle verdiene i arrayet verdier

            int j;
            for (j = 0; j < i; j++) {            //Om i og j ikke har samme indeks (j < i) hopper den inn i if-setningen
                if (verdier[i] == verdier[j]) {    //Om verdiene på indeks i og j har samme verdi 
                                                   // går den ut av for-løkken
                    break;
                }
            }
            if (i == j) {                        //Om indeksen til i og j er like øker antallet ulike tall
                antallUlike++;
            }
        }
        return antallUlike;
    }

    /**Metode som sorterer et array med oddetall på vesten halvdel og partall på høyre, i stigende rekkefølge*/
    public static void delsortering(int[] verdier) {
        int fra = 0;                                   // Setter fra som indeks-plassen til første plass i verdier
        int til = verdier.length - 1;                  // Setter til som indeks-plassen til siste plass i verdier

        while (true) {                                          // While løkken stopper når fra > til
            while (fra <= til && verdier[fra] % 2 != 0) fra++;   // fra er vaktpost/stoppeverdi for til
            while (fra <= til && verdier[til] % 2 == 0) til--;   // til er vaktpost/stoppeverdi for fra

        if(fra < til) {
            bytt(verdier, fra++, til--);                         //bytter om a[fra] og a[til] sine posisjoner
        }
            else break;                                         //hopper ut av while-løkken
        }
        int skille = finnSkille(verdier);

        sorterToDeler(verdier, skille);
    }

    public static void bytt(int[] verdier, int i, int j) {
        int temp = verdier[i]; 
        verdier[i] = verdier[j]; 
        verdier[j] = temp;    //Bytter posisjonen til verdier[i] og verdier[j] med hverandre
    }

    public static int finnSkille(int[] verdier) {
        for(int i = 0; i < verdier.length; i++) {
            if(verdier[i]%2 == 0) {
                return i;
            }
        }
        return 0;
    }

    public static void sorterToDeler(int[] verdier, int skille) {
        for(int i = 0; i < skille; i++) {
            for(int j = 1; j < skille; j++) {
                if(verdier[i] > verdier[j] && i < j) {
                    int temp = verdier[i];
                    verdier[i] = verdier[j];
                    verdier[j] = temp;
                }
            }
        }
        for(int i = skille; i < verdier.length; i++) {
            for(int j = skille+1; j < verdier.length; j++) {
                if(verdier[i] > verdier[j] && i < j) {
                    int temp = verdier[i];
                    verdier[i] = verdier[j];
                    verdier[j] = temp;
                }
            }
        }
    }


    ///// Oppgave 5 //////////////////////////////////////
    /* Metode som tar inn en liste med 'char'-elementer og roterer alle elementene 1 plass mot høyre
    * eks. char[] a = {'A', 'B', 'C', 'D'}
    * rotasjon(a)
    * a == {'D', 'A', 'B', 'C'} */
    public static void rotasjon(char[] verdier) {

        // Tester om listen har mer enn 1 element
        if(verdier.length > 1) {
            int siste_idx = verdier.length - 1;
            char temp = verdier[siste_idx];                       // Tar vare på verdien til siste element

            for (int i = siste_idx - 1; i >= 0; i--) {      // Looper gjennom listen fra høyre til venstre
                verdier[i + 1] = verdier[i];                            // Flytter elementene en plass til høyre
            }

            verdier[0] = temp;                                    // Setter første element i listen lik verdier[siste_idx]
        }
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char [] verdier, int k) {
        int n = verdier.length;

        // Roterer 1 plass hvis lengde lik 2 og 'antall flytt' % 'lengde' != 0
        if(n == 2 && k%n != 0) { rotasjon(verdier); return;}
        char[] temp = new char[n];                         // hjelpeliste

        if(n > 0 && n != 2) {

            // hjelpearrayet får samme verdier som 'verdier'-listen
            System.arraycopy(verdier, 0, temp, 0, n);
            int kAbs = Math.abs(k);                          // Finner absoluttverdien til k (eks. -5 => 5, 5 => 5)
            int flytt;

            if (kAbs > n && k > 0) {

                // Antall flytt til høyre blir lik: 'antall flytt' % 'lengde'
                flytt = k%n;
                rotasjon(verdier, temp, n, flytt);
            }
            else if (kAbs < n && k > 0) {

                // Antall flytt til høyre blir lik: 'antall flytt'
                flytt = k;
                rotasjon(verdier, temp, n, flytt);
            }
            else if (kAbs > n && k < 0) {

                // Antall flytt til høyre blir lik: 'antall flytt' % 'lengde' + 'lengde'
                flytt = k % n + n;
                rotasjon(verdier, temp, n, flytt);
            }
            else if (kAbs < n && k < 0) {

                // Antall flytt til høyre blir lik: 'antall flytt' + 'lengde'
                // eks. k: -3, n: 5, -3 + 5 = 2
                flytt = k + n;
                rotasjon(verdier, temp, n, flytt);
            }
        }
    }

    // Helpemetode for metoden over
    public static void rotasjon(char[] verdier, char[] temp, int n, int flytt) {
        int teller = 0;
        for (int i = 0; i < n; i++) {
            if (i + flytt < n) {
                verdier[i + flytt] = temp[i];
            } else if (i + flytt > n - 1) {
                verdier[teller] = temp[i];
                teller++;
            }
        }
    }





    ///// Oppgave 8 //////////////////////////////////////
    /////  a)        //////////////////////////////////////
    public static String flett(String s1, String s2) {
        //creating string to append values to from both strings
        String out= "";

        for (int i =0; i<s1.length() + s2.length(); i++){
            //checks that there is a char at index i in s1
            if (i<s1.length()){
                out += s1.charAt(i);
            }
            //checks that there is a char at index i in s2
            if (i<s2.length()){
                out += s2.charAt(i);
            }
        }
        return out;
    }


    ////  b)        //////////////////////////////////////
    public static String flett(String... s) {
        //out is the String that will be appended to to create the merged string
        String out = "";
        //totalLength is the total length of all the strings we add
        int totalLength =0;

        //for loop that goes through all the String paramater and finds total length
        for (int i=0; i<s.length;i++){
            totalLength +=s[i].length();
        }



        for (int i=0;i<totalLength;i++){

            //goes through the paramatar strings and adds the char to "out"
            for (int j=0; j<s.length;j++){

                //checks if the String has a char at that index
                if (i<s[j].length()){
                    //if everything is ok we add the char from String at j at index i
                    out+=s[j].charAt(i);
                }
            }
        }
        return out;
    }








    ///// Oppgave 8 //////////////////////////////////////
    //a)

    public static int [] indekssortering(int [] verdier) {
        return null;
    }


   //TODO: Ikke testet
   ///// Oppgave 9 //////////////////////////////////////
    public static int [] tredjeMin(int [] verdier) {
        int n = verdier.length;     // tabellens lengde
        if (n < 3) throw      // må ha minst tre verdier
                new NoSuchElementException("Det er for få verdier i arrayet, verdier.length(" + n + ") < 3!");

        int m1 = 0;      // m_1 er posisjonen til minste verdi
        int m2 = 1;      // m_2 er posisjonen til nest minste verdi
        int m3 = 2;      // m_3 er posisjonen til tredje minste verdi

        //TODO: Bruke indekssortering på de tre første verdiene

        int minverdi = verdier[m1];          // minste verdi
        int nestminverdi = verdier[m2];      // nest minste verdi
        int tredjeminverdi = verdier[m3];    // tredje minste verdi

        for (int i = 3; i < n; i++) {
            if (verdier[i] < tredjeminverdi) {
                if (verdier[i] < nestminverdi) {
                    if(verdier[i] < minverdi) {
                        m3 = m2;
                        tredjeminverdi = verdier[m3];
                        m2 = m1;
                        nestminverdi = verdier[m2];
                        m1 = i;
                        minverdi = verdier[m1];
                    } else {
                        m3 = m2;
                        tredjeminverdi = verdier[m3];
                        m2 = i;
                        nestminverdi = verdier[m2];
                    }
                } else {
                    m3 = i;
                    tredjeminverdi = verdier[m3];    // ny tredje minste
                }
            }
        }
        return new int[] {m1,m2,m3};
    }

    ///// Oppgave 10 //////////////////////////////////////
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
        int antallLike = 0;
        for(int i = 0; i < s2.length(); i++){

            // Hindrer s1.charAt(antallLike) å være outOfBounds når 'antallLike' == s1.length()
            if(antallLike < s1.length()) {
                if (s2.charAt(i) == s1.charAt(antallLike)) {
                    antallLike++;
                }
            }
        }

        if(antallLike == s1.length()) { return true; }        // Returnerer true hvis altallLike == s1.length()
        else { return false; }

    }

}
