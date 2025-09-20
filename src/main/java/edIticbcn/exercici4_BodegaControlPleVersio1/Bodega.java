package edIticbcn.exercici4_BodegaControlPleVersio1;

/**
 * Quan fem un programa és positiu pensar que no l'estem fent només per nosaltres, sinó per a tot l'equip amb qui
 * treballem o, fins i tot, per altres programadors que les reutilitzaran. Per tant, no hem de veure Botiga
 * com una simple classe per a la nostra aplicació, sinó com a integrant d'una biblioteca de classes que més endavant
 * podrem reutilitzar o fer pública. És per això que cal tractar amb molta atenció les decisions de disseny que prenem
 * per resoldre, no fos cas que més endavant ens generi molts problemes.
 *
 *
 * A la versió anterior de Bodega hem pres, de manera potser no premeditada, algunes decisions sobre com tractem casos
 * critics. Per exemple
 * DECISIÓ 1: Què fa el nostre codi quan afegim un Vi i la Bodega està plena?
 *
 * RESPOSTA: el programa llança l'excepció ArrayIndexOutOfBoundsException i, si no es captura, finalitzarà el programa.
 *
 * DECISIÓ 2: que fa el nostre programa quan afegim un vi i està duplicat?
 *
 * RESPOSTA: No l'afegeix i retorna null. Notem que, a banda del nom, la resta de valors del vi, per exemple l'estoc,
 * no tenen en compte.
 *
 * DECISIÓ 3: Què fem si volem accedir a un Vi d'índex no existent.
 *
 * RESPOSTA: Retornem null (d'aquí la utilitat que afegeix retorni el Vi).
 *
 * DECISIÓ 4: Què fem si volem esborrar un Vi que no hi és.
 *
 * RESPOSTA 4: Retornem null (per comunicar que no hi era).
 *
 * En general, aquestes decisions s'han de prendre amb molt de compte, ja que poden portar problemes més endavant
 * quan es reutilitza el codi. Proposem dues idees generals que creiem que poden ser d'utilitat.
 *
 * 1-. Controlar l'excepció
 *
 *
 *
 * El problema és que si no ho té en compte, pot ser que el programa acabi avortant i faci avortar les aplicacions que
 * l'utilitzen. L'excepció ArrayIndexOutOfBoundsException no és GESTIONADA i, per tant, Com podem assegurar que això no passi.
 *
 * Alternatives:
 * 1-. Obligar al programador que fa servir la biblioteca a que gestioni aquesta excepció
 *
 *
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
        bodega.afegeix(new Vi("tres2", 300)); //no afegeix duplicat
        int mida = bodega.mida();

        for(int i=0; i<mida; i++){
            System.out.println(bodega.get(i));
        }


    }

}
