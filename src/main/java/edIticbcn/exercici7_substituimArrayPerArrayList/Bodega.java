package edIticbcn.exercici7_substituimArrayPerArrayList;


import java.util.ArrayList;

/**
 * ACTIVITAT
 * Modifiqueu la classe Bodega de manera que utilitzi un ArrayList<Vi>
 *
 * Noteu que no caldrà nVins ja que per saber quans vins ho ha farem servir el mètode size()
 * indexDe utilitzarà indexOf(...)
 * conté vi farà servir contains(...)
 * No cal modificar el mètode main que afegeix 4 o 5 vins diferents
 *
 */
public class Bodega {


    public static int DEFAULT_MAX_VINS = 10;

    private ArrayList<Vi> vins;


    public Bodega(int mida){
        vins = new ArrayList<>(mida);
    }

    public Bodega() {
        this(DEFAULT_MAX_VINS);
    }

    public int indexDe(Vi vi){

        return vins.indexOf(vi);
    }

    public boolean conteVi(Vi vi){
        return vins.contains(vi);
    }

    public Vi get(int index){
        if (index <0 || index >= vins.size()){
            return null;
        }

        return vins.get(index);
    }

    public Vi afegeix(Vi vi)  {

        if (conteVi(vi)){ //està repetit
            return null;
        }

        vins.add(vi);
        return vi;
    }

    public Vi elimina(Vi vi){
        int index = indexDe(vi);
        if (index == -1){
            return null;
        }
        //desplaçar els vins
        vi = vins.remove(index);

        return vi;
    }

    public int mida() {
        return vins.size();
    }
    public static void main(String[] args) {
        Bodega bodega = new Bodega(3);
        bodega.afegeix(new Vi("ViBo", 1000, 10));
        bodega.afegeix(new Vi("Segon", 2000, 202));
        bodega.afegeix(new Vi("tres", 3000));
        bodega.afegeix(new Vi("quatre", 300)); //no afegeix duplicat

        int mida = bodega.mida();
        for(int i=0; i<mida; i++){
            System.out.println(bodega.get(i));
        }

    }


}
