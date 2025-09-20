package edIticbcn.exercici3_Bodega;

/**
 * Bodega.
 * Permet guardar un nombre determinat de vins.
 * El màxim de vins permès es passa com a argument (per defecte, DEFAULT_MAX_VINS val 10).
 *
 * Indicacions:
 * Els vins es guarden de manera consecutiva (si hi ha 10 vins, es guarden de la posició 0 a la 9).
 * No es poden afegir vins duplicats (amb el mateix nom).
 * En aquesta primera versió no tindrem en compte l'error d'afegir més vins que el màxim permès.
 *
 * Mètodes
 *      afegeix(Vi): Vi
 *      elimina(Vi): Vi
 *      conte(Vi): boolea
 *      indexDe(Vi): int //-1 si hi és
 *      get(int index): Vi
 *      mostrarVins();
 *      mida(): int; retorna quants vins hi ha
 * Indicacions: No podem afegir vins iguals (que tinguin el mateix nom)
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

    public Vi afegeix(Vi vi){

        if (conteVi(vi)){ //està repetit
            return null;
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
        bodega.afegeix(new Vi("tres", 300)); //no afegeix duplicat
        int mida = bodega.mida();

        for(int i=0; i<mida; i++){
            System.out.println(bodega.get(i));
        }


    }

}
