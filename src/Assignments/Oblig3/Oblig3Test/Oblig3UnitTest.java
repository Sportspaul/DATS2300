package Assignments.Oblig3.Oblig3Test;

import Assignments.Oblig3.ObligSBinTre;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class Oblig3UnitTest {

    @Test
    void LeggInnTest() {
        Integer[] a = {4,7,2,9,5,10,8,1,3,6};
        ObligSBinTre<Integer> tre = new ObligSBinTre<>(Comparator.naturalOrder());
        for(int verdi : a) {
            tre.leggInn(verdi);
        }
        System.out.println(tre.antall()); // Utskrift: 10
    }
}
