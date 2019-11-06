package Assignments.Oblig3;

////////////////// ObligSBinTre /////////////////////////////////

import java.sql.SQLOutput;
import java.util.*;

public class ObligSBinTre<T> implements Beholder<T>
{
  private static final class Node<T>   // en indre nodeklasse
  {
    private T verdi;                   // nodens verdi
    private Node<T> venstre, høyre;    // venstre og høyre barn
    private Node<T> forelder;          // forelder

    // konstruktør
    private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder)
    {
      this.verdi = verdi;
      venstre = v; høyre = h;
      this.forelder = forelder;
    }

    private Node(T verdi, Node<T> forelder)  // konstruktør
    {
      this(verdi, null, null, forelder);
    }

    @Override
    public String toString(){ return "" + verdi;}

  } // class Node

  private Node<T> rot;                            // peker til rotnoden
  private int antall;                             // antall noder
  private int endringer;                          // antall endringer
  private String gren = "";

  private final Comparator<? super T> comp;       // komparator

  public ObligSBinTre(Comparator<? super T> c)    // konstruktør
  {
    rot = null;
    antall = 0;
    comp = c;
  }
  
  @Override
  public boolean leggInn(T verdi) {

    Objects.requireNonNull(verdi, "Ulovlig med nullverdier!");

    Node<T> p = rot, q = null;               // p starter i roten
    int cmp = 0;                             // hjelpevariabel

    while (p != null)       // fortsetter til p er ute av treet
    {
      q = p;                                 // q er forelder til p
      cmp = comp.compare(verdi,p.verdi);     // bruker komparatoren
      p = cmp < 0 ? p.venstre : p.høyre;     // flytter p
    }

    // p er nå null, dvs. ute av treet, q er den siste vi passerte

    p = new Node<T>(verdi,q);                   // oppretter en ny node

    if (q == null) rot = p;                  // p blir rotnode
    else if (cmp < 0) q.venstre = p;         // venstre barn til q
    else q.høyre = p;                        // høyre barn til q

    antall++;                                // én verdi mer i treet
    endringer++;                             // ny endring
    return true;                             // vellykket innlegging
  }
  
  @Override
  public boolean inneholder(T verdi)
  {
    if (verdi == null) return false;

    Node<T> p = rot;

    while (p != null)
    {
      int cmp = comp.compare(verdi, p.verdi);
      if (cmp < 0) p = p.venstre;
      else if (cmp > 0) p = p.høyre;
      else return true;
    }

    return false;
  }


  @Override
  public boolean fjern(T verdi)
  {
    if (verdi == null) return false;  // Treet har ingen nullverdier

    Node<T> p = rot, q = null;   // q skal være forelder til p

    while (p != null)            // Leter etter verdi
    {
      int cmp = comp.compare(verdi,p.verdi);      // Sammenligner
      if (cmp < 0) { q = p; p = p.venstre; }      // Går til venstre
      else if (cmp > 0) { q = p; p = p.høyre; }   // Går til høyre
      else break;                                 // Den søkte verdien ligger i p
    }
    if (p == null) return false;   // Finner ikke verdi

    if (p.venstre == null || p.høyre == null)  // Hvis noden som skal fjernes har 0 eller 1 barn
    {
      Node<T> b = p.venstre != null ? p.venstre : p.høyre;  // b er barnet til p noden
      if (p == rot) {
        rot = b;
      }
      else if (p == q.venstre){
        q.venstre = b;
        if(b != null){
          b.forelder = q;
        }
      }
      else {
        q.høyre = b;
        if(b != null){
          b.forelder = q;
        }
      }
    }
    else  // Hvis noden som skal fjernes har 2 barn
    {
      Node<T> s = p, r = p.høyre;   // Finner neste i inorden
      while (r.venstre != null)
      {
        s = r;                      // s er forelder til r
        r = r.venstre;
      }

      p.verdi = r.verdi;   // Kopierer verdien i r til p

      if (s != p) {
        s.venstre = r.høyre;
        if(r.høyre != null){
          r.høyre.forelder = s;
        }

      }
      else {
        s.høyre = r.høyre;
        if(r.høyre != null){
          r.høyre.forelder = s;
        }
      }
    }

    antall--;      // Det er nå én node mindre i treet
    endringer++;   // Det er gjort en ny endring på treet
    return true;
  }
  
  public int fjernAlle(T verdi)
  {
    if(antall == 0) { return 0; }
    int antallFjernet = 0;
    while(fjern(verdi)) { antallFjernet++; }

    return antallFjernet;
  }
  
  @Override
  public int antall()
  {
    return antall;
  }
  
  public int antall(T verdi)
  {
    int antall = 0;
    if (verdi == null) {
      return antall;
    }

    Node<T> p = rot;

    while (p != null)
    {
      int cmp = comp.compare(verdi, p.verdi);
      if(cmp == 0) {
        antall++;
      }
      p = cmp < 0 ? p.venstre : p.høyre;
    }
    return antall;

  }
  
  @Override
  public boolean tom()
  {
    return antall == 0;
  }
  
  @Override
  public void nullstill() {
      int temp = antall;                // Tar vare på antall (før noder fjernes)
      System.out.println(endringer);
      slettAlleNoder(rot);              // Kaller på en rekursiv metode som sletter alle nodene i treet
      rot = null;
      antall = 0;
      endringer += temp;                // Legger til antall noder som ble fjernet til endringer
  }

  /** Hjelpemetode som rekursivt nuller ut alle verdier og pekerere i treet
   * dette skjer i postorden */
  private void slettAlleNoder(Node<T> p) {
    if(p == null) { return; }

    slettAlleNoder(p.venstre);
    slettAlleNoder(p.høyre);

    // Fjerner alle verider og pekere til nodene
    p.verdi = null;
    p.venstre = null;
    p.høyre = null;
    p.forelder = null;
  }


  public static <T> Node<T> nesteInorden(Node<T> p)
  {
    Node<T> q = p.forelder;   // Hjelpereferanse, foreldren til p

    if (p.høyre != null) {    // Hvis p har et høyrebarn utføres løkken
      p = p.høyre;            // P flyttes til sitt høyrebarn
      while (p != null) {
        q = p;
        p = p.venstre;        // P flyttes ned i treet helt til den blir null (treffer en node uten left
                              // child), og q peker på denne noden
      }
    }
    else {
      while (q != null && q.høyre == p) { // Hvis p ikke er roten OG p er et høyrebarn utføres løkken (Når while-løkken
                                          // feiler så er neste node q)
        p = q;
        q = p.forelder;      // P flyttes opp til sin venstre foreldre, og q blir flyttet til p sin foreldre
      }
    }

    return q;
  }

  @Override
  public String toString()
  {
    if (tom()) return "[]";           //Returnerer [] hvis treet ikke har noen noder

    StringJoiner sj = new StringJoiner(", ", "[", "]");
    Node<T> p = rot;

    while (p.venstre != null) {
      p = p.venstre;                  // Gjør slik at p peker på noden nederst til venstre istede for rot
    }

    while (p != null) {
      sj.add(p.toString());           // Skriver ut toStringen til nodene i inorden-rekkefølge
      p = nesteInorden(p);
    }

    return sj.toString();
  }
  
  public String omvendtString()
  {
    if(tom()){
      return "[]";           //Returnerer [] hvis treet ikke har noen noder
    }

    TabellStakk<Node> omvendtStack = new TabellStakk<>();
    Node<T> p = rot;

    while (p.venstre != null) {
      p = p.venstre;                              // Gjør slik at p peker på noden nederst til venstre istede for rot
    }

    while (p != null) {
      omvendtStack.leggInn(p);                    // Fyller stacken med noder
      p = nesteInorden(p);
    }

    return omvendtStack.toString();              // Returnerer toStringen til nodene i omvendt rekkefølge, de siste som
                                                 // ble puttet inn i stacken blir skrevet ut først (LIFO)
  }
  
  public String høyreGren() {
      if(rot == null) { return "[]"; }
      StringBuilder str = new StringBuilder();
      str.append("[");
      Node<T> p = rot;

      // Itererer helt ned til bladnoden
      while(p != null) {
        str.append(p.verdi + ", ");

        // Prøver å gå til høyre i treet, hvis ikke det er mulig gå venstre
        if(p.høyre != null) {
          p = p.høyre;
        }else {
          p = p.venstre;
        }
      }

      str.delete(str.length() - 2, str.length()); // Fjerner de to siste tegnene slik at formatering blir riktig
      str.append("]");
      return str.toString();
  }




  public String lengstGren() {
    if(rot == null) { return "[]"; }
    StringBuilder str = new StringBuilder();
    str.append("[");
    finnLengsteGren(rot, "", 0);
    str.append(gren);
    str.append("]");
    return str.toString();
  }

  private int maksLengde = 0; // Lengden på legste gren

  private void finnLengsteGren(Node node, String tempString, int lengde) {

    if(node == null) {

      // Tar vare på stringen hvis hvis det blir funnet en nye "lengste gren"
      if(lengde > maksLengde) {
          maksLengde = lengde;
          tempString = tempString.substring(0,tempString.length() - 2);
          gren = tempString;
      }
      return;
    }

    tempString += node.verdi + ", ";

    finnLengsteGren(node.venstre, tempString, lengde + 1);
    finnLengsteGren(node.høyre, tempString, lengde + 1);
  }
  
  public String[] grener() {
    TabellListe<Node<T>> bladnoder = finnBladnoder(); // Tabellliste som inneholder alle bladnodene i et tre
    String[] alleGrener = new String[bladnoder.antall()]; // String-liste på størrelse med antall bladnoder

    for(int i = 0; i < bladnoder.antall(); i++) {
      alleGrener[i] = finnGren(bladnoder.hent(i)); // Finner grenen til hver enkelt bladnodene
    }
    return alleGrener; // Returnerer hver enkelt gren i treet
  }

  /** Hjelpemetode for "grener()"*/
  private static String finnGren(Node p) {
    StringJoiner sj = new StringJoiner(", ", "[", "]");
    TabellStakk stack = new TabellStakk<>(); // LIFO
    while(p != null) {
      stack.leggInn(p); // Finner grenen fra en spesifik node, og legger hver verdi inn i en stack
      p = p.forelder; // Beveger peker i retning roten av treet
    }

    while(!stack.tom()) {
      p = (Node)stack.taUt(); // Konkatenerer fra Object til Node
      sj.add(p.toString()); // Mens stacken ikke er tom legges hvert element til en stringjoiner
    }

    return sj.toString(); // Returnerer en gren fra p
  }

  /** Hjelpemetode for "grener()*/
  private TabellListe<Node<T>> finnBladnoder() {
    TabellListe<Node<T>> bladnoder = new TabellListe<>(); // TabellListe som skal holde alle bladnodene i et tre

    Node<T> p = rot;

    if(tom()) {
      return bladnoder; // Hvis listen er tom returneres en tom TabellListe
    }

    while(p.venstre != null) {
      p = p.venstre; // Beveger seg til første node i innorden
    }

    while(p!=null) {
      if(p.venstre == null && p.høyre == null) {
        bladnoder.leggInn(p); // Hvis man befinner seg i en bladnode (ingen barn) legges den til TabellListen
      }
      p = nesteInorden(p); // Går til neste node i innorden
    }

    return bladnoder; // Returnerer en liste med alle bladnoder


  }
  
  public String bladnodeverdier() {
    if(antall == 0) {return "[]"; }

    StringBuilder str = new StringBuilder();
    str.append("[");
    bladNode(rot, str);
    str.delete(str.length() - 2, str.length()); // Fjerner de to siste tegnene slik at formatering blir riktig
    str.append("]");
    return str.toString();
  }


  public  void bladNode(Node p, StringBuilder str) {
    if (p == null) return;

    if(p.venstre == null && p.høyre == null){
      str.append(p.verdi + ", ");
    }

    bladNode(p.venstre, str);
    bladNode(p.høyre, str);
  }
  
  public String postString()
  {
    StringBuilder str = new StringBuilder();

    return "";
  }

 // private void treverserPostorden
  
  @Override
  public Iterator<T> iterator()
  {
    return new BladnodeIterator();
  }
  
  private class BladnodeIterator implements Iterator<T>
  {
    private Node<T> p = rot, q = null;
    private boolean removeOK = false;
    private int iteratorendringer = endringer;


    //TODO: ta en ny titt på metoden
    private BladnodeIterator()  // konstruktør
    {
        // Gjør ingenting om treet er tomt
        if (!hasNext()) {
            return;
        }

        while (p.venstre != null) {
            p = p.venstre;
        }

        while (hasNext()) {
            if (p.venstre == null && p.høyre == null) {
                return;
            }
            p = nesteInorden(p);
        }
    }
    
    @Override
    public boolean hasNext()
    {
      return p != null;  // Denne skal ikke endres!
    }

    // I next() settes q lik p før p flyttes:
    @Override
    public T next()
    {
      if (iteratorendringer != endringer) {
        throw new ConcurrentModificationException();
      }
      if(!hasNext()) {
        throw new NoSuchElementException("Det er ikke flere bladnoder igjen i treet!");
      }

      removeOK = true;
      q = p;
      T verdi = q.verdi;

      while(hasNext()) {
        p = nesteInorden(p);
        if(p == null) {
          return verdi;
        }
        if (p.venstre == null && p.høyre == null) {
          return verdi;
        }
      }
      return verdi;
    }

    //Det er q sin verdi som skal fjernes når remove() kalles.
    @Override
    public void remove()
    {
      if(antall == 0 || removeOK == false) { // Sjekker om det er lov å kalle remove()
        throw new IllegalStateException("Metoden remove() kan ikke kalles!");
      }

      if(iteratorendringer != endringer) {  // Sjekker om det er gjort endringer i listen før remove() ble kjørt
        throw new ConcurrentModificationException("iteratorendringer kan ikke være ulik endringer!");
      }
      q = p;
      
    }

  } // BladnodeIterator

} // ObligSBinTre
