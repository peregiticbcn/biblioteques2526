package edIticbcn.exercici10_ordenemArrays;

import java.util.Comparator;

public class ComparatorDecreixentString implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
}
