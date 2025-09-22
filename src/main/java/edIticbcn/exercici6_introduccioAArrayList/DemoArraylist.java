package edIticbcn.exercici6_introduccioAArrayList;

import java.util.ArrayList;

/**
 * Treballar amb arrays dinàmics (aquests que permeten augmentar la mida de manera dinàmica com a la Bodega) és
 * molt habitual. I millor que programar-ho cada vegada és fer servir una biblioteca estàndard de Java, de les moltes
 * que té. Per exemple ArrayList<E> de la biblioteca java.utils
 *
 * A més de ser dinàmiques (no ens hem de preocupar de si s'ompliran) els ArrayList treballen amb elements genèrics.
 * És a dir, podem fer un ArrayList de Integer, un altre de String o un de Vi (de manera semblant a com podem fer
 * un array Integer[], String[] o Vi[].
 *
 * És per això que ArrayList<E> porta la <E> al final, que significa E Element (que ha de ser una classe).
 *
 * Per exemple, podem crear un ArrayList d'Integer fent
 *
 * ArrayList<Integer> enters = new ArrayList<>()
 *
 * En aquest enllaç trobareu la documentació
 * @link https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
 *
 * Noteu que ArrayList té alguns mètodes prou coneguts (o semblants als que hem implementat)
 * indexOf()
 * contains()
 * add()
 * remove()
 * get()
 *
 * el mètode size() retorna quants elements hi ha a l'array
 * o d'altres més avançats com sort(), per ordenar, etc.
 *
 * Activitat: en aquest exercici podeu veure un ArrayList d'enters (sense dublicats)
 *
 * Completeu el mateix per fer un arrayList d'String de manera que, em comptes de treballar amb els numeros, treballem
 * amb les lletres
 *
 * DEMO PENDENT DE CONCRETAR
 *
 */

public class DemoArraylist {
    public static void main(String[] args) {
        ArrayList<Integer>  enters = new ArrayList<>();
        enters.add(1);
        enters.add(2);
        enters.add(6);
        enters.add(4);


        System.out.println();

    }

}
