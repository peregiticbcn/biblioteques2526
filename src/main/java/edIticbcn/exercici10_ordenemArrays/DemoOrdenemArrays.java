package edIticbcn.exercici10_ordenemArrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Stream;

public class DemoOrdenemArrays {


    public static void main(String[] args) {
        ArrayList<Integer> enters = new ArrayList<>();
        enters.add(2);
        enters.add(4);
        enters.add(1);
        enters.add(6);
        System.out.println("Ordre inicial");
        for(int i=0; i< enters.size(); i++){
            System.out.println(enters.get(i));
        }

        System.out.println("Mostrem ordenats");
        Collections.sort(enters);
        for(int i=0; i< enters.size(); i++){
            System.out.println(enters.get(i));
        }

        //Ordenem Strings
        ArrayList<String> strings = new ArrayList<>();
        strings.add("bola");
        strings.add("iere");
        strings.add("aura");
        strings.add("dilota");

        System.out.println("Ordre inicial");
        for(int i=0; i< strings.size(); i++){
            System.out.println(strings.get(i));
        }

        System.out.println("Mostrem ordenats");
        Collections.sort(strings);
        for(int i=0; i< strings.size(); i++){
            System.out.println(strings.get(i));
        }

        //I si ho volem ordenar en ordre decreixent
        System.out.println("Mostrem ordenats en ordre decreixent");
        Collections.sort(strings);
        for(int i= strings.size()-1; i>= 0; i--){
            System.out.println(strings.get(i));
        }

        System.out.println("Ordenem en ordre decreixent");
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        for(int i=0; i< strings.size(); i++){
            System.out.println(strings.get(i));
        }


        //Amb classe externa
        //Amb classe anònima
        //Amb funció lambda
        System.out.println("Ordenem de més llarg a més curta");
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        for(int i=0; i< strings.size(); i++){
            System.out.println(strings.get(i));
        }

    }
}
