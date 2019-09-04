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
        //TODO: Ikke ferdig

        for(int i = 0; i < strArray1.length; i++ ) {

        }
        if(s2.length() > s1.length()) {
            //TODO:Lage exception
        }
        return false;
    }


}
