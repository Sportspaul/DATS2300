package Assignments.Oblig3;

////////////////// ObligSBinTre /////////////////////////////////

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
  public boolean fjern(T verdi) {
    if (verdi == null) return false;  // treet har ingen nullverdier

    Node<T> p = rot, q = null;   // q skal være forelder til p

    while (p != null) {            // leter etter verdi

      int cmp = comp.compare(verdi,p.verdi);      // sammenligner
      if (cmp < 0) { q = p; p = p.venstre; }      // går til venstre
      else if (cmp > 0) { q = p; p = p.høyre; }   // går til høyre
      else break;    // den søkte verdien ligger i p
    }
    if (p == null) return false;   // finner ikke verdi

    if (p.venstre == null || p.høyre == null) {  // Hvis noden som skal fjernes har 0 eller 1 barn

      Node<T> b = p.venstre != null ? p.venstre : p.høyre;  // b for barn
      if (p == rot) {
        rot = b;
      }else if (p == q.venstre) {
        q.venstre = b;
      }else {
        q.høyre = b;
      }

    } else {  // Hvis noden som skal fjernes har 2 barn

      Node<T> s = p, r = p.høyre;   // finner neste i inorden
      while (r.venstre != null) {
        s = r;    // s er forelder til r
        r = r.venstre;
      }

      p.verdi = r.verdi;   // kopierer verdien i r til p


      if (s != p) {
        s.venstre = r.høyre;
      }
      else s.høyre = r.høyre;
    }

    antall--;   // det er nå én node mindre i treet
    endringer++; // det er gjort en ny endring på treet
    return true;
  }
  
  public int fjernAlle(T verdi)
  {
    int antallFjernet = 0;
    while(fjern(verdi) == true) { antallFjernet++; }

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
      fjernNeste(rot);
  }

  private void fjernNeste(Node<T> p) {
    if(p == null) { return; }

    Node<T> q;
    q = p.venstre;
    fjernNeste(p.venstre);

    q.verdi = null;
    q.forelder = null;
    q.forelder.venstre = null;

    q = p.høyre;
    fjernNeste(q);

  }


  public static <T> Node<T> nesteInorden(Node<T> p)
  {
    Node<T> q = p.forelder;   //Hjelpereferanse for

    if (p.høyre != null) {
      p = p.høyre;
      while (p != null) {
        q = p;
        p = p.venstre;
      }
    } else {
      while (q != null && q.høyre == p) {
        p = q;
        q = p.forelder;
      }
    }

    return q;
  }

  @Override
  public String toString()
  {
    if (tom()) return "[]";

    StringJoiner sj = new StringJoiner(", ", "[", "]");
    Node<T> p = rot;

    while (p.venstre != null) {
      p = p.venstre;
    }

    while (p != null) {
      sj.add(p.toString());
      p = nesteInorden(p);
    }

    return sj.toString();
  }
  
  public String omvendtString()
  {
    throw new UnsupportedOperationException("Ikke kodet ennå!");
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
    str.delete(str.length() - 2, str.length()); // Fjerner de to siste tegnene slik at formatering blir riktig
    str.append("]");
    return str.toString();
  }

  private int maksLengde = 0; // Lengden på legste gren

  private void finnLengsteGren(Node node, String midlertidigGren, int lengde) {

    if(node == null) {

      // Tar vare på stringen hvis hvis det blir funnet en nye "lengste gren"
      if(lengde > maksLengde) {
          maksLengde = lengde;
          gren = midlertidigGren;
      // Tilbakestiller
      } else if(lengde < maksLengde) {
          midlertidigGren = "";
      }
      return;
    }

    midlertidigGren += node.verdi + ", ";

    finnLengsteGren(node.venstre, gren, lengde + 1);
    finnLengsteGren(node.høyre, gren, lengde + 1);
  }
  
  public String[] grener()
  {
    throw new UnsupportedOperationException("Ikke kodet ennå!");
  }
  
  public String bladnodeverdier()
  {
    throw new UnsupportedOperationException("Ikke kodet ennå!");
  }
  
  public String postString()
  {
    throw new UnsupportedOperationException("Ikke kodet ennå!");
  }
  
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
      if(!hasNext()) {
        return;
      }
      // Gå til høyre om venstre barn ikke finnes
      if(rot.venstre == null) {
        p = p.høyre;
      }

      while(hasNext()) {
          p = p.venstre;
      }
      if(p.høyre != null ) {
          while(hasNext()) {
              p = p.venstre;
          }
      }
    }
    
    @Override
    public boolean hasNext()
    {
      return p != null;  // Denne skal ikke endres!
    }

    //Det er q sin verdi som skal fjernes når remove() kalles. I next() settes q lik p før p flyttes:
    @Override
    public T next()
    {
      if (iteratorendringer != endringer) {
        throw new ConcurrentModificationException();
      }
      if(!hasNext()) {
        throw new NoSuchElementException("Det er ikke flere noder igjen i treet!");
      }
      removeOK = true;
      T verdi = p.verdi;
      if(p.venstre != null) {
        p = p.venstre;
      } else {
        p = p.høyre;
      }
      return verdi;
    }
    
    @Override
    public void remove()
    {
      if(antall == 0 || removeOK == false) { // Sjekker om det er lov å kalle remove()
        throw new IllegalStateException("Metoden remove() kan ikke kalles!");
      }

      if(iteratorendringer != endringer) {  // Sjekker om det er gjort endringer i listen før remove() ble kjørt
        throw new ConcurrentModificationException("iteratorendringer kan ikke være ulik endringer!");
      }
      removeOK = false;
      q = p;
      
    }

  } // BladnodeIterator

} // ObligSBinTre
