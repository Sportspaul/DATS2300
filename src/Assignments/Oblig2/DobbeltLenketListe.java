package Assignments.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.Iterator;


/*
    Andreas Hartmann s333759
    Daniel Hansen s333748
    Felix Leypoldt s333743
    Herman Rustad s333769
    Paul Høglend s333733
*/



public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public DobbeltLenketListe() {
    }

    public DobbeltLenketListe(T[] a) {
        // Kaster unntak for null tabell
        if(a == null){ throw new NullPointerException("Tabell a er null!"); }

        a = fjernNullVerdier(a);             // Fjerner alle null-verdier
        if(a.length == 0) { return; }        // Hopper ut av metoden hvis listen er tom

        Node<T> aktuell = new Node<>(a[0]);  // Opretter første node, og gir den verdi
        antall++;                            // Opdaterer antall noder
        hode = aktuell;                      // Setter hode lik første node

            for (int i = 1; i < a.length; i++) {
                    Node<T> neste = new Node<>(a[i]);    // Opretter ny node
                    antall++;                            // Opdaterer antall noder
                    aktuell.neste = neste;               // Setter aktuell sin neste peker
                    neste.forrige = aktuell;             // Setter neste sin forrige peker
                    aktuell = neste;                     // Setter aktuell lik neste
        }
        hale = aktuell;                          // Setter halen lik siste node
    }

    private T[] fjernNullVerdier (T[] a) {
        int antallNullverdier = 0;              // Teller for antall nullverdier

        for(T verdi : a){
            if(verdi == null){                  // Tester hvor mange verdier som er null
                antallNullverdier++;
            }
        }

        if(antallNullverdier == 0){ return a; }     // Returnerer oprinnelig liste hvis det ikke er noe nullverdier

        T[] b = (T[]) new Object[a.length - antallNullverdier];     // Opretter returlisten

        int j = 0;  // index for returlisten

        // Legger til alle verdiene som ikke er null til returlisten
        for(int i = 0; i < a.length; i++) {
            if(a[i] != null){
                b[j] = a[i];
                j++;
            }
        }

        return b;
    }

    public Liste<T> subliste(int fra, int til){
        throw new NotImplementedException();
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        if(antall > 0){
            return false;
        }
        return true;
    }

    @Override
    public boolean leggInn(T verdi) {
        throw new NotImplementedException();
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        throw new NotImplementedException();
    }

    @Override
    public boolean inneholder(T verdi) {
        throw new NotImplementedException();
    }

    @Override
    public T hent(int indeks) {
        throw new NotImplementedException();
    }

    @Override
    public int indeksTil(T verdi) {
        throw new NotImplementedException();
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        throw new NotImplementedException();
    }

    @Override
    public boolean fjern(T verdi) {
        throw new NotImplementedException();
    }

    @Override
    public T fjern(int indeks) {
        throw new NotImplementedException();
    }

    @Override
    public void nullstill() {
        throw new NotImplementedException();
    }

    @Override
    public String toString() {
        if(antall == 0) { return "[]"; }
        StringBuilder utskrift = new StringBuilder("[");
        Node<T> aktuell  = hode; //starter på hode
        /*Løper gjennom listen, så lenge aktuells nestepekeren er ulik null,
          og legger verdien til aktuell node til utskriftstrengen
         */
        while(aktuell.neste != null) {
            utskrift.append( aktuell.verdi);
            aktuell = aktuell.neste;
        }
        utskrift.append("]");
        return utskrift.toString();
    }

    public String omvendtString() {
        if(antall == 0) { return "[]"; }
        StringBuilder utskrift = new StringBuilder("[");
        Node<T> aktuell = hale; //starter på halen

        /*Løper gjennom listen, så lenge aktuells forrigepekeren er ulik null,
          og legger verdien til aktuell node til utskriftstrengen
         */
        while(aktuell.forrige != null) {
            utskrift.append( aktuell.verdi);
            aktuell = aktuell.forrige;
        }
        utskrift.append("]");
        return utskrift.toString();
    }

    @Override
    public Iterator<T> iterator() {
        throw new NotImplementedException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new NotImplementedException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T>
    {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator(){
            throw new NotImplementedException();
        }

        private DobbeltLenketListeIterator(int indeks){
            throw new NotImplementedException();
        }

        @Override
        public boolean hasNext(){
            throw new NotImplementedException();
        }

        @Override
        public T next(){
            throw new NotImplementedException();
        }

        @Override
        public void remove(){
            throw new NotImplementedException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new NotImplementedException();
    }


    //Todo: Fjern før innlevering */
    //Brukes kun for testing
    public Node<T> getHodeForrige() {
        return hode.forrige;
    }

    public Node<T> getHaleNeste() {
        return hale.neste;
    }

    public Node<T> getHodeNeste() {
        return hode.neste;
    }

    public Node<T> getHaleForrige() {
        return hale.forrige;
    }

} // class DobbeltLenketListe


