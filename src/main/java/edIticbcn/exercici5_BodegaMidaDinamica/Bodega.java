package edIticbcn.exercici5_BodegaMidaDinamica;


/**
 * Ja hem vist que amb l'excepció gestionada BodegaPlenaExcepcion solucionem el problema anterior.
 * Tot i això, el codi es fa una mica feixuc perquè cada vegada que afegim un vi hem de fer el try/catch
 *
 * Una alternativa dinàmica a llançar l'excepció seria que, si l'array és ple, incrementar dinàmicament l'espai
 * per tal de posar-ho en un array més gran.
 *
 * Per exemple,
 * ...
 *
 * ACTIVITAT: Modifiqueu Bodega per a que es converteixi en una array dinàmic. És a dir, si no hi ha prou espai
 * 1-. Crea un vector més gran (per no haver-ho de fer sovint, el vector nou tindrà el doble la longitud de l'anterior)
 * 2-. Copia tot els elements al nou vector
 * 3-. Afegeix l'element
 * 4-. Fes que el vector antic sigui el nou
 *
 *
 */

public class Bodega {
    public static int DEFAULT_MAX_VINS = 10;

    private Vi[] vins; //vins.length indicarà el màxim de vins
    private int nVins = 0; //necessitem un comptador per saber quants vins hi ha

    public Bodega(int mida){
        vins = new Vi[mida];
    }

    public Bodega() {
        this(DEFAULT_MAX_VINS);
    }

    public int indexDe(Vi vi){
        //nom = StringUtils.normatitza(nom);
        for(int i=0; i<nVins; i++){
            if (vins[i].getNom().equals(vi.getNom())){
                return i;
            }
        }
        return -1;
    }

    public boolean conteVi(Vi vi){
        return indexDe(vi)!=-1;
    }

    public Vi get(int index){
        if (index <0 || index >= nVins){
            return null;
        }

        return vins[index];
    }

    public Vi afegeix(Vi vi)  {

        if (conteVi(vi)){ //està repetit
            return null;
        }
        if (nVins == vins.length){
            Vi[] mesVins = new Vi[vins.length * 2];
            for(int i=0; i<vins.length; i++){
                mesVins[i]=vins[i];
            }
            vins = mesVins;
        }
        vins[nVins++]=vi;
        return vi;
    }

    public Vi elimina(Vi vi){
        int index = indexDe(vi);
        if (index == -1){
            return null;
        }
        //desplaçar els vins
        vi = vins[index];
        for(int i=index; i<nVins; i++){
            vins[i]=vins[i+1];
        }
        nVins--;
        return vi;
    }

    public int mida() {
        return nVins;
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
