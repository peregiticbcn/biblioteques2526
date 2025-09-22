package edIticbcn.exercici13_aixoVaLent_introduccióALaComplexitat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * Dubte:
 * Com consultem un VI?
 * Problemes:
 * No hi ha indexof
 * No retorna el Vi
 * Pensar amb el funcionament dels duplicats
 * No ordenar
 */
public class BodegaSet {


    public static int DEFAULT_MAX_VINS = 10;

    private TreeSet<Vi> vins;


    public BodegaSet(int mida){
        vins = new TreeSet<>();
    }

    public BodegaSet() {
        this(DEFAULT_MAX_VINS);
    }

    /*public int indexDe(Vi vi){

        return vins.indexOf(vi);
    }
    */


    public boolean conteVi(Vi vi){
        return vins.contains(vi);
    }

    /*
    public Vi get(int index){
        if (index <0 || index >= vins.size()){
            return null;
        }

        return vins.get(index);
    }
    */

    public Vi get(Vi vi){

        return vins.ceiling(vi);
    }

    public Vi afegeix(Vi vi)  {

        if (conteVi(vi)){ //està repetit
            return null;
        }

        vins.add(vi);
        return vi;
    }

    public Vi elimina(Vi vi){

        if (vins.contains(vi)){
            vins.remove(vi);
        }
        //desplaçar els vins

        return vi;
    }

    public int mida() {
        return vins.size();
    }
    /*
    public void ordena(){
        vins.sort(null);
    }

    public void ordenaPerEstocDecreixent(){
        vins.sort(new Comparator<>() {
            @Override
            public int compare(Vi o1, Vi o2) {
                return o2.getEstoc() - o1.getEstoc();
            }
        });
    }

    public void ordenaPerPreuCreixentIEstocDecreixent(){
        vins.sort(new Comparator<>() {
            @Override
            public int compare(Vi o1, Vi o2) {
                if (o1.getPreu()==o2.getPreu()){
                    return o2.getEstoc() - o1.getEstoc();
                }
                return o1.getPreu() - o2.getPreu();
            }
        });
    }
    */
    public void mostra(){
        for(Vi vi: vins){
            System.out.println(vi);
        }
        System.out.println();
    }

    /*
    public static void main(String[] args) {
        BodegaSet bodega = new BodegaSet(3);
        bodega.afegeix(new Vi("ViBo", 1000, 10));
        bodega.afegeix(new Vi("Segon", 2000, 202));
        bodega.afegeix(new Vi("tres", 3000));
        bodega.afegeix(new Vi("quatre", 300));
        bodega.afegeix(new Vi("quatre", 300)); //no afegeix duplicat

        int mida = bodega.mida();
        for(int i=0; i<mida; i++){
            System.out.println(bodega.get(i));
        }

    }
*/

}
