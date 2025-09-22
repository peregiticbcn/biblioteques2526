package edIticbcn.exercici10_ordenemArrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class DemoOrdenemArrays {

    public static void mostraEnters(ArrayList<Integer> enters){
        for(Integer i: enters){
            System.out.println(i);
        }
        System.out.println();
    }

    public static void mostraStrings(ArrayList<String> cadenes){
        for(String s: cadenes){
            System.out.println(s);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> enters = new ArrayList<>();
        enters.add(2);
        enters.add(4);
        enters.add(1);
        enters.add(6);
        System.out.println("Ordre inicial");
        mostraEnters(enters);

        System.out.println("Ordenem numeros ordre natural (el que ens fa per defecte)");
        Collections.sort(enters);
        mostraEnters(enters);


        //Ordenem Strings
        ArrayList<String> strings = new ArrayList<>();
        strings.add("bola");
        strings.add("història");
        strings.add("aura");
        strings.add("pilota");
        System.out.println("Ordre inicial strings");
        mostraStrings(strings);

        System.out.println("Ordenem strings ordre natural (el que es fa per defecte)");
        Collections.sort(strings);
        //Alternativa
        //strings.sort(null);
        mostraStrings(strings);

        System.out.println("Ordenem strings en ordre decreixent");
        System.out.println("Fent una classe externa ComparatorDecreixentStrings");
        Comparator<String> comparatorDecreixentString = new ComparatorDecreixentString();
        strings.sort(comparatorDecreixentString);
        mostraStrings(strings);

        System.out.println("Ordenem strings segons longitud creixent");
        System.out.println("Fent una classe interna ComparatorMidaCreixentString");
        class ComparatorMidaCreixentString implements Comparator<String> {

            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        }
        strings.sort(new ComparatorMidaCreixentString());
        mostraStrings(strings);

        System.out.println("Ordenem strings segons longitud decreixent");
        System.out.println("Fent un comparador anònim");

        strings.sort(new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        mostraStrings(strings);

        System.out.println("Una classe anònima d'un sol mètode es pot substituir per una funció lambda");
        System.out.println("En fem servir una per tornar a ordenar per longitud creixent");
        strings.sort((o1, o2) -> o1.length() - o2.length());
        mostraStrings(strings);

    }
}
