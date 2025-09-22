package edIticbcn.exercici9_vi_amb_equals;



import java.util.ArrayList;
/**
 * A l'exercici anterior, si no us heu avançat als canvis que tocaven i heu fet servir indexOf i contains, podem
 * observar que no es detecta si els vins són duplicats.
 *
 * Feu una prova afegint diverses vegades el mateix vi.
 * Comproveu que el contains no funciona.
 * Comproveu que l'indexOf tampoc funcions.
 *
 * ACTIVITAT
 * Feu els canvis que calgui per tal que es detecti correctament quan dos vins són iguals
 * Considerarem que són iguals si tenen el mateix nom
 *
 * Feu un programa que eviti que hi hagi vins duplicats
 *
 * OBSERVACIÓ: Deixem el HashCode per més endavant (només cal modificar Vi)
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
        bodega.afegeix(new Vi("quatre", 300));
        bodega.afegeix(new Vi("quatre", 300)); //no afegeix duplicat

        int mida = bodega.mida();
        for(int i=0; i<mida; i++){
            System.out.println(bodega.get(i));
        }

    }


}
