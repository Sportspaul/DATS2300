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
    throw new UnsupportedOperationException("Ikke kodet ennå!");
  }
  
  public int fjernAlle(T verdi)
  {
    throw new UnsupportedOperationException("Ikke kodet ennå!");
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
  public void nullstill()
  {
    throw new UnsupportedOperationException("Ikke kodet ennå!");
  }
  
  private static <T> Node<T> nesteInorden(Node<T> p)
  {
    throw new UnsupportedOperationException("Ikke kodet ennå!");
  }
  
  @Override
  public String toString()
  {
    throw new UnsupportedOperationException("Ikke kodet ennå!");
  }
  
  public String omvendtString()
  {
    throw new UnsupportedOperationException("Ikke kodet ennå!");
  }
  
  public String høyreGren()
  {
    throw new UnsupportedOperationException("Ikke kodet ennå!");
  }
  
  public String lengstGren()
  {
    throw new UnsupportedOperationException("Ikke kodet ennå!");
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

    }

  } // BladnodeIterator

} // ObligSBinTre
