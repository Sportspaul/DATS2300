package Assignments.Oblig1;

public class Oblig1 {

    //TODO: Må fjernes!!!!!!!!
    // For å sjekke ut ting underveis
    public static void main(String args[]) {
        Oblig1.inneholdt("abca","dddd");
    }

    //TODO: implementer metodene
    public static int maks(int [] values ) {
        return 0;
    }

    public static int ombyttinger(int [] values ) {
        return 0;
    }

    public static int antallUlikeSortert( int [] values ) {
        return 0;
    }

    public static int antallUlikeUsortert( int [] values ) {
        return 0;
    }

    public static void delsortering(int [] values) { }

    public static void rotasjon(char[] a) { }

    public static void rotasjon(char [] values, int k) { }

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
        for(String s: strArray1) {
            System.out.println(s);
        }
        if(s2.length() > s1.length()) {
            //TODO:Lage exception
        }
        return false;
    }


}
